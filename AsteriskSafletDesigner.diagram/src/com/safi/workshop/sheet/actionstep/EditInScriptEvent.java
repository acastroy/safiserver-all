package com.safi.workshop.sheet.actionstep;

import java.util.EventObject;

public class EditInScriptEvent extends EventObject {

	private String text;
	/**
   * 
   */
  private static final long serialVersionUID = 6488508461979834293L;

	public EditInScriptEvent(Object source, String text) {
	  super(source);
	  this.text = text;
  }

	public String getText() {
  	return text;
  }

	public void setText(String text) {
  	this.text = text;
  }


}
