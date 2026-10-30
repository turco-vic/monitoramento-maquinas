package com.cloudtech.monitoramento.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.cloudtech.monitoramento.model.Maquina;

@Service
public class MaquinaService {

	private final List<Maquina> maquinas = new CopyOnWriteArrayList<>();
	private final AtomicLong proximoId = new AtomicLong(1);

	public Maquina cadastrar(Maquina dados) {
		Maquina maquina = new Maquina(proximoId.getAndIncrement(), dados.nome(), dados.tipo(), dados.setor(),
				dados.status());
		maquinas.add(maquina);
		return maquina;
	}

	public List<Maquina> listar() {
		return maquinas;
	}

	public boolean existe(Long id) {
		return maquinas.stream().anyMatch(maquina -> maquina.id().equals(id));
	}

}
