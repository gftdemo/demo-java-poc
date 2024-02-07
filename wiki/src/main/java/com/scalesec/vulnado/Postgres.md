Português

# Documentação de Código

Este código é uma classe Java chamada `Postgres` que é usada para interagir com um banco de dados PostgreSQL.

## Importações

O código importa várias bibliotecas Java para lidar com conexões de banco de dados, geração de UUIDs, criptografia MD5 e outras operações.

## Método `connection()`

Este método está criando uma conexão com o banco de dados PostgreSQL. Ele usa as variáveis de ambiente do sistema para obter as informações de conexão do banco de dados (host, nome do banco de dados, nome de usuário e senha).

## Método `setup()`

Este método configura o banco de dados. Ele primeiro estabelece uma conexão com o banco de dados e, em seguida, cria duas tabelas: `users` e `comments`. Em seguida, ele limpa qualquer dado existente nas tabelas e insere alguns dados iniciais.

## Método `md5(String input)`

Este método é usado para calcular o valor do hash MD5 de uma string de entrada. Ele usa o método `getInstance("MD5")` da classe `MessageDigest` para obter uma instância de MessageDigest que implementa o algoritmo de hash MD5.

## Método `insertUser(String username, String password)`

Este método insere um novo usuário na tabela `users`. Ele gera um UUID para o usuário, usa o método `md5` para hash a senha fornecida e, em seguida, insere o novo usuário no banco de dados.

## Método `insertComment(String username, String body)`

Este método insere um novo comentário na tabela `comments`. Ele gera um UUID para o comentário e, em seguida, insere o novo comentário no banco de dados. O comentário é associado ao usuário fornecido.
