package com.safi.workshop.view.vareditor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.nebula.widgets.formattedtext.DateFormatter;
import org.eclipse.nebula.widgets.formattedtext.DateTimeFormatter;
import org.eclipse.nebula.widgets.formattedtext.FormattedText;
import org.eclipse.nebula.widgets.formattedtext.StringFormatter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.safi.asterisk.handler.GlobalVariableManager;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.saflet.SafletContext;
import com.safi.db.DbFactory;
import com.safi.db.DbPackage;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.db.VariableType;
import com.safi.db.manager.DBManager;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class VariableEditor extends TitleAreaDialog {

  public enum Mode {
    EDIT, NEW_LOCAL, NEW_GLOBAL
  }

  private CLabel imageLabel;
  private Composite composite;
  private String suggestedName;
  class ContentProvider implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
      return ((List<VariableType>) inputElement).toArray();
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

    }
  }
  private final static String NAME_PATTERN = "[a-zA-Z_][a-zA-Z0-9_]*";
  private FormattedText valueText;
  private Label initialValueLabel;
  private Combo combo;
  private ComboViewer typeComboViewer;
  private Label typeLabel;
  private Text variableNameText;
  private Label nameLabel;
  private Mode mode;
  private Variable variable;
  private AsteriskDiagramEditor currentEditor;
  private VarTypeLabelProvider labelProvider;
  private Label formatNameLabel;
  private Label formatValueLabel;
  private org.eclipse.nebula.widgets.formattedtext.DateFormatter dateFormatter;
  private org.eclipse.nebula.widgets.formattedtext.DateTimeFormatter dateTimeFormatter;
  private org.eclipse.nebula.widgets.formattedtext.DateTimeFormatter timeFormatter;
  private org.eclipse.nebula.widgets.formattedtext.StringFormatter stringFormatter;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public VariableEditor(Shell parentShell, AsteriskDiagramEditor currentEditor, Mode mode) {
    super(parentShell);
    this.mode = mode;
    this.currentEditor = currentEditor;
  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite area = (Composite) super.createDialogArea(parent);
    Composite container = new Composite(area, SWT.NONE);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.marginRight = 50;
    gridLayout.marginLeft = 50;
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);
    container.setLayoutData(new GridData(GridData.FILL_BOTH));
    this.stringFormatter=new StringFormatter();
    this.dateFormatter=new DateFormatter("MM/dd/yyyy");
    this.dateTimeFormatter=new DateTimeFormatter("MM/dd/yyyy hh:mm:ss a");
    this.timeFormatter=new DateTimeFormatter("hh:mm:ss a");
    nameLabel = new Label(container, SWT.NONE);
    nameLabel.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, true));
    nameLabel.setText("Name:");

    variableNameText = new Text(container, SWT.BORDER);
    variableNameText.addModifyListener(new ModifyListener() {
      @Override
      public void modifyText(ModifyEvent e) {
        quickValidateName(variableNameText.getText());
      }
    });
    if(this.suggestedName!=null){
    	variableNameText.setText(this.suggestedName);
    }
    // variableNameText.addVerifyListener(new VerifyListener() {
    // public void verifyText(final VerifyEvent e) {
    // quickValidateName(variableNameText.getText() + e.text);
    // }
    // });

    variableNameText.addFocusListener(new FocusAdapter() {
      @Override
      public void focusLost(final FocusEvent e) {
        quickValidateName(variableNameText.getText());
      }
    });
    final GridData gd_variableNameText = new GridData(SWT.FILL, SWT.BOTTOM, true, false);
    variableNameText.setLayoutData(gd_variableNameText);

    typeLabel = new Label(container, SWT.NONE);
    typeLabel.setText("Type:");

    composite = new Composite(container, SWT.NONE);
    composite.setLayoutData(new GridData());
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.marginWidth = 0;
    gridLayout_1.numColumns = 2;
    composite.setLayout(gridLayout_1);

    // combo = new CCombo(composite, SWT.BORDER);

    typeComboViewer = new ComboViewer(composite, SWT.BORDER);

    imageLabel = new CLabel(composite, SWT.NONE);
    final GridData gd_imageLabel = new GridData(24, SWT.DEFAULT);
    imageLabel.setLayoutData(gd_imageLabel);
    imageLabel.setText("");
    labelProvider = new VarTypeLabelProvider();
    typeComboViewer.setLabelProvider(labelProvider);
    typeComboViewer.setContentProvider(new ContentProvider());
    typeComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
      public void selectionChanged(final SelectionChangedEvent event) {
        IStructuredSelection sel = (IStructuredSelection) event.getSelection();
        if (!sel.isEmpty()) {

          VariableType type = (VariableType) sel.getFirstElement();
          updateTypeFormat(type);
          updateValueTextByType(type, false);
          Image img = labelProvider.getImage(type);
          imageLabel.setImage(img);
          // combo.setBackgroundImage(img);
          // switch (type) {
          // case ARRAY:
          // break;
          // case BOOLEAN:
          // break;
          // case DATE:
          // break;
          // case DATETIME:
          // break;
          // case DECIMAL:
          // break;
          // case INTEGER:
          // break;
          // case OBJECT:
          // break;
          // case TEXT:
          // break;
          // case TIME:
          // break;
          // }
        }
      }

    });
    combo = typeComboViewer.getCombo();
    // combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    combo.setLayoutData(new GridData(100, SWT.DEFAULT));
    typeComboViewer.setInput(VariableType.VALUES);

    initialValueLabel = new Label(container, SWT.NONE);
    initialValueLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, true));
    initialValueLabel.setText("Initial value:");

    valueText = new FormattedText(container, SWT.BORDER);
    valueText.getControl().addFocusListener(new FocusAdapter() {
      @Override
      public void focusLost(final FocusEvent e) {
        VariableType type = getSelectedType();
        updateValueTextByType(type, true);
      }
    });
    final GridData gd_valueText = new GridData(SWT.FILL, SWT.TOP, true, true);
    valueText.getControl().setLayoutData(gd_valueText);
    this.formatNameLabel=new Label(container,SWT.FLAT);
    this.formatNameLabel.setLayoutData(new GridData(SWT.LEFT,SWT.TOP,false,true));
    this.formatNameLabel.setText("Data Format Example :");
    this.formatValueLabel=new Label(container,SWT.FLAT);
    GridData valueGridData=new GridData(SWT.FILL,SWT.TOP,true,true);
    valueGridData.grabExcessVerticalSpace=true;
    valueGridData.grabExcessHorizontalSpace=true;
    this.formatValueLabel.setLayoutData(valueGridData);
    this.formatValueLabel.setText("");
    
   // this.formatValueLabel.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_GRAY));
   
    //
    if (mode == Mode.EDIT) {
      setTitle("Edit Variable " + (variable == null ? "" : variable.getName()));
    } else
      setTitle("Create New " + (mode == Mode.NEW_GLOBAL ? "Global " : "Local ") + "Variable");
    updateUIFromVariable();
    return area;
  }

  protected void updateValueTextByType(VariableType type, boolean showError) {
    String val = valueText.getControl().getText();
    if (StringUtils.isBlank(val))
      return;
    try {
      String old = val;
      val = VariableTranslator
          .translateToText(type, (VariableTranslator.translateValue(type, val)));
    } catch (Exception e) {
      e.printStackTrace();
      if (showError) {
        MessageDialog.openWarning(getShell(), "Invalid Value", val + " is invalid for the type "
            + type);
      }
      val = VariableTranslator.translateToText(type, VariableTranslator.getDefaultForVarType(type));
    }
    if (StringUtils.isBlank(val)) {
      val = VariableTranslator.translateToText(type, VariableTranslator.getDefaultForVarType(type));
    }
    valueText.getControl().setText(val == null ? "" : val);
    //valueText.setValue(val == null ? "" : val);
  }

  @Override
  protected void okPressed() {
	String tmpVariableName=this.variableNameText.getText().trim();
	if(!this.quickValidateName(tmpVariableName)){
		return;
	}
    VariableType type = getSelectedType();
    EAttribute setAttr = DbPackage.eINSTANCE.getVariable_DefaultValue();
    Object newObjVal = null;
    try {
      newObjVal = VariableTranslator.translateValue(type, valueText.getControl().getText());
    } catch (Exception ignore) {

    }

    if (newObjVal == null) {
      newObjVal = VariableTranslator.getDefaultForVarType(type);
    }

    if (mode == Mode.NEW_GLOBAL || mode == Mode.NEW_LOCAL) {

      VariableScope scope = mode == Mode.NEW_LOCAL ? VariableScope.LOCAL : VariableScope.GLOBAL;
      if (scope == VariableScope.GLOBAL && !SafiServerPlugin.getDefault().isConnected())
        return;

      TransactionalEditingDomain editingDomain = null;
      if (currentEditor != null)
        editingDomain = currentEditor.getEditingDomain();

      if (scope == VariableScope.GLOBAL) {
        // GlobalVariableCreateCommand cmd = new GlobalVariableCreateCommand();

        try {
          String name = DBManager.getInstance().getUniqueGlobalVariableName(
        		  tmpVariableName);
          Variable v = DbFactory.eINSTANCE.createVariable();
          v.setName(name);
          v.setType(type);
          v.setScope(scope);
          v.setDefaultValue(newObjVal);
          this.variable=v;
          SafiServerPlugin.getDefault().addGlobalVariable(v);
        } catch (Exception e) {
          e.printStackTrace();
          AsteriskDiagramEditorPlugin.getDefault().logError("Couldn't create new global var", e);
          throw new RuntimeException("Couldn't create new global variable: "
              + e.getLocalizedMessage());
        }
      } else {
        VariableCreateCommand cmd = new VariableCreateCommand(editingDomain, currentEditor
            .getHandlerEditPart().getHandlerModel().getSafletContext(), currentEditor, scope);
        cmd.setName(tmpVariableName);
        cmd.setType(type);
        cmd.setDefaultValue(newObjVal);
        editingDomain.getCommandStack().execute(cmd);
        this.variable=cmd.getNewVariable();
        /*
        this.variable=currentEditor
        .getHandlerEditPart().getHandlerModel().getSafletContext().getVariable(tmpVariableName);
        */
      }
      // viewer.add(cmd.newVariable);
      // if (scope == VariableScope.GLOBAL)
      // viewer.refresh(globalVariables);
      // else
      // viewer.refresh(localVariables);
      // viewer.getContentProvider()
      // EAttribute nameAttr = HandlerPackage.eINSTANCE.
      //        
      // editingDomain.getCommandStack().execute(
      // SetCommand.create(editingDomain, variable, nameAttr, value.toString()));

    } else { //in edit mode
      if (!quickValidateName(tmpVariableName)) {
        MessageDialog.openError(getShell(), "Name Conflict", "Var with name "
            + tmpVariableName + " already exists");
        return;
      }
      try {

        if (variable.getScope() != VariableScope.GLOBAL) {
          TransactionalEditingDomain editingDomain = currentEditor.getEditingDomain();
          EAttribute typeAttr = DbPackage.eINSTANCE.getVariable_Type();

          Command command = SetCommand.create(editingDomain, variable, typeAttr, type);
          CompoundCommand cmd = new CompoundCommand();

          cmd.append(SetCommand.create(editingDomain, variable, setAttr, newObjVal));
          cmd.append(command);

          EAttribute nameAttr = DbPackage.eINSTANCE.getVariable_Name();
          Command setNameCommand = SetCommand.create(editingDomain, variable, nameAttr,
        		  tmpVariableName);
          cmd.append(setNameCommand);

          command = cmd;
          editingDomain.getCommandStack().execute(command);
          currentEditor.setDirty();
        } else {  //globalvar
          if (newObjVal == null)
            newObjVal = VariableTranslator.getDefaultForVarType(type);
          boolean newName = false;
//          String oldName = variable.getName();
          if (!StringUtils.equals(variable.getName(), tmpVariableName)){
          	GlobalVariableManager.getInstance().deleteGlobalVariable(variable);
//          	variable = GlobalVariableManager.getInstance().changeGlobalVariableName(variable, tmpVariableName);
            variable.setName(tmpVariableName);
            newName = true;
          }
          
          if (!ObjectUtils.equals(variable.getDefaultValue(), newObjVal))
            variable.setDefaultValue(newObjVal);

          if (type != variable.getType())
            variable.setType(type);

          if (!StringUtils.equals(variable.getName(), tmpVariableName))
            variable.setName(tmpVariableName);
          
//          GlobalVariableManager.getInstance().
          if (newName){
          	
          	GlobalVariableManager.getInstance().addGlobalVariable(variable);
//          	DBManager.getInstance().saveOrUpdateGlobalVariable(variable);
          }
          else
//          if (newName)
//          	GlobalVariableManager.getInstance().updateVariable(oldName, tmpVariableName);
          DBManager.getInstance().saveOrUpdateGlobalVariable(variable);
          

        }
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        MessageDialog.openError(getShell(), "Variable Error",
            "Couldn't create or update variable: " + e.getLocalizedMessage());
      }
    }
    super.okPressed();
  }

  protected void updateValueTextFromCurrentValue() {

    VariableType type = (VariableType) ((IStructuredSelection) typeComboViewer.getSelection())
        .getFirstElement();
    String textVal = null;
    try {
      Object varVal = variable.getDefaultValue();
      textVal = VariableTranslator.translateToText(type, varVal);

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      textVal = VariableTranslator.translateToText(type, VariableTranslator
          .getDefaultForVarType(type));
      // return null;
    }
    valueText.getControl().setText(textVal == null ? "" : textVal);
    quickValidateName(variableNameText.getText());
  }
  
  @Override
  public void create() {
    // TODO Auto-generated method stub
    super.create();
    quickValidateName(variableNameText.getText());
  }

  /**
   * Create contents of the button bar
   * 
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);

  }

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return new Point(400, 298);
  }

  public Mode getMode() {
    return mode;
  }

  public void setMode(Mode mode) {
    this.mode = mode;
  }

  public Variable getVariable() {
    return variable;
  }

  public void setVariable(Variable variable) {
    this.variable = variable;
    updateUIFromVariable();
  }

  private void updateUIFromVariable() {
    if (variableNameText == null || variableNameText.isDisposed())
      return;
    if (variable == null) {
    	variableNameText.setText(this.suggestedName!=null ? suggestedName : "");
      typeComboViewer.setSelection(new StructuredSelection(VariableType.TEXT));
      valueText.getControl().setText("");
    } else {
      variableNameText.setText(variable.getName() == null ? "" : variable.getName());
      typeComboViewer.setSelection(new StructuredSelection(variable.getType()));
      valueText.getControl().setText(VariableTranslator.translateToText(variable.getType(), variable
          .getDefaultValue()));
    }
    quickValidateName(variableNameText.getText());
//    quickValidateName()
  }
  

  private VariableType getSelectedType() {
    return (VariableType) ((IStructuredSelection) typeComboViewer.getSelection()).getFirstElement();
  }

  private SafletContext getCurrentContext() {
    return currentEditor.getHandlerEditPart().getHandlerModel().getSafletContext();
  }

  private boolean quickValidateName(String name) {
	 Button butt= this.getButton(IDialogConstants.OK_ID);
	  
    if (!name.matches(NAME_PATTERN)) {
      setMessage("Variable name " + name + " is invalid", IMessageProvider.ERROR);
    if(butt!=null) butt.setEnabled(false);
    
      return false;
    } else {
      if ((mode == Mode.EDIT && variable.getScope() == VariableScope.LOCAL)
          || mode == Mode.NEW_LOCAL) {
        Variable v = getCurrentContext().getVariable(name);
        if (v != null && v != variable) {
          setMessage("Variable with name " + name + " already exists", IMessageProvider.ERROR);
          if(butt!=null) butt.setEnabled(false);
          return false;
        } else
          setMessage("", IMessageProvider.NONE);
        Variable v2 = SafiServerPlugin.getDefault().getGlobalVariable(name);
        if (v2 != null && v2 != variable) {
          setMessage("Global Variable with name " + name + " already exists",
              IMessageProvider.ERROR);
          if(butt!=null) butt.setEnabled(false);
          return false;
        } else
          setMessage("", IMessageProvider.NONE);
        
      } else {
        Variable v = SafiServerPlugin.getDefault().getGlobalVariable(name);
        if (v != null && v != variable) {
          setMessage("Global Variable with name " + name + " already exists",
              IMessageProvider.ERROR);
          if(butt!=null) butt.setEnabled(false);
          return false;
        } else
          setMessage("", IMessageProvider.NONE);
      }
    }
    if(butt!=null) butt.setEnabled(true);
    return true;
  }

  class VarTypeLabelProvider extends LabelProvider {
    Map<String, Image> imageHash = new HashMap<String, Image>();

    @Override
    public void dispose() {
      for (Image img : imageHash.values())
      	img.dispose();
      imageHash.clear();
    }

    @Override
    public String getText(Object element) {
      if (element instanceof VariableType)
        return ((VariableType) element).getName();
      else
        return element.toString();
    }

    @Override
    public Image getImage(Object element) {
      if (element instanceof VariableType) {
        VariableType varType = (VariableType) element;
        String relPath = null;
        switch (varType) {
          case ARRAY:
            relPath = "icons/vareditor/Array.gif";
            break;
          case BOOLEAN:
            relPath = "icons/vareditor/Boolean.gif";
            break;
          case DATE:
            relPath = "icons/vareditor/Date.gif";
            break;
          case DATETIME:
            relPath = "icons/vareditor/DateTime.gif";
            break;
          case DECIMAL:
            relPath = "icons/vareditor/Decimal.gif";
            break;
          case INTEGER:
            relPath = "icons/vareditor/Integer.gif";
            break;
          case OBJECT:
            relPath = "icons/vareditor/Object.gif";
            break;
          case TEXT:
            relPath = "icons/vareditor/Text.gif";
            break;
          case TIME:
            relPath = "icons/vareditor/Time.gif";
            break;
        }
        if (relPath != null) {
          Image img = imageHash.get(relPath);
          if (img == null) {
            ImageDescriptor imgDesc = AsteriskDiagramEditorPlugin
                .getBundledImageDescriptor(relPath);
            ImageData data = imgDesc.getImageData();
            data = data.scaledTo(16, 16);

            img = ImageDescriptor.createFromImageData(data).createImage(true);
            // img = imgDesc.createImage(true);
            imageHash.put(relPath, img);
          }
          return img;
        } else
          return null;
      }
      // TODO Auto-generated method stub
      return super.getImage(element);
    }
  }

public void setSuggestedVariableName(String aSuggestedName) {
	// TODO Auto-generated method stub
	this.suggestedName=aSuggestedName;
	//this.variableNameText.setText(this.suggestedName);
	
}
private void updateTypeFormat(VariableType varType) {
	// TODO Auto-generated method stub
	 this.valueText.setFormatter(this.stringFormatter);
	 this.formatValueLabel.setText("");
    switch (varType) {
    case ARRAY:
     this.formatValueLabel.setText("[1,2,3,4] or [one,two,three,four]");
      break;
    case BOOLEAN:
     this.formatValueLabel.setText("true or false");
      break;
    case DATE:
    //this.valueText.setFormatter(this.dateFormatter);
     this.formatValueLabel.setText("12/25/2009");
      break;
    case DATETIME:
   // this.valueText.setFormatter(this.dateTimeFormatter);	
     this.formatValueLabel.setText("12/25/2009 12:47 PM");
      break;
    case DECIMAL:
      this.formatValueLabel.setText("3.141592");
      break;
    case INTEGER:
      this.formatValueLabel.setText("1");
      break;
    case OBJECT:
      this.formatValueLabel.setText("Any object type can be assigned.");
      break;
    case TEXT:
      this.formatValueLabel.setText("Mary had a little lamb");
      break;
    case TIME:
      //this.valueText.setFormatter(this.timeFormatter);	
      this.formatValueLabel.setText("12:45 PM");
      break;
  }
	
}
}
