package com.safi.workshop.sheet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.safi.workshop.edit.parts.AssignmentEditPart;
import com.safi.workshop.edit.parts.ChoiceEditPart;
import com.safi.workshop.edit.parts.CloseDBConnectionEditPart;
import com.safi.workshop.edit.parts.DebugLogEditPart;
import com.safi.workshop.edit.parts.DeleteRowEditPart;
import com.safi.workshop.edit.parts.ExecuteScriptEditPart;
import com.safi.workshop.edit.parts.ExecuteUpdateEditPart;
import com.safi.workshop.edit.parts.GetColValueEditPart;
import com.safi.workshop.edit.parts.GetColValuesEditPart;
import com.safi.workshop.edit.parts.InsertRowEditPart;
import com.safi.workshop.edit.parts.MoveToFirstRowEditPart;
import com.safi.workshop.edit.parts.MoveToInsertRowEditPart;
import com.safi.workshop.edit.parts.MoveToLastRowEditPart;
import com.safi.workshop.edit.parts.MoveToRowEditPart;
import com.safi.workshop.edit.parts.NextRowEditPart;
import com.safi.workshop.edit.parts.OpenDBConnectionEditPart;
import com.safi.workshop.edit.parts.PreviousRowEditPart;
import com.safi.workshop.edit.parts.RunQueryEditPart;
import com.safi.workshop.edit.parts.SetColValueEditPart;
import com.safi.workshop.edit.parts.SetColValuesEditPart;
import com.safi.workshop.edit.parts.ToolstepEditPart;
import com.safi.workshop.edit.parts.UpdatetRowEditPart;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.ActionstepEditorPage;
import com.safi.workshop.sheet.actionstep.AssignmentEditorPage;
import com.safi.workshop.sheet.actionstep.ChoiceEditorPage;
import com.safi.workshop.sheet.actionstep.CloseDBConnectionEditorPage;
import com.safi.workshop.sheet.actionstep.DebugLogEditorPage;
import com.safi.workshop.sheet.actionstep.ExecuteScriptEditorPage;
import com.safi.workshop.sheet.actionstep.ExecuteUpdateEditorPage;
import com.safi.workshop.sheet.actionstep.GetColValueEditorPage;
import com.safi.workshop.sheet.actionstep.GetColValueOutputEditorPage;
import com.safi.workshop.sheet.actionstep.GetColValuesEditorPage;
import com.safi.workshop.sheet.actionstep.MoveToRowEditorPage;
import com.safi.workshop.sheet.actionstep.OpenDBConnectionEditorPage;
import com.safi.workshop.sheet.actionstep.ResultSetEditorPage;
import com.safi.workshop.sheet.actionstep.RunQueryBasicEditorPage;
import com.safi.workshop.sheet.actionstep.RunQueryOutputEditorPage;
import com.safi.workshop.sheet.actionstep.SetColValueEditorPage;
import com.safi.workshop.sheet.actionstep.SetColValuesEditorPage;

public class ActionstepEditorDialogFactoryManager {

  private final static ActionstepEditorDialogFactoryManager instance = new ActionstepEditorDialogFactoryManager();

  public static ActionstepEditorDialogFactoryManager getInstance() {
    return instance;
  }

  private Map<String, ActionstepEditorDialogFactory> editorFactories = new HashMap<String, ActionstepEditorDialogFactory>();

  public List<ActionstepEditorPage> createPages(ToolstepEditPart editPart,
      ActionstepEditorDialog dlg) {
    ActionstepEditorDialogFactory factory = editorFactories.get(editPart.getClass().getName());
    if (factory != null) {
      List<ActionstepEditorPage> pages = factory.createEditorPages(dlg);
      if (pages == null)
        return Collections.emptyList();
      else
        return pages;
    }

    List<ActionstepEditorPage> pages = new ArrayList<ActionstepEditorPage>();
    if (editPart instanceof AssignmentEditPart) {
      AssignmentEditorPage page = new AssignmentEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof ChoiceEditPart) {
      ChoiceEditorPage page = new ChoiceEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof DebugLogEditPart) {
      DebugLogEditorPage page = new DebugLogEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof ExecuteScriptEditPart) {
      ExecuteScriptEditorPage page = new ExecuteScriptEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof CloseDBConnectionEditPart) {
      CloseDBConnectionEditorPage page = new CloseDBConnectionEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof RunQueryEditPart) {
      RunQueryBasicEditorPage page = new RunQueryBasicEditorPage(dlg);
      RunQueryOutputEditorPage pageoutput = new RunQueryOutputEditorPage(dlg);
      pages.add(page);
      pages.add(pageoutput);
    } else if (editPart instanceof SetColValuesEditPart) {
      SetColValuesEditorPage page = new SetColValuesEditorPage(dlg);
      pages.add(page);

    } else if (editPart instanceof GetColValuesEditPart) {
      GetColValuesEditorPage page = new GetColValuesEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof DeleteRowEditPart || editPart instanceof InsertRowEditPart
        || editPart instanceof MoveToFirstRowEditPart || editPart instanceof MoveToLastRowEditPart
        || editPart instanceof MoveToInsertRowEditPart || editPart instanceof NextRowEditPart
        || editPart instanceof PreviousRowEditPart || editPart instanceof UpdatetRowEditPart) {
      ResultSetEditorPage page = new ResultSetEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof ExecuteUpdateEditPart) {
      ExecuteUpdateEditorPage page = new ExecuteUpdateEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof MoveToRowEditPart) {
      MoveToRowEditorPage page = new MoveToRowEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof GetColValueEditPart) {
      GetColValueEditorPage page1 = new GetColValueEditorPage(dlg);
      pages.add(page1);

      GetColValueOutputEditorPage page2 = new GetColValueOutputEditorPage(dlg);
      pages.add(page2);
    } else if (editPart instanceof SetColValueEditPart) {
      SetColValueEditorPage page = new SetColValueEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof OpenDBConnectionEditPart) {
      OpenDBConnectionEditorPage page = new OpenDBConnectionEditorPage(dlg);
      pages.add(page);
    }

    return pages;
  }

  public void registerActionstepEditorDialogFactory(String actionstepClassName,
      ActionstepEditorDialogFactory factory) {
    this.editorFactories.put(actionstepClassName, factory);
  }
}
