package com.bigchaindb.domain;

public class Doctor extends User {
  String name;
  String speciality;
  String phone;
  String license;

  public Doctor(String email, String password, String zip, String name, String speciality, String phone, String license) {

    super(email, password, zip);
    this.name = name;
    this.speciality = speciality;
    this.phone = phone;
    this.license = license;
  }

  public Doctor(String email, String password, String zip, String name, String speciality, String license) {
    super(email, password, zip);
    this.name = name;
    this.speciality = speciality;
    this.license = license;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpeciality() {
    return speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }
}
