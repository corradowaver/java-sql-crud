package com.corradowaver.store.userIterface;

import com.corradowaver.store.dao.Dao;
import com.corradowaver.store.table.Product;
import com.corradowaver.store.table.TableDao;
import com.mysql.cj.result.SqlDateValueFactory;

import java.sql.SQLException;
import java.util.List;

public class UserActionsDao implements Dao<Product> {

  TableDao table = new TableDao();

  public void showAll() {
    try {
      List<Product> products = table.getAll();
      products.forEach(product -> {
        System.out.println("-----------");
        System.out.println(product.getId() + " "
                + product.getProdid() + " "
                + product.getTitle() + " "
                + product.getCost());
      });
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void filterByPrice(int from, int to) {
    try {
      List<Product> products = table.filterByPrice(from, to);
      products.forEach(product -> {
        System.out.println("-----------");
        System.out.println(product.getId() + " "
                + product.getProdid() + " "
                + product.getTitle() + " "
                + product.getCost());
      });
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void add(Product product){
    try {
      table.add(product);
      System.out.println("success");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void getPrice(Product product) {
    try {
      System.out.println(table.getPrice(product));
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void changePrice(Product product, int newPrice) {
    try {
      table.changePrice(product, newPrice);
      System.out.println("success");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(Product product) {
    try {
      table.delete(product);
      System.out.println("success");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
