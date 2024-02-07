# Documentação do Dockerfile

Este arquivo é um Dockerfile, que é usado para criar uma imagem Docker que pode ser usada para criar contêineres. As imagens Docker são como uma "receita" que contém todas as instruções necessárias para criar um ambiente específico, neste caso, um ambiente de desenvolvimento Java com algumas ferramentas adicionais.

Aqui está a explicação detalhada de cada linha:

## FROM openjdk:8
Esta linha está especificando a imagem base que estamos usando. Neste caso, estamos usando a imagem do OpenJDK 8, que é uma implementação de código aberto do Java Development Kit (JDK).

## RUN apt-get update && apt-get install build-essential maven default-jdk cowsay netcat -y && update-alternatives --config javac
Esta linha está executando uma série de comandos que atualizam os pacotes existentes e instalam alguns novos. Aqui estão os detalhes:

- `apt-get update` atualiza a lista de pacotes disponíveis.
- `apt-get install build-essential maven default-jdk cowsay netcat -y` instala uma série de pacotes. `build-essential` contém uma lista de pacotes que são considerados essenciais para compilar software. `maven` é uma ferramenta para gerenciamento e entendimento de projetos de software. `default-jdk` é um pacote que instala o Java Development Kit. `cowsay` é um programa que gera imagens ASCII de uma vaca com uma mensagem. `netcat` é uma ferramenta de rede útil para ler e escrever dados através de conexões de rede. O `-y` no final automaticamente confirma todas as prompts que podem aparecer durante a instalação.
- `update-alternatives --config javac` configura as alternativas para o compilador Java (`javac`).

## COPY . .
Esta linha está copiando todos os arquivos do diretório atual no host para o diretório de trabalho atual na imagem Docker.

## CMD ["mvn", "spring-boot:run"]
Esta linha define o comando que será executado quando um contêiner for iniciado a partir desta imagem Docker. Neste caso, está executando o comando `mvn spring-boot:run`, que inicia a aplicação Spring Boot.