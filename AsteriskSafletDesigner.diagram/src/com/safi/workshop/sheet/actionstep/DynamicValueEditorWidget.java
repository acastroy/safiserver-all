package com.safi.workshop.sheet.actionstep;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.actionstep.Item;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletConstants;
import com.safi.core.saflet.SafletContext;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sheet.DynamicValueEditor2;
import com.safi.workshop.sheet.DynamicValueEditorUtils;
import com.safi.workshop.sheet.DynamicValueEditorUtils.DynamicValueAnnotationInfo;
import com.swtdesigner.ResourceManager;

public class DynamicValueEditorWidget extends Composite {

  private Button clearButton;
  private Button editButton;
  private Text text;
  private Label imageLabel;
  private DynamicValue dynamicValue;
  private EStructuralFeature feature;
  private EObject object;
  private EditingDomain editingDomain;
  private MyEventTable eventTable;
  private DynamicValueAnnotationInfo info = new DynamicValueAnnotationInfo();
  private SafletContext handlerContext;

  /**
   * Create the composite
   * 
   * @param parent
   * @param style
   */
  public DynamicValueEditorWidget(Composite parent, int style) {
    super(parent, style);
    initUI();
  }
  
  protected void initUI() {
    final GridLayout gridLayout = new GridLayout();
    gridLayout.marginHeight = 0;
    gridLayout.horizontalSpacing = 0;
    gridLayout.marginWidth = 0;
    gridLayout.numColumns = 4;
    setLayout(gridLayout);

    text = new Text(this, SWT.BORDER);
    text.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseDown(final MouseEvent e) {
        if (!(info.isTypeLocked && !(DynamicValueType.SCRIPT_TEXT.getLiteral().equals(
            info.dynValueTypeStr) || DynamicValueType.LITERAL_TEXT.getLiteral().equals(
            info.dynValueTypeStr)))
            && (dynamicValue == null || dynamicValue.getType() == DynamicValueType.LITERAL_TEXT || dynamicValue
                .getType() == DynamicValueType.SCRIPT_TEXT)) {
          // if (dynamicValue == null){
          // dynamicValue = ActionStepFactory.eINSTANCE.createDynamicValue();
          // dynamicValue.setType(DynamicValueType.SCRIPT_TEXT);
          // }
          String script = dynamicValue == null ? "" : dynamicValue.getText();
          if (script == null)
            script = "";
          if (script.indexOf('\n') < 0) {
            text.setEditable(true);
          } else {
            text.setEditable(false);
          }
        }
      }
    });
    text.addFocusListener(new FocusAdapter() {
      @Override
      public void focusLost(final FocusEvent e) {
        if (text.getEnabled() && text.getEditable()) {
          String newtext = text.getText();
          boolean changed = false;
          if (dynamicValue == null) {
            if (StringUtils.isNotBlank(newtext)) {
              changed = true;
              dynamicValue = ActionStepFactory.eINSTANCE.createDynamicValue();
              dynamicValue.setText(newtext);
              if (newtext.matches(DynamicValueEditorUtils.PATT_QUOTED_TEXT))
                dynamicValue.setType(DynamicValueType.LITERAL_TEXT);
              else
                dynamicValue.setType(DynamicValueType.SCRIPT_TEXT);
              // object.eSet(feature, dynamicValue);
            } else {
              dynamicValue = null;
              changed = true;
              // object.eSet(feature, dynamicValue);
              text.setEditable(false);
            }

          } else {
            if (StringUtils.isBlank(newtext)) {
              dynamicValue = null;
              changed = true;
              text.setEditable(false);
              // object.eSet(feature, dynamicValue);
            } else if (!StringUtils.equals(newtext, dynamicValue.getText())) {
              DynamicValueType currType = dynamicValue.getType();

              editingDomain.getCommandStack().execute(
                  SetCommand.create(editingDomain, dynamicValue, dynamicValue.eClass()
                      .getEStructuralFeature("text"), newtext));
              boolean isText = newtext.matches(DynamicValueEditorUtils.PATT_QUOTED_TEXT);
              if (isText && currType != DynamicValueType.LITERAL_TEXT) {
                editingDomain.getCommandStack().execute(
                    SetCommand.create(editingDomain, dynamicValue, dynamicValue.eClass()
                        .getEStructuralFeature("type"), DynamicValueType.LITERAL_TEXT));
              } else if (!isText && currType != DynamicValueType.SCRIPT_TEXT) {
                editingDomain.getCommandStack().execute(
                    SetCommand.create(editingDomain, dynamicValue, dynamicValue.eClass()
                        .getEStructuralFeature("type"), DynamicValueType.SCRIPT_TEXT));
              }
              // dynamicValue.setText(newtext);
              // getA
              changed = true;
            }
          }
          if (changed)
            fireModifiedEvent();
        }

      }

    });
    text.setEditable(false);
    text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    imageLabel = new Label(this, SWT.NONE);
    imageLabel.setLayoutData(new GridData(SWT.DEFAULT, SWT.DEFAULT));
    imageLabel.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin.getDefault(),
        "icons/dynamicValueEditor/literal_text.gif"));

    clearButton = new Button(this, SWT.NONE);
    clearButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        dynamicValue = null;
        refresh();
        fireModifiedEvent();
      }
    });
    final GridData gd_clearButton = new GridData(20, 20);
    clearButton.setLayoutData(gd_clearButton);
    clearButton.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin.getDefault(),
        "icons/fail.gif"));

    editButton = new Button(this, SWT.NONE);
    editButton.setLayoutData(new GridData(SWT.DEFAULT, 20));
    editButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        openEditor();
      }
    });
    editButton.setText("...");
    //
  }

  @Override
  public void addListener(int eventType, Listener listener) {
    if (eventType == SWT.Modify) {
      if (eventTable == null)
        eventTable = new MyEventTable();
      eventTable.hook(eventType, listener);
    } else
      super.addListener(eventType, listener);
  }

  @Override
  public void dispose() {
    if (eventTable != null) {
      eventTable.dispose();
      eventTable = null;
    }
    super.dispose();
  }

  protected void openEditor() {
    // first check for subclassed dynvalue annotations
    info = DynamicValueEditorUtils.extractAnnotationInfo(object, feature);

    if (handlerContext == null) {
      if (object instanceof ActionStep) {
        handlerContext = ((ActionStep) object).getSaflet().getSafletContext();
      } else if (object instanceof Item) {
        ActionStep ts = ((Item) object).getParentActionStep();
        if (ts != null)
          handlerContext = ts.getSaflet().getSafletContext();
      } else {
        Saflet h = null;
        Object obj = editingDomain.getRoot(object);
        if (obj instanceof ResourceSet)
          for (Resource r : ((ResourceSet) obj).getResources()) {
            for (EObject o : r.getContents()) {
              if (o instanceof Saflet) {
                h = (Saflet) o;
                break;
              }

            }
          }

        if (h != null)
          handlerContext = h.getSafletContext();

      }

      if (handlerContext == null)
        throw new IllegalStateException("Couldn't retrieve SafletContext from object " + object);
    }

    DynamicValueEditor2 dve = DynamicValueEditorUtils.createDynamicValueEditor(info, object,
        editingDomain, dynamicValue, handlerContext, getShell());

    if (Window.OK == dve.open()) {
      DynamicValue dv = dve.getDynamicValue();
      if (dv == null || StringUtils.isBlank(dv.getText())) {
        dynamicValue = null;
      } else
        dynamicValue = dv;
      fireModifiedEvent();
      refresh();
    }

  }

  private void fireModifiedEvent() {
    Event event = new Event();
    event.type = SWT.Modify;
    event.display = getDisplay();
    event.widget = this;
    if (eventTable != null)
      eventTable.sendEvent(event);
  }

  // private void createSafletChooserDialog() {
  //
  // dynamicValue =
  // SafletPersistenceManager.openSelectSafletDynamicValueDialog(dynamicValue,
  // getShell());
  // }

  @Override
  protected void checkSubclass() {
    // Disable the check that prevents subclassing of SWT components
  }

  public DynamicValue getDynamicValue() {
    return dynamicValue;
  }

  public void setDynamicValue(DynamicValue dynamicValue) {
    this.dynamicValue = dynamicValue;
    if (dynamicValue == null) {
      refresh();
      this.fireModifiedEvent();
      return;
    }
    refresh();

  }

  protected void refresh() {
    info = DynamicValueEditorUtils.extractAnnotationInfo(object, feature);
    if (dynamicValue == null) {
      text.setText("");
      text.setEditable(false);

      // dynamicValue = ActionStepFactory.eINSTANCE.createDynamicValue();
      // dynamicValue.setText("");
      // dynamicValue.setType(DynamicValueType.LITERAL_TEXT);
    } else {
      text.setEditable(false);
      switch (dynamicValue.getType()) {
        case LITERAL_TEXT:
          imageLabel.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin
              .getDefault(), "icons/dynamicValueEditor/literal_text.gif"));
          text.setEditable(true);
          text.setText(dynamicValue.getText());
          break;
        case CUSTOM:
          imageLabel.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin
              .getDefault(), "icons/dynamicValueEditor/custom.gif"));
          EMap<String, String> data = dynamicValue.getData();
          String prefix = null;
          if (data != null) {
            prefix = data.get(SafletConstants.DYNVALKEY_DISPLAY_TYPE);
            if (StringUtils.isBlank(prefix))
              prefix = data.get(SafletConstants.DYNVALKEY_ACTUAL_TYPE);
          }
          if (StringUtils.isBlank(prefix))
            prefix = "Custom: ";
          else
            prefix += ": ";
          text.setText(prefix + dynamicValue.getText());
          break;
        case SCRIPT_TEXT:
          imageLabel.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin
              .getDefault(), "icons/dynamicValueEditor/script.gif"));
          String script = dynamicValue.getText();
          if (script == null)
            script = "";
          if (script.indexOf('\n') < 0) {
            text.setEditable(true);
            text.setText(script);
          } else {
            text.setEditable(false);
            text.setText("Script: "
                + script.substring(script.lastIndexOf('\n') + 1, script.length()));
          }
          break;
        case VARIABLE_NAME:
          imageLabel.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin
              .getDefault(), "icons/dynamicValueEditor/variable.gif"));
          text.setText("Var: " + dynamicValue.getText());
          break;
      }
    }
  }

  public EStructuralFeature getFeature() {
    return feature;
  }

  public void setFeature(EStructuralFeature feature) {
    this.feature = feature;
  }

  public EObject getObject() {
    return object;
  }

  public void setObject(EObject object) {
    this.object = object;
    if (this.object == null) {

    }
  }

  public EditingDomain getEditingDomain() {
    return editingDomain;
  }

  public void setEditingDomain(EditingDomain editingDomain) {
    this.editingDomain = editingDomain;
  }

  public SafletContext getSafletContext() {
    return handlerContext;
  }

  public void setHandlerContext(SafletContext handlerContext) {
    this.handlerContext = handlerContext;
  }

}
