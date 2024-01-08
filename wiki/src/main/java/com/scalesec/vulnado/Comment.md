Português

# Documentação de Código

```java
package com.scalesec.vulnado;
```

O pacote `com.scalesec.vulnado` contém todas as classes relacionadas ao projeto `vulnado`.

---

```java
public class Comment {
```

A classe `Comment` é usada para representar e manipular comentários em nossa aplicação.

---

```java
public String id, username, body;
public Timestamp created_on;
```

Essas são as variáveis de instância da classe `Comment`. `id` é o identificador único do comentário, `username` é o nome do usuário que criou o comentário, `body` é o conteúdo do comentário e `created_on` é o horário em que o comentário foi criado.

---

```java
public Comment(String id, String username, String body, Timestamp created_on) {
```

Este é o construtor da classe `Comment`. Ele é usado para criar uma nova instância de `Comment`.

---

```java
public static Comment create(String username, String body){
```

Este é um método estático que cria um novo comentário. Ele gera um `id` único para o comentário, obtém o horário atual e salva o comentário no banco de dados.

---

```java
public static List<Comment> fetch_all() {
```

Este é um método estático que recupera todos os comentários do banco de dados e os retorna como uma lista de objetos `Comment`.

---

```java
public static Boolean delete(String id) {
```

Este é um método estático que exclui um comentário do banco de dados usando seu `id`.

---

```java
private Boolean commit() throws SQLException {
```

Este é um método privado que salva o comentário no banco de dados. Ele é chamado pelo método `create()`.