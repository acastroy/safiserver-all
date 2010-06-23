package com.safi.workshop.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.User;

public class ServerResourcePropertiesAdapterFactory implements IAdapterFactory {

  @Override
  public Object getAdapter(Object adaptableObject, Class adapterType) {
    if (adapterType == IPropertySource.class) {
      if (adaptableObject instanceof SafiServer) {
        return new SafiServerProperties((SafiServer) adaptableObject);
      } else if (adaptableObject instanceof User) {
        return new UserProperties((User) adaptableObject);
      }
    }
    return null;
  }

  @Override
  public Class[] getAdapterList() {
    return new Class[] { IPropertySource.class };
  }
  // common serverresource props
  public final static String PROPERTY_NAME = "name";
  public final static String PROPERTY_DESCRIPTION = "description";
  public final static String PROPERTY_LAST_MODIFIED = "last modified";
  public final static String PROPERTY_LAST_UPDATED = "last updated";
  public final static String PROPERTY_CREATED_BY = "created by";
  public final static String PROPERTY_MODIFIED_BY = "modified by";

  private final static String PROPERTY_BIND_IP = "bind ip";
  private final static String PROPERTY_AGI_PORT = "FastAGI port";
  private final static String PROPERTY_MANAGEMENT_PORT = "management port";
  private final static String PROPERTY_DEBUG = "is debug";
  private final static String PROPERTY_DB_PORT = "database port";
  public class SafiServerProperties implements IPropertySource {
    SafiServer resource;

    private final Object PropertiesTable[][] = {
        { PROPERTY_NAME, new TextPropertyDescriptor(PROPERTY_NAME, PROPERTY_NAME) },
        { PROPERTY_DESCRIPTION,
            new TextPropertyDescriptor(PROPERTY_DESCRIPTION, PROPERTY_DESCRIPTION) },
        { PROPERTY_LAST_MODIFIED,
            new TextPropertyDescriptor(PROPERTY_LAST_MODIFIED, PROPERTY_LAST_MODIFIED) },
        { PROPERTY_LAST_UPDATED,
            new TextPropertyDescriptor(PROPERTY_LAST_UPDATED, PROPERTY_LAST_UPDATED) },
        { PROPERTY_CREATED_BY, new TextPropertyDescriptor(PROPERTY_CREATED_BY, PROPERTY_CREATED_BY) },
        { PROPERTY_MODIFIED_BY,
            new TextPropertyDescriptor(PROPERTY_MODIFIED_BY, PROPERTY_MODIFIED_BY) },
        { PROPERTY_BIND_IP, new TextPropertyDescriptor(PROPERTY_BIND_IP, PROPERTY_BIND_IP) },
        { PROPERTY_AGI_PORT, new TextPropertyDescriptor(PROPERTY_AGI_PORT, PROPERTY_AGI_PORT) },
        { PROPERTY_MANAGEMENT_PORT,
            new TextPropertyDescriptor(PROPERTY_MANAGEMENT_PORT, PROPERTY_MANAGEMENT_PORT) },
        { PROPERTY_DEBUG, new TextPropertyDescriptor(PROPERTY_DEBUG, PROPERTY_DEBUG) },
        { PROPERTY_DB_PORT, new TextPropertyDescriptor(PROPERTY_DB_PORT, PROPERTY_DB_PORT) } };

    public SafiServerProperties(SafiServer safiServer) {
      this.resource = safiServer;
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
      } else if (PROPERTY_CREATED_BY.equals(id)) {
        return resource.getCreatedBy() == null ? "" : resource.getCreatedBy().getName();
      } else if (PROPERTY_DESCRIPTION.equals(id)) {
        return resource.getDescription();
      } else if (PROPERTY_LAST_MODIFIED.equals(id)) {
        return resource.getLastModified() == null ? "" : resource.getLastModified();
      } else if (PROPERTY_LAST_UPDATED.equals(id)) {
        return resource.getLastUpdated() == null ? "" : resource.getLastUpdated();
      } else if (PROPERTY_MODIFIED_BY.equals(id)) {
        return resource.getModifiedBy() == null ? "" : resource.getModifiedBy().getName();
      } else if (PROPERTY_BIND_IP.equals(id)) {
        return resource.getBindIP();
      } else if (PROPERTY_AGI_PORT.equals(id)) {
        return 4575;
      } else if (PROPERTY_MANAGEMENT_PORT.equals(id)) {
        return resource.getManagementPort();
      } else if (PROPERTY_DEBUG.equals(id)) {
        return resource.isDebug();
      } else if (PROPERTY_DB_PORT.equals(id)) {
        return resource.getDbPort();
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

  
  private final static String PROPERTY_FIRST_NAME = "first name";
  private final static String PROPERTY_LAST_NAME = "last name";
  public class UserProperties implements IPropertySource {
    User resource;

    private final Object PropertiesTable[][] = {
        { PROPERTY_NAME, new TextPropertyDescriptor(PROPERTY_NAME, PROPERTY_NAME) },
        { PROPERTY_DESCRIPTION,
            new TextPropertyDescriptor(PROPERTY_DESCRIPTION, PROPERTY_DESCRIPTION) },
        { PROPERTY_LAST_MODIFIED,
            new TextPropertyDescriptor(PROPERTY_LAST_MODIFIED, PROPERTY_LAST_MODIFIED) },
        { PROPERTY_LAST_UPDATED,
            new TextPropertyDescriptor(PROPERTY_LAST_UPDATED, PROPERTY_LAST_UPDATED) },
        { PROPERTY_CREATED_BY, new TextPropertyDescriptor(PROPERTY_CREATED_BY, PROPERTY_CREATED_BY) },
        { PROPERTY_MODIFIED_BY,
            new TextPropertyDescriptor(PROPERTY_MODIFIED_BY, PROPERTY_MODIFIED_BY) },
        { PROPERTY_FIRST_NAME, new TextPropertyDescriptor(PROPERTY_FIRST_NAME, PROPERTY_FIRST_NAME) },
        { PROPERTY_LAST_NAME, new TextPropertyDescriptor(PROPERTY_LAST_NAME, PROPERTY_LAST_NAME) } };

    public UserProperties(User user) {
      this.resource = user;
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
      } else if (PROPERTY_CREATED_BY.equals(id)) {
        return resource.getCreatedBy() == null ? "" : resource.getCreatedBy().getName();
      } else if (PROPERTY_DESCRIPTION.equals(id)) {
        return resource.getDescription();
      } else if (PROPERTY_LAST_MODIFIED.equals(id)) {
        return resource.getLastModified() == null ? "" : resource.getLastModified();
      } else if (PROPERTY_LAST_UPDATED.equals(id)) {
        return resource.getLastUpdated() == null ? "" : resource.getLastUpdated();
      } else if (PROPERTY_MODIFIED_BY.equals(id)) {
        return resource.getModifiedBy() == null ? "" : resource.getModifiedBy().getName();
      } else if (PROPERTY_FIRST_NAME.equals(id)) {
        return resource.getFirstname();
      } else if (PROPERTY_LAST_NAME.equals(id)) {
        return resource.getLastname();
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
