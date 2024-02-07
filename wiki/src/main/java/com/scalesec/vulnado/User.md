Português

# Documentação de Código

Este código está em Java e representa a classe `User` no pacote `com.scalesec.vulnado`.

## Importações

As importações incluem classes para lidar com conexões SQL, criação de tokens JWT, e criptografia.

## Classe `User`

A classe `User` tem três atributos: `id`, `username` e `hashedPassword`.

### Construtor

O construtor aceita `id`, `username` e `hashedPassword` como parâmetros e os atribui aos atributos correspondentes da classe.

### Método `token(String secret)`

Este método aceita uma string `secret` como argumento e retorna um token JWT. O token é assinado usando a chave secreta, que é criada a partir da string `secret` fornecida.

### Método `assertAuth(String secret, String token)`

Este método aceita uma string `secret` e um token JWT como argumentos e não retorna nada. Ele tenta analisar o token usando a chave secreta criada a partir da string `secret`. Se a análise falhar, uma exceção é lançada.

### Método `fetch(String un)`

Este método aceita um username como argumento e retorna um objeto `User`. Ele cria uma conexão com o banco de dados Postgres, executa uma consulta para buscar um usuário com o username fornecido e, se encontrar um, retorna um objeto `User` com os dados retornados. Se ocorrer um erro, a exceção é impressa e retornada `null`.

## Exceções

As exceções são tratadas imprimindo a pilha de rastreamento e, no caso do método `assertAuth`, lançando uma exceção `Unauthorized` com a mensagem de erro da exceção original.

## Observações

Este código não protege contra ataques de injeção SQL, pois o username é inserido diretamente na consulta SQL. Além disso, o tratamento de exceções poderia ser melhorado, pois atualmente qualquer exceção é simplesmente impressa e o programa continua.