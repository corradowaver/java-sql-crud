package com.corradowaver.store.dao;

import com.corradowaver.store.table.Product;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

  List<T> getAll();

  void add(T t) throws SQLException;

  int getPrice(T t) throws SQLException;

  void changePrice(T t, int n) throws SQLException;

  List<T> filterByPrice(int from, int to) throws SQLException;

  void delete(T t) throws SQLException;
}
