package com.bigchaindb.domain;

import com.bigchaindb.services.IdGenerationService;

public class Disease {
  String id;
  String name;
  String symptoms;
  String precautions;

  IdGenerationService idGenerationService;

  public Disease(String name, String symptoms, String precautions) {
    idGenerationService = IdGenerationService.getInstance();
    this.id = idGenerationService.getIdValue("d-");
    this.name = name;
    this.symptoms = symptoms;
    this.precautions = precautions;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSymptoms() {
    return symptoms;
  }

  public void setSymptoms(String symptoms) {
    this.symptoms = symptoms;
  }

  public String getPrecautions() {
    return precautions;
  }

  public void setPrecautions(String precautions) {
    this.precautions = precautions;
  }
}
