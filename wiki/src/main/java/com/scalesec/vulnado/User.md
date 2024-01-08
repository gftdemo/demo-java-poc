# Documentação de Código

```java
package com.scalesec.vulnado;
```
Este pacote é usado para organizar as classes e interfaces relacionadas ao projeto 'vulnado' da 'scalesec'.

```java
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
```
Essas são as bibliotecas importadas para este arquivo. 
- `java.sql.*`: Usado para lidar com todas as operações de banco de dados.
- `io.jsonwebtoken.*`: Usado para lidar com token JWT para autenticação.
- `javax.crypto.SecretKey`: Usado para manipular a chave secreta para assinatura de token JWT.

```java
public class User {
  public String id, username, hashedPassword;
```
Esta é a classe `User`, que possui três campos públicos: `id`, `username` e `hashedPassword`.

```java
  public User(String id, String username, String hashedPassword) {
    this.id = id;
    this.username = username;
    this.hashedPassword = hashedPassword;
  }
```
Este é o construtor da classe `User` que inicializa `id`, `username` e `hashedPassword`.

```java
  public String token(String secret) {
    SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
    String jws = Jwts.builder().setSubject(this.username).signWith(key).compact();
    return jws;
  }
```
O método `token` gera um token JWT usando o `username` do usuário e uma chave secreta fornecida.

```java
  public static void assertAuth(String secret, String token) {
    try {
      SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
      Jwts.parser()
        .setSigningKey(key)
        .parseClaimsJws(token);
    } catch(Exception e) {
      e.printStackTrace();
      throw new Unauthorized(e.getMessage());
    }
  }
```
O método `assertAuth` é usado para autenticar o token JWT fornecido. Ele lança uma exceção `Unauthorized` se a autenticação falhar.

```java
  public static User fetch(String un) {
    Statement stmt = null;
    User user = null;
    try {
      Connection cxn = Postgres.connection();
      stmt = cxn.createStatement();
      System.out.println("Opened database successfully");

      String query = "select * from users where username = '" + un + "' limit 1";
      System.out.println(query);
      ResultSet rs = stmt.executeQuery(query);
      if (rs.next()) {
        String user_id = rs.getString("user_id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        user = new User(user_id, username, password);
      }
      cxn.close();
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println(e.getClass().getName()+": "+e.getMessage());
    } finally {
      return user;
    }
  }
}
```
O método estático `fetch` é usado para buscar um usuário do banco de dados com base no nome de usuário fornecido. Ele retorna uma instância do `User` se o usuário for encontrado, caso contrário, retorna `null`.