package com.corradowaver.store.userIterface;

import com.corradowaver.store.table.Product;

import java.util.Scanner;

public abstract class Menu {
  private static Scanner sc = new Scanner(System.in);
  private static UserActionsDao ua = new UserActionsDao();


  public static void showMenu() {
    System.out.println("Welcome to the store");
    while (true) {
      System.out.print("Enter command: ");
      String cmd = sc.next();
      switch (cmd) {
        case "/drop_db":
          ua.dropTable();
          break;
        case "/create_db":
          ua.createTable();
          break;
        case "/add":
          ua.add(sc.next(), sc.nextInt());
          break;
        case "/delete":
          ua.delete(sc.next());
          break;
        case "/show_all":
          ua.showAll();
          break;
        case "/price":
          ua.getPrice(sc.next());
          break;
        case "/change_price":
          ua.changePrice(sc.next(), sc.nextInt());
          break;
        case "/filter_by_price":
          ua.filterByPrice(sc.nextInt(), sc.nextInt());
          break;
        case "/quit":
          System.out.println("Bye");
          break;
        default:
          break;
      }
    }

  }
}
