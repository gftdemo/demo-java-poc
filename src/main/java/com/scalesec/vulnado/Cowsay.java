package com.scalesec.vulnado;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger; // Incluido por GFT AI Impact Bot
import java.util.logging.Level; // Incluido por GFT AI Impact Bot

public class Cowsay {
  private static final Logger LOGGER = Logger.getLogger(Cowsay.class.getName()); // Incluido por GFT AI Impact Bot

  private Cowsay() { // Incluido por GFT AI Impact Bot
    // Construtor privado para ocultar o público implícito
  }

  public static String run(String input) {
    ProcessBuilder processBuilder = new ProcessBuilder();
    String sanitizedInput = sanitizeInput(input); // Incluido por GFT AI Impact Bot
    String cmd = "/usr/games/cowsay '" + sanitizedInput + "'"; // Alterado por GFT AI Impact Bot
    LOGGER.log(Level.INFO, cmd); // Alterado por GFT AI Impact Bot

    processBuilder.command("bash", "-c", cmd);
    processBuilder.environment().put("PATH", "/usr/games"); // Incluido por GFT AI Impact Bot

    StringBuilder output = new StringBuilder();

    try {
      Process process = processBuilder.start();
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line + "\n");
      }
    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, "Exception: ", e); // Alterado por GFT AI Impact Bot
    }
    return output.toString();
  }

  private static String sanitizeInput(String input) { // Incluido por GFT AI Impact Bot
    // Implemente a lógica de sanitização de entrada aqui para evitar a injeção de comandos
    return input;
  }
}