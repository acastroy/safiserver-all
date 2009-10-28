package com.safi.workshop.preferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Port;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.swtdesigner.FieldLayoutPreferencePage;
import com.swtdesigner.preference.ComboFieldEditor;

public class AudioDevicesPrefPage extends FieldLayoutPreferencePage implements
    IWorkbenchPreferencePage {

  public final static String ID = "com.safi.workshop.preferences.AudioDevicesPrefPage";
  private static Map<String, Mixer> outputDevices = new HashMap<String, Mixer>();
  private static Map<String, Mixer> inputDevices = new HashMap<String, Mixer>();
  private static boolean preferencesInitialized;
  private ComboFieldEditor inputDeviceEditor;
  private ComboFieldEditor outputEditor;

  /**
   * Create the preference page
   */
  public AudioDevicesPrefPage() {
    super();
    setPreferenceStore(AsteriskDiagramEditorPlugin.getInstance().getPreferenceStore());
  }

  /**
   * Create contents of the preference page
   * 
   * @param parent
   */
  @Override
  public Control createPageContents(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    container.setBounds(0, 0, 573, 314);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.verticalSpacing = 10;
    gridLayout.marginTop = 10;
    gridLayout.marginLeft = 10;
    container.setLayout(gridLayout);
    Set<String> inputKeys = inputDevices.keySet();
    String[][] inputs = new String[inputKeys.size()][];
    int i = 0;
    for (String name : inputKeys) {
      inputs[i++] = new String[] { name, name };
    }
    Set<String> outputKeys = outputDevices.keySet();
    String[][] outputs = new String[outputKeys.size()][];
    i = 0;
    for (String name : outputKeys)
      outputs[i++] = new String[] { name, name };
    final Composite composite = new Composite(container, SWT.NONE);
    inputDeviceEditor = new ComboFieldEditor(PreferenceConstants.PREF_AUDIO_INPUT_DEVICE,
        "Select audio capture device", inputs, composite);
    addField(inputDeviceEditor);
    final Composite composite_1 = new Composite(container, SWT.NONE);
    outputEditor = new ComboFieldEditor(PreferenceConstants.PREF_AUDIO_OUTPUT_DEVICE,
        "Select audio output device", outputs, composite_1);
    addField(outputEditor);
    return container;
  }

  /**
   * Initialize the preference page
   */
  public void init(IWorkbench workbench) {
    // Initialize the preference page
  }

  public static synchronized void initDefaults(IPreferenceStore store) {
    if (preferencesInitialized)
      return;
    try {
      ArrayList<Mixer.Info> mixInfos = new ArrayList<Mixer.Info>(Arrays.asList(AudioSystem
          .getMixerInfo()));
      Line.Info sourceDLInfo = new Line.Info(SourceDataLine.class);
      Line.Info targetDLInfo = new Line.Info(TargetDataLine.class);
      Line.Info clipInfo = new Line.Info(Clip.class);
      Line.Info portInfo = new Line.Info(Port.class);
      for (Mixer.Info mixInfo : mixInfos) {
        Mixer mixer = AudioSystem.getMixer(mixInfo);
        if (mixer.isLineSupported(clipInfo))
          outputDevices.put(mixInfo.getName(), mixer);
        if (mixer.isLineSupported(targetDLInfo)) {
          inputDevices.put(mixInfo.getName(), mixer);
        }
      }
      if (!inputDevices.isEmpty()) {
        String val = inputDevices.keySet().iterator().next();
        store.setDefault(PreferenceConstants.PREF_AUDIO_INPUT_DEVICE, val);
      }
      if (!outputDevices.isEmpty()) {
        String val = outputDevices.keySet().iterator().next();
        store.setDefault(PreferenceConstants.PREF_AUDIO_OUTPUT_DEVICE, val);
      }
      preferencesInitialized = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean performOk() {
    return super.performOk();
  }

  public static Map<String, Mixer> getOutputDevices() {
    return outputDevices;
  }

  public static Map<String, Mixer> getInputDevices() {
    return inputDevices;
  }

  public static Mixer getInputMixer() {
    return inputDevices.get(AsteriskDiagramEditorPlugin.getInstance().getPreferenceStore()
        .getString(PreferenceConstants.PREF_AUDIO_INPUT_DEVICE));
  }

  public static Mixer getOutputMixer() {
    return outputDevices.get(AsteriskDiagramEditorPlugin.getInstance().getPreferenceStore()
        .getString(PreferenceConstants.PREF_AUDIO_OUTPUT_DEVICE));
  }
}
