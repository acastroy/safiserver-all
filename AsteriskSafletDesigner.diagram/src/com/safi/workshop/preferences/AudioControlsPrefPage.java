package com.safi.workshop.preferences;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.CompoundControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Port;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.swtdesigner.FieldLayoutPreferencePage;

public class AudioControlsPrefPage extends FieldLayoutPreferencePage implements
    IWorkbenchPreferencePage {

  public final static String ID = "com.safi.workshop.preferences.AudioPreferences";
  private static final String CONTROL_ELEM = "control";
  private static final String PORT_ELEM = "port";
  private static final String MIXER_ELEM = "mixer";
  private static final String ROOT_ELEM = "controls";
  private Tree outputControlTree;
  private Tree inputControlTree;
  private CheckboxTreeViewer inputControlTreeViewer;
  private CheckboxTreeViewer outputControlTreeViewer;
  private static ControlItem inputRoot;
  private static ControlItem outputRoot;
  private static boolean hideDuplicateControls = true;
  private static Set<Line> openedLines = new HashSet<Line>();

  /**
   * Create the preference page
   */
  public AudioControlsPrefPage() {
    super();
    setPreferenceStore(AsteriskDiagramEditorPlugin.getInstance().getPreferenceStore());
  }

  @Override
  public void dispose() {
    super.dispose();
  }

  public static void closeOpenedLines() {
    for (Line line : openedLines) {
      try {
        if (line.isOpen()) {
          line.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
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
    gridLayout.numColumns = 3;
    gridLayout.verticalSpacing = 10;
    gridLayout.marginTop = 10;
    gridLayout.marginLeft = 10;
    container.setLayout(gridLayout);
    new Label(container, SWT.NONE);
    final Group inputGroup = new Group(container, SWT.NONE);
    inputGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    inputGroup.setText("input");
    inputGroup.setLayout(new GridLayout());
    final Label selectInputControlsLabel = new Label(inputGroup, SWT.CENTER);
    final GridData gd_selectInputControlsLabel = new GridData(SWT.CENTER, SWT.CENTER, true, false);
    selectInputControlsLabel.setLayoutData(gd_selectInputControlsLabel);
    selectInputControlsLabel.setText("Select Input Controls");
    inputControlTreeViewer = new CheckboxTreeViewer(inputGroup, SWT.FULL_SELECTION | SWT.BORDER);
    // inputControlTableViewer = CheckboxTableViewer.newCheckList(inputGroup,
    // SWT.FULL_SELECTION | SWT.BORDER);
    inputControlTreeViewer.setLabelProvider(new AudioControlLabelProvider());
    inputControlTreeViewer.setContentProvider(new AudioControlTreeContentProvider());
    inputControlTreeViewer.addCheckStateListener(new ICheckStateListener() {
      public void checkStateChanged(final CheckStateChangedEvent event) {
        boolean isChecked = event.getChecked();
        Object obj = event.getElement();
        updateCheckboxes(isChecked, obj, inputControlTreeViewer);
      }
    });
    inputControlTree = inputControlTreeViewer.getTree();
    inputControlTree.setLinesVisible(true);
    inputControlTree.setHeaderVisible(true);
    final GridData gd_inputControlTable = new GridData(SWT.FILL, SWT.FILL, true, true);
    gd_inputControlTable.heightHint = 80;
    gd_inputControlTable.widthHint = 250;
    inputControlTree.setLayoutData(gd_inputControlTable);
    final TreeColumn inputControlNameCol = new TreeColumn(inputControlTree, SWT.NONE);
    inputControlNameCol.setWidth(100);
    inputControlNameCol.setText("Name");
    final TreeColumn inputControlDescCol = new TreeColumn(inputControlTree, SWT.NONE);
    inputControlDescCol.setWidth(100);
    inputControlDescCol.setText("Description");
    final Group outputGroup = new Group(container, SWT.NONE);
    outputGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    outputGroup.setText("output");
    outputGroup.setLayout(new GridLayout());
    final Label selectOutputControlsLabel = new Label(outputGroup, SWT.CENTER);
    final GridData gd_selectOutputControlsLabel = new GridData(SWT.CENTER, SWT.CENTER, true, false);
    selectOutputControlsLabel.setLayoutData(gd_selectOutputControlsLabel);
    selectOutputControlsLabel.setText("Select Output Controls");
    outputControlTreeViewer = new CheckboxTreeViewer(outputGroup, SWT.FULL_SELECTION | SWT.BORDER);
    outputControlTreeViewer.setContentProvider(new AudioControlTreeContentProvider());
    outputControlTreeViewer.setLabelProvider(new AudioControlLabelProvider());
    outputControlTreeViewer.addCheckStateListener(new ICheckStateListener() {
      public void checkStateChanged(final CheckStateChangedEvent event) {
        boolean isChecked = event.getChecked();
        Object obj = event.getElement();
        updateCheckboxes(isChecked, obj, outputControlTreeViewer);
      }
    });
    outputControlTree = outputControlTreeViewer.getTree();
    outputControlTree.setLinesVisible(true);
    outputControlTree.setHeaderVisible(true);
    final GridData gd_outputControlTable = new GridData(SWT.FILL, SWT.FILL, true, true);
    gd_outputControlTable.heightHint = 80;
    gd_outputControlTable.widthHint = 250;
    outputControlTree.setLayoutData(gd_outputControlTable);
    final TreeColumn outputControlNameCol = new TreeColumn(outputControlTree, SWT.NONE);
    outputControlNameCol.setWidth(100);
    outputControlNameCol.setText("Name");
    final TreeColumn outputControlDescCol = new TreeColumn(outputControlTree, SWT.NONE);
    outputControlDescCol.setWidth(141);
    outputControlDescCol.setText("Description");
    inputControlTreeViewer.setInput(getInputRoot());
    outputControlTreeViewer.setInput(getOutputRoot());
    clearSelections(getInputRoot());
    clearSelections(getOutputRoot());
    applyInputControlSelections();
    applyOutputControlSelections();
    updateCheckboxes(getInputRoot(), inputControlTreeViewer);
    updateCheckboxes(getOutputRoot(), outputControlTreeViewer);
    return container;
  }

  private void clearSelections(ControlItem item) {
    item.setSelected(false);
    if (item.hasChildren())
      for (ControlItem child : item.getChildren())
        clearSelections(child);
  }

  private static void applyOutputControlSelections() {
    String outputIdStr = AsteriskDiagramEditorPlugin.getInstance().getPreferenceStore().getString(
        PreferenceConstants.PREF_AUDIO_OUTPUT_DEVICE_STRING);
    if (StringUtils.isNotBlank(outputIdStr)) {
      SAXReader reader = new SAXReader(false);
      Document document;
      try {
        document = reader.read(new StringReader(outputIdStr));
        selectPaths(document.getRootElement(), getOutputRoot());
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      selectDefaultOutputControls();
    }
  }

  private static void applyInputControlSelections() {
    String inputIdStr = AsteriskDiagramEditorPlugin.getInstance().getPreferenceStore().getString(
        PreferenceConstants.PREF_AUDIO_INPUT_DEVICE_STRING);
    if (StringUtils.isNotBlank(inputIdStr)) {
      SAXReader reader = new SAXReader(false);
      Document document;
      try {
        document = reader.read(new StringReader(inputIdStr));
        XMLWriter writer = new XMLWriter(System.out, OutputFormat.createPrettyPrint());
        writer.write(document);
        writer.close();
        selectPaths(document.getRootElement(), getInputRoot());
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      selectDefaultInputControls();

    }
  }

  private static ControlItem buildModel(boolean input) {
    Mixer selectedMixer = null;
    if (input)
      selectedMixer = AudioDevicesPrefPage.getInputMixer();
    else
      selectedMixer = AudioDevicesPrefPage.getOutputMixer();
    String selectedMixerName = null;
    HashSet<String> unique = new HashSet<String>();
    if (selectedMixer != null)
      selectedMixerName = selectedMixer.getMixerInfo().getName();

    ControlItem root = new ControlItem(null, ControlItem.Mode.ROOT, 0);
    Line.Info portInfo = new Line.Info(Port.class);
    int mindex = -1;
    for (Mixer.Info minfo : AudioSystem.getMixerInfo()) {
      mindex++;
      if (AudioSystem.getMixer(minfo).isLineSupported(portInfo)) {
        if (hideDuplicateControls && !unique.add(minfo.toString()))
          continue;

        ControlItem item = new ControlItem(minfo, ControlItem.Mode.MIXER, mindex);
        root.addChild(item);
      }
    }
    unique.clear();
    List<ControlItem> ports = new ArrayList<ControlItem>();
    if (root.hasChildren()) {
      for (ControlItem itm : root.getChildren()) {
        Mixer mixer = AudioSystem.getMixer((Mixer.Info) itm.getPayload());
        int pindex = -1;
        for (Line.Info linfo : (input ? mixer.getSourceLineInfo() : mixer.getTargetLineInfo())) {
          pindex++;
          Port.Info pinfo = (Port.Info) linfo;
          if (hideDuplicateControls && !unique.add(pinfo.toString()))
            continue;
          ControlItem pitem = null;
          if (input && pinfo.isSource()) {
            pitem = new ControlItem(pinfo, ControlItem.Mode.INPUT_PORT, pindex);
          } else if (!input && !pinfo.isSource()) {
            pitem = new ControlItem(pinfo, ControlItem.Mode.OUTPUT_PORT, pindex);
          }
          if (pitem != null) {
            itm.addChild(pitem);
            ports.add(pitem);
          }
        }
      }
    }

    unique.clear();
    for (ControlItem port : ports) {
      Port.Info pinfo = (Port.Info) port.getPayload();
      Line line = null;
      boolean wasClosed = false;
      try {
        line = AudioSystem.getLine(pinfo);
        if (!line.isOpen()) {
          wasClosed = true;
          line.open();
          openedLines.add(line);
        }
        unique.clear();
        int cindex = -1;
        for (javax.sound.sampled.Control c : line.getControls()) {
          cindex++;
          if (hideDuplicateControls && !unique.add(c.toString()))
            continue;
          if (!(c instanceof CompoundControl)) {

            ControlItem item = new ControlItem(c, ControlItem.Mode.CONTROL, cindex);
            port.addChild(item);
          } else {
            ControlItem item = new ControlItem(c, ControlItem.Mode.COMPOUND_CONTROL, cindex);
            port.addChild(item);
            int ccindex = -1;
            for (javax.sound.sampled.Control cc : ((CompoundControl) c).getMemberControls()) {
              ccindex++;
              if (hideDuplicateControls && !unique.add(c.toString() + '|' + cc.toString()))
                continue;
              ControlItem citem = new ControlItem(cc, ControlItem.Mode.CONTROL, ccindex);
              item.addChild(citem);
            }
          }
        }
        // line.close();
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        // if (wasClosed && line != null && line.isOpen())
        // line.close();
      }
    }
    return root;
  }

  private static void selectPaths(Element rootElement, ControlItem root) {
    if (rootElement == null)
      return;
    if (!root.hasChildren())
      return;
    for (Object mo : rootElement.elements(MIXER_ELEM)) {
      Element melem = (Element) mo;
      ControlItem mixerItem = null;
      int mixerIndex = 0;
      for (ControlItem mitem : root.getChildren()) {
        if (melem.attribute("text").getText().equals(
            createMixerID((Mixer.Info) mitem.getPayload(), mixerIndex++))) {
          mixerItem = mitem;
          break;
        }
      }
      if (mixerItem != null && mixerItem.hasChildren()) {
        mixerItem.setSelected(true);

        for (Object po : melem.elements(PORT_ELEM)) {
          Element pelem = (Element) po;
          ControlItem portItem = null;
          int portIndex = 0;
          for (ControlItem pitem : mixerItem.getChildren()) {
            if (pelem.attribute("text").getText().equals(
                createPortID((Port.Info) pitem.getPayload(), portIndex++))) {
              portItem = pitem;
              break;
            }
          }
          if (portItem != null && portItem.hasChildren()) {
            portItem.setSelected(true);
            for (Object co : pelem.elements(CONTROL_ELEM)) {
              Element celem = (Element) co;
              ControlItem controlItem = null;
              int controlIndex = 0;
              for (ControlItem citem : portItem.getChildren()) {
                if (celem.attribute("text").getText().equals(
                    createControlID((javax.sound.sampled.Control) citem.getPayload(),
                        controlIndex++))) {
                  controlItem = citem;
                  break;
                }
              }
              if (controlItem != null && controlItem.hasChildren()) {
                controlItem.setSelected(true);
                for (Object cco : celem.elements(CONTROL_ELEM)) {
                  Element ccelem = (Element) cco;
                  ControlItem compoundItem = null;
                  int compoundControlIndex = 0;
                  for (ControlItem citem : controlItem.getChildren()) {
                    if (ccelem.attribute("text").getText().equals(
                        createControlID((javax.sound.sampled.Control) citem.getPayload(),
                            compoundControlIndex++))) {
                      citem.setSelected(true);
                      compoundItem = citem;
                      break;
                    }
                  }
                }
              } else { // leaf
                controlItem.setSelected(true);
              }
            }
          }
        }
      }
    }
  }

  protected static void updateCheckboxes(ControlItem item, CheckboxTreeViewer viewer) {
    if (item.mode == ControlItem.Mode.CONTROL && item.isSelected()) {
      if (viewer != null)
        viewer.setChecked(item, true);
      updateParents(item.getParent(), true, viewer);
    } else if (item.hasChildren())
      for (ControlItem citem : item.getChildren())
        updateCheckboxes(citem, viewer);
  }

  protected void updateCheckboxes(boolean isChecked, Object obj, CheckboxTreeViewer viewer) {
    // List<Object> checkedElements = Arrays.asList(viewer.getCheckedElements());
    ControlItem item = (ControlItem) obj;
    item.setSelected(isChecked);
    checkChildren(item, isChecked, viewer);
    updateParents(item.getParent(), isChecked, viewer);
  }

  private static void updateParents(ControlItem item, boolean isChecked, CheckboxTreeViewer viewer) {
    if (item == null || item.getParent() == null)
      return;
    if (item.hasChildren()) {
      int numChildren = item.getChildren().size();
      int selected = 0;
      int numGrayChecked = 0;
      for (ControlItem ci : item.getChildren()) {
        if (ci.isSelected())
          selected++;
        if (viewer != null && viewer.getGrayed(ci))
          numGrayChecked++;
      }
      if (viewer != null)
        viewer.setGrayed(item, false);
      if (selected == numChildren) {
        if (viewer != null) {
          if (numGrayChecked == 0)
            viewer.setChecked(item, true);
          else
            viewer.setGrayChecked(item, true);
        }
        item.setSelected(true);
      } else if (selected == 0) {
        if (viewer != null)
          viewer.setChecked(item, false);
        item.setSelected(false);
      } else { // 1 or more gray checked
        if (viewer != null)
          viewer.setGrayChecked(item, true);
        item.setSelected(true);
      }
    }
    updateParents(item.getParent(), isChecked, viewer);
  }

  private void checkChildren(ControlItem item, boolean isChecked, CheckboxTreeViewer viewer) {
    viewer.setGrayed(item, false);
    if (!item.hasChildren())
      return;
    for (ControlItem ci : item.getChildren()) {
      ci.setSelected(isChecked);
      viewer.setChecked(ci, isChecked);
      checkChildren(ci, isChecked, viewer);
    }
  }

  /**
   * Initialize the preference page
   */
  public void init(IWorkbench workbench) {
    // Initialize the preference page
  }

  private static String buildPaths(ControlItem root) {
    if (root == null || !root.hasChildren())
      return "";
    Document document = DocumentHelper.createDocument();
    Element rootElement = document.addElement(ROOT_ELEM);
    int mixerIndex = 0;
    for (ControlItem mixer : root.getChildren()) {
      if (mixer.isSelected()) {
        Element melem = rootElement.addElement(MIXER_ELEM);
        melem.addAttribute("text", createMixerID((Mixer.Info) mixer.getPayload(), mixerIndex));
        if (mixer.hasChildren()) {
          int portIndex = 0;
          for (ControlItem port : mixer.getChildren()) {
            if (port.isSelected()) {
              Element pelem = melem.addElement(PORT_ELEM);
              pelem.addAttribute("text", createPortID((Port.Info) port.getPayload(), portIndex));
              if (port.hasChildren()) {
                int controlIndex = 0;
                for (ControlItem control : port.getChildren()) {
                  if (control.isSelected()) {
                    Element celem = pelem.addElement(CONTROL_ELEM);
                    celem.addAttribute("text", createControlID(
                        (javax.sound.sampled.Control) control.getPayload(), controlIndex));
                    if (control.hasChildren()) {
                      int compoundControlIndex = 0;
                      for (ControlItem member : control.getChildren()) {
                        if (member.isSelected()) {
                          Element ccelem = celem.addElement(CONTROL_ELEM);
                          ccelem.addAttribute("text", createControlID(
                              (javax.sound.sampled.Control) member.getPayload(),
                              compoundControlIndex));
                        }
                        compoundControlIndex++;
                      }
                    }
                  }
                  controlIndex++;
                }
              }
            }
            portIndex++;
          }
        }
      }
      mixerIndex++;
    }
    return document.asXML();
  }

  @Override
  public boolean performOk() {
    String inputPath = buildPaths(getInputRoot());
    getPreferenceStore().setValue(PreferenceConstants.PREF_AUDIO_INPUT_DEVICE_STRING, inputPath);
    String outputPath = buildPaths(getOutputRoot());
    getPreferenceStore().setValue(PreferenceConstants.PREF_AUDIO_OUTPUT_DEVICE_STRING, outputPath);
    return super.performOk();
  }

  private static String createMixerID(Mixer.Info mixerInfo, int index) {
    return new StringBuffer(mixerInfo.getName()).append('|').append(mixerInfo.getDescription())
        .append('|').append(mixerInfo.getVendor()).append('|').append(
            mixerInfo.getClass().toString()).append('|').append(index).toString();
  }

  private static String createPortID(Port.Info portInfo, int index) {
    return new StringBuffer(portInfo.getName()).append('|').append(
        portInfo.getLineClass().toString()).append('|').append(portInfo.isSource()).append('|')
        .append(portInfo.getClass().toString()).append('|').append(index).toString();
  }

  private static String createControlID(javax.sound.sampled.Control control, int index) {
    return new StringBuffer(control.getType().toString()).append('|').append(
        control.getClass().toString()).append('|').append(index).toString();
  }

  public static List<ControlItem> getInputControls() {
    ControlItem item = getInputRoot();
    List<ControlItem> list = new ArrayList<ControlItem>();
    collectSelectedControls(item, list);
    return list;
  }

  public static List<ControlItem> getOutputControls() {
    ControlItem item = getOutputRoot();
    List<ControlItem> list = new ArrayList<ControlItem>();
    collectSelectedControls(item, list);
    return list;
  }

  private static void collectSelectedControls(ControlItem item, List<ControlItem> list) {
    if (item.mode != ControlItem.Mode.ROOT && !item.isSelected())
      return;
    if (item.mode == ControlItem.Mode.CONTROL) {
      ControlItem newParent = new ControlItem(item.getParent());
      ControlItem newItem = new ControlItem(item);
      newParent.addChild(newItem);
      list.add(newItem);
    } else if (item.mode == ControlItem.Mode.COMPOUND_CONTROL) {
      if (item.hasChildren()) {
        ControlItem newParent = new ControlItem(item.getParent());
        ControlItem parent = new ControlItem(item);
        newParent.addChild(parent);
        list.add(parent);
        for (ControlItem ci : item.getChildren()) {
          if (ci.isSelected()) {
            parent.addChild(new ControlItem(ci));
          }
        }
      }
    } else if (item.hasChildren()) {
      for (ControlItem ci : item.getChildren())
        collectSelectedControls(ci, list);
    }
  }

  public static void initDefaults(IPreferenceStore store) {
    store.addPropertyChangeListener(new IPropertyChangeListener() {
      @Override
      public void propertyChange(PropertyChangeEvent event) {
        if (PreferenceConstants.PREF_AUDIO_INPUT_DEVICE.equals(event.getProperty()))
          inputRoot = null;
        else if (PreferenceConstants.PREF_AUDIO_OUTPUT_DEVICE.equals(event.getProperty()))
          outputRoot = null;
      }
    });
    // selectDefaultInputControls();
    // selectDefaultOutputControls();
    String inputPath = buildPaths(getInputRoot());
    store.setDefault(PreferenceConstants.PREF_AUDIO_INPUT_DEVICE_STRING, inputPath);
    String outputPath = buildPaths(getOutputRoot());
    store.setDefault(PreferenceConstants.PREF_AUDIO_OUTPUT_DEVICE_STRING, outputPath);
  }

  private static void selectDefaultOutputControls() {
    ControlItem root = getOutputRoot();
    if (root == null || !root.hasChildren())
      return;
    for (ControlItem mitem : root.getChildren()) {
      if (!mitem.hasChildren())
        continue;
      for (ControlItem pitem : mitem.getChildren()) {
        Port.Info portInfo = (Port.Info) pitem.getPayload();
        if (pitem.hasChildren() && Port.Info.SPEAKER.getName().equalsIgnoreCase(portInfo.getName())) {
          boolean foundControls = false;
          for (ControlItem citem : pitem.getChildren()) {
            if (citem.mode == ControlItem.Mode.CONTROL) {
              javax.sound.sampled.Control cntrl = citem.getControl();
              if ("Master Volume".equalsIgnoreCase(cntrl.getType().toString())
                  || "Volume".equalsIgnoreCase(cntrl.getType().toString())) {
                citem.setSelected(true);
                updateCheckboxes(citem, null);
                foundControls = true;
              }
            }
          }
          if (!foundControls) {
            for (ControlItem citem : pitem.getChildren()) {
              if (citem.mode == ControlItem.Mode.CONTROL) {
                citem.setSelected(true);
                updateCheckboxes(citem, null);
                foundControls = true;
              }
            }
          }
        }
      }
    }
  }

  private static void selectDefaultInputControls() {
    ControlItem root = getInputRoot();
    if (root == null || !root.hasChildren())
      return;
    for (ControlItem mitem : root.getChildren()) {
      if (!mitem.hasChildren())
        continue;
      for (ControlItem pitem : mitem.getChildren()) {
        Port.Info portInfo = (Port.Info) pitem.getPayload();
        if (pitem.hasChildren()
            && Port.Info.MICROPHONE.getName().equalsIgnoreCase(portInfo.getName())) {
          boolean foundControls = false;
          for (ControlItem citem : pitem.getChildren()) {
            if (citem.mode == ControlItem.Mode.COMPOUND_CONTROL && citem.hasChildren()) {
              for (ControlItem ccitem : citem.getChildren()) {
                javax.sound.sampled.Control cntrl = ccitem.getControl();
                if ("Select".equalsIgnoreCase(cntrl.getType().toString())
                    || "Volume".equalsIgnoreCase(cntrl.getType().toString())) {
                  ccitem.setSelected(true);
                  updateCheckboxes(ccitem, null);
                  foundControls = true;
                }
              }
              if (!foundControls) { // didn't find any...select all
                for (ControlItem ccitem : citem.getChildren()) {
                  ccitem.setSelected(true);
                  updateCheckboxes(ccitem, null);
                  foundControls = true;
                }
              }
            } else if (citem.mode == ControlItem.Mode.CONTROL) {
              javax.sound.sampled.Control cntrl = citem.getControl();
              if ("Select".equalsIgnoreCase(cntrl.getType().toString())
                  || "Volume".equalsIgnoreCase(cntrl.getType().toString())) {
                citem.setSelected(true);
                updateCheckboxes(citem, null);
                foundControls = true;
              }
            }
          }
          if (!foundControls) {
            for (ControlItem citem : pitem.getChildren()) {
              if (citem.mode == ControlItem.Mode.CONTROL) {
                citem.setSelected(true);
                updateCheckboxes(citem, null);
                foundControls = true;
              }
            }
          }
        }
      }
    }
  }

  @Override
  protected void performDefaults() {
    // super.performDefaults();
    IPreferenceStore store = getPreferenceStore();
    store.setToDefault(PreferenceConstants.PREF_AUDIO_INPUT_DEVICE_STRING);
    store.setToDefault(PreferenceConstants.PREF_AUDIO_OUTPUT_DEVICE_STRING);
    clearSelections(getInputRoot());
    clearSelections(getOutputRoot());
    if (inputControlTreeViewer != null)
      inputControlTreeViewer.setCheckedElements(new Object[0]);
    if (outputControlTreeViewer != null)
      outputControlTreeViewer.setCheckedElements(new Object[0]);
    // initDefaults(store);
    selectDefaultInputControls();
    selectDefaultOutputControls();
    inputControlTreeViewer.refresh();
    outputControlTreeViewer.refresh();
    // applyInputControlSelections();
    // applyOutputControlSelections();
    // updateCheckboxes(getInputRoot(), inputControlTreeViewer);
    // updateCheckboxes(getOutputRoot(), outputControlTreeViewer);

  }

  /******************************************************* Controls *********************************************/
  class AudioControlTreeContentProvider implements IStructuredContentProvider, ITreeContentProvider {
    public AudioControlTreeContentProvider() {
    }

    @Override
    public Object[] getElements(Object inputElement) {
      return getChildren(inputElement);
    }

    @Override
    public void dispose() {
      // TODO Auto-generated method stub
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
      // TODO Auto-generated method stub
    }

    @Override
    public Object[] getChildren(Object parentElement) {
      return ((ControlItem) parentElement).getChildren() == null ? new Object[0]
          : ((ControlItem) parentElement).getChildren().toArray();
    }

    @Override
    public Object getParent(Object element) {
      return ((ControlItem) element).getParent();
    }

    @Override
    public boolean hasChildren(Object element) {
      return ((ControlItem) element).getChildren() != null
          && !((ControlItem) element).getChildren().isEmpty();
    }
  }

  class AudioControlLabelProvider extends LabelProvider implements ITableLabelProvider {
    public String getColumnText(Object element, int columnIndex) {
      ControlItem ci = (ControlItem) element;
      if (ci.mode == ControlItem.Mode.CONTROL || ci.mode == ControlItem.Mode.COMPOUND_CONTROL) {
        javax.sound.sampled.Control control = ci.getControl();
        if (columnIndex == 0) {
          return control.getType().toString();
        } else
          return control.toString();
      } else if (ci.mode == ControlItem.Mode.INPUT_PORT || ci.mode == ControlItem.Mode.OUTPUT_PORT) {
        Port.Info pinfo = (Port.Info) ci.getPayload();
        if (pinfo == null)
          return null;
        if (columnIndex == 0)
          return pinfo.getName();
        else if (columnIndex == 1)
          return pinfo.toString();
        return element.toString();
      } else if (ci.mode == ControlItem.Mode.MIXER) {
        Mixer.Info minfo = (Mixer.Info) ci.getPayload();
        if (minfo == null)
          return null;
        if (columnIndex == 0)
          return minfo.getName();
        else if (columnIndex == 1)
          return minfo.getDescription();
      }
      return null;
    }

    public Image getColumnImage(Object element, int columnIndex) {
      return null;
    }
  }

  public static class ControlItem {
    enum Mode {
      ROOT, MIXER, INPUT_PORT, OUTPUT_PORT, COMPOUND_CONTROL, CONTROL
    };

    Object payload;
    ControlItem parent;
    List<ControlItem> children;
    Mode mode;
    boolean selected;
    int index;

    public ControlItem(Object payload, Mode mode, int index) {
      this.payload = payload;
      this.mode = mode;
      this.index = index;
    }

    public ControlItem(ControlItem item) {
      this.payload = item.payload;
      this.mode = item.mode;
      this.payload = item.payload;
      this.selected = item.selected;
      this.index = item.index;
    }

    public ControlItem getParent() {
      return parent;
    }

    public void setParent(ControlItem parent) {
      this.parent = parent;
    }

    public javax.sound.sampled.Control getControl() {
      return (javax.sound.sampled.Control) payload;
    }

    public void addChild(ControlItem item) {
      if (children == null)
        children = new ArrayList<ControlItem>();
      children.add(item);
      item.setParent(this);
    }

    public boolean hasChildren() {
      return children != null && !children.isEmpty();
    }

    public List<ControlItem> getChildren() {
      return children;
    }

    public void setChildren(List<ControlItem> children) {
      this.children = children;
    }

    public Object getPayload() {
      return payload;
    }

    public void setPayload(Object payload) {
      this.payload = payload;
    }

    public boolean isSelected() {
      return selected;
    }

    public void setSelected(boolean selected) {
      this.selected = selected;
    }

    public int getIndex() {
      return index;
    }

    public void setIndex(int index) {
      this.index = index;
    }
  }

  public static ControlItem getInputRoot() {
    if (inputRoot == null)
      try {
        inputRoot = buildModel(true);
        applyInputControlSelections();
      } catch (Exception e) {
        e.printStackTrace();
      }
    return inputRoot;
  }

  public static ControlItem getOutputRoot() {
    if (outputRoot == null)
      try {
        outputRoot = buildModel(false);
        applyOutputControlSelections();
      } catch (Exception e) {
        e.printStackTrace();
      }
    return outputRoot;
  }

  public boolean isHideDuplicateControls() {
    return hideDuplicateControls;
  }

  public void setHideDuplicateControls(boolean hideDuplicateControls) {
    AudioControlsPrefPage.hideDuplicateControls = hideDuplicateControls;
  }

}
