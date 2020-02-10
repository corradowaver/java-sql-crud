package com.corradowaver.store.userIterface;

import com.corradowaver.store.table.Product;

import java.util.Scanner;

public abstract class Menu {
  private static Scanner sc = new Scanner(System.in);
  private static UserActionsDao ua = new UserActionsDao();


  public static void showMenu() {
    System.out.println("What do you want to do?");
    String cmd = sc.next();
    switch (cmd) {
      case "/drop_db":
        break;
      case "/fill_db":
        break;
      case "/add":
        ua.add(fillProduct());
        break;
      case "/delete":
        ua.delete(fillProduct());
        break;
      case "/show_all":
        ua.showAll();
        break;
      case "/price":
        ua.getPrice(fillProduct());
        break;
      case "/change_price":
        ua.changePrice(fillProduct(), sc.nextInt());
        break;
      case "/filter_by_price":
        ua.filterByPrice(sc.nextInt(), sc.nextInt());
        break;

    }

  }

  private static Product fillProduct() {
    System.out.println("Enter product id");
    int prodId = sc.nextInt();
    System.out.println("Enter product title");
    String title = sc.next();
    System.out.println("Enter product price");
    int price = sc.nextInt();
    return new Product(prodId, title, price);
  }
}
