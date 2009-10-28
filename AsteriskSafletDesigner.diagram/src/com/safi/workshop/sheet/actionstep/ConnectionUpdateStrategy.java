package com.safi.workshop.sheet.actionstep;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;

import com.safi.core.actionstep.DBConnectionId;

public class ConnectionUpdateStrategy extends EMFUpdateValueStrategy {

  private List<DBConnectionId> connections;

  public ConnectionUpdateStrategy(List<DBConnectionId> calls2) {
    this.connections = calls2;
  }

  public ConnectionUpdateStrategy(int updatePolicy) {
    super(updatePolicy);
    // TODO Auto-generated constructor stub
  }

  public ConnectionUpdateStrategy(boolean provideDefaults, int updatePolicy) {
    super(provideDefaults, updatePolicy);
    // TODO Auto-generated constructor stub
  }

  @Override
  public Object convert(Object value) {
    // TODO Auto-generated method stub
    return super.convert(value);
  }

  @Override
  protected IConverter createConverter(Object fromType, Object toType) {
    if (fromType == String.class) {
      return new Converter(fromType, toType) {

        @Override
        public Object convert(Object fromObject) {
          if (fromObject instanceof DBConnectionId)
            return ((DBConnectionId) fromObject).getId();
          for (DBConnectionId call : connections) {
            if (StringUtils.equals(call.getId(), (String) fromObject)) {
              return call;
            }
          }
          return null;
        }

      };
    }

    return super.createConverter(fromType, toType);
  }

  public List<DBConnectionId> getCalls() {
    return connections;
  }

  public void setCalls(List<DBConnectionId> calls) {
    this.connections = calls;
  }

  // protected IStatus doSet(IObservableValue observableValue, Object value) {
  // if (observableValue instanceof EditingDomainEObjectObservableValue){
  // EditingDomainEObjectObservableValue val =
  // (EditingDomainEObjectObservableValue)observableValue;
  // Command command = SetCommand.create(val.getObserved()., eObject, eStructuralFeature,
  // value);
  // domain.getCommandStack().execute(command);
  // try {
  // observableValue.setValue(value);
  // } catch (Exception ex) {
  // return ValidationStatus.error(BindingMessages
  // .getString(BindingMessages.VALUEBINDING_ERROR_WHILE_SETTING_VALUE),
  // ex);
  // }
  // return Status.OK_STATUS;
  // }
  // else
  // super.doSet(observableValue, value);
  // }
}
