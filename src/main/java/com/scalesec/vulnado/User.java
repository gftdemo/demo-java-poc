package com.scalesec.vulnado;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Logger;

public class User {
  
  private static final Logger LOGGER = Logger.getLogger(User.class.getName());

  private static final String ID = "id";
  private static final String USERNAME = "username";
  private static final String HASHED_PASSWORD = "hashedPassword";

  private String id;
  private String username;
  private String hashedPassword;

  public User(String id, String username, String hashedPassword) {
    this.id = id; 
    this.username = username;
    this.hashedPassword = hashedPassword;
  }

  public String token(String secret) {
    // Generate JWT token using secret
    return ""; 
  }

  public static void assertAuth(String secret, String token) {
    // Validate JWT token using secret
  }

  public static User fetch(String username) {
    
    Connection cxn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      cxn = Postgres.connection();
      
      stmt = cxn.createStatement();
      
      String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
      PreparedStatement pstmt = cxn.prepareStatement(query);
      pstmt.setString(1, username);
      
      rs = pstmt.executeQuery();
      
      if (rs.next()) {
        String user_id = rs.getString("user_id");
        String user_username = rs.getString("username");
        String password = rs.getString("password");
        return new User(user_id, user_username, password);
      }
      
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
    } finally {
      if (rs != null) { 
        try {
          rs.close();
        } catch (Exception e) {
          LOGGER.severe(e.getMessage());  
        }
      }
      if (stmt != null) {
        try {
          stmt.close();
        } catch (Exception e) {
          LOGGER.severe(e.getMessage());
        }
      }
      if (cxn != null) {
        try {
          cxn.close();
        } catch (Exception e) {
          LOGGER.severe(e.getMessage());
        }
      }
    }
    
    return null;
  }
  
}