package com.bigchaindb.services;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class IdGenerationService {
  private static IdGenerationService idGenerationService;

  private IdGenerationService() {
  }

  public static IdGenerationService getInstance() {
    if(idGenerationService == null) {
      idGenerationService = new IdGenerationService();
    }
    return idGenerationService;
  }

  public String getIdValue(String prefix) {
    String uuid = UUID.randomUUID().toString();
    byte[] bytes = uuid.getBytes(StandardCharsets.UTF_8);
    String base36 = new BigInteger(1, bytes).toString(36);
    return prefix + base36;
  }
}
