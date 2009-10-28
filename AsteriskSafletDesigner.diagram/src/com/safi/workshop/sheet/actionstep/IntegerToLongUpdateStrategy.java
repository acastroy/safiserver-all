package com.safi.workshop.sheet.actionstep;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;

public class IntegerToLongUpdateStrategy extends EMFUpdateValueStrategy {

  public IntegerToLongUpdateStrategy() {
    // TODO Auto-generated constructor stub
  }

  public IntegerToLongUpdateStrategy(int updatePolicy) {
    super(updatePolicy);
    // TODO Auto-generated constructor stub
  }

  public IntegerToLongUpdateStrategy(boolean provideDefaults, int updatePolicy) {
    super(provideDefaults, updatePolicy);
    // TODO Auto-generated constructor stub
  }

  @Override
  protected IConverter createConverter(Object fromType, final Object toType) {
    if (fromType == Integer.class || fromType == int.class) {
      return new Converter(Integer.class, toType) {
        @Override
        public Object convert(Object fromObject) {
          if (fromObject instanceof Integer) {
            return new Long(((Integer) fromObject).longValue());
          } else if (fromObject instanceof Long) {
            return ((Long) fromObject).intValue();
          } else if (fromObject instanceof String)
            try {
              return Long.parseLong((String) fromObject);
            } catch (NumberFormatException e) {
              e.printStackTrace();
            }
          return (long) 0;

        }

      };
    }
    return super.createConverter(fromType, toType);
  }
}
