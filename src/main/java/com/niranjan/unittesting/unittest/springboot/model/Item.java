package com.niranjan.unittesting.unittest.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Item {

  @Id
  private int id;
  private String name;
  private int price;
  private int qnt;
  @Transient
  private int value;

  protected Item(){

  }

  public Item(int id, String name, int price, int qnt) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.qnt = qnt;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public int getQnt() {
    return qnt;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "Item{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", price=" + price +
        ", qnt=" + qnt +
        '}';
  }
}
