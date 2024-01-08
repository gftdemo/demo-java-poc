# Documentação do código Dockerfile

Este arquivo Dockerfile tem duas instruções principais: `FROM` e `COPY`.

```Dockerfile
FROM nginx:alpine
COPY . /usr/share/nginx/html
```

## Descrição das Instruções

### FROM nginx:alpine

Esta instrução especifica a imagem base que será usada para criar o nosso novo contêiner Docker. Aqui, `nginx:alpine` é uma imagem Docker oficial do NGINX, uma popular solução de servidor web.

O termo 'alpine' se refere a uma variante minimalista da imagem que é muito menor em tamanho (apenas 5MB) e tem menos camadas, tornando-a mais eficiente.

### COPY . /usr/share/nginx/html

A instrução `COPY` copia novos arquivos ou diretórios do host e os adiciona ao sistema de arquivos do contêiner em um caminho específico.

Neste caso, `.` indica o diretório atual (onde o Dockerfile está localizado) no host. `/usr/share/nginx/html` é o destino no sistema de arquivos do contêiner.

Assim, esta instrução copia o conteúdo do diretório atual do host para o diretório `/usr/share/nginx/html` dentro do contêiner. Isso é útil quando queremos adicionar nosso site ou aplicativo web ao contêiner.

## Resumo

Este Dockerfile cria um contêiner NGINX baseado em Alpine e copia os arquivos do diretório atual do host para o diretório de hospedagem padrão do NGINX no contêiner. Quando o contêiner é executado, o NGINX serve o conteúdo copiado.