package com.cloudtech.monitoramento.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public Map<String, String> paginaInicial() {
		return Map.of("mensagem", "Bem-vindo ao sistema de monitoramento de máquinas da CloudTech Solutions");
	}

}
