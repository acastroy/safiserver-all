package com.safi.workshop.view.vareditor;

import java.util.List;
import com.safi.db.Variable;

public class VariableCategory {
  private List<Variable> variables;
  private String name;
  private List<VariableCategory> childCategories;
  private VariableCategory parent;

  public VariableCategory() {
    variables = new java.util.ArrayList<Variable>();
    childCategories = new java.util.ArrayList<VariableCategory>();
  }

  public Object[] getChildren() {
    List<Object> children = new java.util.ArrayList<Object>();
    children.addAll(variables);
    children.addAll(childCategories);
    return children.toArray();
  }

  public boolean hasChildren() {
    return !variables.isEmpty() || !childCategories.isEmpty();
  }

  @Override
  public String toString() {
    return name;
  }

  public List<Variable> getVariables() {
    return variables;
  }

  public void setVariables(List<Variable> variables) {
    this.variables = variables;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<VariableCategory> getChildCategories() {
    return childCategories;
  }

  public void setChildCategories(List<VariableCategory> childCategories) {
    this.childCategories = childCategories;
  }

  public VariableCategory getParent() {
    return parent;
  }

  public void setParent(VariableCategory parent) {
    this.parent = parent;
  }

  public void addVariable(Variable v) {
    if (variables != null && !variables.contains(v) && v != null)
      variables.add(v);
  }

  public void removeVariable(Variable v) {
    if (variables != null)
      variables.remove(v);
  }

  public void clear() {
    if (variables != null)
      variables.clear();

  }
}
