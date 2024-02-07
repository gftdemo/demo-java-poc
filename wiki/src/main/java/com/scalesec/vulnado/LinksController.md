Português.

# Documentação do Código

## Pacote: com.scalesec.vulnado

Este pacote contém as classes e os métodos necessários para o funcionamento do projeto Vulnado.

## Importações

O código importa várias classes e interfaces do framework Spring Boot, que é usado para simplificar o desenvolvimento de aplicações Java. Além disso, importa classes de I/O para manipulação de dados.

## Classe: LinksController

Esta é uma classe controladora do Spring Boot, que manipula as solicitações HTTP que chegam ao servidor.

### Anotações

- `@RestController`: esta anotação é usada para marcar essa classe como uma controladora de serviço REST. Com isso, a classe pode processar solicitações HTTP e enviar respostas.
  
- `@EnableAutoConfiguration`: esta anotação informa ao Spring Boot para configurar automaticamente o aplicativo com base nas dependências do pom.xml.

### Métodos

#### links

- `@RequestMapping(value = "/links", produces = "application/json")`: esta anotação mapeia solicitações HTTP GET para o caminho "/links" para o método links(). Produz uma resposta no formato JSON.

- Parâmetro: `@RequestParam String url`: é uma anotação usada para indicar que o valor do parâmetro deve ser obtido da string de consulta da solicitação HTTP. Neste caso, o método espera receber uma URL como parâmetro.

- Retorno: `List<String>`: o método retorna uma lista de strings.

- Exceções: `throws IOException`: este método pode lançar uma exceção do tipo IOException. 

- Funcionalidade: Este método usa a classe LinkLister para obter uma lista de links a partir da URL fornecida.

#### linksV2

- `@RequestMapping(value = "/links-v2", produces = "application/json")`: esta anotação mapeia solicitações HTTP GET para o caminho "/links-v2" para o método linksV2(). Produz uma resposta no formato JSON.

- Parâmetro: `@RequestParam String url`: semelhante ao método links, este método também espera receber uma URL como parâmetro.

- Retorno: `List<String>`: o método retorna uma lista de strings.

- Exceções: `throws BadRequest`: este método pode lançar uma exceção do tipo BadRequest.

- Funcionalidade: Este método usa a classe LinkLister para obter uma lista de links a partir da URL fornecida. Este método é uma versão alternativa do método links.