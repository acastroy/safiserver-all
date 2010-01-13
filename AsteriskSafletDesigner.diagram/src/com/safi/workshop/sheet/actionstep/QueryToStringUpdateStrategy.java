package com.safi.workshop.sheet.actionstep;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.swt.widgets.Text;
import com.safi.core.actionstep.impl.DBQueryIdImpl;
import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.server.plugin.SafiServerPlugin;

public class QueryToStringUpdateStrategy extends EMFUpdateValueStrategy {

  Text text_dbQueryID;

  public QueryToStringUpdateStrategy(Text text) {
    // TODO Auto-generated constructor stub
    text_dbQueryID = text;
  }

  public QueryToStringUpdateStrategy(int updatePolicy) {
    super(updatePolicy);
    // TODO Auto-generated constructor stub
  }

  public QueryToStringUpdateStrategy(boolean provideDefaults, int updatePolicy) {
    super(provideDefaults, updatePolicy);
    // TODO Auto-generated constructor stub
  }

  @Override
  protected IConverter createConverter(final Object fromType, final Object toType) {

    if (fromType == String.class) {
      return new Converter(String.class, toType) {
        @Override
        public Object convert(Object fromObject) {

          return text_dbQueryID.getData();

        }

      };
    } else if (fromType == DBQueryIdImpl.class) {
      return new Converter(DBQueryIdImpl.class, toType) {
        @Override
        public Object convert(Object fromObject) {
          return ((DBQueryIdImpl) fromType).getId();

        }

      };
    }
    return null;
  }

  private Object findById(String id) {
    String[] segs = id.split("\\.");
    Object parent = null;
    parent = SafiServerPlugin.getDefault().getDriverManager().getDriver(segs[0]);
    if (parent == null || segs.length == 1)
      return parent;

    parent = ((DBDriver) parent).getConnection(segs[1]);
    if (parent == null || segs.length == 2)
      return parent;

    parent = ((DBConnection) parent).getQuery(segs[2]);
    // if (parent == null || segs.length == 3)
    return parent;

    // return ((Query) parent).getParameter(segs[3]);
  }
}
