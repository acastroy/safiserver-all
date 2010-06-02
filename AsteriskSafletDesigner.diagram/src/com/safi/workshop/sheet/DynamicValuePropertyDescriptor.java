package com.safi.workshop.sheet;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletContext;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class DynamicValuePropertyDescriptor extends PropertyDescriptor {

  private EditingDomain editingDomain;
  private FileDialog fileDialog;

  public DynamicValuePropertyDescriptor(Object object,
      IItemPropertyDescriptor itemPropertyDescriptor, EditingDomain editingDomain) {
    super(object, itemPropertyDescriptor);
    this.editingDomain = editingDomain;
  }

  @Override
  public CellEditor createPropertyEditor(Composite composite) {
    EStructuralFeature structuralFeature = ((EStructuralFeature) itemPropertyDescriptor
        .getFeature(object));

    String description = null;
    String attributeName = null;
    String expectedReturnType = null;
    String dynValueTypeStr = null;
    boolean isTypeLocked = false;
    String helperClass = null;
    // first check for subclassed dynvalue annotations
    EObject obj = (EObject) object;
    EAnnotation annotation = null;
    for (EAnnotation annot : obj.eClass().getEAnnotations()) {
      if (annot.getSource().startsWith("DynamicValueAnnotation")) {
        EMap<String, String> map = annot.getDetails();
        String propertyName = map.get("superProperty");

        if (StringUtils.isBlank(propertyName)
            || !StringUtils.equals(propertyName, structuralFeature.getName())) {
          continue;
        } else {
          annotation = annot;
        }
      }

    }
    if (annotation == null)
      annotation = structuralFeature.getEAnnotation("DynamicValueAnnotation");

    if (annotation != null) {
      EMap<String, String> map = annotation.getDetails();
      description = map.get("description");
      expectedReturnType = map.get("expectedReturnType");
      dynValueTypeStr = map.get("type");
      isTypeLocked = Boolean.valueOf(map.get("isTypeLocked"));
      helperClass = map.get("helperClass");
      if ("com.safi.workshop.sheet.assist.FileBrowserAssistant".equals(helperClass) && isTypeLocked) {
        return createHandlerBrowserEditor(composite);
      } else if ("com.safi.workshop.sheet.assist.SafletChooserAssistant".equals(helperClass))
        // return createSafletChooserDialog(composite);
        helperClass = "com.safi.workshop.sheet.SelectSafletDynamicValueEditorPage";
    }
    attributeName = (object instanceof ActionStep ? ((ActionStep) object).getName() + "->" : "")
        + structuralFeature.getName();

    return createDynamicValueEditor(composite, attributeName, expectedReturnType, description,
        isTypeLocked, dynValueTypeStr, helperClass);

  }

  @Override
  public ILabelProvider getLabelProvider() {
    final IItemLabelProvider itemLabelProvider = itemPropertyDescriptor.getLabelProvider(object);
    return new LabelProvider() {
      @Override
      public String getText(Object object) {
        if (object instanceof DynamicValue) {
          DynamicValue dynamicValue = ((DynamicValue) object);
          DynamicValueType type = dynamicValue.getType();
          if (type == DynamicValueType.LITERAL_TEXT)
            return dynamicValue.getText();
          else if (type == DynamicValueType.VARIABLE_NAME)
            return "Variable: " + dynamicValue.getText();
          else if (type == DynamicValueType.CUSTOM)
            return dynamicValue.getText();
          else if (type == DynamicValueType.SCRIPT_TEXT)
            return "Script";
        }
        return itemLabelProvider.getText(object);
      }

      @Override
      public Image getImage(Object object) {
        return ExtendedImageRegistry.getInstance().getImage(itemLabelProvider.getImage(object));
      }
    };
    // TODO Auto-generated method stub
    // return super.getLabelProvider();
  }

  private CellEditor createDynamicValueEditor(final Composite composite,
      final String attributeName, final String expectedReturnType, final String description,
      final boolean isTypeLocked, final String dynValueTypeStr, final String helperClassString) {

    CellEditor editor = new DynamicValueCellEditor(composite, getEditLabelProvider(), editingDomain) {
      @Override
      protected Object openDialogBox(Control cellEditorWindow) {
        final DynamicValueEditor2 dve = new DynamicValueEditor2(cellEditorWindow.getShell());
        dve.setAttributeName(attributeName);
        dve.setExpectedReturnType(expectedReturnType);
        dve.setDescription(description);
        dve.setTypeLocked(isTypeLocked);
        Object val = getValue();
        SafletContext handlerContext = null;
        if (object instanceof ActionStep) {
          handlerContext = ((ActionStep) object).getSaflet().getSafletContext();
        } else {
          Saflet h = null;
          Object obj = this.editingDomain.getRoot(object);
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

        DynamicValue dynamicValue = (DynamicValue) val;
        dve.setDynamicValue(dynamicValue);
        dve.setEditingDomain(editingDomain);

        final boolean hasHelperClass = StringUtils.isNotBlank(helperClassString);

        final SafletContext handlerContextFinal = handlerContext;
        // LiteralDynamicValueEditorPage literalPage = new
        // LiteralDynamicValueEditorPage();
        // dve.addPage(literalPage);
        ProgressMonitorDialog pmd = new ProgressMonitorDialog(AsteriskDiagramEditorUtil
            .getActiveShell());
        try {
          pmd.run(true, false, new IRunnableWithProgress() {

            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException,
                InterruptedException {
              monitor.beginTask("Open Dynamic Value Editor", IProgressMonitor.UNKNOWN);
              Display.getDefault().asyncExec(new Runnable() {

                public void run() {
                  if (!(hasHelperClass && isTypeLocked)) {
                    VariableDynamicValueEditorPage variablePage = new VariableDynamicValueEditorPage(
                        handlerContextFinal);
                    dve.addPage(variablePage);

                    ScriptDynamicValueEditorPage scriptPage = new ScriptDynamicValueEditorPage(
                        handlerContextFinal);
                    dve.addPage(scriptPage);
                  }
                  if (hasHelperClass) {
                    Thread currentThread = Thread.currentThread();
                    ClassLoader oldLoader = currentThread.getContextClassLoader();
                    try {

                      currentThread.setContextClassLoader(AsteriskDiagramEditorPlugin.class
                          .getClassLoader());
                      String[] classes = helperClassString.split(";");
                      for (String s : classes) {
                        DynamicValueEditorPage page = DynamicValueEditorUtils.buildEditorPage(s,
                            handlerContextFinal, editingDomain);
                        if (page != null) {
                          dve.addPage(page);
                          dve.setDefaultPage(page);
                        }
                      }
                    } finally {
                      currentThread.setContextClassLoader(oldLoader);
                    }
                  }
                }
              });
            }

          });
        } catch (InvocationTargetException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        // BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
        //
        // public void run() {
        // ScriptDynamicValueEditorPage scriptPage = new ScriptDynamicValueEditorPage(
        // handlerContextFinal);
        // dve.addPage(scriptPage);
        // }
        // });

        if (dynamicValue == null) {
          dve.setDefaultPageByType(dynValueTypeStr);
        } else if (dynamicValue.getType() == DynamicValueType.CUSTOM
            && StringUtils.isNotBlank(expectedReturnType)) {
          for (int i = 0; i < dve.getNumPages(); i++) {
            if (StringUtils.equals(dve.getPage(i).getType(), expectedReturnType)) {
              dve.setDefaultPage(dve.getPage(i));
              break;
            }
          }
        }
        dve.setBlockOnOpen(true);
        dve.open();
        DynamicValue dv = dve.getDynamicValue();
        if (dv == null || StringUtils.isBlank(dv.getText()))
          return null;
        return dv;
      }
    };
    if (isTypeLocked
        && !StringUtils.equals(DynamicValueType.SCRIPT_TEXT.toString(), dynValueTypeStr))
      ((DynamicValueCellEditor) editor).setEditable(false);
    return editor;
  }

  private CellEditor createHandlerBrowserEditor(Composite composite) {
    CellEditor editor = new ExtendedDialogCellEditor(composite, getEditLabelProvider()) {

      @Override
      protected Object openDialogBox(Control cellEditorWindow) {
        if (fileDialog == null) {
          fileDialog = new FileDialog(cellEditorWindow.getShell(), SWT.SINGLE);
          // fileDialog.setFilterNames(new String[] { "Asterisk Saflet Files" });
          // fileDialog.setFilterExtensions(new String[] { "*.saflet" });
          fileDialog.setText("Select File");
        }
        DynamicValue dynamicValue = (DynamicValue) getValue();
        if (dynamicValue != null) {
          fileDialog.setFileName(dynamicValue.getText());
        } else {
          dynamicValue = ActionStepFactory.eINSTANCE.createDynamicValue();
          dynamicValue.setType(DynamicValueType.LITERAL_TEXT);
        }
        String file = fileDialog.open();
        if (file == null) {
          dynamicValue.setText("");
        } else
          dynamicValue.setText(file);

        return dynamicValue;
      }
    };
    return editor;
  }

  private CellEditor createSafletChooserDialog(Composite composite) {

    return new SelectSafletDialogCellEditor(composite, getEditLabelProvider());
  }

}
