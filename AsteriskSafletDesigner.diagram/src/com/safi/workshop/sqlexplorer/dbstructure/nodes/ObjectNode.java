package com.safi.workshop.sqlexplorer.dbstructure.nodes;

import org.eclipse.swt.graphics.Image;

public class ObjectNode extends AbstractNode {

  public ObjectNode(String name, String type, INode parent, Image image) {
    super(parent, name, parent.getSession(), type);
    _image = image;
  }

  /**
   * This node cannot have childnodes.
   */
  @Override
  public boolean isEndNode() {
    return true;
  }

  /**
   * This node cannot have childnodes.
   */
  @Override
  public void loadChildren() {
    return;
  }

  @Override
  public String getQualifiedName() {
    return "\"" + getSchemaOrCatalogName() + "\".\"" + getName() + "\"";
  }

}
