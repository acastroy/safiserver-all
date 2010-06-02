package com.safi.workshop.audio;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.audio.utils.AudioUtils;

public class MultiSynchronizePromptsAction implements IWorkbenchWindowActionDelegate {

  public MultiSynchronizePromptsAction() {
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

  @Override
  public void init(IWorkbenchWindow window) {
    // TODO Auto-generated method stub

  }

  @Override
  public void run(IAction action) {

    AudioUtils.synchronizePrompts(SafiServerPlugin.getDefault().getAvailableAsteriskServers());

  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
  }

}
