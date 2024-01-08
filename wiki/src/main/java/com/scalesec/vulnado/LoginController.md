Português

## Documentação de Código

Este código é um controlador de login para uma aplicação Spring Boot, que autentica usuários e retorna um token de autorização se a autenticação for bem-sucedida.

### Pacotes

O pacote `com.scalesec.vulnado` é o pacote base para o aplicativo. Ele usa as seguintes bibliotecas Spring Boot:

- `org.springframework.boot.*`
- `org.springframework.http.HttpStatus`
- `org.springframework.web.bind.annotation.*`
- `org.springframework.boot.autoconfigure.*`
- `org.springframework.stereotype.*`
- `org.springframework.beans.factory.annotation.*`

Também usa a biblioteca `java.io.Serializable`.

### Classe `LoginController`

Esta é a classe principal. Ela é anotada com `@RestController` e `@EnableAutoConfiguration`, que indicam que é um controlador REST e deve ter a configuração automática habilitada.

A classe possui um campo privado `secret` que é injetado a partir das propriedades do aplicativo (`app.secret`).

A classe define um método `login`, que é mapeado para o caminho `/login` e aceita solicitações POST com conteúdo JSON. Este método tenta buscar um usuário com o nome de usuário fornecido e compara a senha fornecida (após a hash) com a senha armazenada. Se a senha corresponder, retorna um `LoginResponse` com o token do usuário. Se não, lança uma exceção `Unauthorized`.

### Classe `LoginRequest`

Esta é uma classe simples que implementa `Serializable` e tem dois campos públicos: `username` e `password`. É usada para deserializar o corpo da solicitação de login.

### Classe `LoginResponse`

Esta também é uma classe simples que implementa `Serializable`. Possui um campo público `token` e um construtor que aceita uma string, que é atribuída ao token. É usada para serializar a resposta do login.

### Classe `Unauthorized`

Esta é uma classe de exceção personalizada que estende `RuntimeException` e é anotada com `@ResponseStatus(HttpStatus.UNAUTHORIZED)`. Isso significa que, se essa exceção for lançada, a resposta terá o status 401 (Não autorizado). A classe tem um construtor que aceita uma string, que é passada para o construtor da superclasse.