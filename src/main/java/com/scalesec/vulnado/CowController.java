package com.scalesec.vulnado;

import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.*;

// Removido por GFT AI Impact Bot: import java.io.Serializable;

@RestController
@EnableAutoConfiguration
public class CowController {
    // Alterado por GFT AI Impact Bot: Adicionado o método HTTP GET para garantir que apenas métodos seguros sejam permitidos aqui.
    @RequestMapping(value = "/cowsay", method = RequestMethod.GET)
    String cowsay(@RequestParam(defaultValue = "I love Linux!") String input) {
        return Cowsay.run(input);
    }
}