# Documentação do Código

Este é um arquivo de configuração Docker Compose, que é usado para definir e executar multi-container Docker applications.

## Estrutura do Código

O código é dividido em quatro serviços: `vulnado`, `client`, `db` e `internal_site`.

### Serviço: vulnado

Este serviço é construído a partir do Dockerfile no diretório atual (indicado pelo `.`). Ele mapeia a porta 8080 do host para a porta 8080 do container e depende do serviço `db`. Ele também está vinculado aos serviços `db` e `internal_site`. As variáveis de ambiente são definidas para a conexão com o banco de dados.

### Serviço: client

Este serviço é construído a partir do Dockerfile no diretório `client`. Ele mapeia a porta 1337 do host para a porta 80 do container.

### Serviço: db

Este serviço usa a imagem Docker `postgres`. As variáveis de ambiente são definidas para a senha e o nome do banco de dados.

### Serviço: internal_site

Este serviço é construído a partir do Dockerfile no diretório `internal_site`.

## Como usar

Para criar e iniciar todos os serviços, você pode usar o comando `docker-compose up`.