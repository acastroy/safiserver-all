package com.safi.db.test;

import java.io.IOException;
import com.safi.db.SafiDriverManager;
import com.safi.db.manager.DBManager;
import com.safi.db.manager.DBManagerException;
import com.safi.db.manager.DBResourceException;

public class PersistenceTest {

  public void doTest() throws IOException, DBResourceException, DBManagerException {
    
     SafiDriverManager managa = DBManager.getInstance().getDriverManagerFromFile(
     "D:\\runtime-SAFIWorkshop5.product\\SafiDBResources.db");
//    SafiDriverManager managa = DBManager.getInstance().getDriverManager("SafiDBResources_test.db");
    DBManager.getInstance().saveDriverManager(managa, false);
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    PersistenceTest test = new PersistenceTest();
    try {
      test.doTest();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
