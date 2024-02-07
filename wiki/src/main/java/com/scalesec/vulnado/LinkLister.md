Português

# Documentação do Código

Este código é parte do pacote `com.scalesec.vulnado`. Ele importa várias classes, incluindo `org.jsoup.Jsoup`, `org.jsoup.nodes.Document`, `org.jsoup.nodes.Element`, `org.jsoup.select.Elements`, `java.util.ArrayList`, `java.util.List`, `java.io.IOException` e `java.net.*`.

A classe principal é `LinkLister` que possui dois métodos: `getLinks` e `getLinksV2`.

## Método `getLinks`

O método `getLinks` recebe uma string `url` como parâmetro e retorna uma lista de strings. Essa lista contém todos os links absolutos (absUrl) encontrados na página da web associada à URL passada como parâmetro. 

A classe `Jsoup` é usada para conectar-se à URL e obter o documento HTML associado. Então, usando o método `select("a")`, todos os elementos `<a>` (links) são selecionados. Cada link encontrado é adicionado à lista `result` que será retornada ao final do método.

## Método `getLinksV2`

O método `getLinksV2` também recebe uma string `url` como parâmetro, mas antes de retornar os links encontrados, ele verifica se a URL pertence a uma rede IP privada. Se a URL pertencer a uma rede IP privada (começando com "172.", "192.168" ou "10."), uma exceção `BadRequest` é lançada com a mensagem "Use of Private IP". 

Se a URL não pertencer a uma rede IP privada, o método `getLinks` é chamado e seus resultados são retornados.

Se ocorrer qualquer outra exceção durante a execução do método, uma exceção `BadRequest` é lançada com a mensagem da exceção original.

Essa classe é útil para listar todos os links em uma página da web e pode ser usada para rastrear todos os links de um site ou para verificar se uma página específica contém algum link quebrado. A verificação de redes IP privadas no método `getLinksV2` ajuda a prevenir a exploração de vulnerabilidades de SSRF (Server Side Request Forgery).