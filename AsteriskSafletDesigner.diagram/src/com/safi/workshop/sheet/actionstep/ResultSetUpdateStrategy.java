package com.safi.workshop.sheet.actionstep;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import com.safi.core.actionstep.DBResultSetId;

public class ResultSetUpdateStrategy extends EMFUpdateValueStrategy {

  private List<DBResultSetId> resultSets;

  public ResultSetUpdateStrategy(List<DBResultSetId> resultSets) {
    this.resultSets = resultSets;
  }

  public ResultSetUpdateStrategy(int updatePolicy) {
    super(updatePolicy);
    // TODO Auto-generated constructor stub
  }

  public ResultSetUpdateStrategy(boolean provideDefaults, int updatePolicy) {
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
          if (fromObject instanceof DBResultSetId)
            return ((DBResultSetId) fromObject).getName();
          for (DBResultSetId rs : resultSets) {
            if (StringUtils.equals(rs.getName(), (String) fromObject)) {
              return rs;
            }
          }
          return null;
        }

      };
    }

    return super.createConverter(fromType, toType);
  }

  public List<DBResultSetId> getResultSets() {
    return resultSets;
  }

  public void setResultSets(List<DBResultSetId> resultSets) {
    this.resultSets = resultSets;
  }

}
