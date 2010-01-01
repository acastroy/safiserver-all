package com.safi.workshop.actionpak1.editpart;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.Item;
import com.safi.workshop.actionpak1.command.SetInputItemValueCommand;

public class ManagerActionInputParamEditorWidget extends InputItemEditorWidget {

  public ManagerActionInputParamEditorWidget(Composite parent, int style) {
    super(parent, style);
    addButton.setEnabled(false);
    deleteButton.setEnabled(false);
    moveUpButton.setEnabled(false);
    moveDownButton.setEnabled(false);
   
    Table table=this.listViewer.getTable();
    table.setLinesVisible(true);
    table.setHeaderVisible(true);
    TableColumn column = new TableColumn(table, SWT.NONE);
    column.setText("Property Name");
    column.setWidth(100);
    TableColumn column2 = new TableColumn(table, SWT.NONE);
    column2.setText("Type");
    column2.setWidth(50);
    TableColumn column3 = new TableColumn(table, SWT.NONE);
    column3.setText("Value");
    column3.setWidth(100);
    this.listViewer.setLabelProvider(new MyLabelProvider());
    
  }

//  @Override
//  protected void newItem() {
//    
//  }
  
  @Override
  protected void editItem(Item item) {
    
    if (!SetInputItemValueCommand.executeCmd((InputItem)item, editingDomain,
        getActionstepEditorDialog().getEditPart().getActionStep().getSaflet().getSafletContext(), false))
        return;
//    Command command = getActionstepEditorDialog().getEditPart().getEditingDomain().getCommandStack().getMostRecentCommand();
//    getActionstepEditorDialog().rollbackCount++;
    listViewer.refresh();
  }
  
  @Override
  protected void delete() {
    // TODO Auto-generated method stub
//    super.delete();
  }
  
  @Override
  protected void moveDown() {
    // TODO Auto-generated method stub
//    super.moveDown();
  }
  
  @Override
  protected void moveUp() {
    // TODO Auto-generated method stub
//    super.moveUp();
  }
  
/*
  @Override
  protected LabelProvider createLabelProvider() {
    // TODO Auto-generated method stub
	 
	  
    return new LabelProvider() {
      public String getText(Object element) {
        InputItem item = (InputItem) element;
        return item.getParameterName() + " = "
            + (item.getDynamicValue() == null ? "" : item.getDynamicValue().getText());
      }

      public Image getImage(Object element) {
       // return WebServicesPlugin.getInstance().getBundledImage("icons/parameter.gif");
    	  return null;
      }
    };
    
  }
*/  
  private class MyLabelProvider implements ITableLabelProvider{

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		 InputItem item = (InputItem) element;
		 if(item==null)return null;
		 switch(columnIndex){
		 case 0:
			 return item.getParameterName();
		 case 1:
			 
			  return "String";
		 case 2:
			 DynamicValue value=item.getDynamicValue();
			 if(value!=null){
				 return value.getText();
			 }
		 }
		return null;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}


	  
  }
  
 

}
