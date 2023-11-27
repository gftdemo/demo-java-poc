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
  // Make sure allowing safe and unsafe HTTP methods is safe here.
  // Added RequestMethod.GET to limit the HTTP methods allowed
  @RequestMapping(value = "/links", method = RequestMethod.GET, produces = "application/json") // Alterado por GFT AI Impact Bot
  List<String> links(@RequestParam String url) throws IOException{
    return LinkLister.getLinks(url);
  }

  // Make sure allowing safe and unsafe HTTP methods is safe here.
  // Added RequestMethod.GET to limit the HTTP methods allowed
  @RequestMapping(value = "/links-v2", method = RequestMethod.GET, produces = "application/json") // Alterado por GFT AI Impact Bot
  List<String> linksV2(@RequestParam String url) throws BadRequest{
    return LinkLister.getLinksV2(url);
  }
}