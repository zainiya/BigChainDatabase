package com.bigchaindb.domain;

import java.util.HashMap;
import java.util.Map;

public class DbNode {
  String url;
  String appId;
  String appKey;

  public DbNode(String url, String appId, String appKey) {
    this.url = url;
    this.appId = appId;
    this.appKey = appKey;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getAppKey() {
    return appKey;
  }

  public void setAppKey(String appKey) {
    this.appKey = appKey;
  }

  public Map<String, Object> getAsMap() {
    Map<String, Object> map = new HashMap<String, Object>();
    Map<String, String> headers = new HashMap<String, String>();
    headers.put("app_id", this.appId);
    headers.put("app_key", this.appKey);

    map.put("baseUrl", this.url); // http://10.0.0.1:9984
    map.put("headers", headers); //{"app_id" : "fd2b400f5bf8b375fb294a58327344b3dfeec55a" , "appKey": "0JHKPnPGwcO0x82BuTQeNxJFhRKe8AtUzcZxQNadBRk="}
    return map;
  }
}
