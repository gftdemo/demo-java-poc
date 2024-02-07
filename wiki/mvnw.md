# Documentação do Código

Este código é um script em lote para inicializar o Maven, uma ferramenta de automação de compilação para projetos Java. Ele é licenciado pela Apache Software Foundation sob a licença Apache 2.0.

## Licença

Este código é licenciado sob a [Apache License, Versão 2.0](http://www.apache.org/licenses/LICENSE-2.0). Você pode usar este arquivo de acordo com a licença. Por favor, consulte o arquivo NOTICE para mais informações sobre a propriedade dos direitos autorais.

## Variáveis de Ambiente

Este script precisa das seguintes variáveis de ambiente:

- `JAVA_HOME`: O diretório onde o JDK está instalado.
- `M2_HOME`: (opcional) O diretório onde o Maven está instalado.
- `MAVEN_BATCH_ECHO`: (opcional) Se definido como 'on', o script irá ecoar os comandos em lote.
- `MAVEN_BATCH_PAUSE`: (opcional) Se definido como 'on', o script irá pausar antes de terminar.
- `MAVEN_OPTS`: (opcional) Parâmetros a serem passados para a JVM ao executar o Maven.
- `MAVEN_SKIP_RC`: (opcional) Se definido, o script irá ignorar o carregamento dos arquivos mavenrc.

## Validação

O script verifica se `JAVA_HOME` está definido e aponta para um diretório válido que contém `java.exe`. Se `JAVA_HOME` não for encontrado ou for inválido, o script irá terminar com um erro.

## Configuração do Projeto

O script procura o diretório base do projeto, ou seja, o diretório que contém a pasta `.mvn`. Se não for encontrado, ele usará o diretório de trabalho atual como base do projeto.

## Download Automático

Este script tem uma extensão para permitir o download automático do `maven-wrapper.jar` do Maven-central. Isso permite o uso do maven wrapper em projetos que proíbem o check-in de dados binários.

## Execução do Maven

Finalmente, o script executa o Maven com as opções e configurações especificadas. Se ocorrer um erro durante a execução do Maven, o script terminará com o mesmo código de erro.

## Pós-execução

Depois de executar o Maven, o script verifica a existência de um script pós-execução e o executa se existir. O script também irá pausar se `MAVEN_BATCH_PAUSE` for definido como 'on'.