Português

# Documentação do Código

O código é um script jQuery que lida com a funcionalidade de comentários em uma página da web. 

```javascript
$(document).ready(function(){
  ...
});
```
Esta linha garante que o código seja executado apenas após o documento HTML completo ser totalmente carregado.

```javascript
var source = $("#comment-template").html();
var template = Handlebars.compile(source);
```
Aqui, o código usa o Handlebars (uma biblioteca de modelagem JavaScript) para compilar um modelo de comentário.

```javascript
$.ajaxSetup({ beforeSend: function(xhr) {
  xhr.setRequestHeader('x-auth-token', localStorage.jwt);
}});
```
Este código adiciona o JWT (JSON Web Token) de um usuário ao cabeçalho de cada solicitação AJAX, que é uma forma de autenticação.

Existem duas funções principais: `setupDeleteCommentHandler` e `fetchComments`.

`setupDeleteCommentHandler` é uma função que permite aos usuários excluir seus comentários.

`fetchComments` é uma função que recupera todos os comentários de uma API e insere-os na página, desde que não contenham a string `<script>` (para prevenir ataques de script entre sites).

Além disso, existem manipuladores de eventos para os botões "submit-comment" e "signout". 

O manipulador "submit-comment" envia uma solicitação POST para adicionar um novo comentário à API quando clicado.

O manipulador "signout" limpa o JWT e o nome de usuário do armazenamento local, exibe um alerta e redireciona o usuário para a página de login.

Finalmente, quando o script é inicializado, ele verifica se um JWT existe no armazenamento local. Se existir, ele busca e exibe os comentários. Se não, redireciona o usuário para a página de login.