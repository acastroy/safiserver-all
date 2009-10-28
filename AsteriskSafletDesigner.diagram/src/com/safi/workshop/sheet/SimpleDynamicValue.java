package com.safi.workshop.sheet;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;

public class SimpleDynamicValue extends EObjectImpl implements DynamicValue {
  private String text = "";
  private DynamicValueType type = DynamicValueType.LITERAL_TEXT;
  private EObject payload;
  protected BasicEMap<String, String> data;

  @Override
  public String getText() {
    return text;
  }

  @Override
  public DynamicValueType getType() {
    // TODO Auto-generated method stub
    return type;
  }

  @Override
  public void setText(String value) {
    this.text = value;

  }

  @Override
  public void setType(DynamicValueType value) {
    this.type = value;

  }

  public EObject getPayload() {
    return payload;
  }

  public void setPayload(EObject payload) {
    this.payload = payload;
  }

  @Override
  public BasicEMap<String, String> getData() {
    if (data == null)
      data = new BasicEMap<String, String>();

    return data;
  }

}
