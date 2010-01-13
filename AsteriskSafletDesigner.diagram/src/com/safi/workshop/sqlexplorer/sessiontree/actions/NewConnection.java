package com.safi.workshop.sqlexplorer.sessiontree.actions;

import org.eclipse.jface.action.Action;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.plugin.actions.OpenPasswordConnectDialogAction;
import com.safi.workshop.sqlexplorer.util.TextUtil;

/**
 * @author Mazzolini
 * 
 */
public class NewConnection extends Action {

  private User user;

  /**
   * @param alias
   */
  public NewConnection(User user) {
    this.user = user;
  }

  @Override
  public void run() {
    OpenPasswordConnectDialogAction openDlgAction = new OpenPasswordConnectDialogAction(user
        .getAlias(), user, false);
    openDlgAction.run();
  }

  @Override
  public String getText() {
    String name = user.getAlias().getName() + '/' + user.getUserName();
    name = TextUtil.replaceChar(name, '@', "_");
    return name;
  }

}
