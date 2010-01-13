package com.safi.workshop.audio;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.CompoundControl;
import javax.sound.sampled.Control;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.Port;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.PreferencesUtil;
import com.richclientgui.toolbox.slider.CoolSlider;
import com.richclientgui.toolbox.slider.CoolSliderPositionChangeListener;
import com.safi.workshop.audio.utils.AudioException;
import com.safi.workshop.audio.utils.AudioUtils;
import com.safi.workshop.audio.utils.RecordableClip;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.preferences.AudioControlsPrefPage;
import com.safi.workshop.preferences.AudioDevicesPrefPage;
import com.safi.workshop.preferences.AudioControlsPrefPage.ControlItem;
import com.safi.workshop.util.NativeExecUtil;

public class AudioRecorder extends Composite {

  private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.##");
  private static final String POS_LABEL_STRING = "Position: \n%d secs";
  private static final String LENGTH_LABEL_STRING = "Length: \n%d secs";

  enum PlayState {
    STOPPED, PAUSED, PLAYING, RECORDING
  };

  private Button editWaveformButton;
  private RecordableClip clip;
  private WaveformViewerPanel clipViewer;
  protected float currentLevel;
  protected DataLine player;
  private ProgressBar levelIndicator;
  private CoolSlider coolSlider;
  private Button recordButton;
  private Button pauseButton;
  private Button playButton;
  private Button stopButton;
  private File file;
  private Map<String, AudioControlWidget> outputControls = new HashMap<String, AudioControlWidget>();
  private Map<String, AudioControlWidget> inputControls = new HashMap<String, AudioControlWidget>();
  private PlayState state = PlayState.STOPPED;
  private List<Line> openLines = new ArrayList<Line>();
  private CLabel lengthLabel;
  private CLabel positionLabel;
  private Composite controlPanel;

  /**
   * Create the composite
   * 
   * @param parent
   * @param style
   */
  public AudioRecorder(Composite parent, int style) {
    super(parent, style | SWT.DOUBLE_BUFFERED);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 6;
    setLayout(gridLayout);
    clipViewer = new WaveformViewerPanel(this);
    clipViewer.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseDoubleClick(final MouseEvent e) {
        openWaveformEditor();
      }
    });
    AsteriskDiagramEditorPlugin pg = AsteriskDiagramEditorPlugin.getInstance();
    final GridData gd_clipViewer = new GridData(SWT.FILL, SWT.FILL, true, false, 5, 1);
    gd_clipViewer.heightHint = 100;
    clipViewer.setLayoutData(gd_clipViewer);

    final Composite composite_1 = new Composite(this, SWT.NONE);
    final GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, false, false);
    gd_composite_1.widthHint = 93;
    composite_1.setLayoutData(gd_composite_1);
    levelIndicator = new ProgressBar(composite_1, SWT.VERTICAL | SWT.SMOOTH);
    levelIndicator.setBounds(0, 5, 18, 90);
    levelIndicator.setMinimum(0);
    levelIndicator.setMaximum(100);
    levelIndicator.setToolTipText("Recording level indicator");
    lengthLabel = new CLabel(composite_1, SWT.SHADOW_IN | SWT.CENTER);
    lengthLabel.setBounds(25, 5, 88, 43);

    positionLabel = new CLabel(composite_1, SWT.SHADOW_IN | SWT.CENTER);
    positionLabel.setBounds(25, 53, 88, 42);

    coolSlider = new CoolSlider(this, SWT.HORIZONTAL, pg
        .getBundledImage("icons/slider/slider_leftmost.png"), pg
        .getBundledImage("icons/slider/slider_left_tile.png"), pg
        .getBundledImage("icons/slider/slider_thumb.png"), pg
        .getBundledImage("icons/slider/slider_thumb.png"), pg
        .getBundledImage("icons/slider/slider_thumb.png"), pg
        .getBundledImage("icons/slider/slider_right_tile.png"), pg
        .getBundledImage("icons/slider/slider_rightmost.png"));
    coolSlider.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 6, 1));
    coolSlider.addPositionChangeListener(new CoolSliderPositionChangeListener() {
      @Override
      public void positionChanged(double position, boolean mouseEvent, boolean dragging) {
        if (mouseEvent && player != null && !dragging) {
          synchPlayerWithSlider();
        }
      }

      @Override
      public void dragStarted() {
        if (state == PlayState.PLAYING)
          pause();
      }

      @Override
      public void dragStopped() {
        if (state == PlayState.PAUSED)
          play();
      }
    });
    recordButton = new Button(this, SWT.NONE);
    recordButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        record();
      }
    });
    final GridData gd_recordButton = new GridData(SWT.LEFT, SWT.TOP, false, false);
    gd_recordButton.widthHint = 50;
    recordButton.setLayoutData(gd_recordButton);
    recordButton.setToolTipText("Record");
    recordButton.setImage(AudioUtils.recordImage);
    pauseButton = new Button(this, SWT.NONE);
    final GridData gd_pauseButton = new GridData(SWT.LEFT, SWT.TOP, false, false);
    gd_pauseButton.widthHint = 50;
    pauseButton.setLayoutData(gd_pauseButton);
    pauseButton.setToolTipText("Pause");
    pauseButton.setImage(AudioUtils.pauseImage);
    pauseButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseDown(MouseEvent arg0) {
        pause();
      }
    });
    playButton = new Button(this, SWT.NONE);
    playButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        play();
      }
    });
    final GridData gd_playButton = new GridData(SWT.LEFT, SWT.TOP, false, false);
    gd_playButton.widthHint = 50;
    playButton.setLayoutData(gd_playButton);
    playButton.setToolTipText("Play");
    playButton.setImage(AudioUtils.playImage);

    stopButton = new Button(this, SWT.NONE);
    stopButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseDown(MouseEvent arg0) {
        stop();
      }
    });

    final GridData gd_stopButton = new GridData(SWT.LEFT, SWT.TOP, false, false);
    gd_stopButton.widthHint = 50;
    stopButton.setLayoutData(gd_stopButton);
    stopButton.setToolTipText("Stop");
    stopButton.setImage(AudioUtils.stopImage);

    editWaveformButton = new Button(this, SWT.NONE);
    editWaveformButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        openWaveformEditor();
      }
    });
    final GridData gd_editWaveformButton = new GridData(SWT.LEFT, SWT.TOP, false, false);
    editWaveformButton.setLayoutData(gd_editWaveformButton);
    // editWaveformButton.setText("Edit waveform");
    editWaveformButton.setToolTipText("Edit prompt in the waveform editor");
    editWaveformButton.setImage(AudioUtils.editWaveformImage);
    final Button nativeSoundControlButton = new Button(this, SWT.NONE);
    nativeSoundControlButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        try {
          NativeExecUtil.openWindowsSoundControl(true);
        } catch (Exception e1) {
          e1.printStackTrace();
          MessageDialog.openError(getShell(), "Audio Control Error",
              "Couldn't open native audio controls: " + e1.getLocalizedMessage());
        }
      }
    });
    nativeSoundControlButton.setLayoutData(new GridData());
    nativeSoundControlButton.setText("Native Sound Control");

    controlPanel = new Composite(this, SWT.NONE);
    GridLayout rowLayout = new GridLayout();
    rowLayout.numColumns = 3;
    rowLayout.verticalSpacing = 0;
    rowLayout.marginHeight = 0;
    controlPanel.setLayout(rowLayout);
    final GridData gd_scale = new GridData(SWT.FILL, SWT.FILL, true, true, 6, 1);
    controlPanel.setLayoutData(gd_scale);
    buildControls(controlPanel);

    // new Label(this, SWT.NONE);
    //
    if (System.getProperty("os.name").toLowerCase().indexOf("windows") < 0) {
      nativeSoundControlButton.setVisible(false);
    }
  }

  protected void openWaveformEditor() {
    if (clip == null || clip.isRecording())
      return;
    stop();
    WaveformEditor editor = new WaveformEditor(getShell());
    RecordableClip newclip = new RecordableClip(clip);
    editor.setClip(newclip);
    int result = editor.open();
    if (result == Window.OK) {
      byte[] audioData = editor.getAudioData();
      if (audioData != null) {
        clip.setAudioData(audioData);
        clipViewer.redraw();
      }
      editor.dispose();
    }

  }

  private void buildControls(final Composite controlPanel) {
    try {
      boolean hasControls = false;
      List<ControlItem> inputs = AudioControlsPrefPage.getInputControls();
      if (inputs != null && !inputs.isEmpty()) {
        addControls(controlPanel, inputs, "input", inputControls);
        hasControls = true;
      }
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
    GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
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

  protected void stop() {
    state = PlayState.STOPPED;
    try {
      if (clip != null) {
        setStopEnabled(false);
        setPauseEnabled(false);
        setPlayEnabled(true);
        setRecordEnabled(true);
        clip.stop();
        clip.reset();
        if (isSaveable())
          audioFileRecorded();
      }
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Audio Error", "Couldn't stop audio: "
          + e.getLocalizedMessage());
    }
  }

  protected void play() {
    state = PlayState.PLAYING;
    try {
      if (clip != null) {
        setStopEnabled(true);
        setPauseEnabled(true);
        setPlayEnabled(false);
        setRecordEnabled(false);
        clip.start();
      }
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Audio Error", "Couldn't play audio: "
          + e.getLocalizedMessage());
    }
  }

  protected void pause() {
    try {
      state = PlayState.PAUSED;
      if (clip != null) {
        setStopEnabled(true);
        setPauseEnabled(false);
        setPlayEnabled(true);
        setRecordEnabled(false);
        clip.stop(false);
      }
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Audio Error", "Couldn't pause audio: "
          + e.getLocalizedMessage());
    }
  }

  protected void record() {
    state = PlayState.RECORDING;
    try {
      if (clip == null)
        initClip();
      else {
        MessageDialog dlg = new MessageDialog(AsteriskDiagramEditorUtil.getActiveShell(),
            "Recording Exists", null, "An existing recording exists", MessageDialog.QUESTION,
            new String[] { "Overwrite", "Append", "Cancel" }, 1);
        int result = dlg.open();
        if (result == 2 || result == -1)
          return;
        if (result == 0) {
          clip.clear();
        }

        clip.reset();
      }
      setStopEnabled(true);
      setPauseEnabled(false);
      setPlayEnabled(false);
      setRecordEnabled(false);
      clip.record();
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Audio Error", "Couldn't record audio: "
          + e.getLocalizedMessage());
    }
  }

  @Override
  public void dispose() {
    if (clip != null) {
      try {
        clip.dispose();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    for (Line line : openLines) {
      if (line.isOpen()) {
        line.close();
      }
    }
    super.dispose();
  }

  public boolean isSaveable() {
    return clip != null && clip.isSaveable();
  }

  public boolean save() throws IOException {
    clip.save(file, AudioFileFormat.Type.WAVE);
    return true;
  }

  public void initClip() throws IOException, AudioException {
    // AudioFormat format = new AudioFormat(44100.0F, 16, 1, false, false);
    File f = null;
    if (file == null) {
      f = File.createTempFile("tempRecord", ".wav");
      f.deleteOnExit();
      file = f;
    }
    clip = new RecordableClip(file, AudioUtils.DEFAULT_AUDIO_FORMAT);
    clipViewer.showClip(clip);
    // volumeSlider.setControl(clip.getVolumeControl());
    // updateVolume();
    clip.addClipListener(new RecordableClip.ClipListener() {
      @Override
      public void newData(int offset, int length) {
        if (isDisposed())
          return;
        final int p = offset;
        final int i = clip.getLengthInSamples() - 1;
        if (i < 0)
          return;
        final int value = clip.getSample(i);
        Display d = getDisplay();
        d.asyncExec(new Runnable() {
          @Override
          public void run() {
            // Level Indicator
            int val = (int) ((value / (float) clip.getMaxSampleHeight()) * (levelIndicator
                .getMaximum() - levelIndicator.getMinimum()));
            levelIndicator.setSelection(Math.abs(val * 2));

            // Length label
            float length = i / clip.getFrameRate();
            lengthLabel.setText(LENGTH_LABEL_STRING.replace("%d", DECIMAL_FORMAT.format(length)));

            // Position label
            positionLabel.setText(POS_LABEL_STRING.replace("%d", DECIMAL_FORMAT.format(length)));
          }
        });
      }

      @Override
      public void newPlayHead(long playhead) {
        if (isDisposed())
          return;
        if (coolSlider.isDragging())
          return;
        final int lengthInSamples = clip.getLengthInSamples();
        final float pctDone = playhead / (float) lengthInSamples;
        final int value = clip.getSample(playhead);
        Display d = getDisplay();
        d.asyncExec(new Runnable() {
          @Override
          public void run() {
            coolSlider.updateSlider(pctDone);
            int val = (int) ((value / (float) clip.getMaxSampleHeight()) * (levelIndicator
                .getMaximum() - levelIndicator.getMinimum()));
            levelIndicator.setSelection(Math.abs(val * 2));
            double postionVal = clip.getLengthInSeconds() * pctDone;
            if (pctDone > .98) {
              postionVal = (clip.getLengthInSamples() - 1) / clip.getFrameRate();
            }
            positionLabel
                .setText(POS_LABEL_STRING.replace("%d", DECIMAL_FORMAT.format(postionVal)));
          }
        });
      }

      @Override
      public void playerCreated(DataLine player) {
        AudioRecorder.this.player = player;
        updateControls(player);
      }

      @Override
      public void playerDisposed(DataLine player) {
      }

      @Override
      public void playerStopped(DataLine player) {
        Display d = getDisplay();
        d.asyncExec(new Runnable() {
          @Override
          public void run() {
            if (state != PlayState.PAUSED)
              stop();
          }
        });
      }
    });
  }

  protected void updateControls(DataLine player) {
    for (Control c : player.getControls()) {
      AudioControlWidget f = outputControls.get(c.getType().toString());
      if (f != null) {
        f.setControl(c);
      }

    }
    for (AudioControlWidget widget : inputControls.values()) {
      widget.controlChanged();
    }
  }

  protected void audioFileRecorded() {
  }

  @Override
  protected void checkSubclass() {
    // Disable the check that prevents subclassing of SWT components
  }

  // private void updateLevel(final int playhead) {
  // if (levelIndicator.isDisposed())
  // return;
  //
  // int max = clip.getMaxSampleHeight();
  // int sample = Math.abs(clip.getLastSample());
  // int value = (int) Math.round((sample / (((float) max) * 0.5f)) * 100f);
  // levelIndicator.setSelection(value);
  // }
  // private void updateVolume() {
  // volumeSlider.controlChanged();
  // currentLevel = (volumeSlider.getMaximum() - volumeSlider.getSelection())
  // / (float) volumeSlider.getMaximum();
  // if (clip != null && player != null) {
  // clip.setVolume(currentLevel);
  // }
  // }
  public void setPlayEnabled(boolean enabled) {
    if (!isDisposed())
      playButton.setEnabled(enabled);
  }

  public void setPauseEnabled(boolean enabled) {
    if (!isDisposed())
      pauseButton.setEnabled(enabled);
  }

  public void setStopEnabled(boolean enabled) {
    if (!isDisposed())
      stopButton.setEnabled(enabled);
  }

  public void setRecordEnabled(boolean enabled) {
    if (!isDisposed())
      recordButton.setEnabled(enabled);
  }

  protected void synchPlayerWithSlider() {
    if (isDisposed())
      return;
    if (player != null) {
      double pct = coolSlider.getCurrentPosition();
      double duration = ((Clip) player).getMicrosecondLength();
      // Position label
      positionLabel.setText(POS_LABEL_STRING.replace("%d", DECIMAL_FORMAT.format(pct)));
      // player.stop();
      ((Clip) player).setMicrosecondPosition((long) (duration * pct));
      // player.start();
    }
  }

  public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());
    AudioRecorder recorder = new AudioRecorder(shell, SWT.NONE);
    shell.open();
    shell.pack();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();
    // if (!recorder.isDisposed())
    recorder.dispose();
  }

  public File getFile() {
    return file;
  }

  public void setFile(File file) throws IOException, AudioException {
    this.file = file;
    if (file != null) {
      initClip();
    }

  }
}
