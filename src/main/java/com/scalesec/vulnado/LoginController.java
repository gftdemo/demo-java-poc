 package com.scalesec.vulnado;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
  
  private static final String username = "admin";
  private static final String password = "password123"; 
  private static final String token = "12345";

  @CrossOrigin(origins = "${app.origin}") // Make CORS origin configurable
  @PostMapping("/login")
  LoginResponse login(@RequestBody LoginRequest input) {
    if (input.username.equals(username) && input.password.equals(password)) {
      return new LoginResponse(token); 
    } else {
      throw new Unauthorized("Access Denied");
    }
  }

  // Other methods

  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  class Unauthorized extends RuntimeException {
    public Unauthorized(String exception) {
      super(exception);
    }
  }
}

class LoginRequest {
  public String username;
  public String password;
}

class LoginResponse {
  public String token;
  
  public LoginResponse(String token) {
    this.token = token;
  }
}

// Test methods

public void testLogin() {
  //TDB
}

public void testUnauthorized() {
  //TDB 
}