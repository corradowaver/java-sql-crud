package com.corradowaver.store.table;

import java.sql.Connection;
import java.sql.SQLException;

public class TableController {

  private Connection connection;

  public TableController(Connection connection) {
    this.connection = connection;
  }

  public void createNewTable() throws SQLException {
    final String CREATE_TABLE_SQL="CREATE TABLE IF NOT EXISTS products ("
            + "id INT NOT NULL UNIQUE AUTO_INCREMENT,"
            + "prodid INT not NULL,"
            + "title VARCHAR(255) UNIQUE ,"
            + "cost INT NOT NULL,"
            + "PRIMARY KEY (id))";
    connection.createStatement().executeUpdate(CREATE_TABLE_SQL);
  }

  public void deleteTable() throws SQLException {
    final String DROP_TABLE_SQL="DROP TABLE IF EXISTS products";
    connection.createStatement().executeUpdate(DROP_TABLE_SQL);
  }
}
