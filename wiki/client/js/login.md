Português

```markdown
# Documentação do Código

O código a seguir é um script em jQuery que é executado quando a página web é totalmente carregada. A função `$(document).ready()` garante que todo o código dentro dela será executado apenas quando o documento HTML estiver totalmente carregado.

```javascript
$(document).ready(function(){
```

No interior desta função, temos um evento click associado ao botão com o ID "btn-login". Quando este botão é clicado, a função anônima associada a ele é executada.

```javascript
  $("#btn-login").click(function(){
```

Dentro desta função anônima, as variáveis 'username' e 'password' são definidas. Elas obtêm seus valores dos campos de entrada correspondentes na página HTML.

```javascript
    var username = $('#inputUsername').val();
    var password = $('#inputPassword').val();
```

Em seguida, essas variáveis são usadas para criar um objeto 'payload', que será enviado ao servidor.

```javascript
    var payload = {username: username, password: password};
```

Aqui, é feita uma requisição AJAX ao servidor. A requisição é do tipo POST e é enviada para a URL "http://localhost:8080/login". O 'payload' é convertido para uma string JSON e enviado como dados da requisição.

```javascript
    $.ajax({
      type: 'POST',
      url: "http://localhost:8080/login",
      data: JSON.stringify(payload),
      dataType: "json",
      contentType: "application/json"
    })
```

Se a requisição falhar, um alerta será exibido na tela com a mensagem "Whoops, try again".

```javascript
    .fail(function(data){
      alert("Whoops, try again");
    })
```

Se a requisição for bem sucedida, o token JWT retornado pelo servidor é armazenado no armazenamento local do navegador. Além disso, o nome de usuário, que é extraído do token, também é armazenado no armazenamento local. Finalmente, o usuário é redirecionado para a página "index.html".

```javascript
    .done(function(data){
      localStorage.jwt = data.token;
      var username = JSON.parse(atob(data.token.split('.')[1]))['sub'];
      localStorage.username = username;
      window.location.replace("index.html");
    })
  })
});
```
```