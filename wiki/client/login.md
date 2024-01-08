# Documentação do Código

## Estrutura Básica

O código é uma página web HTML básica com o `doctype` HTML5. Ele define a linguagem da página como inglês (`<html lang="en">`). A página inclui metadados no cabeçalho (`<head>`) e conteúdo no corpo (`<body>`).

## Cabeçalho

O cabeçalho (`<head>`) inclui as seguintes informações:

- Conjunto de caracteres usado na página (`<meta charset="utf-8">`)
- Configurações de viewport para controle de layout em dispositivos móveis (`<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">`)
- Título da página (`<title>Vulnado</title>`)
- Link para os estilos CSS do Bootstrap e estilos personalizados para a página (`<link href="css/main.css" rel="stylesheet">`)

## Corpo

O corpo (`<body>`) da página contém:

- Uma barra de navegação (`<nav>`), incluindo um botão para expandir ou recolher o menu em dispositivos móveis.
- Um contêiner principal (`<main role="main" class="container">`) que contém um formulário de login. 

## Formulário de Login

O formulário de login inclui:

- Um título (`<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>`)
- Um campo de input para o nome do usuário (`<input type="username" id="inputUsername" class="form-control top" placeholder="Username" required autofocus>`)
- Um campo de input para a senha (`<input type="password" id="inputPassword" class="form-control bottom" placeholder="Password" required>`)
- Um botão para submeter o formulário (`<button id="btn-login" class="btn btn-lg btn-primary btn-block">Sign in</button>`)
- Um parágrafo com informações de copyright (`<p class="mt-5 mb-3 text-muted">&copy; 2019</p>`)

## Scripts

No final da página, há vários scripts sendo importados:

- jQuery, uma biblioteca JavaScript popular (`<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>`)
- Popper.js, uma biblioteca para tooltips e popovers (`<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>`)
- Bootstrap, um framework CSS (`<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>`)
- Handlebars.js, uma biblioteca de templates (`<script src="http://builds.handlebarsjs.com.s3.amazonaws.com/handlebars.min-v4.1.0.js"></script>`)
- Um script personalizado para gerenciar o login (`<script src="js/login.js"></script>`)