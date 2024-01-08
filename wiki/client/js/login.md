Português

# Documentação do Código

O código é escrito em JavaScript, usando a biblioteca jQuery. Ele é executado quando a página é totalmente carregada e pronta para o usuário interagir.

```javascript
$(document).ready(function(){
```
Este bloco de código é uma função jQuery que será executada assim que a página do documento estiver pronta.

```javascript
  $("#btn-login").click(function(){
```
Esta função é acionada quando o botão com o id "btn-login" é clicado.

```javascript
    var username = $('#inputUsername').val();
    var password = $('#inputPassword').val();
```
Estas linhas estão pegando o valor dos campos de entrada para nome de usuário e senha.

```javascript
    var payload = {username: username, password: password};
```
Aqui, estamos criando um objeto JavaScript chamado "payload" que contém o nome de usuário e a senha.

```javascript
    $.ajax({
      type: 'POST',
      url: "http://localhost:8080/login",
      data: JSON.stringify(payload),
      dataType: "json",
      contentType: "application/json"
    })
```
Esta é uma função AJAX que envia uma solicitação POST para o servidor no endereço "http://localhost:8080/login", com o payload que contém o nome de usuário e a senha.

```javascript
    .fail(function(data){
      alert("Whoops, try again");
    })
```
Se a solicitação falhar, o usuário receberá um alerta dizendo "Whoops, tente novamente".

```javascript
    .done(function(data){
      localStorage.jwt = data.token;
```
Se a solicitação for bem-sucedida, o token recebido na resposta será armazenado no armazenamento local do navegador.

```javascript
      var username = JSON.parse(atob(data.token.split('.')[1]))['sub'];
      localStorage.username = username;
```
Em seguida, o nome de usuário é extraído do token, decodificado e armazenado no armazenamento local.

```javascript
      window.location.replace("index.html");
    })
```
Finalmente, o usuário é redirecionado para a página "index.html".

```javascript
  })
});
```
As duas últimas linhas são o fechamento das funções aninhadas.