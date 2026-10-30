package com.cloudtech.monitoramento.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cloudtech.monitoramento.model.RegistroProducao;

@Service
public class ProducaoService {

	private final List<RegistroProducao> registros = new CopyOnWriteArrayList<>();
	private final MaquinaService maquinaService;

	public ProducaoService(MaquinaService maquinaService) {
		this.maquinaService = maquinaService;
	}

	public RegistroProducao registrar(RegistroProducao registro) {
		if (!maquinaService.existe(registro.maquinaId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Máquina não encontrada");
		}
		registros.add(registro);
		return registro;
	}

	public List<RegistroProducao> listar() {
		return registros;
	}

}
