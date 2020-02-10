package com.corradowaver.store;

import com.corradowaver.store.connector.Connector;
import com.corradowaver.store.table.Product;
import com.corradowaver.store.table.TableDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Connection connection = Connector.getConnection();
    TableDao table = new TableDao(connection);
    Product product = new Product(1, "kekes", 1);
    List<Product> res = null;
    try {
      res = table.filterByPrice(5000, 2000);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    System.out.println(res);

  }

}
