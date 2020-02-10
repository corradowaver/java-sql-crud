package com.corradowaver.store.table;

import com.corradowaver.store.dao.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableDao implements Dao<Product> {
  private Connection connection;

  public TableDao(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Product> getAll() throws SQLException {
      ResultSet resultSet =
              connection.createStatement().executeQuery("SELECT * FROM products");
      return makeProductsList(resultSet);
  }

  @Override
  public void add(Product product) throws SQLException {
    int prodid = product.getProdid();
    String title = product.getTitle();
    int cost = product.getCost();
    String sql = "INSERT INTO products (prodid, title, cost) VALUES (?, ?, ?)";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, prodid);
    ps.setString(2, title);
    ps.setInt(3, cost);
    ps.execute();
  }

  @Override
  public int getPrice(Product product) throws SQLException {
    String title = product.getTitle();
    String sql = "SELECT cost FROM products WHERE title = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setString(1, title);
    ResultSet resultSet = ps.executeQuery();
    resultSet.next();
    return resultSet.getInt("cost");
  }

  @Override
  public void changePrice(Product product, int newPrice) throws SQLException {
    String title = product.getTitle();
    String sql = "UPDATE products SET cost = ? WHERE title = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, newPrice);
    ps.setString(2, title);
    ps.execute();
  }

  @Override
  public List<Product> filterByPrice(int from, int to) throws SQLException {
    String sql = "SELECT * FROM products WHERE cost BETWEEN ? AND ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setInt(1, from);
    ps.setInt(2, to);
    ResultSet resultSet = ps.executeQuery();

    return makeProductsList(resultSet);
  }

  @Override
  public void delete(Product product) throws SQLException {
    String title = product.getTitle();
    String sql = "DELETE FROM products WHERE title = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setString(1, title);
    ps.execute();
  }

  private List<Product> makeProductsList(ResultSet resultSet) throws SQLException {
    List<Product> products = new ArrayList<>();

    while (resultSet.next()) {
      int id = resultSet.getInt("id");
      int prodid = resultSet.getInt("prodid");
      String title = resultSet.getString("title");
      int cost = resultSet.getInt("cost");

      Product product = new Product(id, prodid, title,cost);
      products.add(product);
    }
    return products;
  }

}
