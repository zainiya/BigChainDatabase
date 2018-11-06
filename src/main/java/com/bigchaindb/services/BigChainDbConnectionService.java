package com.bigchaindb.services;

import com.bigchaindb.builders.BigchainDbConfigBuilder;
import com.bigchaindb.domain.DbNode;
import com.bigchaindb.model.Connection;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BigChainDbConnectionService {
  List<DbNode> bigChainDbConnections;

  public BigChainDbConnectionService() {
    bigChainDbConnections = new ArrayList<DbNode>();
  }

  void readConnectionsInfo(String filePath) throws IOException {
    String json = new String(Files.readAllBytes(Paths.get(filePath)));
    JsonParser jsonParser = new JsonParser();
    JsonElement element = jsonParser.parse(json);
    JsonObject jsonObject = element.getAsJsonObject();
    String url = jsonObject.get("url").toString().replaceAll("\"", "");
    String appId = jsonObject.get("appId").toString().replaceAll("\"", "");
    String appKey = jsonObject.get("appKey").toString().replaceAll("\"", "");
    System.out.println(new DbNode(url, appId, appKey).getAsMap().toString());
    bigChainDbConnections.add(new DbNode(url, appId, appKey));
  }

  public void connectDbNodes(List<String> filePaths) {
    filePaths.forEach(filePath -> {
      try {
        this.readConnectionsInfo(filePath);
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
    List<Connection> connections = new ArrayList<>();
    bigChainDbConnections.forEach(dbNode -> {
      connections.add(new Connection(dbNode.getAsMap()));
    });
    BigchainDbConfigBuilder
      .addConnections(connections)
      .setTimeout(10000)
      .setup();
  }

  public static void main(String[] a) {
    BigChainDbConnectionService b = new BigChainDbConnectionService();
    List<String> files = new ArrayList<String>();
    files.add("/Users/Parth/BigChainDatabase/src/main/resources/DbNodes/DbNode1.json");
    b.connectDbNodes(files);
  }
}
