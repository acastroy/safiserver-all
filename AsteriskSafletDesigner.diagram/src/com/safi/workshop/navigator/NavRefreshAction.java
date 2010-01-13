package com.safi.workshop.navigator;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class NavRefreshAction implements IWorkbenchAction {

  IWorkbenchAction refresh;

  public NavRefreshAction(IWorkbenchAction aCreate) {
    // TODO Auto-generated constructor stub
    refresh = aCreate;
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub
    refresh.dispose();
  }

  @Override
  public void addPropertyChangeListener(IPropertyChangeListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public int getAccelerator() {
    // TODO Auto-generated method stub
    return refresh.getAccelerator();
  }

  @Override
  public String getActionDefinitionId() {
    // TODO Auto-generated method stub
    return "Saflet.action.refresh";
  }

  @Override
  public String getDescription() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ImageDescriptor getDisabledImageDescriptor() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HelpListener getHelpListener() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ImageDescriptor getHoverImageDescriptor() {
    // TODO Auto-generated method stub
    return refresh.getHoverImageDescriptor();
  }

  @Override
  public String getId() {
    // TODO Auto-generated method stub
    return "Saflet.action.refresh";
  }

  @Override
  public ImageDescriptor getImageDescriptor() {
    // TODO Auto-generated method stub
    return refresh.getImageDescriptor();
  }

  @Override
  public IMenuCreator getMenuCreator() {
    // TODO Auto-generated method stub
    return refresh.getMenuCreator();
  }

  @Override
  public int getStyle() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public String getText() {
    // TODO Auto-generated method stub
    return refresh.getText();
  }

  @Override
  public String getToolTipText() {
    // TODO Auto-generated method stub
    return refresh.getToolTipText();
  }

  @Override
  public boolean isChecked() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return refresh.isEnabled();
  }

  @Override
  public boolean isHandled() {
    // TODO Auto-generated method stub
    return refresh.isHandled();
  }

  @Override
  public void removePropertyChangeListener(IPropertyChangeListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public void run() {
    // TODO Auto-generated method stub
    try {
      refresh.run();
      ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
      AsteriskDiagramEditorUtil.getSafiNavigator().refresh();
    } catch (Exception ex) {
    }
  }

  @Override
  public void runWithEvent(Event event) {
    // TODO Auto-generated method stub
    try {
      refresh.runWithEvent(event);
      ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
      AsteriskDiagramEditorUtil.getSafiNavigator().refresh();
    } catch (Exception ex) {
    }
  }

  @Override
  public void setAccelerator(int keycode) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setActionDefinitionId(String id) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setChecked(boolean checked) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setDescription(String text) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setDisabledImageDescriptor(ImageDescriptor newImage) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setEnabled(boolean enabled) {
    // TODO Auto-generated method stub
    this.refresh.setEnabled(true);

  }

  @Override
  public void setHelpListener(HelpListener listener) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setHoverImageDescriptor(ImageDescriptor newImage) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setId(String id) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setImageDescriptor(ImageDescriptor newImage) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setMenuCreator(IMenuCreator creator) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setText(String text) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setToolTipText(String text) {
    // TODO Auto-generated method stub

  }

}
