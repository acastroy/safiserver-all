package com.safi.workshop.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import com.safi.db.Query;
import com.safi.db.QueryParameter;

public class DBResourcePropertiesAdapterFactory implements IAdapterFactory {

  private final static String PROPERTY_NAME = "name";
  private final static String PROPERTY_LAST_MODIFIED = "last modified";
  private final static String PROPERTY_LAST_UPDATED = "last updated";

  private final static String PROPERTY_SQL_TXT = "SQL";
  private final static String PROPERTY_QUERY_TYPE = "query type";
  private final static String PROPERTY_CATALOG = "catalog";
  
  private final static String PROPERTY_PARAM_TYPE = "data type";

  @Override
  public Object getAdapter(Object adaptableObject, Class adapterType) {
    if (adapterType == IPropertySource.class) {
      if (adaptableObject instanceof Query) {
        return new QueryProperties((Query) adaptableObject);
      } else if (adaptableObject instanceof QueryParameter) {
        return new QueryParameterProperties((QueryParameter) adaptableObject);
      }
    }
    return null;
  }

  @Override
  public Class[] getAdapterList() {
    return new Class[] { IPropertySource.class };
  }

  public class QueryProperties implements IPropertySource {
    Query resource;

    private final Object PropertiesTable[][] = {
        { PROPERTY_NAME, new TextPropertyDescriptor(PROPERTY_NAME, PROPERTY_NAME) },
        { PROPERTY_SQL_TXT, new TextPropertyDescriptor(PROPERTY_SQL_TXT, PROPERTY_SQL_TXT) },
        { PROPERTY_QUERY_TYPE, new TextPropertyDescriptor(PROPERTY_QUERY_TYPE, PROPERTY_QUERY_TYPE) },
        { PROPERTY_CATALOG, new TextPropertyDescriptor(PROPERTY_CATALOG, PROPERTY_CATALOG) },
        { PROPERTY_LAST_MODIFIED,
            new TextPropertyDescriptor(PROPERTY_LAST_MODIFIED, PROPERTY_LAST_MODIFIED) },
        { PROPERTY_LAST_UPDATED,
            new TextPropertyDescriptor(PROPERTY_LAST_UPDATED, PROPERTY_LAST_UPDATED) } };

    public QueryProperties(Query query) {
      this.resource = query;
    }

    @Override
    public Object getEditableValue() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public IPropertyDescriptor[] getPropertyDescriptors() {
      // Create the property vector.
      IPropertyDescriptor[] propertyDescriptors = new IPropertyDescriptor[PropertiesTable.length];

      for (int i = 0; i < PropertiesTable.length; i++) {
        // Add each property supported.
        PropertyDescriptor descriptor;
        descriptor = (PropertyDescriptor) PropertiesTable[i][1];
        propertyDescriptors[i] = descriptor;
        descriptor.setCategory("Resource Info");
      }
      // Return it.
      return propertyDescriptors;

    }

    @Override
    public Object getPropertyValue(Object id) {
      if (PROPERTY_NAME.equals(id)) {
        return resource.getName();
      } else if (PROPERTY_SQL_TXT.equals(id)) {
        return resource.getQuerySql() == null ? "" : resource.getQuerySql();
      } else if (PROPERTY_QUERY_TYPE.equals(id)) {
        return resource.getQueryType() == null ? "" : resource.getQueryType().getName();
      } else if (PROPERTY_LAST_MODIFIED.equals(id)) {
        return resource.getLastModified() == null ? "" : resource.getLastModified();
      } else if (PROPERTY_LAST_UPDATED.equals(id)) {
        return resource.getLastUpdated() == null ? "" : resource.getLastUpdated();
      } else if (PROPERTY_CATALOG.equals(id)) {
        return resource.getCatalog() == null ? "" : resource.getCatalog();
      } else
        return null;
    }

    @Override
    public boolean isPropertySet(Object id) {
      return false;
    }

    @Override
    public void resetPropertyValue(Object id) {
    }

    @Override
    public void setPropertyValue(Object id, Object value) {
    }
  }

  public class QueryParameterProperties implements IPropertySource {
    QueryParameter resource;

    private final Object PropertiesTable[][] = {
        { PROPERTY_NAME, new TextPropertyDescriptor(PROPERTY_NAME, PROPERTY_NAME) },
        { PROPERTY_PARAM_TYPE, new TextPropertyDescriptor(PROPERTY_PARAM_TYPE, PROPERTY_PARAM_TYPE) },
        { PROPERTY_LAST_MODIFIED,
            new TextPropertyDescriptor(PROPERTY_LAST_MODIFIED, PROPERTY_LAST_MODIFIED) },
        { PROPERTY_LAST_UPDATED,
            new TextPropertyDescriptor(PROPERTY_LAST_UPDATED, PROPERTY_LAST_UPDATED) } };

    public QueryParameterProperties(QueryParameter query) {
      this.resource = query;
    }

    @Override
    public Object getEditableValue() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public IPropertyDescriptor[] getPropertyDescriptors() {
      // Create the property vector.
      IPropertyDescriptor[] propertyDescriptors = new IPropertyDescriptor[PropertiesTable.length];

      for (int i = 0; i < PropertiesTable.length; i++) {
        // Add each property supported.
        PropertyDescriptor descriptor;
        descriptor = (PropertyDescriptor) PropertiesTable[i][1];
        propertyDescriptors[i] = descriptor;
        descriptor.setCategory("Resource Info");
      }
      // Return it.
      return propertyDescriptors;

    }

    @Override
    public Object getPropertyValue(Object id) {
      if (PROPERTY_NAME.equals(id)) {
        return resource.getName();
      } else if (PROPERTY_PARAM_TYPE.equals(id)) {
        return resource.getDataType() == null ? "" : resource.getDataType().getName();
      } else if (PROPERTY_LAST_MODIFIED.equals(id)) {
        return resource.getLastModified() == null ? "" : resource.getLastModified();
      } else if (PROPERTY_LAST_UPDATED.equals(id)) {
        return resource.getLastUpdated() == null ? "" : resource.getLastUpdated();
      } else
        return null;
    }

    @Override
    public boolean isPropertySet(Object id) {
      return false;
    }

    @Override
    public void resetPropertyValue(Object id) {
    }

    @Override
    public void setPropertyValue(Object id, Object value) {
    }
  }
}
