package com.corradowaver.store.dao;

import java.sql.SQLException;

public  interface Dao<T> {

  void add(T t) throws SQLException;

  void changePrice(T t, int n) throws SQLException;

  void delete(T t) throws SQLException;
}
