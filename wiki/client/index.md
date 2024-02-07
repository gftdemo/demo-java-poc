# Documentação do Código HTML

Este documento é a documentação do código HTML.

```html
<!doctype html>
<html lang="en">
  <head>
    ...
  </head>
  <body>
    ...
  </body>
</html>
```

O código acima é uma estrutura básica de HTML. O HTML começa com a declaração do tipo de documento (`<!doctype html>`), seguido pela tag html principal que envolve todo o documento HTML. A tag `<head>` contém metadados sobre o documento HTML, enquanto a tag `<body>` contém o conteúdo principal que é exibido aos usuários no navegador.

## Cabeçalho

```html
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="...">
  <link href="css/main.css" rel="stylesheet">
  <title>Vulnado</title>
</head>
```

O elemento `<head>` contém metatags que são usadas para especificar a codificação de caracteres para o documento (`<meta charset="utf-8">`) e para tornar o layout responsivo (`<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">`). Além disso, há links para os arquivos CSS externos.

## Corpo

```html
<body>
  <nav>...</nav>
  <main role="main" class="container">...</main>
  <script src="..."></script>
</body>
```

O elemento `<body>` contém a navegação (`<nav>`), o conteúdo principal (`<main>`) e os scripts externos (`<script>`). O conteúdo principal é composto por várias seções, incluindo imagens, textos e formulários para comentários.

## Navegação

```html
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
  <a class="navbar-brand" href="index.html">Vulnado</a>
  ...
</nav>
```

A navegação é criada usando a classe Bootstrap 'navbar'. O título da navegação é "Vulnado" e redireciona para a página 'index.html' quando clicado.

## Conteúdo principal

```html
<main role="main" class="container">
  <div class="puppy">...</div>
  <div class="container">...</div>
  <div class="row" style="padding-top:20px">...</div>
</main>
```

O conteúdo principal contém uma imagem de um cachorro, uma seção para comentários e um formulário para enviar novos comentários.

## Scripts

```html
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
...
<script src="js/index.js"></script>
```

Os scripts externos incluem a biblioteca jQuery, Popper.js, Bootstrap e um arquivo de script personalizado 'index.js'.