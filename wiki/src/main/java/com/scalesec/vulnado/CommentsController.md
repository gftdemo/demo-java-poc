# Documentação do Código

Este código pertence a um pacote chamado `com.scalesec.vulnado`. Ele utiliza a biblioteca Spring para criar uma API RESTful que gerencia comentários. 

## Classes e Métodos

1. `CommentsController`: Esta é a classe principal que contém os métodos para criar, ler e deletar comentários. 

- `comments(@RequestHeader(value="x-auth-token") String token)`: Este método retorna uma lista de todos os comentários. Ele requer um token de autenticação no cabeçalho da solicitação.

- `createComment(@RequestHeader(value="x-auth-token") String token, @RequestBody CommentRequest input)`: Este método cria um novo comentário usando as informações fornecidas no corpo da solicitação. Ele também requer um token de autenticação no cabeçalho da solicitação.

- `deleteComment(@RequestHeader(value="x-auth-token") String token, @PathVariable("id") String id)`: Este método deleta um comentário com base no ID fornecido. Ele também requer um token de autenticação no cabeçalho da solicitação.

2. `CommentRequest`: Esta é uma classe auxiliar usada para deserializar o corpo da solicitação ao criar um novo comentário. Ela contém um nome de usuário e o corpo do comentário.

3. `BadRequest`: Esta é uma classe de exceção personalizada que é lançada quando ocorre um erro de solicitação inválida (HTTP 400).

4. `ServerError`: Esta é uma classe de exceção personalizada que é lançada quando ocorre um erro interno do servidor (HTTP 500).

## Anotações

- `@RestController`: Esta anotação é usada para indicar que a classe é um controlador Spring e pode processar solicitações HTTP.

- `@EnableAutoConfiguration`: Esta anotação permite que o Spring Boot configure automaticamente o aplicativo baseado no conteúdo do classpath e em outras configurações.

- `@CrossOrigin(origins = "*")`: Esta anotação permite solicitações CORS de qualquer origem para os métodos anotados.

- `@RequestMapping`: Esta anotação é usada para mapear solicitações HTTP para métodos de manipulador específicos.

- `@ResponseStatus`: Esta anotação é usada em exceções personalizadas para fornecer um código de status HTTP específico quando a exceção é lançada. 

- `@Value`: Esta anotação é usada para injetar valores de propriedades em campos ou métodos.

## Propriedades

- `app.secret`: É uma propriedade que armazena o valor do segredo do aplicativo, usado para verificar a autenticidade do token de autenticação.

## Segurança

Os métodos na classe `CommentsController` exigem um token de autenticação no cabeçalho da solicitação (`x-auth-token`). Se o token fornecido não for válido, uma exceção será lançada.