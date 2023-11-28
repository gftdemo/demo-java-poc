package com.scalesec.vulnado;

// Removed unused imports
// import org.springframework.boot.*;
// import org.springframework.http.HttpStatus;
// import java.io.Serializable;

import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.*;
import java.util.List;
import java.io.IOException;

@RestController
@EnableAutoConfiguration
public class LinksController {
  @RequestMapping(value = "/links", method = RequestMethod.GET, produces = "application/json") // Alterado por GFT AI Impact Bot: Added method = RequestMethod.GET to ensure only safe HTTP methods are allowed
  List<String> links(@RequestParam String url) throws IOException{
    return LinkLister.getLinks(url);
  }
  @RequestMapping(value = "/links-v2", method = RequestMethod.GET, produces = "application/json") // Alterado por GFT AI Impact Bot: Added method = RequestMethod.GET to ensure only safe HTTP methods are allowed
  List<String> linksV2(@RequestParam String url) throws BadRequest{
    return LinkLister.getLinksV2(url);
  }
}