package com.cloudtech.monitoramento.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cloudtech.monitoramento.model.RegistroProducao;
import com.cloudtech.monitoramento.service.ProducaoService;

@RestController
@RequestMapping("/producao")
public class ProducaoController {

	private final ProducaoService service;

	public ProducaoController(ProducaoService service) {
		this.service = service;
	}

	// RF02 — Registrar dados de produção
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RegistroProducao registrar(@RequestBody RegistroProducao registro) {
		return service.registrar(registro);
	}

	// RF04 — Consultar dados de produção
	@GetMapping
	public List<RegistroProducao> listar() {
		return service.listar();
	}

}
