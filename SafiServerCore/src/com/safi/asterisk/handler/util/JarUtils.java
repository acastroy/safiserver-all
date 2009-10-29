package com.safi.asterisk.handler.util;


import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.eclipse.emf.ecore.EPackage;

import com.safi.asterisk.handler.SafletEngine;
import com.safi.asterisk.handler.classloader.JarClassLoader;

public class JarUtils {

  protected static final Set<EPackage> packageSet = new HashSet<EPackage>();
  
  public static void loadJar(File file) throws Exception {
    String filePath = file.getAbsolutePath();
    filePath = "jar:file://" + filePath + "!/";
    // URL url = new File(filePath).toURI().toURL();
    // URL url = new URL("file:/" + file.getAbsolutePath());
    URL url = file.toURI().toURL();
    JarClassLoader cl = new JarClassLoader(new URL[] { url }, ClassLoader.getSystemClassLoader());
    JarFile jf = new JarFile(file);
    for (Enumeration<JarEntry> enm = jf.entries(); enm.hasMoreElements();) {
      JarEntry entry = enm.nextElement();

      String entryName = entry.getName();
      if (entryName.toLowerCase().endsWith(".class")) {
        int index = entryName.indexOf("class");
        String classname = entryName.substring(0, index - 1).replace('/', '.');
        try {
          Class clz = cl.loadClass(classname, true);
          if (EPackage.class.isAssignableFrom(clz)) {
            Field f = clz.getField("eINSTANCE");
            Object obj = f.get(null);

            // EObject obj = (EObject)clz.newInstance();
            // EPackage pkg = obj.eClass().getEPackage();
            packageSet.add((EPackage) obj);

          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    jf.close();
    // Thread.currentThread().setContextClassLoader(cl);

  }

  public static void loadJars(File[] files) throws Exception {
    JarClassLoader cl = null;
    URL[] urls = new URL[files.length];
    for (int i = 0; i < files.length; i++) {
      File file = files[i];
      String filePath = file.getAbsolutePath();
      filePath = "jar:file://" + filePath + "!/";
      // URL url = new File(filePath).toURI().toURL();
      // String urlString = "file:/" + file.getAbsolutePath();
      if (SafletEngine.debuggerLog.isDebugEnabled()) {
        SafletEngine.debuggerLog.debug("Loading actionpack from " + file);
      }
      URL url = file.toURI().toURL();
      urls[i] = url;
    }
    cl = new JarClassLoader(urls, ClassLoader.getSystemClassLoader());
    for (File file : files) {
      JarFile jf = new JarFile(file);
      for (Enumeration<JarEntry> enm = jf.entries(); enm.hasMoreElements();) {
        JarEntry entry = enm.nextElement();

        String entryName = entry.getName();
        if (entryName.toLowerCase().endsWith(".class")) {
          int index = entryName.indexOf("class");
          String classname = entryName.substring(0, index - 1).replace('/', '.');
          try {
            Class clz = cl.loadClass(classname, true);
            if (EPackage.class.isAssignableFrom(clz)) {
              Field f = clz.getField("eINSTANCE");
              Object obj = f.get(null);

              // EObject obj = (EObject)clz.newInstance();
              // EPackage pkg = obj.eClass().getEPackage();
              packageSet.add((EPackage) obj);

            }
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
      jf.close();
    }
    // Thread.currentThread().setContextClassLoader(cl);

  }
}
