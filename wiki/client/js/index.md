```markdown
# Documentação do Código

Este é um script JavaScript/jQuery que lida com a funcionalidade de comentários de uma aplicação web.

## Inicialização do script

Primeiro, o script aguarda até que o documento HTML esteja pronto. Então, compila um template Handlebars a partir do elemento HTML com o id `#comment-template`.

## Configuração do AJAX

O script define uma configuração global para todas as requisições AJAX, adicionando um JSON Web Token (JWT) do localStorage ao cabeçalho de cada requisição.

## Funções Auxiliares

Existem duas funções principais definidas no script:

### `setupDeleteCommentHandler`

Esta função é responsável por configurar o evento click para cada botão de deletar comentário. Quando clicado, o script faz uma requisição DELETE para a API de comentários com o ID do comentário associado ao botão. Se a requisição for bem sucedida, o elemento pai do botão (que contém todo o comentário) é removido do DOM.

### `fetchComments`

Esta função faz uma requisição GET para a API de comentários, limpa o container de comentários e então adiciona cada comentário retornado pela API ao container. Se o corpo do comentário não contiver a tag `<script>`, o comentário é adicionado ao container.

## Manipuladores de Evento

Existem três manipuladores de evento configurados no script:

### `#submit-comment`

Quando o botão com o id `#submit-comment` é clicado, o script faz uma requisição POST para a API de comentários com o corpo do novo comentário e o nome de usuário armazenado no localStorage. Se a requisição for bem sucedida, o campo de texto do novo comentário é limpo e a função `fetchComments` é chamada para atualizar os comentários.

### `#signout`

Quando o botão com o id `#signout` é clicado, o script limpa o JWT e o nome de usuário do localStorage e redireciona o usuário para a página de login.

## Inicialização da página

Quando a página é carregada, se houver um JWT no localStorage, a função `fetchComments` é chamada para carregar os comentários. Se não houver um JWT, o usuário é redirecionado para a página de login.
```