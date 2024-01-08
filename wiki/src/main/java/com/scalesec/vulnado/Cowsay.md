Português.

# Documentação de Código

Este é um pacote Java chamado `com.scalesec.vulnado`.

## Classe Cowsay

Neste pacote, temos uma classe pública chamada `Cowsay` que possui um método estático chamado `run`.

### Método Run

O método `run` aceita uma entrada do tipo String e retorna uma String. A ideia deste método é executar o comando `cowsay` do Unix com a entrada fornecida e retornar a saída.

O método faz o seguinte:

1. Cria um `ProcessBuilder`, que é uma classe utilitária que pode ser usada para construir instâncias de `Process`.

2. Cria um comando `bash` que executa o `cowsay` com a entrada fornecida.

3. Imprime o comando na saída padrão para fins de depuração.

4. Configura o `ProcessBuilder` para executar o comando e inicia o processo.

5. Cria um `BufferedReader` que lê a saída do processo.

6. Lê cada linha da saída do processo e anexa à uma variável `StringBuilder` chamada `output`.

7. Se ocorrer uma exceção durante a execução do processo, imprime o rastreamento da pilha de exceções.

8. Retorna a saída do processo como uma String.

Note que este código é vulnerável à injeção de comandos do shell, pois a entrada do usuário é diretamente inserida no comando sem qualquer tipo de sanitização. Não é aconselhável usar tal abordagem em produção.