package com.safi.workshop.sheet.actionstep;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.safi.core.actionstep.CloseDBConnection;
import com.safi.core.actionstep.DBConnectionId;

public class CloseDBConnectionEditorPage extends AbstractActionstepEditorPage {

  private Combo combo;
  private ComboViewer comboViewer;
  private Label call1Label;
  private Text text;
  private Label nameLabel;

  public CloseDBConnectionEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    nameLabel = new Label(this, SWT.NONE);
    nameLabel.setText("Name*:");

    text = new Text(this, SWT.BORDER);
    final GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_text.widthHint = 50;
    text.setLayoutData(gd_text);

    call1Label = new Label(this, SWT.NONE);
    call1Label.setText("Connection*:");

    comboViewer = new ComboViewer(this, SWT.BORDER);
    combo = comboViewer.getCombo();
    final GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_combo.widthHint = 50;
    combo.setLayoutData(gd_combo);
    IObservableValue ob = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("name"));
    // IObservableValue ob =
    // EMFObservables.observeValue(parent.getEditPart().getActionStep(), parent
    // .getEditPart().getActionStep().eClass().getEStructuralFeature("name"));
    ISWTObservableValue uiElement = SWTObservables.observeText(text,
        SWT.FocusOut);
    SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);

    // fix this got to go over this stuff.
    List<DBConnectionId> calls = new ArrayList<DBConnectionId>();
    for (Iterator<EObject> iter = parent.getEditPart().getActionStep().eResource().getAllContents(); iter
        .hasNext();) {
      EObject obj = iter.next();
      if (obj instanceof DBConnectionId)
        calls.add((DBConnectionId) obj);
    }
    CloseDBConnection closeToolStep = (CloseDBConnection) parent.getEditPart().getActionStep();
    comboViewer.setContentProvider(new IStructuredContentProvider() {

      @Override
      public void dispose() {
      }

      @Override
      public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
      }

      @Override
      public Object[] getElements(Object inputElement) {
        return ((List<DBConnectionId>) inputElement).toArray();
      }

    });
    comboViewer.setLabelProvider(new ILabelProvider() {

      @Override
      public void addListener(ILabelProviderListener listener) {
      }

      @Override
      public void dispose() {
      }

      @Override
      public boolean isLabelProperty(Object element, String property) {
        return true;
      }

      @Override
      public void removeListener(ILabelProviderListener listener) {

      }

      @Override
      public Image getImage(Object element) {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public String getText(Object element) {
        // System.out.println(((DBConnectionId) element).getId());
        String id = ((DBConnectionId) element).getId();

        String[] names = id.split(".");
        // System.out.println("burglang:"+names.length);
        if (names.length > 0) {
          return names[names.length - 1];
        } else
          return id;
      }

    });
    comboViewer.setInput(calls);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("connection"));
    ISWTObservableValue comboElement = SWTObservables.observeSelection(combo);

    comboElement = SWTObservables.observeDelayedValue(400, comboElement);
    ConnectionUpdateStrategy cus = new ConnectionUpdateStrategy(calls);
    // CallUpdateStrategy cus = new CallUpdateStrategy(calls);
    bindingContext.bindValue(comboElement, ob, cus, cus);
    // bindingContext.bindValue(comboElement, ob, null, null);
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
