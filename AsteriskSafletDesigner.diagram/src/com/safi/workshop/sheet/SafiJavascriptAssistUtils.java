package com.safi.workshop.sheet;

/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *

 *******************************************************************************/

import java.util.Date;
import java.util.HashMap;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.dltk.internal.javascript.reference.resolvers.ReferenceResolverContext;
import org.eclipse.dltk.internal.javascript.reference.resolvers.ResolverManager;
import org.eclipse.dltk.internal.javascript.typeinference.HostCollection;
import org.eclipse.dltk.internal.javascript.typeinference.NativeArrayReference;
import org.eclipse.dltk.internal.javascript.typeinference.NativeBooleanReference;
import org.eclipse.dltk.internal.javascript.typeinference.NativeNumberReference;
import org.eclipse.dltk.internal.javascript.typeinference.NativeObjectReference;
import org.eclipse.dltk.internal.javascript.typeinference.NativeStringReference;
import org.eclipse.dltk.internal.javascript.typeinference.PositionReachedException;
import org.eclipse.dltk.internal.javascript.typeinference.TypeInferencer;
import com.safi.core.saflet.SafletContext;
import com.safi.db.Variable;
import com.xored.org.mozilla.javascript.CompilerEnvirons;
import com.xored.org.mozilla.javascript.ErrorReporter;
import com.xored.org.mozilla.javascript.EvaluatorException;
import com.xored.org.mozilla.javascript.Parser;
import com.xored.org.mozilla.javascript.ScriptOrFnNode;

public class SafiJavascriptAssistUtils {

  public static ReferenceResolverContext buildContext(ISourceModule module, int position,
      String content, String fileName2, SafletContext context) {
    HashMap settings = new HashMap();
    ReferenceResolverContext createResolverContext = ResolverManager.createResolverContext(module,
        settings, false);
    createResolverContext.init();
    Parser p = new Parser(new CompilerEnvirons(), new NullReporter());

    ScriptOrFnNode parse = p.parse(content, fileName2, 0);
    TypeInferencer inf = new TypeInferencer((ModelElement) module, createResolverContext);
    try {
      inf.doInterferencing(parse, position);
    } catch (PositionReachedException ex) {
      // ex.printStackTrace();
    }
    HostCollection collection = inf.getCollection();
    // Map<Object, Object> map = inf.getFunctionMap();
    // for (Map.Entry entry : map.entrySet()) {
    // System.err.println("The func key is " + entry.getKey() + " and the ref is "
    // + entry.getValue() + " of fukcin type " + entry.getValue().getClass());
    // }
    // Map<String, IReference> map = (Map<String, IReference>) collection.getReferences();
    // for (Map.Entry<String, IReference> entry : map.entrySet()) {
    // System.err.println("The key is " + entry.getKey() + " and the ref is "
    // + entry.getValue().getName() + " of fukcin type " + entry.getValue().getClass());
    // }
    for (Variable v : context.getVariables()) {
      // switch (v.getType()) {
      // case ARRAY:
      // collection.add(v.getName(), new NativeArrayReference(v.getName()));
      // break;
      // case BOOLEAN:
      // collection.add(v.getName(), new NativeBooleanReference(v.getName()));
      // break;
      // case DATE:
      // case DATETIME:
      // collection.add(v.getName(), new NativeDateReference(v.getName()));
      // break;
      // case DECIMAL:
      // case INTEGER:
      // case TIME:
      // collection.add(v.getName(), new NativeNumberReference(v.getName()));
      // break;
      // case TEXT:
      // collection.add(v.getName(), new NativeStringReference(v.getName()));
      // break;
      // case OBJECT:
      // collection.add(v.getName(), new NativeObjectReference(v.getName(),
      // v.getDefaultValue() == null ? Object.class : v.getDefaultValue().getClass()));
      // break;
      // }
      switch (v.getType()) {
        case ARRAY:
          collection.add(v.getName(), new NativeArrayReference(v.getName()));
          break;
        case BOOLEAN:
          collection.add(v.getName(), new NativeBooleanReference(v.getName()));
          break;
        case DATE:
        case DATETIME:
        case TIME:
          collection.add(v.getName(), new NativeObjectReference(v.getName(), Date.class));
          break;
        case DECIMAL:
          collection.add(v.getName(), new NativeNumberReference(v.getName()));
          break;
        case INTEGER:
          collection.add(v.getName(), new NativeNumberReference(v.getName()));
          break;
        case TEXT:
          collection.add(v.getName(), new NativeStringReference(v.getName()));
          break;
        case OBJECT:
          collection.add(v.getName(), new NativeObjectReference(v.getName(),
              v.getDefaultValue() == null ? Object.class : v.getDefaultValue().getClass()));
          break;
      }
    }

    // collection.add("myFuckingInt", new NativeNumberReference("myFuckingInt"));
    createResolverContext.setHostCollection(collection);

    return createResolverContext;
  }

//  public static class PositionCalculator {
//
//    private boolean isMember;
//    private final String completion;
//    private final String completionPart;
//    private final String corePart;
//
//    public PositionCalculator(String conString, int pos, boolean bothSides) {
//      int position = pos;
//      if (bothSides) {
//        int lastDot = -1;
//        int k = pos;
//        int nestLevel = 0;
//        boolean needDot = false;
//        if (bothSides) {
//          int maxPos = conString.length() - 1;
//          if (pos < maxPos) {
//            while (pos < maxPos) {
//              pos++;
//              char charAt = conString.charAt(pos);
//              if (charAt == ']') {
//                nestLevel++;
//                continue;
//              }
//              if (charAt == '[') {
//                nestLevel--;
//                continue;
//              }
//              if (nestLevel > 0)
//                continue;
//              if (Character.isWhitespace(charAt)) {
//
//                pos += 1;
//                break;
//              }
//
//              if (!needDot && Character.isJavaIdentifierPart(charAt))
//                continue;
//              else {
//                pos += 1;
//                // isMember = false;
//                break;
//              }
//            }
//            position = pos - 1;
//          } else
//            position = pos + 1;
//
//        }
//        pos = k;
//        l2: while (pos > 0) {
//          pos--;
//          char charAt = conString.charAt(pos);
//          if (charAt == '\n')
//            break;
//          if (charAt == ']' || charAt == ')') {
//            nestLevel++;
//            continue;
//          }
//          if (charAt == '[' || charAt == '(') {
//            nestLevel--;
//            continue;
//          }
//          if (nestLevel > 0)
//            continue;
//          if (Character.isWhitespace(charAt)) {
//            needDot = true;
//            continue l2;
//          }
//
//          if (charAt == '.') {
//            isMember = true;
//            needDot = false;
//            if (lastDot == -1)
//              lastDot = pos + 1;
//
//            continue l2;
//          }
//          if (!needDot && Character.isJavaIdentifierPart(charAt))
//            continue l2;
//          else {
//            pos += 1;
//            // isMember = false;
//            break l2;
//          }
//        }
//        if (position > conString.length())
//          position = conString.length();
//        completion = conString.substring(pos, position).trim();
//        if (lastDot != -1) {
//          isMember = true;
//          completionPart = conString.substring(lastDot, position).trim();
//          corePart = conString.substring(pos, lastDot - 1).trim();
//        } else {
//          isMember = false;
//          completionPart = completion;
//          corePart = completion;
//        }
//      } else {
//        completion = HostCollection.parseCompletionString(conString.substring(0, pos), false);
//        int lastDot = completion.lastIndexOf('.');
//        if (lastDot != -1) {
//          isMember = true;
//          completionPart = completion.substring(lastDot + 1);
//          corePart = completion.substring(0, lastDot);
//        } else {
//          isMember = false;
//          completionPart = completion;
//          corePart = completion;
//        }
//      }
//    }
//
//    public String getCompletion() {
//      return completion;
//    }
//
//    public String getCompletionPart() {
//      return completionPart;
//    }
//
//    public String getCorePart() {
//      return corePart;
//    }
//
//    public boolean isMember() {
//      return isMember;
//    }
//  }

  final static class NullReporter implements ErrorReporter {
    public void error(String arg0, String arg1, int arg2, String arg3, int arg4) {

    }

    public EvaluatorException runtimeError(String arg0, String arg1, int arg2, String arg3, int arg4) {
      return null;
    }

    public void warning(String arg0, String arg1, int arg2, String arg3, int arg4) {

    }
  }

}
