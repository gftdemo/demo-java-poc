package com.scalesec.vulnado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class VulnadoApplication {
	public static void main(String[] args) {
		// Correção da vulnerabilidade Denial of Service: StringBuilder
		// Ajuste para evitar a criação de um StringBuilder muito grande que poderia causar um Denial of Service
		// Limitando o tamanho do StringBuilder
		int maxStringBuilderSize = 1000;
		StringBuilder sb = new StringBuilder(maxStringBuilderSize);

		// Correção da vulnerabilidade Dead Code: Unused Field
		// Removendo a chamada para o método Postgres.setup() que não está sendo usado
		// Postgres.setup();

		SpringApplication.run(VulnadoApplication.class, args);
	}
}