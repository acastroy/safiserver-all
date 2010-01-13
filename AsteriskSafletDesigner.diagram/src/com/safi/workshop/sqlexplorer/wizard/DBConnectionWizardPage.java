package com.safi.workshop.sqlexplorer.wizard;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class DBConnectionWizardPage extends WizardPage {

  public DBConnectionWizardPage(String pageName) {
    super(pageName);
    // setImageDescriptor(ResourceManager.getPluginImageDescriptor(AsteriskDiagramEditorPlugin.getDefault(),
    // "icons/wizban/connection_wiz.gif"));
    setImageDescriptor(AsteriskDiagramEditorPlugin
        .getBundledImageDescriptor("icons/wizban/connection_wiz.gif"));
  }

  @Override
  public void setWizard(IWizard newWizard) {
    super.setWizard(newWizard);
    updateTitleAndMessage();
  }

  public void updateTitleAndMessage() {
    setTitle(getDBConnectionWizard().getTitle());
    setMessage(getDBConnectionWizard().getMessage());
  }

  public DBConnectionWizardPage(String pageName, String title, ImageDescriptor titleImage) {
    super(pageName, title, titleImage);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void createControl(Composite parent) {
    // TODO Auto-generated method stub

  }

  protected DBConnectionWizard getDBConnectionWizard() {
    return (DBConnectionWizard) getWizard();
  }

  protected void parsePortAndHost(String[] port, String[] host, String[] dbname) {
    String url = getDBConnectionWizard().getUrl();
    port[0] = "";
    host[0] = "";
    dbname[0] = "";
    if (StringUtils.isBlank(url)) {
      return;
    }
    int firstDblFwdSlashIdx = -1;
    boolean gotfirst = false;
    int i = 0;
    for (; i < url.length(); i++) {
      if (url.charAt(i) == '/') {
        if (firstDblFwdSlashIdx == -1) {
          if (gotfirst)
            firstDblFwdSlashIdx = i + 1;
          else
            gotfirst = true;
        } else {
          break;
        }
      }
    }
    if (firstDblFwdSlashIdx == -1) {
      return;
    }
    String s = url.substring(firstDblFwdSlashIdx, i);
    int lastColon = s.lastIndexOf(':');
    int start = -1;
    if (lastColon == -1) {

      host[0] = s;
      start = ++i;
    } else if (lastColon >= 0 && lastColon <= s.length()) {
      port[0] = s.substring(lastColon + 1);
      host[0] = s.substring(0, lastColon);
      start = ++i;
    }
    if (start != -1) {
      for (; i < url.length(); i++) {
        if (Character.isLetterOrDigit(url.charAt(i)) || url.charAt(i) == '_'
            || url.charAt(i) == '-')
          continue;
        else
          break;
      }
      dbname[0] = start != i ? url.substring(start, Math.min(url.length(), i)) : "";
    }
  }

  public void activate() {

  }

}
