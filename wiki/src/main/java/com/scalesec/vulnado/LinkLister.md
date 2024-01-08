Português

```markdown
# Documentação do Código

## Pacote e Importações 

O código pertence ao pacote `com.scalesec.vulnado`. Ele importa várias classes e pacotes, incluindo o pacote `org.jsoup` que é uma biblioteca em Java para trabalhar com HTML real e fornecer extração e manipulação de dados usando DOM, CSS e métodos jquery-like.

```java
package com.scalesec.vulnado;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.net.*;
```

## Classe LinkLister 

A classe `LinkLister` contém dois métodos públicos estáticos - `getLinks` e `getLinksV2`.

```java
public class LinkLister {
    ...
}
```

### Método getLinks

O método `getLinks` recebe uma URL como string, conecta-se a ela e extrai todos os links presentes na página HTML. Ele retorna uma lista de strings, onde cada string é uma URL absoluta para um link encontrado na página.

```java
public static List<String> getLinks(String url) throws IOException {
    List<String> result = new ArrayList<String>();
    Document doc = Jsoup.connect(url).get();
    Elements links = doc.select("a");
    for (Element link : links) {
        result.add(link.absUrl("href"));
    }
    return result;
}
```

### Método getLinksV2

O método `getLinksV2` é uma versão aprimorada do método `getLinks`. Ele recebe uma URL como string e verifica se o host da URL começa com "172.", "192.168" ou "10.". Se for verdade, uma exceção `BadRequest` é lançada, informando que o uso de IP privado não é permitido. Caso contrário, ele chama o método `getLinks` e retorna o resultado.

```java
public static List<String> getLinksV2(String url) throws BadRequest {
    try {
        URL aUrl= new URL(url);
        String host = aUrl.getHost();
        System.out.println(host);
        if (host.startsWith("172.") || host.startsWith("192.168") || host.startsWith("10.")){
            throw new BadRequest("Use of Private IP");
        } else {
            return getLinks(url);
        }
    } catch(Exception e) {
        throw new BadRequest(e.getMessage());
    }
}
```
```