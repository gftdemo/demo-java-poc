package com.scalesec.vulnado;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cowsay {

  private static final Logger logger = LogManager.getLogger(Cowsay.class);
  
  private Cowsay() {
    // private constructor to hide public one
  }

  public static String run(String input) {
    // sanitize input
    input = input.replaceAll("[^a-zA-Z0-9 ]", "");
    
    ProcessBuilder processBuilder = new ProcessBuilder();
    String cmd = "/usr/games/cowsay '" + input + "'";

    // log command instead of printing
    logger.info(cmd); 

    processBuilder.command("bash", "-c", cmd);

    StringBuilder output = new StringBuilder();

    try {
      Process process = processBuilder.start();
      BufferedReader reader = 
          new BufferedReader(new InputStreamReader(process.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line + "\n");
      }
    } catch (Exception e) {
      logger.error("Error running cowsay", e);
    }
    return output.toString();
  }
}