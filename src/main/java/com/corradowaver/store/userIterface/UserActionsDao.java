package com.corradowaver.store.userIterface;

import com.corradowaver.store.table.Product;
import com.corradowaver.store.table.TableController;
import com.corradowaver.store.table.TableDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserActionsDao {
  private Scanner sc = new Scanner(System.in);
  private TableDao table = new TableDao();
  private TableController tc = new TableController();

  public void task() {
    System.out.println("%t%t*Running default task");
    dropTable();
    createTable();
    System.out.print("Enter a number of products: ");
    int number = sc.nextInt();
    for (int i = 0; i < number; i++) {
      System.out.println("Enter title then price: ");
      add(sc.next(), sc.nextInt());
    }
  }

  public void createTable() {
    try {
      tc.createNewTable();
      System.out.println("\t\t*new table has been created*");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void dropTable() {
    try {
      tc.deleteTable();
      System.out.println("\t\t*old table has been deleted*");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void printList(List<Product> products) {
    products.forEach(product -> {
      System.out.println(" ____________________ ");
      System.out.printf("|%10s | %7d|%n", product.getTitle(), product.getCost());
    });
  }

  public void showAll() {
    try {
      List<Product> products = table.getAll();
      if (!products.isEmpty()) {
        printList(products);
      } else {
        System.out.println("\t\t!empty products list!");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void filterByPrice(int from, int to) {
    try {
      List<Product> products = table.filterByPrice(from, to);
      if (!products.isEmpty()) {
       printList(products);
      } else {
        System.out.println("\t\t!empty products list!");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void add(String title, int cost){
    try {
      Product product = new Product(title, cost);
      table.add(product);
      System.out.println("\t\t*success*");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void getPrice(String title) {
    try {
      Product product = new Product(title);
      System.out.println(table.getPrice(product));
    } catch (SQLException e) {
      System.out.println("\t\t!product not found!");
    }
  }

  public void changePrice(String title, int newPrice) {
    try {
      Product product = new Product(title);
      table.changePrice(product, newPrice);
      System.out.println("\t\t*success*");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void delete(String title) {
    try {
      Product product = new Product(title);
      table.delete(product);
      System.out.println("\t\t*success*");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
