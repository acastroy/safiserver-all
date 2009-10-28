package com.safi.workshop.part;

import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;

/**
 * @generated
 */
public class AsteriskDiagramActionBarContributor extends DiagramActionBarContributor {

  public AsteriskDiagramActionBarContributor() {
    super();
  }

  /**
   * @generated
   */
  @Override
  protected Class getEditorClass() {
    return AsteriskDiagramEditor.class;
  }

  /**
   * @generated
   */
  @Override
  protected String getEditorId() {
    return AsteriskDiagramEditor.ID;
  }

  @Override
  public void contributeToMenu(IMenuManager menuManager) {
    // TODO Auto-generated method stub
    super.contributeToMenu(menuManager);
  }

  /**
   * @generated NOT
   */
  @Override
  public void init(IActionBars bars) {
    // TODO Auto-generated method stub
    super.init(bars);

    bars.getToolBarManager().remove(ActionIds.ACTION_ARRANGE_ALL);
    bars.getToolBarManager().remove(ActionIds.ACTION_ARRANGE_SELECTION);
    IAction action = getAction(ActionIds.ACTION_ARRANGE_ALL);
    if (action != null)
      getActionRegistry().removeAction(action);
    for (IContributionItem item : bars.getToolBarManager().getItems()) {
      if ("arrangeMenu".equals(item.getId()) || "showConnectorLabels".equals(item.getId())
          || "toolbarFontGroup".equals(item.getId()) || "compartmentMenu".equals(item.getId())
          || "fontNameContributionItem".equals(item.getId())
          || "fontSizeContributionItem".equals(item.getId())
          || "fontBoldAction".equals(item.getId()) || "fontItalicAction".equals(item.getId())
          || "fontColorContributionItem".equals(item.getId())
          || "fillColorContributionItem".equals(item.getId())
          || ActionIds.ACTION_HIDE_CONNECTION_LABELS.equals(item.getId())) {
        bars.getToolBarManager().remove(item);
      }

    }
    // bars.getToolBarManager().removeAll();
    bars.updateActionBars();
    IContributionItem[] items = this.getActionBars().getMenuManager().getItems();
    for (IContributionItem item : items) {
      if ("diagramMenu".equals(item.getId())) {
        IMenuManager me = this.getActionBars().getMenuManager().findMenuUsingPath("diagramMenu");
        if (me != null) {
          IContributionItem[] items2 = me.getItems();
          for (IContributionItem element : items2) {
            String id = element.getId();
            if ("arrangeMenu".equals(id)) {

              me.remove(id);
              me.update(true);
            } else if ("filtersMenu".equals(id)) {

              me.remove(id);
              me.update(true);
            } else if (ActionIds.ACTION_FONT_DIALOG.equals(id)
                || ActionIds.CUSTOM_LINE_COLOR.equals(id) || ActionIds.CUSTOM_FONT_NAME.equals(id)
                || ActionIds.CUSTOM_FILL_COLOR.equals(id)) {
              me.remove(id);
              me.update(true);
            }

          }
        }
      }
    }
  }

  @Override
  public void contributeToCoolBar(ICoolBarManager coolBarManager) {
    // TODO Auto-generated method stub
    super.contributeToCoolBar(coolBarManager);
  }

  @Override
  public void contributeToToolBar(IToolBarManager toolBarManager) {
    // TODO Auto-generated method stub
    super.contributeToToolBar(toolBarManager);
  }
}
