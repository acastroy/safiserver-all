package com.safi.workshop.actions;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.swt.widgets.Display;
import com.safi.core.actionstep.ActionStep;
import com.safi.db.Variable;
import com.safi.server.manager.DebugEventListener;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.mbean.ENotificationWrapper;
import com.safi.server.saflet.mbean.EObjectReference;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class DebugEventListenerImpl implements DebugEventListener {

  @Override
  public void debugEvent(final ENotificationWrapper event) {
    Display d = Display.getDefault();
    d.asyncExec(new Runnable() {

      @Override
      public void run() {
        try {

          EObjectReference notObj = (EObjectReference) event.getNotifiderID();
          String uid = notObj.getUID();
          if (notObj.isGlobalVar()) {
            Variable v = SafiServerPlugin.getDefault().getGlobalVariable(uid);
            if (v != null) {
              EStructuralFeature feature = v.eClass().getEStructuralFeature(event.getFeatureID());
              Object value = event.getNewValue();
              System.err.println("Setting feature " + feature + " of " + uid + " to " + value);
              v.eSet(feature, value);

              // switch (event.getEventType()) {
              // case Notification.SET:
              // case Notification.UNSET:
              // v.eSet(feature, value);
              // break;
              // case Notification.ADD:
              // System.err.println("dont' know how to add "+value+" to global "+uid);
              // break;
              // case Notification.REMOVE:
              // v.eSet(feature
              // command = RemoveCommand.create(editor.getEditingDomain(), object,
              // feature, value);
              // break;
              // }
            }
          } else {
            Object[] a = AsteriskDiagramEditorUtil.getEObjectByID(uid);
            if (a != null && a[0] != null) {
              EObject object = (EObject) a[0];
              EStructuralFeature feature = object.eClass().getEStructuralFeature(
                  event.getFeatureID());
              AsteriskDiagramEditor editor = (AsteriskDiagramEditor) a[1];
              Object value = event.getNewValue();
              if (value instanceof EObjectReference) {
                value = object.eResource().getEObject(((EObjectReference) value).getUID());
              }
              if (value == null && object.eGet(feature) == null) // need to ignore null to
                // null change
                return;
              System.err.println("Object "
                  + (object instanceof ActionStep ? "Actionstep " + ((ActionStep) object).getName()
                      : object) + " got feature " + feature.getName() + " set to " + value);
              Command command = null;
              switch (event.getEventType()) {
                case Notification.SET:
                case Notification.UNSET:
                  command = SetCommand.create(editor.getEditingDomain(), object, feature, value);
                  break;
                case Notification.ADD:
                  command = AddCommand.create(editor.getEditingDomain(), object, feature, value);
                  break;
                case Notification.REMOVE:
                  command = RemoveCommand.create(editor.getEditingDomain(), object, feature, value);
                  break;
              }
              // command = SetCommand.create(editor.getEditingDomain(), object, feature,
              // value);
              if (command != null)
                editor.getEditingDomain().getCommandStack().execute(command);
            }

            else {
              AsteriskDiagramEditorPlugin.getInstance().logWarn(
                  "Couldn't find object for uid " + uid);
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
          AsteriskDiagramEditorPlugin.getInstance().logError(
              "Error caught while handling debug notification " + event, e);
        }
      }

    });
    // ENotificationWrapper wrapper = (ENotificationWrapper)obj;

  }

}