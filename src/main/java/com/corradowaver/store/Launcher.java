package com.corradowaver.store;

import com.corradowaver.store.connector.Connector;
import com.corradowaver.store.userIterface.Menu;
import java.sql.SQLException;

public class Launcher {

  public static void main(String[] args) {

    try {
      Menu.showMenu();
    } finally {
      try {
        Connector.getConnection().close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

}
