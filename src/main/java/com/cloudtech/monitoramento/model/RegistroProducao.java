package com.cloudtech.monitoramento.model;

public record RegistroProducao(Long maquinaId, Double consumoKw, String horarioAcionamento, Integer pecasProduzidas) {
}
