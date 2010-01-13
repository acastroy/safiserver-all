package com.safi.workshop.view.vareditor;

import java.util.ArrayList;
import java.util.List;
import com.safi.core.saflet.SafletContext;
import com.safi.db.Variable;
import com.safi.server.plugin.SafiServerPlugin;

public class VarUtils {

  public static String getUniqueVariableName(SafletContext currentContext, String prefix) {
    if (currentContext == null)
      return prefix;
    List<Variable> vars = new ArrayList<Variable>(currentContext.getVariables());
    if (SafiServerPlugin.getDefault() != null && SafiServerPlugin.getDefault().isConnected())
      vars.addAll(SafiServerPlugin.getDefault().getGlobalVariables());
    int i = 0;
    while (true) {
      String candidateName = (++i == 1 ? prefix : (prefix + i));
      boolean collision = false;
      for (Variable v : vars) {
        if ((candidateName).equals(v.getName())) {
          collision = true;
          break;
        }
      }
      if (collision)
        continue;
      return candidateName;
    }
  }
}
