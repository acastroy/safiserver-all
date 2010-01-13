package com.safi.workshop.audio;

import java.io.File;
import java.nio.ByteOrder;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import com.safi.workshop.audio.utils.AudioCommon;
import com.safi.workshop.audio.utils.AudioConverter;
import com.safi.workshop.audio.utils.AudioUtils;
import com.safi.workshop.audio.utils.RecordableClip;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.swtdesigner.ResourceManager;

public class ImportPromptPage extends WizardPage {
  private Composite composite;
  private Button openWaveformEditorButton;
  private Text text;
  private Label errorLabel;
  private File audioFile;
  private String oldText = "";
  private Button convertButton;
  private PromptMediaController promptMediaController;
  private AudioFormat convertedFormat;

  /**
   * Create the wizard
   */
  public ImportPromptPage() {
    super("wizardPage");
    setTitle("New Prompt Wizard");
    setDescription("Select a valid audio file from your local file system");
    setImageDescriptor(ResourceManager.getPluginImageDescriptor(AsteriskDiagramEditorPlugin
        .getDefault(), "icons/wizban/PromptWizard.gif"));
  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 4;
    container.setLayout(gridLayout);
    //
    setControl(container);
    final Label fileLabel = new Label(container, SWT.RIGHT);
    fileLabel.setAlignment(SWT.RIGHT);
    fileLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, false));
    fileLabel.setText("File:");
    text = new Text(container, SWT.BORDER);
    text.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false));
    text.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        // errorLabel.setText("");
      }

      @Override
      public void focusLost(FocusEvent e) {
        textChanged();
      }
    });
    final Button browseButton = new Button(container, SWT.NONE);
    browseButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        FileDialog dlg = new FileDialog(getShell(), SWT.OPEN);
        dlg.setFileName(text.getText());
        dlg.setText("Select audio file");
        String file = dlg.open();
        if (file != null) {
          text.setText(file);
          textChanged();
        }
      }
    });
    browseButton.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false));
    browseButton.setText("Browse");
    convertButton = new Button(container, SWT.NONE);
    convertButton.setEnabled(false);
    convertButton.setLayoutData(new GridData());
    convertButton.setText("Convert");
    convertButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        audioFile = doConversion(text.getText());
        if (audioFile != null) {
          convertButton.setEnabled(false);
          setPageComplete(true);
          errorLabel.setText("Conversion Successful");
          loadMediaController();
          openWaveformEditorButton.setEnabled(true);
        } else
          openWaveformEditorButton.setEnabled(false);
      }
    });
    new Label(container, SWT.NONE);

    composite = new Composite(container, SWT.NONE);
    composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
    composite.setLayout(new GridLayout());
    errorLabel = new Label(composite, SWT.CENTER);
    errorLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    errorLabel.setForeground(getShell().getDisplay().getSystemColor(SWT.COLOR_RED));
    errorLabel.setText("No file entered");

    promptMediaController = new PromptMediaController(composite, SWT.NONE);
    promptMediaController.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    openWaveformEditorButton = new Button(promptMediaController.getButtonPanel(), SWT.NONE);
    openWaveformEditorButton.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin
        .getDefault(), "icons/audio/edit_waveform.gif"));
    openWaveformEditorButton.setEnabled(false);
    openWaveformEditorButton.setLayoutData(new GridData());
    openWaveformEditorButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        openWaveformEditor();
      }
    });
    setPageComplete(false);
  }

  protected void openWaveformEditor() {
    if (audioFile == null)
      return;
    try {

      AudioConverter converter = new AudioConverter();
      converter.setDesiredChannels(1);
      converter.setDesiredSampleRate(8000f);
      converter.setDesiredEncoding(AudioFormat.Encoding.PCM_SIGNED);
      converter.setDesiredBigEndian(AudioCommon.SYSTEM_BYTE_ORDER == ByteOrder.BIG_ENDIAN);
      converter.setInputFile(text.getText());
      AudioInputStream stream = converter.convert();
      AudioFormat convertedFormat = stream.getFormat();
      File f = File.createTempFile("temp", "wav");
      f.deleteOnExit();

      AudioSystem.write(stream, AudioFileFormat.Type.WAVE, f);

      WaveformEditor editor = new WaveformEditor(getShell());
      RecordableClip newclip = new RecordableClip(f, convertedFormat);
      editor.setSaveClipOnExit(true, AudioFileFormat.Type.WAVE);
      editor.setClip(newclip);
      int result = editor.open();
      if (result == Window.OK) {

        File gsmfile = doConversion(f.getAbsolutePath());
        audioFile = gsmfile;
        promptMediaController.loadFile(gsmfile);

      }
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Edit Waveform Error", "Couldn't open waveform editor: "
          + e.getLocalizedMessage());
    }
  }

  public File doConversion(String filename) {
    try {
      AudioConverter converter = new AudioConverter();
      converter.setDesiredChannels(1);
      converter.setDesiredSampleRate(8000f);
      converter.setDesiredEncoding(new AudioFormat.Encoding("GSM0610"));
      converter.setInputFile(filename);
      AudioInputStream stream = converter.convert();
      convertedFormat = stream.getFormat();
      File f = File.createTempFile("gsmtemp", "gsm");
      f.deleteOnExit();

      AudioSystem.write(stream, AudioUtils.GSM_FORMAT, f);
      return f;
      // return AudioUtils.convertToGSM(new File(text.getText()));
    } catch (Exception e) {
      MessageDialog.openError(getShell(), "Conversion Error", "Couldn't convert file "
          + text.getText() + " to GSM: " + e.getLocalizedMessage());
    }
    return null;
  }

  public File getAudioFile() {
    return audioFile;
  }

  public void setAudioFile(File audioFile) {
    this.audioFile = audioFile;
  }

  public String getFilename() {
    return text.getText();
  }

  private void textChanged() {
    String ft = text.getText();
    if (StringUtils.equals(oldText, ft))
      return;
    oldText = ft;
    audioFile = null;
    convertButton.setEnabled(false);
    openWaveformEditorButton.setEnabled(false);
    if (StringUtils.isBlank(oldText)) {
      setPageComplete(false);
    } else {
      File file = new File(oldText);
      if (!file.exists()) {
        setPageComplete(false);
        errorLabel.setText("File " + file + " does not exist");
      } else if (!file.getName().toLowerCase().endsWith(".gsm")) {
        errorLabel
            .setText("File is not int GSM format. Press 'convert' button to convert the file into GSM format.");
        convertButton.setEnabled(true);
        promptMediaController.disable();
      } else {
        audioFile = file;
        loadMediaController();
        setPageComplete(true);
      }
    }
  }

  private void loadMediaController() {
    try {
      promptMediaController.loadFile(audioFile);
    } catch (Exception e1) {
      e1.printStackTrace();
      MessageDialog.openWarning(getShell(), "Load Prompt Error",
          "Couldn't load prompt for playback: " + e1.getLocalizedMessage());
    }
  }
}
