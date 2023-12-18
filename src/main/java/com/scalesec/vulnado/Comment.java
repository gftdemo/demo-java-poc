package com.scalesec.vulnado;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class Comment {

  private static final String ID = "id";
  private static final String USERNAME = "username";
  private static final String BODY = "body";
  private long createdOn;

  public Comment(String id, String username, String body, long createdOn) {
    this.id = id;
    this.username = username;
    this.body = body;
    this.createdOn = createdOn;
  }

  public static Comment create(String username, String body){
    long time = new Date().getTime();
    Comment comment = new Comment(UUID.randomUUID().toString(), username, body, time);
    try (Connection con = Postgres.connection();
         PreparedStatement pstmt = con.prepareStatement("INSERT INTO comments (" + ID + ", " + USERNAME + ", " + BODY + ", created_on) VALUES (?,?,?,?)")) {
      pstmt.setString(1, comment.id);
      pstmt.setString(2, comment.username);
      pstmt.setString(3, comment.body);
      pstmt.setLong(4, comment.createdOn);
      return pstmt.executeUpdate() == 1 ? comment : null;
    } catch (Exception e) {
      throw new ServerError(e.getMessage()); 
    }
  }

  public static List<Comment> fetchAll() {
    List<Comment> comments = new ArrayList<>();
    try (Connection con = Postgres.connection();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM comments")) {
      while (rs.next()) {
        String id = rs.getString(ID);
        String username = rs.getString(USERNAME);
        String body = rs.getString(BODY);
        long createdOn = rs.getLong("created_on");
        comments.add(new Comment(id, username, body, createdOn));
      }
    } catch (Exception e) {
      // log error
    }
    return comments;
  }

  public static boolean delete(String id) {
    try (Connection con = Postgres.connection();
         PreparedStatement pstmt = con.prepareStatement("DELETE FROM comments WHERE id = ?")) {
      pstmt.setString(1, id);
      return pstmt.executeUpdate() == 1;
    } catch (Exception e) {
      // log error
    }
    return false;
  }

}