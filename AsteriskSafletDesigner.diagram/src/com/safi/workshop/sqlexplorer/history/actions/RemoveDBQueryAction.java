package com.safi.workshop.sqlexplorer.history.actions;

import com.safi.db.Query;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

public class RemoveDBQueryAction extends org.eclipse.jface.action.Action {

  private com.safi.workshop.sqlexplorer.dbproduct.Alias alias;
  private Query query;

  public RemoveDBQueryAction() {
    super();
  }

  @Override
  public String getText() {

    return Messages.getString("SQLHistoryView.RemoveQuery");
  }

  @Override
  public boolean isEnabled() {
    return alias != null && query != null;
  }

  @Override
  public void run() {

    try {
      if (alias != null)
        alias.removeQuery(query);

    } catch (Throwable e) {
      SQLExplorerPlugin.error("Error removing item from clipboard", e);
    }
  }

  public com.safi.workshop.sqlexplorer.dbproduct.Alias getAlias() {
    return alias;
  }

  public void setAlias(com.safi.workshop.sqlexplorer.dbproduct.Alias alias) {
    this.alias = alias;
  }

  public Query getQuery() {
    return query;
  }

  public void setQuery(Query query) {
    this.query = query;
  }
}
