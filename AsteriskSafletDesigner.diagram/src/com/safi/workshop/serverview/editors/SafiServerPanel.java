package com.safi.workshop.serverview.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.part.EditorPart;

import com.safi.asterisk.handler.mbean.SysInfo;
import com.safi.workshop.serverview.ServerViewEditorInput;
import com.safi.workshop.serverview.ServerViewPanel;

public class SafiServerPanel extends EditorPart {

  private ServerViewPanel serverViewPanel;
  private ServerViewEditorInput serverInput;

  public SafiServerPanel() {
    super();
  }

  @Override
  public void dispose() {
    super.dispose();
  }

  @Override
  public void doSave(IProgressMonitor monitor) {
    // TODO Auto-generated method stub

  }

  @Override
  public void doSaveAs() {
    // TODO Auto-generated method stub

  }

  @Override
  public void init(IEditorSite site, IEditorInput input) {
    setSite(site);
    setInput(input);
    this.serverInput = (ServerViewEditorInput) input;
  }

  @Override
  public void setInput(IEditorInput input) {
    super.setInput(input);
  }

  @Override
  public boolean isDirty() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isSaveAsAllowed() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void createPartControl(Composite parent) {
    parent.setLayout(new GridLayout());
    serverViewPanel = new ServerViewPanel(parent, SWT.NONE);

  }

  @Override
  public void setFocus() {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isSaveOnCloseNeeded() {
    return true;
  }

  public void updateInfo(final SysInfo info) {
    Display d = Display.getCurrent();
    if (d != null)
      serverViewPanel.update(info);
    else {
      d = Display.getDefault();
      d.asyncExec(new Runnable() {
        @Override
        public void run() {
          // TODO Auto-generated method stub
          serverViewPanel.update(info);
        }
      });
    }

  }

  public void selectLicenseViewTab() {
    // TODO Auto-generated method stub
    this.serverViewPanel.selectLicenseViewTab();
  }
}
