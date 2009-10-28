package com.safi.workshop.sheet.actionstep;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import com.safi.core.actionstep.DBQueryParamId;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.Item;
import com.safi.core.actionstep.QueryParamMapping;
import com.safi.db.SQLDataType;

public class QueryParamMappingEditorWidget extends AbstractItemEditorWidget {

  public QueryParamMappingEditorWidget(Composite parent, int style) {
    super(parent, style);
    addButton.setEnabled(false);
    deleteButton.setEnabled(false);
    moveDownButton.setEnabled(false);
    moveUpButton.setEnabled(false);
    listViewer.setLabelProvider(new LabelProvider() {

      @Override
      public Image getImage(Object element) {
        return null;
      }

      @Override
      public String getText(Object element) {
        if (element instanceof QueryParamMapping) {
          QueryParamMapping qelement = (QueryParamMapping) element;
          DBQueryParamId paramId = qelement.getQueryParam();
          DynamicValue dvalue = qelement.getValue();
          SQLDataType dtype = qelement.getSetAsDatatype();
          String label = "";
          if (paramId != null) {
            label = label + qelement.getLabelText();
          }
          if (dvalue != null) {
            label = label + "=" + dvalue.getText();
          }
          if (dtype != null) {
            label = label + " [" + dtype.getLiteral() + "]";
          }
          return label;

        }
        if (element == null)
          return "";

        return element.toString();
      }
    });

  }

  @Override
  protected void editItem(Item item) {
    QueryParamMapping newItem = (QueryParamMapping) EcoreUtil.copy(item);
    EditQueryParamMappingDialog dlg = new EditQueryParamMappingDialog(Display.getDefault()
        .getActiveShell(), newItem, editingDomain, getActionstepEditorDialog().getEditPart()
        .getActionStep().getSaflet().getSafletContext());
    if (Window.OK == dlg.open()) {
      replace(item, newItem);
      listViewer.refresh();
    }
  }

  @Override
  protected void newItem() {
    // QueryParamMapping item = ActionStepFactory.eINSTANCE.createQueryParamMapping();
    // EditQueryParamMappingDialog dlg = new EditQueryParamMappingDialog(
    // Display.getDefault().getActiveShell(), (QueryParamMapping) item, editingDomain,
    // getActionstepEditorDialog().getEditPart().getActionStep().getSaflet().getSafletContext());
    // if (EditQueryParamMappingDialog.OK == dlg.open()) {
    // itemList.add(item);
    // listViewer.refresh();
    // }

  }

  @Override
  protected void delete() {
    // TODO Auto-generated method stub
    // super.delete();
  }

  @Override
  protected void moveUp() {
    // TODO Auto-generated method stub
    // super.moveUp();
  }

  @Override
  protected void moveDown() {
    // TODO Auto-generated method stub
    // super.moveDown();
  }
}
