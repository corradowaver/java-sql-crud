package com.corradowaver.store.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

  private static final String URL = "jdbc:mysql://localhost:3306/goods-db?useLegacyDatetimeCode=false&serverTimezone=UTC";
  private static final String USER = "root";
  private static final String PASSWORD = "root";

  public static Connection getConnection() {
    try {
      java.sql.Driver driver = new com.mysql.cj.jdbc.Driver();
      DriverManager.registerDriver(driver);
      return DriverManager.getConnection(URL, USER, PASSWORD);

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}