package com.example.tradingapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Trade {

  @Id
  @Column
  private int id;

  @Column
  private long sellOrderId;

  @Column
  private long buyOrderId;

  @Column
  private long price;

  @Column
  private long quantity;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getSellOrderId() {
    return sellOrderId;
  }

  public void setSellOrderId(long sellOrderId) {
    this.sellOrderId = sellOrderId;
  }

  public long getBuyOrderId() {
    return buyOrderId;
  }

  public void setBuyOrderId(long buyOrderId) {
    this.buyOrderId = buyOrderId;
  }

  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

}
