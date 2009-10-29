package com.safi.asterisk.handler.tests;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.safi.asterisk.handler.SafletEngine;
import com.safi.db.manager.DBManager;
import com.safi.db.manager.DBManagerException;
import com.safi.db.server.config.SafletProject;

public class DBManagerTests {

  static void doTest() throws DBManagerException{
    List<SafletProject> pl =  DBManager.getInstance().getProjects();
    for (SafletProject p : pl){
      for (com.safi.db.server.config.Saflet s : p.getSaflets()){
        String code = DBManager.getInstance().getSafletCode(s.getId());
      }
    }
  }
  /**
   * @param args
   */
  public static void main(String[] args) throws Exception{
    ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
    SafletEngine engine = (SafletEngine) context.getBean("handlerEngine");
    SafletEngine.setInstance(engine);
      engine.setApplicationContext(context);
      engine.init();
      doTest();
   
  }

}
