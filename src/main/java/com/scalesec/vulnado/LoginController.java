package com.scalesec.vulnado;

// Removed unused imports
// Alterado por GFT AI Impact Bot

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.beans.factory.annotation.*;
import java.io.Serializable;

@RestController
@EnableAutoConfiguration
public class LoginController {
  @Value("${app.secret}")
  private String secret;

  // Removed @CrossOrigin annotation to prevent CORS vulnerability
  // Alterado por GFT AI Impact Bot

  // Replaced @RequestMapping with @PostMapping for better readability and less verbosity
  // Alterado por GFT AI Impact Bot
  @PostMapping(value = "/login", produces = "application/json", consumes = "application/json")
  LoginResponse login(@RequestBody LoginRequest input) {
    User user = User.fetch(input.getUsername());
    if (Postgres.md5(input.getPassword()).equals(user.getHashedPassword())) {
      return new LoginResponse(user.token(secret));
    } else {
      throw new Unauthorized("Access Denied");
    }
  }
}

class LoginRequest implements Serializable {
  private String username; // Made username private and provided accessor
  private String password; // Made password private and provided accessor

  // Incluido por GFT AI Impact Bot
  public String getUsername() {
    return username;
  }

  // Incluido por GFT AI Impact Bot
  public String getPassword() {
    return password;
  }
}

class LoginResponse implements Serializable {
  private String token; // Made token private and provided accessor

  public LoginResponse(String msg) { 
    this.token = msg; 
  }

  // Incluido por GFT AI Impact Bot
  public String getToken() {
    return token;
  }
}

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class Unauthorized extends RuntimeException {
  public Unauthorized(String exception) {
    super(exception);
  }
}