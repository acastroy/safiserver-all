package com.safi.workshop.sheet.actionstep;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.AbstractVetoableValue;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.safi.core.actionstep.DBConnectionId;

/**
 * {@link IObservable} implementation that wraps a {@link Text} widget. The time at which
 * listeners should be notified about changes to the text is specified on construction.
 * 
 * <dl>
 * <dt>Events:</dt>
 * <dd>If the update event type (specified on construction) is <code>SWT.Modify</code> a
 * value change event will be fired on every key stroke. If the update event type is
 * <code>SWT.FocusOut</code> a value change event will be fired on focus out. When in
 * either mode if the user is entering text and presses [Escape] the value will be
 * reverted back to the last value set using doSetValue(). Regardless of the update event
 * type a value changing event will fire on verify to enable vetoing of changes.</dd>
 * </dl>
 * 
 * @since 1.0
 */
public class DBConnectionWidgetObservableValue extends AbstractVetoableValue {

  /**
   * {@link Text} widget that this is being observed.
   */
  private final NewDBConnectionWidget dvew;

  /**
   * Flag to track when the model is updating the widget. When <code>true</code> the
   * handlers for the SWT events should not process the event as this would cause an
   * infinite loop.
   */
  private boolean updating = false;

  /**
   * SWT event that on firing this observable will fire change events to its listeners.
   */
  private final int updateEventType;

  /**
   * Valid types for the {@link #updateEventType}.
   */
  private static final int[] validUpdateEventTypes = new int[] { SWT.Modify, SWT.None };

  /**
   * Previous value of the Text.
   */
  private DBConnectionId oldValue;

  private Listener updateListener = new Listener() {
    public void handleEvent(Event event) {
      if (!updating) {
        DBConnectionId newValue = dvew.getConnectionID();
        // oldValue = null;//what should we do here?
        if ((newValue == null && oldValue != null) || (newValue == null && newValue != oldValue)
            || (newValue != null && !newValue.equals(oldValue))) {
          if (newValue == oldValue) {
            // fireValueChange(Diffs.createValueDiff(null, newValue));
          } else
            fireValueChange(Diffs.createValueDiff(oldValue, newValue));
          oldValue = newValue;
        }
      }
    }
  };

  private VerifyListener verifyListener;

  /**
   * Constructs a new instance bound to the given <code>text</code> widget and configured
   * to fire change events to its listeners at the time of the
   * <code>updateEventType</code>.
   * 
   * @param text
   * @param updateEventType
   *          SWT event constant as to what SWT event to update the model in response to.
   *          Appropriate values are: <code>SWT.Modify</code>, <code>SWT.FocusOut</code>,
   *          <code>SWT.None</code>.
   * @throws IllegalArgumentException
   *           if <code>updateEventType</code> is an incorrect type.
   */
  public DBConnectionWidgetObservableValue(final NewDBConnectionWidget text, int updateEventType) {
    this(SWTObservables.getRealm(text.getDisplay()), text, updateEventType);
  }

  /**
   * Constructs a new instance.
   * 
   * @param realm
   *          can not be <code>null</code>
   * @param dvew
   * @param updateEventType
   */
  public DBConnectionWidgetObservableValue(final Realm realm, NewDBConnectionWidget dvew,
      int updateEventType) {
    super(realm);

    boolean eventValid = false;
    for (int i = 0; !eventValid && i < validUpdateEventTypes.length; i++) {
      eventValid = (updateEventType == validUpdateEventTypes[i]);
    }
    if (!eventValid) {
      throw new IllegalArgumentException(
          "UpdateEventType [" + updateEventType + "] is not supported."); //$NON-NLS-1$//$NON-NLS-2$
    }
    this.dvew = dvew;
    this.updateEventType = updateEventType;
    if (updateEventType != SWT.None) {
      dvew.addListener(updateEventType, updateListener);
    }

    if (dvew.getConnectionID() != null)
      oldValue = (DBConnectionId) EcoreUtil.copy(dvew.getConnectionID());
    else
      oldValue = null;

  }

  /**
   * Sets the bound {@link Text Text's} text to the passed <code>value</code>.
   * 
   * @param value
   *          new value, String expected
   * @see org.eclipse.core.databinding.observable.value.AbstractVetoableValue#doSetApprovedValue(java.lang.Object)
   * @throws ClassCastException
   *           if the value is anything other than a String
   */
  @Override
  protected void doSetApprovedValue(final Object value) {
    try {
      updating = true;
      DBConnectionId value2 = dvew.getConnectionID();
      dvew.setConnectionID((DBConnectionId) value);
      oldValue = value2;
    } finally {
      updating = false;
    }
  }

  /**
   * Returns the current value of the {@link Text}.
   * 
   * @see org.eclipse.core.databinding.observable.value.AbstractVetoableValue#doGetValue()
   */
  @Override
  public Object doGetValue() {
    return dvew.getConnectionID();
  }

  /**
   * Returns the type of the value from {@link #doGetValue()}, i.e. String.class
   * 
   * @see org.eclipse.core.databinding.observable.value.IObservableValue#getValueType()
   */
  public Object getValueType() {
    return String.class;
  }

  @Override
  public void dispose() {
    if (!dvew.isDisposed()) {
      if (updateEventType != SWT.None) {
        dvew.removeListener(updateEventType, updateListener);
      }
    }
    super.dispose();
  }
}
