package com.scalesec.vulnado;

import org.apache.catalina.Server;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class Comment {
  public String id, username, body;
  public Timestamp created_on;

  public Comment(String id, String username, String body, Timestamp created_on) {
    this.id = id;
    this.username = username;
    this.body = body;
    this.created_on = created_on;
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

  public static List<Comment> fetch_all() {
    Statement stmt = null;
    Connection cxn = null;
    ResultSet rs = null;
    List<Comment> comments = new ArrayList();
    try {
      cxn = Postgres.connection();
      stmt = cxn.createStatement();

      String query = "select * from comments;";
      rs = stmt.executeQuery(query);
      while (rs.next()) {
        String id = rs.getString("id");
        String username = rs.getString("username");
        String body = rs.getString("body");
        Timestamp created_on = rs.getTimestamp("created_on");
        Comment c = new Comment(id, username, body, created_on);
        comments.add(c);
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println(e.getClass().getName()+": "+e.getMessage());
    } finally {
      try {
        if (rs != null) rs.close(); // Alterado por GFT AI Impact Bot
        if (stmt != null) stmt.close(); // Alterado por GFT AI Impact Bot
        if (cxn != null) cxn.close(); // Alterado por GFT AI Impact Bot
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return comments;
    }
  }

  public static Boolean delete(String id) {
    Connection con = null;
    PreparedStatement pStatement = null;
    try {
      String sql = "DELETE FROM comments where id = ?";
      con = Postgres.connection();
      pStatement = con.prepareStatement(sql);
      pStatement.setString(1, id);
      return 1 == pStatement.executeUpdate();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (pStatement != null) pStatement.close(); // Alterado por GFT AI Impact Bot
        if (con != null) con.close(); // Alterado por GFT AI Impact Bot
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return false;
    }
  }

  private Boolean commit() throws SQLException {
    Connection con = null;
    PreparedStatement pStatement = null;
    try {
      String sql = "INSERT INTO comments (id, username, body, created_on) VALUES (?,?,?,?)";
      con = Postgres.connection();
      pStatement = con.prepareStatement(sql);
      pStatement.setString(1, this.id);
      pStatement.setString(2, this.username);
      pStatement.setString(3, this.body);
      pStatement.setTimestamp(4, this.created_on);
      return 1 == pStatement.executeUpdate();
    } finally {
      try {
        if (pStatement != null) pStatement.close(); // Alterado por GFT AI Impact Bot
        if (con != null) con.close(); // Alterado por GFT AI Impact Bot
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}