package com.scalesec.vulnado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
  private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
  private String id;
  private String username;
  private String hashedPassword;

  public User(String id, String username, String hashedPassword) { // Alterado por GFT AI Impact Bot
    this.id = id;
    this.username = username;
    this.hashedPassword = hashedPassword;
  }

  public String getId() { // Incluido por GFT AI Impact Bot
    return id;
  }

  public String getUsername() { // Incluido por GFT AI Impact Bot
    return username;
  }

  public String getHashedPassword() { // Incluido por GFT AI Impact Bot
    return hashedPassword;
  }

  public String token(String secret) {
    SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
    return Jwts.builder().setSubject(this.username).signWith(key).compact(); // Alterado por GFT AI Impact Bot
  }

  public static void assertAuth(String secret, String token) {
    try {
      SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
      Jwts.parser()
        .setSigningKey(key)
        .parseClaimsJws(token);
    } catch(Exception e) {
      LOGGER.error(e.getMessage(), e); // Alterado por GFT AI Impact Bot
      throw new Unauthorized(e.getMessage());
    }
  }

  public static User fetch(String un) {
    User user = null;
    try (Connection cxn = Postgres.connection(); // Alterado por GFT AI Impact Bot
         PreparedStatement stmt = cxn.prepareStatement("select * from users where username = ? limit 1")) { // Alterado por GFT AI Impact Bot
      LOGGER.debug("Opened database successfully"); // Alterado por GFT AI Impact Bot

      stmt.setString(1, un); // Incluido por GFT AI Impact Bot
      LOGGER.debug(stmt.toString()); // Alterado por GFT AI Impact Bot
      try (ResultSet rs = stmt.executeQuery()) { // Alterado por GFT AI Impact Bot
        if (rs.next()) {
          String userId = rs.getString("user_id"); // Alterado por GFT AI Impact Bot
          String username = rs.getString("username");
          String password = rs.getString("password");
          user = new User(userId, username, password);
        }
      }
    } catch (SQLException e) {
      LOGGER.error(e.getMessage(), e); // Alterado por GFT AI Impact Bot
    }
    return user; // Alterado por GFT AI Impact Bot
  }
}