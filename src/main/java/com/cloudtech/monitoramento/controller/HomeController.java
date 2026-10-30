package com.cloudtech.monitoramento.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	private final String versao;

	public HomeController(@Value("${app.versao}") String versao) {
		this.versao = versao;
	}

	@GetMapping("/")
	public Map<String, String> paginaInicial() {
		return Map.of("mensagem", "Bem-vindo ao sistema de monitoramento de máquinas da CloudTech Solutions");
	}

	// RF05 — Verificar status da aplicação
	@GetMapping("/status")
	public Map<String, String> status() {
		Map<String, String> resposta = new LinkedHashMap<>();
		resposta.put("status", "online");
		resposta.put("mensagem", "Aplicação de monitoramento em execução");
		return resposta;
	}

	@GetMapping("/versao")
	public Map<String, String> versao() {
		return Map.of("versao", versao);
	}

}
