package com.safi.workshop.audio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.CompoundControl;
import javax.sound.sampled.Control;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Port;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.PreferencesUtil;

import com.richclientgui.toolbox.slider.CoolSlider;
import com.richclientgui.toolbox.slider.CoolSliderPositionChangeListener;
import com.safi.workshop.audio.utils.AudioException;
import com.safi.workshop.audio.utils.AudioUtils;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.preferences.AudioControlsPrefPage;
import com.safi.workshop.preferences.AudioDevicesPrefPage;
import com.safi.workshop.preferences.AudioControlsPrefPage.ControlItem;

public class PromptMediaController extends Composite {

  enum PlayState {
    STOPPED, PAUSED, PLAYING
  };

  private Composite buttonPanel;
  private Button playButton;
  private Button pauseButton;
  private Button stopButton;
  private Clip player;
  private File currFile;
  private CoolSlider filePositionSlider;
  private float currentLevel;
  private Timer currentTimer = new Timer(true);
  private TimerTask sliderTask;
  boolean dragging = false;
  private Map<String, AudioControlWidget> outputControls = new HashMap<String, AudioControlWidget>();
  private List<Line> openLines = new ArrayList<Line>();
  private PlayState state = PlayState.STOPPED;

  /**
   * Create the composite
   * 
   * @param parent
   * @param style
   */
  public PromptMediaController(Composite parent, int style) {
    super(parent, style);
    Shell sh = getShell();
    if (sh != null) {
      sh.addDisposeListener(new DisposeListener() {
        @Override
        public void widgetDisposed(DisposeEvent e) {
          dispose();

        }
      });

    }
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);
    filePositionSlider = new CoolSlider(this, SWT.HORIZONTAL, AudioUtils.sliderLeftmost,
        AudioUtils.sliderLeftTile, AudioUtils.sliderThumb, AudioUtils.sliderThumb,
        AudioUtils.sliderThumb, AudioUtils.sliderRightTile, AudioUtils.sliderRightmost);

    filePositionSlider.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
    filePositionSlider.setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
    filePositionSlider.setForeground(getDisplay().getSystemColor(SWT.COLOR_WHITE));

    filePositionSlider.addPositionChangeListener(new CoolSliderPositionChangeListener() {
      @Override
      public void positionChanged(double position, boolean mouseEvent, boolean dragging) {
        if (mouseEvent && player != null && !dragging) {
          synchPlayerWithSlider();
        }
      }

      @Override
      public void dragStarted() {
      }

      @Override
      public void dragStopped() {
      }
    });
    Composite controlPanel = new Composite(this, SWT.NONE);
    GridLayout rowLayout = new GridLayout();
    rowLayout.numColumns = 9;
    rowLayout.verticalSpacing = 0;
    rowLayout.marginHeight = 0;
    controlPanel.setLayout(rowLayout);
    final GridData gd_scale = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 2);
    controlPanel.setLayoutData(gd_scale);
    buildControls(controlPanel);

    buttonPanel = new Composite(this, SWT.NONE);
    final GridData gd_buttonPanel = new GridData(SWT.CENTER, SWT.TOP, false, false);
    buttonPanel.setLayoutData(gd_buttonPanel);
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.numColumns = 5;
    buttonPanel.setLayout(gridLayout_1);
    playButton = new Button(buttonPanel, SWT.NONE);
    playButton.setLayoutData(new GridData());
    playButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        play();
      }
    });
    playButton.setToolTipText("Play");
    playButton.setImage(AudioUtils.playImage);
    pauseButton = new Button(buttonPanel, SWT.TOGGLE);
    pauseButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        pause();
      }
    });
    pauseButton.setToolTipText("pause");
    pauseButton.setImage(AudioUtils.pauseImage);

    stopButton = new Button(buttonPanel, SWT.NONE);
    stopButton.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    stopButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        stop();
      }
    });
    stopButton.setToolTipText("stop");
    stopButton.setImage(AudioUtils.stopImage);

    //
    setPauseEnabled(false);
    setPlayEnabled(false);
    setStopEnabled(false);
  }

  private void buildControls(final Composite controlPanel) {
    try {
      boolean hasControls = false;
      List<ControlItem> outputs = AudioControlsPrefPage.getOutputControls();
      if (outputs != null && !outputs.isEmpty()) {
        addControls(controlPanel, outputs, "output", outputControls);
        hasControls = true;
      }
      if (!hasControls) {
        final Link configureControlsLink = new Link(controlPanel, SWT.NONE);
        final GridData gd_configureControlsLink = new GridData(SWT.CENTER, SWT.CENTER, true, true);
        gd_configureControlsLink.heightHint = 42;
        configureControlsLink.setLayoutData(gd_configureControlsLink);
        configureControlsLink.addSelectionListener(new SelectionAdapter() {
          @Override
          public void widgetSelected(final SelectionEvent e) {

            PreferenceDialog dlg = PreferencesUtil.createPreferenceDialogOn(getShell(),
                AudioDevicesPrefPage.ID, new String[] { AudioDevicesPrefPage.ID,
                    AudioControlsPrefPage.ID }, null);
            if (Window.OK == dlg.open()) {
              configureControlsLink.dispose();
              buildControls(controlPanel);
              getShell().pack();
            }

          }
        });
        configureControlsLink
            .setText("No audio controls have been configured. \nTo configure controls click <a href=\"\">here</a>");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // if (input != null)
      // input.close();
    }
  }

  private void addControls(Composite controlPanel, List<ControlItem> controls, String groupName,
      Map<String, AudioControlWidget> controlMap) {
    org.eclipse.swt.widgets.Group group = new org.eclipse.swt.widgets.Group(controlPanel,
        SWT.H_SCROLL | SWT.V_SCROLL);
    GridData layoutData = new GridData(SWT.FILL, SWT.TOP, true, true);
    group.setLayoutData(layoutData);
    GridLayout layout = new GridLayout();
    layout.numColumns = 6;
    group.setLayout(layout);
    group.setText(groupName);
    for (ControlItem ci : controls) {
      try {
        int idx = ci.getIndex();
        Port.Info pinfo = (Port.Info) ci.getParent().getPayload();
        Line line = AudioSystem.getLine(pinfo);
        if (!line.isOpen()) {
          line.open();
          openLines.add(line);
        }
        Control c = line.getControls()[idx];
        if (c instanceof FloatControl) {
          if (FloatControl.Type.BALANCE == c.getType() || FloatControl.Type.PAN == c.getType()
              || FloatControl.Type.SAMPLE_RATE == c.getType())
            continue;
          String title = c.getType().toString();
          FloatControlWidget floatControlWidget = new FloatControlWidget(group, (FloatControl) c,
              title);
          GridData layoutData2 = new GridData(SWT.BEGINNING, SWT.FILL, false, true);
          layoutData2.minimumHeight = 110;
          floatControlWidget.setLayoutData(layoutData2);
          controlMap.put(c.getType().toString(), floatControlWidget);
        } else if (c instanceof BooleanControl) {
          String title = c.getType().toString() + "\n(input)";
          BooleanControlWidget booleanControlWidget = new BooleanControlWidget(group, c, title);
          booleanControlWidget.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false,
              false));
          controlMap.put(c.getType().toString(), booleanControlWidget);
        } else if (c instanceof CompoundControl && ci.hasChildren()) {
          org.eclipse.swt.widgets.Group compoundGroup = new org.eclipse.swt.widgets.Group(group,
              SWT.H_SCROLL | SWT.V_SCROLL);
          compoundGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
          compoundGroup.setText(c.getType().toString());
          layout = new GridLayout();
          layout.numColumns = ci.getChildren().size();
          compoundGroup.setLayout(layout);
          for (ControlItem cci : ci.getChildren()) {
            Control c2 = cci.getControl();
            if (c2 instanceof FloatControl) {
              String title = c2.getType().toString();
              FloatControlWidget floatControlWidget = new FloatControlWidget(compoundGroup,
                  (FloatControl) c2, title);
              GridData layoutData2 = new GridData(SWT.BEGINNING, SWT.FILL, false, true);
              layoutData2.minimumHeight = 110;
              floatControlWidget.setLayoutData(layoutData2);
              controlMap.put(c.getType() + "/" + c2.getType().toString(), floatControlWidget);
            } else if (c2 instanceof BooleanControl) {
              String title = c2.getType().toString();
              BooleanControlWidget booleanControlWidget = new BooleanControlWidget(compoundGroup,
                  c2, title);
              booleanControlWidget.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false,
                  false));
              controlMap.put(c.getType() + "/" + c2.getType().toString(), booleanControlWidget);
            }
          }
        }
        // else
        // if (c instanceof BooleanControl)
        // new BooleanControlWidget(this, ())
      } catch (Exception exe) {
        exe.printStackTrace();
        AsteriskDiagramEditorPlugin.getInstance()
            .logError("Couldn't instantiat audio control", exe);
      }
    }
  }

  protected void synchPlayerWithSlider() {
    if (isDisposed())
      return;
    if (player != null) {
      double pct = filePositionSlider.getCurrentPosition();
      double duration = (player).getMicrosecondLength();
      // player.stop();
      (player).setMicrosecondPosition((long) (duration * pct));
      // player.start();
    }
  }

  @Override
  public void dispose() {
    currentTimer.cancel();
    currentTimer.purge();
    if (player != null) {
      try {
        Clip p = player;
        player = null;
        p.stop();
        p.close();
        if (sliderTask != null)
          sliderTask.cancel();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    for (Line line : openLines) {
      if (line.isOpen())
        line.close();
    }
    super.dispose();

    super.dispose();
  }

  public void disable() {
    setPauseEnabled(false);
    setPlayEnabled(false);
    setStopEnabled(false);
    filePositionSlider.setEnabled(false);
  }

  public void enable() {
    setPauseEnabled(true);
    setPlayEnabled(true);
    setStopEnabled(true);
    filePositionSlider.setEnabled(true);
  }

  public synchronized void loadFile(File file) throws AudioException,
      UnsupportedAudioFileException, IOException, LineUnavailableException {
    if (currFile == file)
      return;
    currFile = file;
    disable();
    if (player != null) {
      try {
        Clip p = player;
        player = null;
        p.stop();
        p.close();
        if (sliderTask != null)
          sliderTask.cancel();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    Mixer outputMixer = AudioDevicesPrefPage.getOutputMixer();
    if (outputMixer == null) {
      throw new AudioException("No input device found");
    }
    AudioInputStream instream = AudioSystem.getAudioInputStream(AudioUtils.DEFAULT_AUDIO_FORMAT,
        AudioSystem.getAudioInputStream(file));
    Line.Info clipInfo = new Line.Info(Clip.class);

    player = (Clip) outputMixer.getLine(clipInfo);
    filePositionSlider.updateSlider(0.0d);
    player.addLineListener(new LineListener() {

      @Override
      public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP) {
          stop();
        }
      }

    });

    player.open(instream);
    setPlayEnabled(true);
    filePositionSlider.setEnabled(true);
    sliderTask = new FilePositionTask();

    currentTimer.scheduleAtFixedRate(sliderTask, 100, 100);

  }

  public void stop() {
    if (isDisposed())
      return;
    Display d = getDisplay();
    Runnable runna = new Runnable() {
      public void run() {
        try {
          if (state == PlayState.PAUSED)
            return;
          if (isDisposed())
            return;
          state = PlayState.STOPPED;

          // TODO Auto-generated method stub
          if (player == null)
            return;
          if (player.isRunning())
            player.stop();
          player.flush();
          player.setFramePosition(0);

          if (!filePositionSlider.isDisposed())
            filePositionSlider.updateSlider(0.0d);

          setPauseEnabled(false);
          setPauseToggled(false);
          setPlayEnabled(true);
          setStopEnabled(false);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    };
    if (d.getThread() != Thread.currentThread()) {
      d.asyncExec(runna);
    } else
      runna.run();
  }

  public void pause() {

    if (player == null)
      return;

    if (state == PlayState.PLAYING && player.isRunning() && pauseButton.getSelection()) {
      state = PlayState.PAUSED;
      player.stop();
      // player.flush();
      setPlayEnabled(true);
      setStopEnabled(true);
    } else if (!player.isRunning() && !pauseButton.getSelection()) {
      play(); // continue
    }
  }

  public void play() {
    if (state == PlayState.PLAYING || player == null || player.isRunning())
      return;
    state = PlayState.PLAYING;
    // player.open();
    player.start();
    setPauseEnabled(true);
    setPauseToggled(false);
    setPlayEnabled(false);
    setStopEnabled(true);
  }

  public void setPlayEnabled(boolean enabled) {
    if (!playButton.isDisposed())
      playButton.setEnabled(enabled);
  }

  public void setPauseEnabled(boolean enabled) {
    if (!pauseButton.isDisposed())
      pauseButton.setEnabled(enabled);
  }

  public void setPauseToggled(boolean state) {
    if (!pauseButton.isDisposed())
      pauseButton.setSelection(state);
  }

  public void setStopEnabled(boolean enabled) {
    if (!stopButton.isDisposed())
      stopButton.setEnabled(enabled);
  }

  @Override
  protected void checkSubclass() {
    // Disable the check that prevents subclassing of SWT components
  }

  public static void main(String[] args) throws Exception {
    Display display = new Display();
    Shell shell = new Shell(display, SWT.SHELL_TRIM);
    shell.setLayout(new FillLayout());
    PromptMediaController controller = new PromptMediaController(shell, SWT.NONE);
    shell.open();
    // controller.loadFile(new File(
    // "D:\\documents and settings\\zxwolfe\\My Documents\\My Audio\\prompts\\munkies.gsm"));
    String filename = "D:\\workspace\\Handlers.runtime\\audio\\to-hear-weather-status.gsm";
    controller.loadFile(new File(filename));
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();
  }

  private class FilePositionTask extends TimerTask {

    @Override
    public void run() {
      if (player == null)
        return;
      if (isDisposed())
        return;
      // if (!player.isRunning())
      // return;
      long duration = player.getMicrosecondLength();
      if (duration <= 0) {
        Display d = getDisplay();
        d.asyncExec(new Runnable() {
          @Override
          public void run() {
            if (!filePositionSlider.isDisposed())
              filePositionSlider.updateSlider(0.0d);
          }
        });
      } else {
        final double pctDone = player.getMicrosecondPosition() / (double) duration;
        Display d = getDisplay();
        d.asyncExec(new Runnable() {
          @Override
          public void run() {
            if (dragging || filePositionSlider.isDisposed())
              return;
            filePositionSlider.updateSlider(pctDone);
          }
        });
      }
    }
  }

  public Composite getButtonPanel() {
    return buttonPanel;
  }

}
