package com.scalesec.vulnado;

// Removed unused import
// import org.apache.catalina.Server;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Logger; // Added for logging

public class Comment {
  // Made fields non-public and added accessors
  private String id, username, body;
  private Timestamp createdOn; // Renamed to match the regular expression '^[a-z][a-zA-Z0-9]*$'

  public Comment(String id, String username, String body, Timestamp createdOn) {
    this.id = id;
    this.username = username;
    this.body = body;
    this.createdOn = createdOn;
  }

  // Accessors
  public String getId() { return id; }
  public String getUsername() { return username; }
  public String getBody() { return body; }
  public Timestamp getCreatedOn() { return createdOn; }

  public static Comment create(String username, String body){
    long time = new Date().getTime();
    Timestamp timestamp = new Timestamp(time);
    Comment comment = new Comment(UUID.randomUUID().toString(), username, body, timestamp);
    try {
      if (comment.commit()) {
        return comment;
      } else {
        throw new BadRequest("Unable to save comment");
      }
    } catch (Exception e) {
      throw new ServerError(e.getMessage());
    }
  }

  public static List<Comment> fetchAll() { // Renamed to match the regular expression '^[a-z][a-zA-Z0-9]*$'
    Statement stmt = null;
    List<Comment> comments = new ArrayList<>();
    try {
      Connection cxn = Postgres.connection();
      stmt = cxn.createStatement();

      String query = "select * from comments;";
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        String id = rs.getString("id");
        String username = rs.getString("username");
        String body = rs.getString("body");
        Timestamp createdOn = rs.getTimestamp("created_on"); // Renamed to match the regular expression '^[a-z][a-zA-Z0-9]*$'
        Comment c = new Comment(id, username, body, createdOn);
        comments.add(c);
      }
    } catch (Exception e) {
      e.printStackTrace();
      Logger.getLogger(Comment.class.getName()).severe(e.getClass().getName()+": "+e.getMessage()); // Replaced System.err with logger
    } finally {
      try {
        if (stmt != null) stmt.close(); // Closed Statement in finally block
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return comments; // Moved return statement out of finally block
  }

  public static boolean delete(String id) { // Changed return type to primitive boolean
    PreparedStatement pStatement = null;
    try {
      String sql = "DELETE FROM comments where id = ?";
      Connection con = Postgres.connection();
      pStatement = con.prepareStatement(sql);
      pStatement.setString(1, id);
      return 1 == pStatement.executeUpdate();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (pStatement != null) pStatement.close(); // Closed PreparedStatement in finally block
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return false; // Moved return statement out of finally block
  }

  private boolean commit() throws SQLException { // Changed return type to primitive boolean
    String sql = "INSERT INTO comments (id, username, body, created_on) VALUES (?,?,?,?)";
    Connection con = Postgres.connection();
    PreparedStatement pStatement = con.prepareStatement(sql);
    pStatement.setString(1, this.id);
    pStatement.setString(2, this.username);
    pStatement.setString(3, this.body);
    pStatement.setTimestamp(4, this.createdOn);
    return 1 == pStatement.executeUpdate();
  }
}