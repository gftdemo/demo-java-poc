Português

# Documentação do Código

Este código é um script de inicialização do Maven2 escrito em batch script. Ele é responsável por preparar e iniciar um ambiente Maven no Windows.

## Licença

Este código é licenciado sob a Licença Apache, Versão 2.0. Você pode obtê-la em: http://www.apache.org/licenses/LICENSE-2.0.

## Variáveis de Ambiente

O script requer as seguintes variáveis de ambiente:

- `JAVA_HOME` - caminho para o diretório home do JDK.
- `M2_HOME` (opcional) - caminho para o diretório home do Maven2.
- `MAVEN_BATCH_ECHO` (opcional) - ativa o eco dos comandos em lote se definido como 'on'.
- `MAVEN_BATCH_PAUSE` (opcional) - pausa o script no final se definido como 'on'.
- `MAVEN_OPTS` (opcional) - parâmetros passados para a JVM ao executar o Maven.
- `MAVEN_SKIP_RC` (opcional) - desativa o carregamento de arquivos mavenrc se definido como 'on'.

## Funcionamento do Script

Inicialmente, o script verifica a existência e a validade do diretório `JAVA_HOME`. Se `JAVA_HOME` não for encontrado ou for inválido, o script terminará com um erro.

Em seguida, o script tenta encontrar o diretório base do projeto, que é o diretório que contém a pasta `.mvn`. Se não for encontrado, o diretório de trabalho atual é usado.

Após isso, o script verifica a existência de um arquivo `jvm.config` no diretório base do projeto. Se existir, ele lê as configurações adicionais da JVM deste arquivo.

Depois, o script define `MAVEN_JAVA_EXE` como o executável java no `JAVA_HOME` e `WRAPPER_JAR` como o arquivo maven-wrapper.jar no diretório base do projeto.

O script então verifica a existência do `WRAPPER_JAR`. Se não existir, ele baixa o arquivo `maven-wrapper.jar` do Maven-central.

Finalmente, o script executa o Maven com todas as propriedades e opções coletadas durante a execução do script.

## Tratamento de Erros

Se qualquer erro ocorrer durante a execução do script (como `JAVA_HOME` não encontrado ou inválido, erro ao executar o Maven, etc.), o script terminará com o código de erro 1. Caso contrário, o script terminará normalmente.