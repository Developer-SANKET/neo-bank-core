package com.neobank.core.entity;
import jakarta.persistence.*;
@Entity
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String customerName;
  private Double balance;
  private Double dailyLimit = 50000.0;
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getCustomerName() { return customerName; }
  public void setCustomerName(String customerName) { this.customerName = customerName; }
  public Double getBalance() { return balance; }
  public void setBalance(Double balance) { this.balance = balance; }
  public Double getDailyLimit() { return dailyLimit; }
  public void setDailyLimit(Double dailyLimit) { this.dailyLimit = dailyLimit; }
}
