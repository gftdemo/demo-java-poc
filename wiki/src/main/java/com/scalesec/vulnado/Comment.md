# Documentação do Código

## Pacote e Importações

```java
package com.scalesec.vulnado;

import org.apache.catalina.Server;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
```

Este pacote importa classes necessárias para lidar com servidores, data e tempo, manipulação de SQL e geração de UUID.

## Classe Comment

```java
public class Comment {
  public String id, username, body;
  public Timestamp created_on;
```

A classe `Comment` define um comentário com quatro propriedades: `id`, `username`, `body` e `created_on`.

### Construtor

```java
public Comment(String id, String username, String body, Timestamp created_on) {
  this.id = id;
  this.username = username;
  this.body = body;
  this.created_on = created_on;
}
```

O construtor da classe `Comment` inicializa um novo objeto `Comment` com o `id`, `username`, `body` e `created_on` fornecidos.

### Método create

```java
public static Comment create(String username, String body){
  ...
}
```

O método `create` cria um novo comentário com o `username` e `body` fornecidos, gera um UUID para o `id` e configura o `created_on` para a hora atual. O comentário é então commitado para o banco de dados.

### Método fetch_all

```java
public static List<Comment> fetch_all() {
  ...
}
```

O método `fetch_all` recupera todos os comentários do banco de dados e retorna uma lista de objetos `Comment`.

### Método delete

```java
public static Boolean delete(String id) {
  ...
}
```

O método `delete` exclui um comentário com o `id` fornecido do banco de dados.

### Método commit

```java
private Boolean commit() throws SQLException {
  ...
}
```

O método `commit` insere o comentário no banco de dados. Ele retorna `true` se a inserção for bem sucedida e `false` caso contrário.

## Exceções

A classe `Comment` também manipula exceções. As exceções são lançadas quando ocorre um erro durante a criação, recuperação ou exclusão de um comentário. As mensagens de erro são impressas no console para ajudar no diagnóstico do problema.