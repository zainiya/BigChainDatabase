package com.bigchaindb.domain;

import com.bigchaindb.services.IdGenerationService;

import java.util.Date;

public class User {
  String id;
  String email;
  String password;
  String zip;
  String dateCreated;

  IdGenerationService idGenerationService;

  public User(String email, String password, String zip) {
    idGenerationService = IdGenerationService.getInstance();
    this.id = idGenerationService.getIdValue("u-");

    this.email = email;
    this.password = password;
    this.zip = zip;
    this.dateCreated = new Date().toString();
  }

  public String getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }
}
