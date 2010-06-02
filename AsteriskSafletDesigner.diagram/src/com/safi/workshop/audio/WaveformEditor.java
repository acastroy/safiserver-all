package com.safi.workshop.audio;

import java.io.File;
import java.io.IOException;
import java.nio.ByteOrder;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.AudioFileFormat.Type;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.safi.workshop.audio.AudioRecorder.PlayState;
import com.safi.workshop.audio.utils.AudioCommon;
import com.safi.workshop.audio.utils.AudioException;
import com.safi.workshop.audio.utils.AudioUtils;
import com.safi.workshop.audio.utils.RecordableClip;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class WaveformEditor extends org.eclipse.jface.dialogs.Dialog {

  private static final int ARROW_INC = 10;
  private ToolItem deleteItemToolItem;
  private ToolItem separatorToolItem;
  private final static String SELECTION_TEXT_FORMAT = "Selection start: %d end: %d";
  private final static NumberFormat SHORT_DECIMAL_FORMAT = new DecimalFormat("####.00");
  private Label selectionLabel;
  private Composite composite;
  private static final int ZOOM_INC = 1;

  private static final int DEFAULT_SAMPLES_PER_PIXEL = 50;
  private static final int MARGIN = 5;

  private RecordableClip clip;
  private int samplesPerPixel = DEFAULT_SAMPLES_PER_PIXEL;
  private int cursorPixelPosition;

  // UI stuff
  private ToolItem stopToolItem;
  private ToolItem playToolItem;
  private ToolBar toolBar_2;
  private CoolItem playbackControls;
  private ToolItem zoomOutToolItem;
  private ToolItem zoomInToolItem;
  private ToolBar toolBar_1;
  private CoolItem zoomControls;
  private ToolItem pasteToolItem;
  private ToolItem copyToolItem;
  private ToolItem cutToolItem;
  private ToolBar toolBar;
  private CoolItem editControls;
  private CoolBar coolBar;
  private WaveformEditorCanvas canvas;
  private ScrolledComposite scrolledComposite;
  protected Object result;

  private ToolItem undoToolItem;

  private ToolItem redoToolItem;

  private ToolItem muteToolItem;

  private PlayState state;
  private Clipboard clipboard;
  private ToolItem increaseAmpItem;
  private ToolItem decreaseAmpItem;
  protected byte[] data;
  private ToolItem zoomToFitToolItem;
  private boolean optimizedRendering = true;
  private boolean saveOnExit;
  private Type saveType;
  private ToolItem resetToolItem;
  private ToolItem insertSilenceToolItem;

  /**
   * Create the dialog
   * 
   * @param parent
   */
  public WaveformEditor(Shell parent) {
    super(parent);
  }

  /**
   * Open the dialog
   * 
   * @return the result
   */
  // public Object open() {
  // createContents();
  // shell.open();
  // shell.layout();
  // shell.addDisposeListener(new DisposeListener() {
  //
  // @Override
  // public void widgetDisposed(DisposeEvent e) {
  // try {
  // clip.dispose();
  // } catch (Exception e2) {
  // // TODO: handle exception
  // }
  //
  // }
  //
  // });
  // Display display = getParent().getDisplay();
  // clipboard = new Clipboard(display);
  // while (!shell.isDisposed()) {
  // if (!display.readAndDispatch())
  // display.sleep();
  // }
  // return result;
  // }
  static String character(char character) {
    switch (character) {
      case 0:
        return "'\\0'";
      case SWT.BS:
        return "'\\b'";
      case SWT.CR:
        return "'\\r'";
      case SWT.DEL:
        return "DEL";
      case SWT.ESC:
        return "ESC";
      case SWT.LF:
        return "'\\n'";
      case SWT.TAB:
        return "'\\t'";
    }
    return "'" + character + "'";
  }

  @Override
  public int open() {
    // TODO Auto-generated method stub
    return super.open();
  }

  @Override
  protected void constrainShellSize() {
    // TODO Auto-generated method stub
    super.constrainShellSize();
    adjustCanvasSize();
    scrolledComposite.layout();
    canvas.redraw();
  }

  @Override
  protected boolean isResizable() {
    return true;
  }

  @Override
  protected Point getInitialSize() {
    // TODO Auto-generated method stub
    return new Point(765, 268);
  }

  /**
   * Create contents of the dialog
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite shell = (Composite) super.createDialogArea(parent);
    shell.addDisposeListener(new DisposeListener() {

      @Override
      public void widgetDisposed(DisposeEvent e) {
        try {
          byte[] data = clip.getAudioData();

          int len = clip.getLengthInBytes();
          WaveformEditor.this.data = new byte[len];
          System.arraycopy(data, 0, WaveformEditor.this.data, 0, len);
          if (saveOnExit) {
            try {
              clip.save(clip.getCurrentFile(), saveType);
            } catch (Exception e2) {
              AsteriskDiagramEditorPlugin.getInstance().logError(
                  "Couldn't save clip to file " + clip.getCurrentFile(), e2);
            }

          }
          clip.dispose();
          clip = null;
        } catch (Exception e2) {
        }
      }
    });

    KeyAdapter keyAdapter = new KeyAdapter() {
      @Override
      public void keyPressed(final KeyEvent e) {
        if ((e.stateMask & SWT.CTRL) == SWT.CTRL) {
          if (e.keyCode == 'x' || e.character == 'x')
            cut();
          else if (e.keyCode == 'c' || e.character == 'c')
            copy();
          else if (e.keyCode == 'v' || e.character == 'v')
            paste();
          else if (e.keyCode == 'z' || e.character == 'z')
            undo();
          else if (e.keyCode == 'y' || e.character == 'y')
            redo();
          else if (e.keyCode == 'a' || e.character == 'a')
            selectAll();
          if (e.keyCode == SWT.END) {
            selectToEnd();
          } else if (e.keyCode == SWT.HOME) {
            selectToBeginning();
          } else if (e.keyCode == SWT.ARROW_RIGHT) {
            selectStartToRight();
          } else if (e.keyCode == SWT.ARROW_LEFT) {
            selectStartToLeft();
          }
        } else if (e.keyCode == SWT.DEL)
          delete();
        else if (e.keyCode == SWT.CR) {
          play();
        } else if (e.keyCode == ' ')
          stop();
        else if ((e.stateMask & SWT.SHIFT) == SWT.SHIFT) {
          if (e.keyCode == SWT.END) {
            selectToEnd();
          } else if (e.keyCode == SWT.HOME) {
            selectToBeginning();
          } else if (e.keyCode == SWT.ARROW_RIGHT) {
            selectEndToRight();
          } else if (e.keyCode == SWT.ARROW_LEFT) {
            selectEndToLeft();
          }
        } else if (e.keyCode == SWT.END)
          moveCursorToEnd();
        else if (e.keyCode == SWT.HOME)
          moveCursorToBeginning();
      }
    };

    getShell().addControlListener(new ControlAdapter() {
      @Override
      public void controlResized(ControlEvent e) {
        adjustCanvasSize();
        canvas.redraw();
      }
    });
    clipboard = new Clipboard(getShell().getDisplay());
    coolBar = new CoolBar(shell, SWT.NONE);

    editControls = new CoolItem(coolBar, SWT.PUSH);
    editControls.setText("cut");

    toolBar = new ToolBar(coolBar, SWT.NONE);
    editControls.setControl(toolBar);

    cutToolItem = new ToolItem(toolBar, SWT.PUSH);
    cutToolItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        if (canvas.tracker.hasSelection()) {
          cut();
        }
      }

    });
    cutToolItem.setToolTipText("Cut selected audio");
    cutToolItem.setImage(AudioUtils.cutImage);

    copyToolItem = new ToolItem(toolBar, SWT.PUSH);
    copyToolItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        copy();
      }
    });
    copyToolItem.setToolTipText("Copy selected audio");
    copyToolItem.setImage(AudioUtils.copyImage);

    pasteToolItem = new ToolItem(toolBar, SWT.PUSH);
    pasteToolItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        paste();
      }
    });
    pasteToolItem.setToolTipText("Paste audio from clipboard");
    pasteToolItem.setImage(AudioUtils.pasteImage);

    undoToolItem = new ToolItem(toolBar, SWT.PUSH);
    undoToolItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        undo();
      }
    });
    undoToolItem.setToolTipText("Undo last operation");
    undoToolItem.setImage(AudioUtils.undoImage);

    redoToolItem = new ToolItem(toolBar, SWT.PUSH);
    redoToolItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        redo();
      }
    });
    redoToolItem.setToolTipText("Redo last operation");
    redoToolItem.setImage(AudioUtils.redoImage);

    separatorToolItem = new ToolItem(toolBar, SWT.SEPARATOR);
    separatorToolItem.setText("separator");

    deleteItemToolItem = new ToolItem(toolBar, SWT.PUSH);
    deleteItemToolItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        delete();
      }
    });
    deleteItemToolItem.setToolTipText("Delete selected audio");
    deleteItemToolItem.setImage(AudioUtils.deleteImage);

    Point p = toolBar.computeSize(SWT.DEFAULT, SWT.DEFAULT);
    toolBar.setSize(p);
    Point p2 = editControls.computeSize(p.x, p.y);
    editControls.setControl(toolBar);
    editControls.setSize(p2);

    zoomControls = new CoolItem(coolBar, SWT.PUSH);
    zoomControls.setText("New item");

    toolBar_1 = new ToolBar(coolBar, SWT.NONE);
    zoomControls.setControl(toolBar_1);

    zoomInToolItem = new ToolItem(toolBar_1, SWT.PUSH);
    zoomInToolItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        if (samplesPerPixel <= ZOOM_INC)
          return;
        samplesPerPixel -= ZOOM_INC;
        zoomValueChanged();
      }
    });
    zoomInToolItem.setToolTipText("Zoom in");
    zoomInToolItem.setImage(AudioUtils.zoomInImage);

    zoomOutToolItem = new ToolItem(toolBar_1, SWT.PUSH);
    zoomOutToolItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        samplesPerPixel += ZOOM_INC;
        zoomValueChanged();
      }
    });
    zoomOutToolItem.setToolTipText("Zoom out");
    zoomOutToolItem.setImage(AudioUtils.zoomOutImage);

    zoomToFitToolItem = new ToolItem(toolBar_1, SWT.PUSH);
    zoomToFitToolItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        zoomToFit();
      }
    });
    zoomToFitToolItem.setToolTipText("Zoom to fit selection");
    zoomToFitToolItem.setImage(AudioUtils.zoomToFitImage);

    p = toolBar_1.computeSize(SWT.DEFAULT, SWT.DEFAULT);
    toolBar_1.setSize(p);
    p2 = zoomControls.computeSize(p.x, p.y);
    zoomControls.setControl(toolBar_1);
    zoomControls.setSize(p2);

    // start
    CoolItem dspControls = new CoolItem(coolBar, SWT.PUSH);
    dspControls.setText("New item");

    ToolBar dspToolbar = new ToolBar(coolBar, SWT.NONE);
    dspControls.setControl(dspToolbar);

    increaseAmpItem = new ToolItem(dspToolbar, SWT.PUSH);
    increaseAmpItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        increaseAmplitude();
      }
    });
    // increaseAmpItem.setText("Vol +");
    increaseAmpItem.setToolTipText("Increase amplitude of the selected region");
    increaseAmpItem.setImage(AudioUtils.amplitudeUpImage);

    decreaseAmpItem = new ToolItem(dspToolbar, SWT.PUSH);
    decreaseAmpItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        decreaseAmplitude();
      }
    });
    // decreaseAmpItem.setText("Vol -");
    decreaseAmpItem.setToolTipText("Decrease amplitude of the selected region");
    decreaseAmpItem.setImage(AudioUtils.amplitudeDownImage);

    muteToolItem = new ToolItem(dspToolbar, SWT.PUSH);
    muteToolItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        mute();
      }
    });
    // muteToolItem.setText("Mute");
    muteToolItem.setToolTipText("Mute the selected region");
    muteToolItem.setImage(AudioUtils.muteImage);

    insertSilenceToolItem = new ToolItem(dspToolbar, SWT.PUSH);
    insertSilenceToolItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        insertSilence();
      }
    });
    // muteToolItem.setText("Mute");
    insertSilenceToolItem.setToolTipText("Insert 1 second of silence");
    insertSilenceToolItem.setImage(AudioUtils.insertSilenceImage);

    p = dspToolbar.computeSize(SWT.DEFAULT, SWT.DEFAULT);
    dspToolbar.setSize(p);
    p2 = dspControls.computeSize(p.x, p.y);
    dspControls.setControl(dspToolbar);
    dspControls.setSize(p2);

    // end
    playbackControls = new CoolItem(coolBar, SWT.PUSH);

    toolBar_2 = new ToolBar(coolBar, SWT.NONE);
    playbackControls.setControl(toolBar_2);

    playToolItem = new ToolItem(toolBar_2, SWT.PUSH);
    playToolItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        play();
      }
    });
    playToolItem.setToolTipText("Play audio");
    playToolItem.setImage(AudioUtils.playImage);

    stopToolItem = new ToolItem(toolBar_2, SWT.PUSH);
    stopToolItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        stop();
      }
    });
    stopToolItem.setToolTipText("Stop");
    stopToolItem.setImage(AudioUtils.stopImage);

    resetToolItem = new ToolItem(toolBar_2, SWT.PUSH);
    resetToolItem.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        moveToStart();
      }
    });
    resetToolItem.setToolTipText("Rewind to beginning");
    resetToolItem.setImage(AudioUtils.rewindImage);

    p = toolBar_2.computeSize(SWT.DEFAULT, SWT.DEFAULT);
    toolBar_2.setSize(p);
    p2 = playbackControls.computeSize(p.x, p.y);
    playbackControls.setControl(toolBar_2);
    playbackControls.setSize(p2);

    scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
    scrolledComposite.getHorizontalBar().setIncrement(10);
    scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    scrolledComposite.addKeyListener(keyAdapter);
    canvas = new WaveformEditorCanvas(scrolledComposite, SWT.NONE | SWT.DOUBLE_BUFFERED);
    canvas.setSize(749, 233);
    scrolledComposite.setContent(canvas);
    scrolledComposite.getHorizontalBar().addListener(SWT.Selection, new Listener() {
      public void handleEvent(Event e) {
        if (e.detail == SWT.DRAG)
          return; // we're still dragging
        canvas.redraw();
      }
    });

    // composite = new Composite(shell, SWT.NONE);
    // composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    // final GridLayout gridLayout = new GridLayout();
    // gridLayout.numColumns = 3;
    // composite.setLayout(gridLayout);
    //
    // selectionLabel = new Label(composite, SWT.NONE);
    // final GridData gd_selectionLabel = new GridData(SWT.FILL, SWT.CENTER, true, false);
    // selectionLabel.setLayoutData(gd_selectionLabel);

    //
    adjustCanvasSize();
    return shell;
  }

  protected void insertSilence() {
    if (canvas.tracker.hasSelection()) {
      int[] selection = canvas.tracker.getSampleSelection();
      byte[] buffer = createSilence();
      clip.paste(selection[0], buffer);
      adjustCanvasSize();
      canvas.redraw();
    }

  }

  private byte[] createSilence() {
    float samplesPerSec = clip.getSampleRate();
    int size = clip.getFrameSize();
    byte[] buf = new byte[Math.round(samplesPerSec) * size];
    return buf;
  }

  protected void selectEndToLeft() {
    canvas.tracker.addToSelectionEnd(-ARROW_INC);
    scrollTo(canvas.tracker.selectionStart);
  }

  protected void selectEndToRight() {
    canvas.tracker.addToSelectionEnd(ARROW_INC);
    scrollTo(canvas.tracker.selectionEnd);
  }

  protected void selectStartToLeft() {
    canvas.tracker.addToSelectionStart(-ARROW_INC);
    scrollTo(canvas.tracker.selectionStart);
  }

  protected void selectStartToRight() {
    canvas.tracker.addToSelectionStart(ARROW_INC);
    scrollTo(canvas.tracker.selectionEnd);
  }

  protected void selectToBeginning() {
    canvas.tracker.selectToBeginning();
    scrollTo(0);
  }

  protected void selectToEnd() {
    canvas.tracker.selectToEnd();
    scrollTo(canvas.tracker.selectionEnd);
  }

  protected void moveCursorToBeginning() {
    canvas.tracker.moveToStart();
    scrollToSelection();
  }

  protected void moveCursorToEnd() {
    canvas.tracker.moveToEnd();
    scrollToSelection();
  }

  protected void zoomToFit() {
    if (!canvas.tracker.hasSelection())
      return;

    int width = scrolledComposite.getClientArea().width;
    int[] selection = canvas.tracker.currentSelectionInSamples;
    if (selection == null)
      return;

    int selectionWidth = selection[1] - selection[0];
    double actualSamplesPerPix = selectionWidth / (double) width;

    samplesPerPixel = Math.max(ZOOM_INC, ((int) Math.ceil(actualSamplesPerPix / ZOOM_INC))
        * ZOOM_INC);
    zoomValueChanged();

  }

  private void scrollToSelection() {
    Point cp = canvas.getLocation();
    int width = scrolledComposite.getClientArea().width;
    int start = canvas.tracker.selectionStart;
    int end = canvas.tracker.selectionEnd;
    if (end < start) {
      int temp = end;
      end = start;
      start = temp;
    }

    boolean startInWindow = (cp.x + start) > 0;
    boolean endInWindow = (cp.x + end) < width;
    if (startInWindow && endInWindow)
      return;

    int curBarPos = scrolledComposite.getHorizontalBar().getSelection();
    if (startInWindow && (end - start) < width) {
      scrolledComposite.getHorizontalBar().setSelection(Math.max(0, end - width));
      cp.x = -(end - width);
    } else {
      scrolledComposite.getHorizontalBar().setSelection(Math.max(0, start));

      cp.x = -start;

    }
    canvas.setLocation(cp);
    canvas.redraw();
  }

  private void scrollTo(int pos) {
    Point cp = canvas.getLocation();
    int width = scrolledComposite.getClientArea().width;
    int start = pos;
    int end = pos;
    if (end < start) {
      int temp = end;
      end = start;
      start = temp;
    }

    boolean startInWindow = (cp.x + start) > 0;
    boolean endInWindow = (cp.x + end) < width;
    if (startInWindow && endInWindow) {
      canvas.redraw();
      return;
    }

    int curBarPos = scrolledComposite.getHorizontalBar().getSelection();
    if (startInWindow && (end - start) < width) {
      scrolledComposite.getHorizontalBar().setSelection(Math.max(0, end - width));
      cp.x = -(end - width);
    } else {
      scrolledComposite.getHorizontalBar().setSelection(Math.max(0, start));

      cp.x = -start;

    }
    canvas.setLocation(cp);
    canvas.redraw();
  }

  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    selectionLabel = new Label(parent, SWT.NONE);
    final GridData gd_selectionLabel = new GridData(SWT.FILL, SWT.CENTER, true, false);
    selectionLabel.setLayoutData(gd_selectionLabel);
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }

  @Override
  protected void setButtonLayoutData(Button button) {
    final GridData data = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    data.widthHint = 45;
    button.setLayoutData(data);
  }

  @Override
  protected Control createButtonBar(Composite parent) {
    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 3;
    composite.setLayout(gridLayout);
    createButtonsForButtonBar(composite);
    return composite;
  }

  protected void cut() {

    try {
      if (!canvas.tracker.hasSelection())
        return;
      int[] selection = canvas.tracker.getSampleSelection();

      // clip.deleteSelection(selection[0], selection[1]);
      byte[] data = clip.getSelection(selection[0], selection[1]);
      clipboard.setContents(new Object[] { data },
          new Transfer[] { AudioDataTransfer.getInstance() });
      clip.cut(selection[0], selection[1]);
      canvas.tracker.clearSelection();
      adjustCanvasSize();
      canvas.redraw();
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Edit Error", "Couldn't cut the selection: "
          + e.getLocalizedMessage());
    }
  }

  protected void delete() {
    try {
      if (!canvas.tracker.hasSelection())
        return;
      int[] selection = canvas.tracker.getSampleSelection();

      clip.cut(selection[0], selection[1]);
      canvas.tracker.clearSelection();
      adjustCanvasSize();
      canvas.redraw();
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Edit Error", "Couldn't delete the selection: "
          + e.getLocalizedMessage());
    }
  }

  protected void copy() {
    try {
      if (!canvas.tracker.hasSelection())
        return;
      int[] selection = canvas.tracker.getSampleSelection();
      byte[] data = clip.getSelection(selection[0], selection[1]);
      clipboard.setContents(new Object[] { data },
          new Transfer[] { AudioDataTransfer.getInstance() });
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Edit Error", "Couldn't copy the selection: "
          + e.getLocalizedMessage());
    }
  }

  protected void paste() {
    try {
      int selection = canvas.tracker.getCursorSamplePos();
      byte[] data = (byte[]) clipboard.getContents(AudioDataTransfer.getInstance());
      if (data == null)
        return;
      clip.paste(selection, data);
      canvas.tracker.clearSelection();
      adjustCanvasSize();
      canvas.redraw();
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Edit Error", "Couldn't paste the selection: "
          + e.getLocalizedMessage());
    }
  }

  protected void undo() {
    try {
      clip.undo();
      adjustCanvasSize();
      canvas.redraw();
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Undo Error", "Couldn't undo the operation: "
          + e.getLocalizedMessage());
    }
  }

  protected void redo() {
    try {
      clip.redo();
      adjustCanvasSize();
      canvas.redraw();
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Redo Error", "Couldn't redo the operation: "
          + e.getLocalizedMessage());
    }
  }

  protected void mute() {
    try {
      if (!canvas.tracker.hasSelection())
        return;
      int[] selection = canvas.tracker.getSampleSelection();
      clip.mute(selection[0], selection[1]);
      canvas.redraw();
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Edit Error", "Couldn't mute the selection: "
          + e.getLocalizedMessage());
    }
  }

  protected void decreaseAmplitude() {
    try {
      if (!canvas.tracker.hasSelection())
        return;
      int[] selection = canvas.tracker.getSampleSelection();
      clip.changeAmplitude(selection[0], selection[1], -0.1f);
      canvas.redraw();
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Edit Error",
          "Couldn't decrease amplitude for the selection: " + e.getLocalizedMessage());
    }

  }

  protected void increaseAmplitude() {
    try {
      if (!canvas.tracker.hasSelection())
        return;
      int[] selection = canvas.tracker.getSampleSelection();
      clip.changeAmplitude(selection[0], selection[1], 0.1f);
      canvas.redraw();
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Edit Error",
          "Couldn't increase amplitude for the selection: " + e.getLocalizedMessage());
    }

  }

  protected void selectAll() {
    try {
      canvas.tracker.selectAll();
      clip.setSelection(0, clip.getLengthInSamples());
      canvas.redraw();
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Select Error", "Couldn't select entire waveform: "
          + e.getLocalizedMessage());
    }
  }

  public RecordableClip getClip() {
    return clip;
  }

  public void setClip(final RecordableClip clip) {
    this.clip = clip;
    if (canvas != null && !canvas.isDisposed()) {
      adjustCanvasSize();
      scrolledComposite.layout();
      canvas.redraw();
    }
    clip.addClipListener(new RecordableClip.ClipListener() {
      @Override
      public void newData(int offset, int length) {

      }

      @Override
      public void newPlayHead(long playhead) {

        Shell shell = getShell();
        if (shell == null || shell.isDisposed())
          return;

        Display d = shell.getDisplay();
        if (d == null || d.isDisposed())
          return;
        d.asyncExec(new Runnable() {
          @Override
          public void run() {
            if (!canvas.isDisposed())
              canvas.redraw();
          }
        });
      }

      @Override
      public void playerCreated(DataLine player) {

      }

      @Override
      public void playerDisposed(DataLine player) {
      }

      @Override
      public void playerStopped(DataLine player) {
        Display d = getShell().getDisplay();
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

  protected void play() {
    if (state == PlayState.PLAYING)
      return;
    state = PlayState.PLAYING;
    try {
      if (clip != null) {
        System.out.println("Starting...");
        setStopEnabled(true);
        setPlayEnabled(false);
        if (canvas.tracker.hasSelection()) {
          int[] selection = canvas.tracker.getSampleSelection();
          clip.setSelection(selection[0], selection[1]);
        } else {
          clip.clearSelection();
          // int start = canvas.tracker.selectionStart;
          // if (start >= 0){
          // clip.setSelection(start, start);
          // }

        }
        clip.start();
      }
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Audio Error", "Couldn't play audio: "
          + e.getLocalizedMessage());
    }
  }

  protected void stop() {
    if (state == PlayState.STOPPED)
      return;
    state = PlayState.STOPPED;
    try {
      if (clip != null) {
        System.out.println("Stopping...");
        setStopEnabled(false);
        setPlayEnabled(true);
        // cursorPixelPosition = clip.getPlayHead();
        clip.stop();
        clip.reset();
      }
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Audio Error", "Couldn't stop audio: "
          + e.getLocalizedMessage());
    }
  }

  protected void moveToStart() {
    canvas.tracker.clearSelection();
    if (!canvas.isDisposed())
      canvas.redraw();
  }

  private void setPlayEnabled(boolean b) {
    if (playToolItem.isDisposed())
      return;
    playToolItem.setEnabled(b);

  }

  private void setStopEnabled(boolean b) {
    if (stopToolItem.isDisposed())
      return;
    stopToolItem.setEnabled(b);
  }

  private void adjustCanvasSize() {
    int length = clip.getLengthInSamples();
    Point pt = canvas.getSize();

    int scrolledHeight = scrolledComposite.getClientArea().height;
    canvas.setSize((int) Math.round(length / (double) samplesPerPixel), scrolledHeight == 0 ? pt.y
        : scrolledHeight);

  }

  private void zoomValueChanged() {

    canvas.tracker.zoomLevelChanged();
    adjustCanvasSize();
    // canvas.redraw();
    scrollToSelection();
  }

  class WaveformEditorCanvas extends Canvas {

    private static final int DRAW_TENTH_SCALE_THRESHOLD = 20;
    private static final int DRAW_HUNDREDTH_SCALE_THRESHOLD = 75;
    private SelectionTracker tracker;

    public WaveformEditorCanvas(Composite parent, int style) {
      super(parent, style);
      setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
      addPaintListener(new PaintListener() {
        long lastPaint = -1;

        @Override
        public void paintControl(PaintEvent evt) {
          // if (lastPaint >= 0 && evt.time - lastPaint < 100)
          // return;
          lastPaint = evt.time;

          paint(evt.gc, evt.x, evt.y, evt.width, evt.height);
        }
      });

      tracker = new SelectionTracker();
      addMouseMoveListener(tracker);
      addMouseListener(tracker);
      addMouseTrackListener(tracker);
    }

    private int getScaledSampleHeight(Rectangle clientArea, int max_sample_height, int sample) {
      double scaleFactor = clientArea.height / (max_sample_height * 1.2d);
      return (int) Math.round(sample * scaleFactor);
    }

    public void paint(GC g, int paintx, int painty, int paintWidth, int paintHeight) {
      int lengthInSamples = -1;
      if (clip == null || (lengthInSamples = clip.getLengthInSamples()) == 0) {
        return;
      }
      // int tmppaintx = paintx;
      // int tmppaintwidth = paintWidth;
      //      
      // if (lastxPaintX != -1){
      // if (lastxPaintX > paintx){ //scrolling forward
      // paintWidth += (lastxPaintX - (paintx+paintWidth));
      // } else {
      // paintx = lastxPaintX+lastPaintWidth;
      // }
      // }
      // lastxPaintX=tmppaintx;
      // lastPaintWidth = tmppaintwidth;

      // paintWidth = Math.max(20, paintWidth);
      g.setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
      g.setForeground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
      Rectangle clientArea = getClientArea();
      // int samplesPerPixel = lengthInSamples / clientArea.width;
      long average_ct = 0;
      int max_sample_height = clip.getMaxSampleHeight();

      Rectangle scrollableClientArea = scrolledComposite.getClientArea();
      int midY = scrollableClientArea.height / 2;
      // g.setColor(Color.BLACK);

      // Point canvasPos = canvas.getLocation();

      // paintx = -canvasPos.x + 10;
      // paintWidth = scrollableClientArea.width+20;

      int lasty = midY;
      int lastx = 0;
      int pixel = 0;
      int canvasAreaWidth = clientArea.width;

      if (optimizedRendering) {
        pixel = paintx;
        lasty = -1;
      } else {
        pixel = 0;
        paintx = 0;
        paintWidth = canvasAreaWidth;
      }

      int startSample = paintx * samplesPerPixel;

      for (int i = startSample; i < lengthInSamples; i++) {
        int sample = clip.getSample(i);

        average_ct++;
        if (average_ct % samplesPerPixel == 0) {
          if (tracker.isSelected(pixel)) {
            g.setForeground(getDisplay().getSystemColor(SWT.COLOR_GREEN));
            g.drawLine(pixel, 0, pixel, clientArea.height);
            g.setForeground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
          }
          int height = getScaledSampleHeight(scrollableClientArea, max_sample_height, sample);
          //            
          // float average = average_sum / average_ct;
          // int height = Math.round((average / max_sample_height) * clientArea.height);
          int x = pixel;
          int y = midY - height;
          if (lasty != -1)
            g.drawLine(lastx, lasty, x, y);
          lastx = x;
          lasty = y;

          pixel++;
          average_ct = 0;

          if (pixel >= (paintx + paintWidth))
            break;
        }

      }
      // if (clip.isPlaying()) {
      int head = (int) clip.getPlayHead();
      cursorPixelPosition = (int) (head / (double) samplesPerPixel);
      // }

      // System.out.println("zamples perzone "+samplesPerZone+" so start is "+startSample+" with zone "+zone);

      if (cursorPixelPosition >= paintx && cursorPixelPosition <= (paintx + paintWidth)) {
        drawBar(g);
      }
      // mClip.getPlayHead() / SAMPLES_PER_PIXEL;
      // g.drawRect(0, 10, 1, -10);

      g.setForeground(getDisplay().getSystemColor(SWT.COLOR_GRAY));
      g.drawLine(paintx, midY, paintx + paintWidth, midY);
      g.setForeground(getDisplay().getSystemColor(SWT.COLOR_BLUE));
      drawTimeScale(g, scrollableClientArea, clientArea, paintx, paintWidth);
    }

    private void drawTimeScale(GC g, Rectangle scrollableClientArea, Rectangle clientArea,
        int paintx, int paintWidth) {
      paintx = 0;
      paintWidth = clientArea.width;
      // TODO Auto-generated method stub
      int scaleY = scrollableClientArea.height - 2;
      int lastScaleX = 0;
      float samplesPerSec = clip.getSampleRate();
      double pixelsPerSec = samplesPerSec / (double) samplesPerPixel;
      double pixelsPerTenthSec = samplesPerSec / (samplesPerPixel * 10d);

      g.drawLine(paintx, scaleY, paintx + paintWidth, scaleY);
      double currentMarker = 0;
      int seconds = 0;
      int count = 0;
      boolean drawHundredths = pixelsPerTenthSec > DRAW_HUNDREDTH_SCALE_THRESHOLD;
      boolean drawTenths = pixelsPerTenthSec > DRAW_TENTH_SCALE_THRESHOLD;
      if (drawHundredths) {
        int tenths = 0;
        double pixelsPerHundredth = pixelsPerTenthSec * .1d;
        while (currentMarker < clientArea.width) {
          if (count % 100 == 0) {
            if (currentMarker > paintx) {
              g.drawLine((int) currentMarker, scaleY, (int) currentMarker, scaleY - 10);
              String text = String.valueOf(seconds);
              Point pt = g.textExtent(text);
              g.drawText(text, (int) (currentMarker - (pt.x * 0.5d)), scaleY - (9 + pt.y), true);
            }
            seconds++;
            tenths = 0;
          } else if (count % 10 == 0) {
            if (tenths++ > 0 && currentMarker > paintx) {
              String text = "0." + String.valueOf(tenths);
              Point pt = g.textExtent(text);
              g.drawText(text, (int) (currentMarker - (pt.x * 0.5d)), scaleY - (8 + pt.y), true);
              g.drawLine((int) currentMarker, scaleY, (int) currentMarker, scaleY - 7);
            }
          } else if (currentMarker > paintx) {
            g.drawLine((int) currentMarker, scaleY, (int) currentMarker, scaleY - 4);
          }

          count++;
          currentMarker += pixelsPerHundredth;
          if (currentMarker > (paintx + paintWidth))
            break;
        }
      } else if (drawTenths) {
        while (currentMarker < clientArea.width) {
          if (count % 10 == 0) {
            if (currentMarker > paintx) {
              g.drawLine((int) currentMarker, scaleY, (int) currentMarker, scaleY - 10);
              String text = String.valueOf(seconds);
              Point pt = g.textExtent(text);
              g.drawText(text, (int) (currentMarker - (pt.x * 0.5d)), scaleY - (9 + pt.y), true);
            }
            seconds++;
          } else if (currentMarker > paintx) {
            g.drawLine((int) currentMarker, scaleY, (int) currentMarker, scaleY - 7);
          }
          count++;
          currentMarker += pixelsPerTenthSec;
          if (currentMarker > (paintx + paintWidth))
            break;
        }
      } else {
        while (currentMarker < clientArea.width) {
          if (currentMarker > paintx) {
            g.drawLine((int) currentMarker, scaleY, (int) currentMarker, scaleY - 10);
            String text = String.valueOf(count);
            Point pt = g.textExtent(text);
            g.drawText(text, (int) (currentMarker - (pt.x * 0.5d)), scaleY - (9 + pt.y), true);
          }
          count++;
          currentMarker += pixelsPerSec;
          if (currentMarker > (paintx + paintWidth))
            break;
        }
      }

    }

    void drawBar(GC g) {
      if (g != null) {
        // g.setForeground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
        // g.setXORMode(true);
        g.drawLine(cursorPixelPosition, 0, cursorPixelPosition, getClientArea().height);
      }
    }
  }

  private enum DragMode {
    START, END, NONE
  };

  private static final int SELECTION_GRAB_ZONE = 10;
  private static final int SCROLL_DRAG_ZONE = 15;
  private static final int MIN_SCROLL_INC = 10;
  private static final int MAX_SCROLL_INC = 100;

  public class SelectionTracker implements MouseListener, MouseMoveListener, MouseTrackListener {

    private DragMode dragging = DragMode.NONE;
    private int selectionStart;
    private int selectionEnd;

    private int[] currentSelectionInSamples = new int[] { 0, 0 };

    public SelectionTracker() {
      getShell().getDisplay().timerExec(200, new DragAutoScroller());
    }

    public void moveToStart() {
      canvas.tracker.selectionStart = 0;
      canvas.tracker.selectionEnd = 0;
      canvas.tracker.updateSampleSelection();
    }

    public void moveToEnd() {
      int pos = canvas.getClientArea().width - 1;
      canvas.tracker.selectionStart = pos;
      canvas.tracker.selectionEnd = pos;
      canvas.tracker.updateSampleSelection();
    }

    public void selectAll() {
      int start, end;
      if (selectionEnd < selectionStart) {
        start = selectionEnd;
        end = selectionStart;
      } else {
        start = selectionStart;
        end = selectionEnd;
      }
      start = 0;
      end = canvas.getClientArea().width - 1;

      if (selectionEnd < selectionStart) {
        selectionEnd = start;
        selectionStart = end;
      } else {
        selectionStart = start;
        selectionEnd = end;
      }

      updateSampleSelection();
      dragging = DragMode.NONE;
      updateSelectionLabel();
    }

    public void addToSelectionEnd(int amt) {
      selectionEnd += amt;
      selectionEnd = Math.min(canvas.getClientArea().width, Math.max(selectionEnd, 0));

      updateSampleSelection();
      dragging = DragMode.NONE;
      updateSelectionLabel();
    }

    public void addToSelectionStart(int amt) {
      selectionStart += amt;
      selectionStart = Math.min(canvas.getClientArea().width, Math.max(selectionStart, 0));

      updateSampleSelection();
      dragging = DragMode.NONE;
      updateSelectionLabel();
    }

    public void selectToBeginning() {

      selectionEnd = 0;
      updateSampleSelection();
      dragging = DragMode.NONE;
      updateSelectionLabel();
    }

    public void selectToEnd() {

      int end = canvas.getClientArea().width - 1;
      selectionEnd = end;
      updateSampleSelection();
      dragging = DragMode.NONE;
      updateSelectionLabel();
    }

    public void clearSelection() {
      selectionEnd = selectionStart = 0;
      dragging = DragMode.NONE;
      currentSelectionInSamples = new int[] { 0, 0 };
    }

    public int getCursorPos() {
      return selectionStart;
    }

    public int getCursorSamplePos() {
      int start = Math.min(selectionStart, selectionEnd);
      start = Math.max(0, start);
      return (samplesPerPixel * start);
    }

    public boolean hasSelection() {
      return (selectionStart > -1 && selectionEnd > -1);
      // return (selectionStart != selectionEnd);
    }

    public void zoomLevelChanged() {

      int start = (int) Math.floor(currentSelectionInSamples[0] / samplesPerPixel);
      int end = (int) Math.floor(currentSelectionInSamples[1] / samplesPerPixel);
      if (selectionEnd < selectionStart) {
        selectionEnd = start;
        selectionStart = end;
      } else {
        selectionEnd = end;
        selectionStart = start;
      }

    }

    public int[] getSampleSelection() {
      if (currentSelectionInSamples != null)
        return currentSelectionInSamples;
      if (selectionStart == -1 || selectionEnd == -1)
        return null;
      int start, end;
      if (selectionEnd < selectionStart) {
        start = selectionEnd;
        end = selectionStart;
      } else {
        start = selectionStart;
        end = selectionEnd;
      }
      start = Math.max(0, start);
      end = Math.min((int) Math.floor(clip.getLengthInSamples() / (double) samplesPerPixel), end);
      int[] selection = new int[] { samplesPerPixel * start, samplesPerPixel * end };

      return selection;
    }

    public void updateSampleSelection() {
      // if (selectionStart == -1 || selectionEnd == -1) {
      // currentSelectionInSamples = null;
      // return;
      // }

      int start, end;
      if (selectionEnd < selectionStart) {
        start = selectionEnd;
        end = selectionStart;
      } else {
        start = selectionStart;
        end = selectionEnd;
      }
      if (start == end) {
        end = Math.min((int) Math.floor(clip.getLengthInSamples() / (double) samplesPerPixel), end);
        start = end;
        currentSelectionInSamples = new int[] { samplesPerPixel * end, samplesPerPixel * end };
      } else {
        start = Math.max(0, start);
        end = Math.min((int) Math.floor(clip.getLengthInSamples() / (double) samplesPerPixel), end);
        currentSelectionInSamples = new int[] { samplesPerPixel * start, samplesPerPixel * end };

      }
    }

    public boolean isSampleSelected(int sample) {
      return sample >= currentSelectionInSamples[0] && sample <= currentSelectionInSamples[1];
    }

    public boolean isSelected(int pixel) {
      if (selectionStart == pixel || selectionEnd == pixel)
        return true;
      int start, end;
      if (selectionEnd < selectionStart) {
        start = selectionEnd;
        end = selectionStart;
      } else {
        start = selectionStart;
        end = selectionEnd;
      }

      if (pixel >= start && pixel <= end)
        return true;
      return false;
    }

    @Override
    public void mouseDoubleClick(MouseEvent e) {
      // if (canvas.getClientArea().contains(e.x, e.y)) {
      // dragging = false;
      // selectionEnd = -1;
      // currentSelectionInSamples = null;
      // }
    }

    @Override
    public void mouseDown(MouseEvent e) {
      if (canvas.getClientArea().contains(e.x, e.y)) {
        dragging = DragMode.END;
        currentSelectionInSamples = null;
        if ((e.stateMask & SWT.SHIFT) != 0) {
          selectionEnd = e.x;
          dragging = DragMode.NONE;
          updateSampleSelection();
          canvas.redraw();
        } else if ((e.stateMask & SWT.CTRL) != 0) {
          selectionStart = e.x;
          dragging = DragMode.NONE;
          updateSampleSelection();
          canvas.redraw();
        } else if ((Math.abs(e.x - selectionEnd) < SELECTION_GRAB_ZONE)) {

          dragging = DragMode.END;
        } else if ((Math.abs(e.x - selectionStart) < SELECTION_GRAB_ZONE)) {
          dragging = DragMode.START;

        } else {
          selectionStart = selectionEnd = e.x;
          updateSampleSelection();
        }
      }
    }

    @Override
    public void mouseUp(MouseEvent e) {
      if (dragging != DragMode.NONE) {
        if (dragging == DragMode.END)
          selectionEnd = Math.min(canvas.getClientArea().width, Math.max(e.x, 0));
        else
          selectionStart = Math.min(canvas.getClientArea().width, Math.max(e.x, 0));

        if (selectionEnd < selectionStart) {
          int temp = selectionEnd;
          selectionEnd = selectionStart;
          selectionStart = temp;
        }
        updateSampleSelection();
        updateSelectionLabel();

        dragging = DragMode.NONE;
        canvas.redraw();
      }
    }

    public void updateSelectionLabel() {

      if (currentSelectionInSamples == null)
        selectionLabel.setText("Selection start: " + (getCursorPos() * samplesPerPixel)
            / clip.getSampleRate());
      else
        selectionLabel.setText("Selection start: "
            + SHORT_DECIMAL_FORMAT.format(currentSelectionInSamples[0] / clip.getFrameRate())
            + " end: "
            + SHORT_DECIMAL_FORMAT.format(currentSelectionInSamples[1] / clip.getFrameRate())
            + " seconds");
    }

    @Override
    public void mouseMove(MouseEvent e) {
      if (dragging != DragMode.NONE) {
        if (dragging == DragMode.END)
          selectionEnd = e.x;
        else
          selectionStart = e.x;
        updateSampleSelection();
        updateSelectionLabel();
        canvas.redraw();
      } else {

        if (selectionEnd != -1
            && (Math.abs(e.x - selectionEnd) < SELECTION_GRAB_ZONE || Math
                .abs(e.x - selectionStart) < SELECTION_GRAB_ZONE)) {
          if ((e.stateMask & SWT.BUTTON1) == 0) {
            canvas.setCursor(getShell().getDisplay().getSystemCursor(SWT.CURSOR_SIZEWE));
          }
        } else {
          Cursor c = canvas.getCursor();
          Cursor def = getShell().getDisplay().getSystemCursor(SWT.DEFAULT);
          if (c != def)
            canvas.setCursor(def);
        }

      }

    }

    @Override
    public void mouseEnter(MouseEvent e) {
      // TODO Auto-generated method stub

    }

    @Override
    public void mouseExit(MouseEvent e) {
      // TODO Auto-generated method stub

    }

    @Override
    public void mouseHover(MouseEvent e) {
      // TODO Auto-generated method stub

    }

    // public void zoomChanged() {
    // if (selectionStart != -1 && selectionEnd != -1) {
    // selectionStart = (int) (selectionStart / zoomLevel);
    // selectionEnd = (int) (selectionEnd / zoomLevel);
    // }
    // }

  }

  class DragAutoScroller implements Runnable {
    Display display;

    public DragAutoScroller() {
      display = getShell().getDisplay();
    }

    @Override
    public void run() {
      if (display.isDisposed() || scrolledComposite.isDisposed())
        return;
      Point pt = display.getCursorLocation();
      pt = display.map(null, scrolledComposite, pt);
      if (canvas.tracker.dragging != DragMode.NONE && pt.x < SCROLL_DRAG_ZONE) {
        int dist = Math.abs(pt.x - SCROLL_DRAG_ZONE);
        int inc = Math.min(MAX_SCROLL_INC, MIN_SCROLL_INC + dist);
        ScrollBar horizontalBar = scrolledComposite.getHorizontalBar();
        int selection = horizontalBar.getSelection();
        if (selection > horizontalBar.getMinimum()) {
          horizontalBar.setSelection(Math.max(0, selection - inc));
          Point cp = canvas.getLocation();
          cp.x += inc;
          cp.x = Math.min(0, cp.x);
          canvas.setLocation(cp);
        }
      } else if (canvas.tracker.dragging != DragMode.NONE
          && pt.x > (scrolledComposite.getClientArea().width - SCROLL_DRAG_ZONE)) {
        int dist = pt.x - (scrolledComposite.getClientArea().width - SCROLL_DRAG_ZONE);
        int inc = Math.min(MAX_SCROLL_INC, MIN_SCROLL_INC + dist);
        ScrollBar horizontalBar = scrolledComposite.getHorizontalBar();
        int selection = horizontalBar.getSelection();
        if (selection < horizontalBar.getMaximum()) {
          horizontalBar.setSelection(Math.min(horizontalBar.getMaximum(), selection + inc));
          Point cp = canvas.getLocation();
          cp.x -= inc;
          cp.x = Math.max(-(canvas.getSize().x - scrolledComposite.getClientArea().width), cp.x);
          canvas.setLocation(cp);
        }
      }

      if (display.isDisposed())
        return;
      else
        display.timerExec(200, this);
    }

  }
  static class AudioDataTransfer extends ByteArrayTransfer {

    private static final String TYPENAME = "audio_bytes"; //$NON-NLS-1$

    private static final int TYPEID = registerType(TYPENAME);

    private static AudioDataTransfer _instance = new AudioDataTransfer();

    public static AudioDataTransfer getInstance() {
      return _instance;
    }

    @Override
    public void javaToNative(Object object, TransferData transferData) {
      if (!checkMyType(object) || !isSupportedType(transferData)) {
        DND.error(DND.ERROR_INVALID_DATA);
      }
      byte[] buffer = (byte[]) object;
      super.javaToNative(buffer, transferData);
    }

    @Override
    public Object nativeToJava(TransferData transferData) {
      if (isSupportedType(transferData)) {

        byte[] buffer = (byte[]) super.nativeToJava(transferData);
        return buffer;
      }
      return null;
    }

    @Override
    protected String[] getTypeNames() {
      return new String[] { TYPENAME };
    }

    @Override
    protected int[] getTypeIds() {
      return new int[] { TYPEID };
    }

    boolean checkMyType(Object object) {
      if (object == null || !(object instanceof byte[]) || ((byte[]) object).length == 0)
        return false;

      return true;
    }

    @Override
    protected boolean validate(Object object) {
      return checkMyType(object);
    }
  }

  public static void main(String[] args) throws IOException, AudioException {
    File file = new File("D:\\temp\\RadioQuality.wav");
    AudioFormat format = new AudioFormat(22050.0f, 16, 1, true,
        AudioCommon.SYSTEM_BYTE_ORDER == ByteOrder.BIG_ENDIAN);
    RecordableClip clip = new RecordableClip(file, format);
    Shell shell = new Shell();
    WaveformEditor editor = new WaveformEditor(shell);
    editor.setClip(clip);
    editor.open();
  }

  public byte[] getAudioData() {
    // if (clip != null){
    // byte[] data = clip.getAudioData();
    // int len = clip.getLengthInBytes();
    // byte[] temp = new byte[len];
    // System.arraycopy(data, 0, temp, 0, len);
    // return data;
    // }
    // else {
    // return data;
    // }

    byte[] temp = null;
    byte[] dat = null;
    int len = 0;
    if (clip != null) {
      dat = clip.getAudioData();
      len = clip.getLengthInBytes();
    } else {
      dat = data;
      len = dat.length;
    }
    if (dat == null || dat.length == 0)
      return new byte[0];

    temp = new byte[len];
    System.arraycopy(dat, 0, temp, 0, len);
    return temp;
  }

  public void dispose() {
    data = null;
  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("Safi Waveform Editor");
  }

  public void setSaveClipOnExit(boolean b, Type type) {
    saveOnExit = b;
    if (b)
      this.saveType = type;

  }
}
