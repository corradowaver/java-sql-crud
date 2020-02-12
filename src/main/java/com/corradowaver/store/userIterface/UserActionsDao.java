package com.corradowaver.store.userIterface;

import com.corradowaver.store.table.Product;
import com.corradowaver.store.table.TableController;
import com.corradowaver.store.table.TableDao;

import java.sql.SQLException;
import java.util.List;

public class UserActionsDao {

  TableDao table = new TableDao();
  TableController tc = new TableController();

  public void createTable() {
    try {
      tc.createNewTable();
      System.out.println("*success*");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void dropTable() {
    try {
      tc.deleteTable();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void showAll() {
    try {
      List<Product> products = table.getAll();
      if (!products.isEmpty()) {
        products.forEach(product -> {
          System.out.println("-----------");
          System.out.println(product.getTitle() + " "
                  + product.getCost());
        });
      } else {
        System.out.println("!empty products list!");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void filterByPrice(int from, int to) {
    try {
      List<Product> products = table.filterByPrice(from, to);
      if (!products.isEmpty()) {
        products.forEach(product -> {
          System.out.println("-----------");
          System.out.println(product.getTitle() + " "
                  + product.getCost());
        });
      } else {
        System.out.println("!products not found!");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void add(String title, int cost){
    try {
      Product product = new Product(title, cost);
      table.add(product);
      System.out.println("*success*");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void getPrice(String title) {
    try {
      Product product = new Product(title);
      System.out.println(table.getPrice(product));
    } catch (SQLException e) {
      System.out.println("!product not found!");
    }
  }

  public void changePrice(String title, int newPrice) {
    try {
      Product product = new Product(title);
      table.changePrice(product, newPrice);
      System.out.println("*success*");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void delete(String title) {
    try {
      Product product = new Product(title);
      table.delete(product);
      System.out.println("*success*");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
