package com.cloudtech.monitoramento;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class EndpointsTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void paginaInicial() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.mensagem").exists());
	}

	@Test
	void statusDaAplicacao() throws Exception {
		mockMvc.perform(get("/status"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("online"))
				.andExpect(jsonPath("$.mensagem").value("Aplicação de monitoramento em execução"));
	}

	@Test
	void versaoDaAplicacao() throws Exception {
		mockMvc.perform(get("/versao"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.versao").exists());
	}

	@Test
	void cadastroEListagemDeMaquinas() throws Exception {
		mockMvc.perform(post("/maquinas/cadastro")
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
								{
								  "nome": "Máquina CNC 01",
								  "tipo": "CNC",
								  "setor": "Usinagem",
								  "status": "em operação"
								}
								"""))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").isNumber())
				.andExpect(jsonPath("$.nome").value("Máquina CNC 01"));

		mockMvc.perform(get("/maquinas"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray());
	}

	@Test
	void registroEConsultaDeProducao() throws Exception {
		mockMvc.perform(post("/maquinas/cadastro")
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
								{
								  "nome": "Máquina CNC 02",
								  "tipo": "CNC",
								  "setor": "Usinagem",
								  "status": "em operação"
								}
								"""))
				.andExpect(status().isCreated());

		mockMvc.perform(post("/producao")
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
								{
								  "maquinaId": 1,
								  "consumoKw": 12.5,
								  "horarioAcionamento": "08:30",
								  "pecasProduzidas": 150
								}
								"""))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.pecasProduzidas").value(150));

		mockMvc.perform(get("/producao"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray());
	}

}
