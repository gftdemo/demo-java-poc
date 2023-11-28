package com.scalesec.vulnado;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger; // Incluido por GFT AI Impact Bot

public class Cowsay {
  private static final Logger LOGGER = Logger.getLogger(Cowsay.class.getName()); // Incluido por GFT AI Impact Bot

  private Cowsay() { // Incluido por GFT AI Impact Bot
    // Private constructor to hide the implicit public one
  }

  public static String run(String input) {
    ProcessBuilder processBuilder = new ProcessBuilder();
    // Make sure the "PATH" used to find this command includes only what you intend
    String cmd = "/usr/games/cowsay '" + input + "'"; // Alterado por GFT AI Impact Bot

    // Replace this use of System.out by a logger
    LOGGER.info(cmd); // Alterado por GFT AI Impact Bot

    // Make sure that this user-controlled command argument doesn't lead to unwanted behavior
    processBuilder.command("bash", "-c", cmd); // Alterado por GFT AI Impact Bot

    StringBuilder output = new StringBuilder();

    try {
      Process process = processBuilder.start();
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line + "\n");
      }
    } catch (Exception e) {
      LOGGER.severe(e.getMessage()); // Alterado por GFT AI Impact Bot
    }
    // Make sure this debug feature is deactivated before delivering the code in production
    return output.toString(); // Alterado por GFT AI Impact Bot
  }
}