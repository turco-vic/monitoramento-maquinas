# Monitoramento de Máquinas - CloudTech Solutions

Aplicação em Java Spring Boot para cadastro, consulta e acompanhamento de dados das máquinas monitoradas.

## Endpoints

| Endpoint | Descrição |
|----------|-----------|
| `GET /` | Página inicial |
| `GET /status` | Status da aplicação |
| `GET /maquinas` | Listagem de máquinas |
| `POST /maquinas/cadastro` | Cadastro de máquinas |
| `POST /producao` / `GET /producao` | Registro ou consulta de produção |
| `GET /versao` | Versão da aplicação |

## Como executar

```bash
./mvnw spring-boot:run
```

A aplicação sobe em `http://localhost:8080`.

## Testes

```bash
./mvnw test
```
