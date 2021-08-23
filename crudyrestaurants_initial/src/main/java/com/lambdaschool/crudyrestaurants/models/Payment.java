package com.lambdaschool.crudyrestaurants.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long paymentid;

  @Column(nullable = false, unique = true)
  private String type;

  @ManyToMany(mappedBy = "payments")
  private Set<Restaurant> restaurants = new HashSet<>();

  public Payment(){
  }

  public Payment(String type) {
    this.type = type;
  }

  public long getPaymentid(){
    return paymentid;
  }

  public void setPaymentid(long paymentid) {
    this.paymentid = paymentid;
  }

  public String getType(){
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Set<Restaurant> getRestaurants(){
    return restaurants;
  }

  public void setRestaurants(Set<Restaurant> restaurants) {
    this.restaurants = restaurants;
  }
}
