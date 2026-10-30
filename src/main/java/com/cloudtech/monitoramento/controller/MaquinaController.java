package com.cloudtech.monitoramento.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cloudtech.monitoramento.model.Maquina;
import com.cloudtech.monitoramento.service.MaquinaService;

@RestController
@RequestMapping("/maquinas")
public class MaquinaController {

	private final MaquinaService service;

	public MaquinaController(MaquinaService service) {
		this.service = service;
	}

	// RF03 — Consultar máquinas cadastradas
	@GetMapping
	public List<Maquina> listar() {
		return service.listar();
	}

	// RF01 — Cadastrar máquina
	@PostMapping("/cadastro")
	@ResponseStatus(HttpStatus.CREATED)
	public Maquina cadastrar(@RequestBody Maquina maquina) {
		return service.cadastrar(maquina);
	}

}
