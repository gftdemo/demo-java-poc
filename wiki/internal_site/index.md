# Documentação do Código HTML

O código HTML a seguir descreve uma página web que serve como um diretório interno para uma empresa. 

```html
<html>
 <body>
   <h1>Internal Directory</h1>

   <ul>
     <li>CEO - <a href="mailto:alice@example.com?subject=feedback">email me</a>
     <li>COO - <a href="mailto:bob@example.com?subject=feedback">email me</a>
     <li>CTO - <a href="mailto:tom@example.com?subject=feedback">email me</a>
     <li>CISO - <a href="mailto:eve@example.com?subject=feedback">email me</a>
   </ul>
 </body>
</html>
```

## Descrição do Código

- `<html>` : Este é o elemento raiz de uma página HTML.
- `<body>` : Contém o conteúdo principal que será visível para os usuários quando eles visitarem a página.
- `<h1>` : Define um cabeçalho de primeiro nível. Neste caso, o cabeçalho é "Internal Directory".
- `<ul>` : Define uma lista não ordenada.
- `<li>` : Define um item da lista. Cada item da lista representa um cargo e um link de email correspondente na empresa.
- `<a href="mailto:alice@example.com?subject=feedback">email me</a>` : Este é um link de email que, quando clicado, abre o cliente de email padrão do usuário com um email pré-endereçado. O `mailto:` especifica que o link é um endereço de email, e o `?subject=feedback` especifica o assunto do email. A frase "email me" é o texto visível do link.

Cada item da lista representa um cargo diferente na empresa (CEO, COO, CTO, CISO) e contém um link de email correspondente que permite aos visitantes enviar um email diretamente para a pessoa nesse cargo.