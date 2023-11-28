package com.scalesec.vulnado;

// Removed unused import
// import org.apache.catalina.Server;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Logger;

public class Comment {
  // Made fields non-public and provided accessors
  private String id;
  private String username;
  private String body;
  private Timestamp createdOn; // Renamed to match the regular expression '^[a-z][a-zA-Z0-9]*$'

  public Comment(String id, String username, String body, Timestamp createdOn) {
    this.id = id;
    this.username = username;
    this.body = body;
    this.createdOn = createdOn;
  }

  // Accessors
  public String getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getBody() {
    return body;
  }

  public Timestamp getCreatedOn() {
    return createdOn;
  }

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
    try (Connection cxn = Postgres.connection()) { // Used try-with-resources
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
    }
    return comments; // Moved return statement out of finally block
  }

  public static boolean delete(String id) { // Used primitive boolean
    boolean result = false; // Refactored to not always return the same value
    try (Connection con = Postgres.connection(); // Used try-with-resources
         PreparedStatement pStatement = con.prepareStatement("DELETE FROM comments where id = ?")) {
      pStatement.setString(1, id);
      result = 1 == pStatement.executeUpdate();
    } catch(Exception e) {
      e.printStackTrace();
    }
    return result; // Moved return statement out of finally block
  }

  private boolean commit() throws SQLException { // Used primitive boolean
    boolean result = false; // Refactored to not always return the same value
    String sql = "INSERT INTO comments (id, username, body, created_on) VALUES (?,?,?,?)";
    try (Connection con = Postgres.connection(); // Used try-with-resources
         PreparedStatement pStatement = con.prepareStatement(sql)) {
      pStatement.setString(1, this.id);
      pStatement.setString(2, this.username);
      pStatement.setString(3, this.body);
      pStatement.setTimestamp(4, this.createdOn);
      result = 1 == pStatement.executeUpdate();
    }
    return result;
  }
}