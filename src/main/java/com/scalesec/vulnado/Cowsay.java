package com.scalesec.vulnado;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger; // Incluido por GFT AI Impact Bot

public class Cowsay {
  private static final Logger logger = Logger.getLogger(Cowsay.class.getName()); // Incluido por GFT AI Impact Bot

  private Cowsay() { // Incluido por GFT AI Impact Bot
    // Construtor privado para ocultar o público implícito
  }

  public static String run(String input) {
    ProcessBuilder processBuilder = new ProcessBuilder();
    String cmd = "/usr/games/cowsay '" + input + "'";

    // Substituído System.out por logger
    logger.info(cmd); // Alterado por GFT AI Impact Bot

    // Certifique-se de que o argumento do comando controlado pelo usuário não leve a um comportamento indesejado
    if (input == null || input.contains(";") || input.contains("&") || input.contains("|")) { // Incluido por GFT AI Impact Bot
      return "Invalid command"; // Incluido por GFT AI Impact Bot
    }

    processBuilder.command("bash", "-c", cmd);

    StringBuilder output = new StringBuilder();

    try {
      Process process = processBuilder.start();
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line + "\n");
      }
    } catch (Exception e) {
      logger.severe(e.getMessage()); // Alterado por GFT AI Impact Bot
    }
    return output.toString();
  }
}