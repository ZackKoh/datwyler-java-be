package com.zackk.datwyler.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private Integer credit;

  // Attempting getting the loans here
  @OneToMany(targetEntity = Loan.class)
  private List<Loan> loans;

  public Customer(String name, Integer credit) {
    this.name = name;
    this.credit = credit;
  }

  public Customer(Long id, String name, Integer credit) {
    this.id = id;
    this.name = name;
    this.credit = credit;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getCredit() {
    return credit;
  }

  public void setCredit(Integer credit) {
    this.credit = credit;
  }

  public List<Loan> getList() {
    return loans;
  }

  public void setList(List<Loan> loans) {
    this.loans = loans;
  }
}
