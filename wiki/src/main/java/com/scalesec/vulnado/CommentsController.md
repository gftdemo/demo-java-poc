# Documentação do Código

Este é um pacote de controlador de comentários em um aplicativo web Spring Boot. O pacote `com.scalesec.vulnado` contém as classes `CommentsController`, `CommentRequest`, `BadRequest` e `ServerError`.

## Classe `CommentsController`

Esta classe é um controlador REST que lida com as operações de Comentários do aplicativo.

- Anotação `@RestController`: Esta anotação é usada para indicar que essa classe é um controlador REST.
- Anotação `@EnableAutoConfiguration`: Com essa anotação, o Spring Boot pode configurar automaticamente qualquer coisa que você possa ter deixado de configurar.

A classe `CommentsController` tem três métodos:

### Método `comments`

Este método retorna uma lista de todos os comentários. Ele usa a anotação `@CrossOrigin` para permitir solicitações de qualquer origem e a anotação `@RequestMapping` para mapear as solicitações GET para "/comments" para este método.

### Método `createComment`

Este método aceita uma solicitação POST em "/comments" para criar um novo comentário. O corpo da solicitação deve ser JSON e deve conter o nome de usuário e o corpo do comentário.

### Método `deleteComment`

Este método aceita uma solicitação DELETE para "/comments/{id}", onde "{id}" é o ID do comentário que deve ser excluído.

## Classe `CommentRequest`

Esta é uma classe auxiliar que representa o corpo da solicitação ao criar um novo comentário. Ela possui duas propriedades, `username` e `body`.

## Classe `BadRequest`

Esta é uma classe de exceção que é lançada quando ocorre um erro de solicitação inválida (400). Ela usa a anotação `@ResponseStatus` para mapear a exceção para o status HTTP 400.

## Classe `ServerError`

Esta é uma classe de exceção que é lançada quando ocorre um erro interno no servidor (500). Ela usa a anotação `@ResponseStatus` para mapear a exceção para o status HTTP 500.