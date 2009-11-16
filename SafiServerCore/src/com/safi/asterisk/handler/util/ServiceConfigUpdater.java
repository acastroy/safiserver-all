package com.safi.asterisk.handler.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.collections.DefaultMapEntry;
import org.apache.log4j.Logger;

public class ServiceConfigUpdater {
  private final static Logger log = Logger.getLogger(ServiceConfigUpdater.class.getName());
  private Properties serviceConfigProperties;
  
  public void updateServiceConfig() throws IOException {
    try {
//      File file = search(new File("."), "wrapper.conf");
//      String osPathID = System.getProperty("os.path.id");
      File file = loadServerConfigProperties();
//      String patt = "^wrapper\\.java\\.classpath\\.[0-9]{1,3}\\s*=%ROOT_DIR%/lib/([a-zA-Z0-9\\.\\-_])*(\\*)?.jar$";
      String keypatt = "^wrapper\\.java\\.classpath\\.([0-9]{1,3})\\s*$";
      String pathpatt = "%ROOT_DIR%/lib/([a-zA-Z0-9\\.\\-_])*(\\*)?.jar";
      Pattern keypattern = Pattern.compile(keypatt);
      Pattern pathpattern = Pattern.compile(pathpatt);
      List<Map.Entry<Object, Object>> cpEntries = new LinkedList<Map.Entry<Object,Object>>();
      TreeMap<Integer, Map.Entry<Object, Object>> sortedMap = new TreeMap<Integer, Map.Entry<Object, Object>>();
//      final Set<String> currentLibJars = new HashSet<String>();
      for (Map.Entry<Object, Object> entry : serviceConfigProperties.entrySet()){
        String key = (String)entry.getKey();
        Matcher matcher = keypattern.matcher(key);
        if (matcher.matches()){
          Matcher pathmatcher = pathpattern.matcher((String)entry.getValue());
          if  (pathmatcher.matches()){
            String number = matcher.group(1);
            sortedMap.put(Integer.parseInt(number), new DefaultMapEntry(entry.getKey(), entry.getValue()));
          }
          else{
            cpEntries.add(new DefaultMapEntry(entry.getKey(), entry.getValue()));
          }
        }
      }
//      String fnamepatt = "%ROOT_DIR%/lib/((([a-zA-Z0-9\\.\\-_])*)_v[0-9]*)\\.jar";
      for (Map.Entry<Object, Object> entry : sortedMap.values()){
        serviceConfigProperties.remove(entry.getKey());
      }
      
      for (Map.Entry<Object, Object> entry : cpEntries){
        serviceConfigProperties.remove(entry.getKey());
      }
      
//      String currentDirectory = System.getProperty("user.dir");
      File[] libfiles = getServerJars();
      
      Map<String, List<File>> filemap = new HashMap<String, List<File>>();
      
      for (File lf : libfiles){
        String[] names = FileUtils.getJarBaseNameAndSuffix(lf.getName());
       String name = names[0];
        List<File> grp = filemap.get(name);
        if (grp == null){
          grp = new ArrayList<File>();
          filemap.put(name, grp);
        }
        grp.add(lf);
        
      }
      int i = 0;
      for (; i < cpEntries.size(); i++){
        serviceConfigProperties.put("wrapper.java.classpath."+(i+1), cpEntries.get(i).getValue());
      }
      
      for (List<File> fl : filemap.values()){
        Collections.sort(fl, new Comparator<File>(){
          @Override
          public int compare(File o1, File o2) {
            return o2.getName().compareTo(o1.getName());
          }
        });
        
        serviceConfigProperties.put("wrapper.java.classpath."+(i+1), "%ROOT_DIR%/lib/"+fl.get(0).getName());
        i++;
      }
//      props.store(new FileOutputStream(new File("wrapper_test.conf")), null);
      serviceConfigProperties.store(new FileOutputStream(file), null);
//      WrapperManager.restartAndReturn();
    } catch (Exception exe) {
      exe.printStackTrace();
      log.error("Couldn't udpate service classpath", exe);
      throw new IOException("Couldn't udpate service classpath", exe);
    }
    
  }


  private File[] getServerJars() {
    final File libDir = new File("lib");
    File[] libfiles = libDir.listFiles(new FilenameFilter(){
      @Override
      public boolean accept(File dir, String name) {
        if (dir == libDir && name.endsWith(".jar")){
          return true;
        }
        return false;
      }
    });
    return libfiles;
  }


  private File loadServerConfigProperties() throws IOException, FileNotFoundException {
    File file = new File("./deploy/libs.conf");
    serviceConfigProperties = new Properties();
    serviceConfigProperties.load(new FileInputStream(file));
    return file;
  }
  
  public boolean jarIsNewer(String newname){
    return FileUtils.jarIsNewer(newname, getServerJars());
  }
  
  
  
  static File search(File dir, String name)
      throws IOException
  {
      File[] files = dir.listFiles();
      if (files == null)
          throw new IOException("not a valid directory");
      for (int i = 0; i < files.length; ++i)
      {
          if (files[i].getName().compareToIgnoreCase(name) == 0)
          {
              return files[i];
          }
          if (files[i].isDirectory()){
              File f = search(files[i], name);
              if (f != null)
                return f; 
          }
      }
      return null;
  }

  /**
   * @param args
   * @throws IOException 
   */
  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    new ServiceConfigUpdater().updateServiceConfig();
  }


  public Properties getServiceConfigProperties() {
    if (serviceConfigProperties == null)
      try {
        loadServerConfigProperties();
      } catch (Exception e) {
        e.printStackTrace();
        log.error("Couldn't load server config props",e);
      } 
    return serviceConfigProperties;
  }

}
