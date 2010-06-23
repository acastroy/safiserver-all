package com.safi.workshop.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskVisualIDRegistry;

/**
 * @generated
 */
public class AsteriskEditPartFactory implements EditPartFactory {

  /**
   * @generated
   */
  public EditPart createEditPart(EditPart context, Object model) {
    if (model instanceof View) {
      View view = (View) model;
      int visualID = AsteriskVisualIDRegistry.getVisualID(view);
      switch (visualID) {

        case HandlerEditPart.VISUAL_ID:
          return new HandlerEditPart(view);

        case AssignmentEditPart.VISUAL_ID:
          return new AssignmentEditPart(view);

        case AssignmentNameEditPart.VISUAL_ID:
          return new AssignmentNameEditPart(view);

        case ChoiceEditPart.VISUAL_ID:
          return new ChoiceEditPart(view);

        case ChoiceNameEditPart.VISUAL_ID:
          return new ChoiceNameEditPart(view);


        case IfThenEditPart.VISUAL_ID:
          return new IfThenEditPart(view);

        case IfThenNameEditPart.VISUAL_ID:
          return new IfThenNameEditPart(view);


        case ExecuteScriptEditPart.VISUAL_ID:
          return new ExecuteScriptEditPart(view);

        case ExecuteScriptNameEditPart.VISUAL_ID:
          return new ExecuteScriptNameEditPart(view);

        case InvokeSafletEditPart.VISUAL_ID:
          return new InvokeSafletEditPart(view);

        case InvokeSafletNameEditPart.VISUAL_ID:
          return new InvokeSafletNameEditPart(view);

        case InvokeSafletLabelTextEditPart.VISUAL_ID:
          return new InvokeSafletLabelTextEditPart(view);

        case DebugLogEditPart.VISUAL_ID:
          return new DebugLogEditPart(view);

        case DebugLogNameEditPart.VISUAL_ID:
          return new DebugLogNameEditPart(view);

        case OpenDBConnectionEditPart.VISUAL_ID:
          return new OpenDBConnectionEditPart(view);

        case OpenDBConnectionNameEditPart.VISUAL_ID:
          return new OpenDBConnectionNameEditPart(view);

        case CloseDBConnectionEditPart.VISUAL_ID:
          return new CloseDBConnectionEditPart(view);

        case CloseDBConnectionNameEditPart.VISUAL_ID:
          return new CloseDBConnectionNameEditPart(view);

        case OpenQueryEditPart.VISUAL_ID:
          return new OpenQueryEditPart(view);

        case OpenQueryNameEditPart.VISUAL_ID:
          return new OpenQueryNameEditPart(view);

        case SetQueryParamEditPart.VISUAL_ID:
          return new SetQueryParamEditPart(view);

        case SetQueryParamNameEditPart.VISUAL_ID:
          return new SetQueryParamNameEditPart(view);

        case ExecuteUpdateEditPart.VISUAL_ID:
          return new ExecuteUpdateEditPart(view);

        case ExecuteUpdateNameEditPart.VISUAL_ID:
          return new ExecuteUpdateNameEditPart(view);

        case ExecuteQueryEditPart.VISUAL_ID:
          return new ExecuteQueryEditPart(view);

        case ExecuteQueryNameEditPart.VISUAL_ID:
          return new ExecuteQueryNameEditPart(view);

        case NextRowEditPart.VISUAL_ID:
          return new NextRowEditPart(view);

        case NextRowNameEditPart.VISUAL_ID:
          return new NextRowNameEditPart(view);

        case GetColValueEditPart.VISUAL_ID:
          return new GetColValueEditPart(view);

        case GetColValueNameEditPart.VISUAL_ID:
          return new GetColValueNameEditPart(view);

        case SetColValueEditPart.VISUAL_ID:
          return new SetColValueEditPart(view);

        case SetColValueNameEditPart.VISUAL_ID:
          return new SetColValueNameEditPart(view);

        case UpdatetRowEditPart.VISUAL_ID:
          return new UpdatetRowEditPart(view);

        case UpdatetRowNameEditPart.VISUAL_ID:
          return new UpdatetRowNameEditPart(view);

        case MoveToRowEditPart.VISUAL_ID:
          return new MoveToRowEditPart(view);

        case MoveToRowNameEditPart.VISUAL_ID:
          return new MoveToRowNameEditPart(view);

        case MoveToLastRowEditPart.VISUAL_ID:
          return new MoveToLastRowEditPart(view);

        case MoveToLastRowNameEditPart.VISUAL_ID:
          return new MoveToLastRowNameEditPart(view);

        case DeleteRowEditPart.VISUAL_ID:
          return new DeleteRowEditPart(view);

        case DeleteRowNameEditPart.VISUAL_ID:
          return new DeleteRowNameEditPart(view);

        case MoveToInsertRowEditPart.VISUAL_ID:
          return new MoveToInsertRowEditPart(view);

        case MoveToInsertRowNameEditPart.VISUAL_ID:
          return new MoveToInsertRowNameEditPart(view);

        case InsertRowEditPart.VISUAL_ID:
          return new InsertRowEditPart(view);

        case InsertRowNameEditPart.VISUAL_ID:
          return new InsertRowNameEditPart(view);

        case MoveToFirstRowEditPart.VISUAL_ID:
          return new MoveToFirstRowEditPart(view);

        case MoveToFirstRowNameEditPart.VISUAL_ID:
          return new MoveToFirstRowNameEditPart(view);

        case PreviousRowEditPart.VISUAL_ID:
          return new PreviousRowEditPart(view);

        case PreviousRowNameEditPart.VISUAL_ID:
          return new PreviousRowNameEditPart(view);

        case GetColValuesEditPart.VISUAL_ID:
          return new GetColValuesEditPart(view);

        case GetColValuesNameEditPart.VISUAL_ID:
          return new GetColValuesNameEditPart(view);

        case SetColValuesEditPart.VISUAL_ID:
          return new SetColValuesEditPart(view);

        case SetColValuesNameEditPart.VISUAL_ID:
          return new SetColValuesNameEditPart(view);

        case RunQueryEditPart.VISUAL_ID:
          return new RunQueryEditPart(view);

        case RunQueryNameEditPart.VISUAL_ID:
          return new RunQueryNameEditPart(view);

        case OutputEditPart.VISUAL_ID:
          return new OutputEditPart(view);

        case CaseItemEditPart.VISUAL_ID:
          return new CaseItemEditPart(view);

        case CaseItemLabelTextEditPart.VISUAL_ID:
          return new CaseItemLabelTextEditPart(view);

        case GetColMappingEditPart.VISUAL_ID:
          return new GetColMappingEditPart(view);

        case GetColMappingGetAsDatatypeEditPart.VISUAL_ID:
          return new GetColMappingGetAsDatatypeEditPart(view);

        case SetColMappingEditPart.VISUAL_ID:
          return new SetColMappingEditPart(view);

        case SetColMappingSetAsDatatypeEditPart.VISUAL_ID:
          return new SetColMappingSetAsDatatypeEditPart(view);

        case QueryParamMappingEditPart.VISUAL_ID:
          return new QueryParamMappingEditPart(view);

        case WrapLabelEditPart.VISUAL_ID:
          return new WrapLabelEditPart(view);

        case ChoiceItemPanelEditPart.VISUAL_ID:
          return new ChoiceItemPanelEditPart(view);

        case GetColValuesValuesPanelEditPart.VISUAL_ID:
          return new GetColValuesValuesPanelEditPart(view);

        case SetColValuesValuesPanelEditPart.VISUAL_ID:
          return new SetColValuesValuesPanelEditPart(view);

        case RunQueryRunQueryValuesPanelEditPart.VISUAL_ID:
          return new RunQueryRunQueryValuesPanelEditPart(view);

        case OutputTargetEditPart.VISUAL_ID:
          return new OutputTargetEditPart(view);

        case CaseItemTargetToolstepEditPart.VISUAL_ID:
          return new CaseItemTargetToolstepEditPart(view);
        default: {
          for (AsteriskDiagramEditorPlugin.ActionStepProfile p : AsteriskDiagramEditorPlugin
              .getInstance().getActionstepProfiles()) {
            String id = String.valueOf(visualID);
            if (p.semanticHint.equals(id) || p.labelSemanticHint.equals(id)
                || id.equals(p.inputItemLabelSemanticHint)
                || id.equals(p.inputItemPanelSemanticHint) || id.equals(p.inputItemSemanticHint)
                || id.equals(p.outputItemLabelSemanticHint)
                || id.equals(p.outputItemPanelSemanticHint) || id.equals(p.outputItemSemanticHint)) {
              return p.editPartFactory.createEditPart(view, visualID);
            }
          }
        }
      }
    }
    return createUnrecognizedEditPart(context, model);
  }

  /**
   * @generated
   */
  private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
    // Handle creation of unrecognized child node EditParts here
    // for (AsteriskDiagramEditorPlugin.ActionStepProfile a : AsteriskDiagramEditorPlugin
    // .getInstance().getActionstepProfiles()) {
    //
    // }
    return null;
  }

  /**
   * @generated
   */
  public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
    if (source.getFigure() instanceof WrapLabel)
      return new TextCellEditorLocator((WrapLabel) source.getFigure());
    else {
      return new LabelCellEditorLocator((Label) source.getFigure());
    }
  }

  /**
   * @generated
   */
  static private class TextCellEditorLocator implements CellEditorLocator {

    /**
     * @generated
     */
    private WrapLabel wrapLabel;

    /**
     * @generated
     */
    public TextCellEditorLocator(WrapLabel wrapLabel) {
      this.wrapLabel = wrapLabel;
    }

    /**
     * @generated
     */
    public WrapLabel getWrapLabel() {
      return wrapLabel;
    }

    /**
     * @generated
     */
    public void relocate(CellEditor celleditor) {
      Text text = (Text) celleditor.getControl();
      Rectangle rect = getWrapLabel().getTextBounds().getCopy();
      getWrapLabel().translateToAbsolute(rect);
      if (getWrapLabel().isTextWrapped() && getWrapLabel().getText().length() > 0) {
        rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
      } else {
        int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
        rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
      }
      if (!rect.equals(new Rectangle(text.getBounds()))) {
        text.setBounds(rect.x, rect.y, rect.width, rect.height);
      }
    }

  }

  /**
   * @generated
   */
  private static class LabelCellEditorLocator implements CellEditorLocator {

    /**
     * @generated
     */
    private Label label;

    /**
     * @generated
     */
    public LabelCellEditorLocator(Label label) {
      this.label = label;
    }

    /**
     * @generated
     */
    public Label getLabel() {
      return label;
    }

    /**
     * @generated
     */
    public void relocate(CellEditor celleditor) {
      Text text = (Text) celleditor.getControl();
      Rectangle rect = getLabel().getTextBounds().getCopy();
      getLabel().translateToAbsolute(rect);
      int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
      rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
      if (!rect.equals(new Rectangle(text.getBounds()))) {
        text.setBounds(rect.x, rect.y, rect.width, rect.height);
      }
    }
  }
}
