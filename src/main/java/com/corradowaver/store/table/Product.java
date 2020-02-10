package com.corradowaver.store.table;

public class Product {
  private int id;
  private int prodid;
  private String title;
  private int cost;

  public Product(int id, int prodid, String title, int cost) {
    this.id = id;
    this.prodid = prodid;
    this.title = title;
    this.cost = cost;
  }

  public Product(int prodid, String title, int cost) {
    this.prodid = prodid;
    this.title = title;
    this.cost = cost;
  }

  public int getProdid() {
    return prodid;
  }

  public void setProdid(int prodid) {
    this.prodid = prodid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }
}
