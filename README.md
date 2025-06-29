# MEDIÇÕES DO SLA

## Serviço 1: POST /orcamento
**Tipo de operação:** inserção (escrita)
- **Arquivos envolvidos:**
    - [`src/main/java/.../api/OrcamentoController.java`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/app/src/main/java/com/pi2/cargobrasil/api/OrcamentoController.java)
    - [`src/main/java/.../service/OrcamentoService.java`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/app/src/main/java/com/pi2/cargobrasil/service/OrcamentoService.java)
    - [`src/main/java/.../domain/Orcamento.java`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/app/src/main/java/com/pi2/cargobrasil/domain/Orcamento.java)
    - [`src/main/java/.../domain/dto/OrcamentoDTO.java`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/app/src/main/java/com/pi2/cargobrasil/domain/dto/OrcamentoDTO.java)
    - [`src/main/java/.../api/OrcamentoConverter.java`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/app/src/main/java/com/pi2/cargobrasil/api/OrcamentoConverter.java)

- **Código de medição:**
    - [`/k6/orcamento-test.js`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/k6/orcamento-test-.js)
    - [`/k6/orcamento_post.html`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/k6/orcamento_post.html)
- **Data da medição:** 29/06/2025
- **Configurações utilizadas:**
    - Máquina local: Windows 10, 16GB RAM, Java 17, Spring Boot 3, porta 8080
    - Banco de dados H2 Local
    - 10 → 20 usuários simultâneos, carga por 40 segundos

### Métricas:
- **Latência média:** XX ms
- **Vazão:** XX req/s
- **Concorrência máxima:** 20 VUs
- **Gráfico:** [orcamento_post.html](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/k6/orcamento_post.html)

## Serviço 2: GET /servico/list
**Tipo de operação:** leitura
- **Arquivos envolvidos:**
  - [`src/main/java/.../api/OrcamentoController.java`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/app/src/main/java/com/pi2/cargobrasil/api/OrcamentoController.java)
 
- **Código de medição:**
  - [`/k6/servicos-test.js`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/k6/servicos-test-.js)
  - [`/k6/servicos_get.html`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/k6/servicos_get.html)
- **Data da medição:** 29/06/2025
- **Configurações utilizadas:**
  - Máquina local: Windows 10, 16GB RAM, Java 17, Spring Boot 3, porta 8080
  - Banco de dados H2 Local
  - 10 → 20 usuários simultâneos, carga por 40 segundos

### Métricas:
- **Latência média:** XX ms
- **Vazão:** XX req/s
- **Concorrência máxima:** 20 VUs
- **Gráfico:** [servicos_get.html](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/k6/servicos_get.html)