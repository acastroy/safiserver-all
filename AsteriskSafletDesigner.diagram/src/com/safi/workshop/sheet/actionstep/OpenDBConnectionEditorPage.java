package com.safi.workshop.sheet.actionstep;

import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.safi.core.actionstep.OpenDBConnection;

public class OpenDBConnectionEditorPage extends AbstractActionstepEditorPage {

  private NewDBConnectionWidget newDBConnectionWidget;
  private Label dbConnectionLabel;
  private Text text;
  private Label nameLabel;

  public OpenDBConnectionEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    OpenDBConnection openDBConnection = (OpenDBConnection) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    nameLabel = new Label(this, SWT.NONE);
    nameLabel.setText("Name:");

    text = new Text(this, SWT.BORDER);
    final GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_text.widthHint = 50;
    text.setLayoutData(gd_text);

    //

    IObservableValue ob = ActionstepEditObservables.observeValue(editingDomain, openDBConnection,
        openDBConnection.eClass().getEStructuralFeature("name"));
    // IObservableValue ob =
    // EMFObservables.observeValue(parent.getEditPart().getActionStep(), parent
    // .getEditPart().getActionStep().eClass().getEStructuralFeature("name"));
    ISWTObservableValue uiElement = SWTObservables.observeText(text, SWT.FocusOut);

    dbConnectionLabel = new Label(this, SWT.NONE);
    dbConnectionLabel.setText("DB Connection*:");

    newDBConnectionWidget = new NewDBConnectionWidget(this, SWT.NONE);
    newDBConnectionWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    uiElement = SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);

    ob = ActionstepEditObservables.observeValue(editingDomain, openDBConnection, openDBConnection
        .eClass().getEStructuralFeature("connection"));
    DBConnectionWidgetObservableValue connVal = new DBConnectionWidgetObservableValue(
        newDBConnectionWidget, SWT.Modify);
    bindingContext.bindValue(connVal, ob, null, null);

  }

  @Override
  public String getTabText() {
    // TODO Auto-generated method stub
    return "Basic";
  }

  @Override
  public boolean validate() {
    IObservableList list = bindingContext.getBindings();
    for (Binding b : (List<Binding>) list) {
      b.validateTargetToModel();
    }
    return true;
  }

}
