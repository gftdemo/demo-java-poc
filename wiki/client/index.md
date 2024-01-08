# Documentação do Código HTML

Este é um arquivo HTML básico usado para criar a interface de um site chamado "Vulnado". Aqui está um detalhamento de cada seção do arquivo:

## <!doctype html>
Indica que este documento é um documento HTML5.

## <html lang="en">
O elemento raiz de uma página HTML. O atributo 'lang' define o idioma do conteúdo do documento.

## <head>
Contém metadados (dados sobre os dados) e links para scripts e estilos.

- **<meta charset="utf-8">** Define o conjunto de caracteres para o documento, que é "utf-8".
- **<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">** Configura a viewport para ser responsiva em dispositivos móveis.
- **<link>** Tags usadas para vincular estilos CSS externos e a biblioteca Bootstrap ao documento.
- **<title>Vulnado</title>** Define o título do documento, que aparece na barra de título do navegador.

## <body>
Contém o conteúdo visível da página HTML.

- **<nav>** Define uma barra de navegação.
- **<main role="main" class="container">** Define o conteúdo principal do documento. A classe 'container' é uma classe Bootstrap usada para centrar o layout.
- **<div class="puppy">** Contém uma imagem e texto relacionados a um cachorro.
- **<div id="comments-container"></div>** É o local onde os comentários dos usuários serão inseridos dinamicamente.
- **<input type="text" id="new-comment" class="form-control" placeholder="Comment">** É onde os usuários podem digitar novos comentários.
- **<button id="submit-comment" class="btn btn-primary">** É o botão que os usuários clicam para enviar seus comentários.
  
## <script>
Tags usadas para vincular scripts JS externos ao documento. Scripts incluem bibliotecas jQuery, Popper.js, Bootstrap e Handlebars.js, além do script personalizado 'index.js'.

## <script id="comment-template" type="text/x-handlebars-template">
Um modelo Handlebars que é usado para criar a estrutura dos comentários dos usuários. Handlebars é uma biblioteca JavaScript que permite criar templates HTML semânticos.