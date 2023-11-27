package com.scalesec.vulnado;

// import org.springframework.boot.*; // Removido por GFT AI Impact Bot
// import org.springframework.stereotype.*; // Removido por GFT AI Impact Bot
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

  // @CrossOrigin(origins = "*") // Removido por GFT AI Impact Bot
  @PostMapping(value = "/login", produces = "application/json", consumes = "application/json") // Alterado por GFT AI Impact Bot
  LoginResponse login(@RequestBody LoginRequest input) {
    User user = User.fetch(input.getUsername()); // Alterado por GFT AI Impact Bot
    if (Postgres.md5(input.getPassword()).equals(user.getHashedPassword())) { // Alterado por GFT AI Impact Bot
      return new LoginResponse(user.token(secret));
    } else {
      throw new Unauthorized("Access Denied");
    }
  }
}

class LoginRequest implements Serializable {
  private String username; // Alterado por GFT AI Impact Bot
  private String password; // Alterado por GFT AI Impact Bot

  public String getUsername() { return username; } // Incluido por GFT AI Impact Bot
  public String getPassword() { return password; } // Incluido por GFT AI Impact Bot
}

class LoginResponse implements Serializable {
  private String token; // Alterado por GFT AI Impact Bot

  public LoginResponse(String msg) { this.token = msg; }

  public String getToken() { return token; } // Incluido por GFT AI Impact Bot
}

@ResponseStatus(HttpStatus.UNAUTHORIZED)
class Unauthorized extends RuntimeException {
  public Unauthorized(String exception) {
    super(exception);
  }
}