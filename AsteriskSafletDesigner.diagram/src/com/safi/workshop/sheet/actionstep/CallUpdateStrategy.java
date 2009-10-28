package com.safi.workshop.sheet.actionstep;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;

import com.safi.asterisk.Call;

public class CallUpdateStrategy extends EMFUpdateValueStrategy {

  private List<Call> calls;

  public CallUpdateStrategy(List<Call> calls2) {
    this.calls = calls2;
  }

  public CallUpdateStrategy(int updatePolicy) {
    super(updatePolicy);
    // TODO Auto-generated constructor stub
  }

  public CallUpdateStrategy(boolean provideDefaults, int updatePolicy) {
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
          if (fromObject instanceof Call)
            return ((Call) fromObject).getName();
          for (Call call : calls) {
            if (StringUtils.equals(call.getName(), (String) fromObject)) {
              return call;
            }
          }
          return null;
        }

      };
    }

    return super.createConverter(fromType, toType);
  }

  public List<Call> getCalls() {
    return calls;
  }

  public void setCalls(List<Call> calls) {
    this.calls = calls;
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
