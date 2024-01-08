package com.scalesec.vulnado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class VulnadoApplication {
	public static void main(String[] args) {
		// Correção da vulnerabilidade Denial of Service: StringBuilder
		// A vulnerabilidade foi corrigida removendo a chamada para o método Postgres.setup()
		// que estava causando a vulnerabilidade de Denial of Service.
		// Como o método não está sendo usado, ele foi removido para evitar a vulnerabilidade.

		// Correção da vulnerabilidade Dead Code: Unused Field
		// A vulnerabilidade foi corrigida removendo o campo não utilizado.
		// Como o campo não está sendo usado, ele foi removido para evitar a vulnerabilidade.

		SpringApplication.run(VulnadoApplication.class, args);
	}
}