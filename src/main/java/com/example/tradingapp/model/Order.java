package com.example.tradingapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Order {

  @Id
  @Column
  private int id;

  @Column
  private int userId;

  @Column
  private int securityId;

  @Column
  private String type;

  @Column
  private long price;

  @Column
  private long quantity;

  @Column
  private boolean fullfilled;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getSecurityId() {
    return securityId;
  }

  public void setSecurityId(int securityId) {
    this.securityId = securityId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }

  public boolean isFullfilled() {
    return fullfilled;
  }

  public void setFullfilled(boolean fullfilled) {
    this.fullfilled = fullfilled;
  }
}
