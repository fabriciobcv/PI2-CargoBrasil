# Sistema de Orçamento e Rastreio da transportadora CargoBrasil

O projeto consiste em uma **API Rest** utilizando Springboot para funcionários e clientes da empresa CargoBrasil, **com testes de carga utilizando o [k6](https://k6.io/)**


## Testes de carga com k6

## Serviço 1: POST /orcamento
**Tipo de operação:** inserção (escrita)
- **Arquivos envolvidos:**
    - [`src/main/java/.../api/OrcamentoController.java`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/app/src/main/java/com/pi2/cargobrasil/api/OrcamentoController.java)
    - [`src/main/java/.../service/OrcamentoService.java`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/app/src/main/java/com/pi2/cargobrasil/service/OrcamentoService.java)
    - [`src/main/java/.../domain/Orcamento.java`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/app/src/main/java/com/pi2/cargobrasil/domain/Orcamento.java)
    - [`src/main/java/.../domain/dto/OrcamentoDTO.java`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/app/src/main/java/com/pi2/cargobrasil/domain/dto/OrcamentoDTO.java)
    - [`src/main/java/.../api/OrcamentoConverter.java`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/app/src/main/java/com/pi2/cargobrasil/api/OrcamentoConverter.java)

- **Código de medição:**
    - [`/k6/orcamento-post-test.js`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/k6/orcamento-post-test.js)
    - [`/k6/orcamento-post.html`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/k6/orcamento-post.html)
- **Data da medição:** 29/06/2025
- **Configurações utilizadas:**
    - Máquina local: Windows 10, 16GB RAM, Java 17, Spring Boot 3, porta 8080
    - Banco de dados H2 Local
    - 10 → 20 usuários simultâneos, carga por 40 segundos

### Métricas:
- **Latência média:** 1.1 ms
- **Vazão:** 11.25 req/s
- **Concorrência máxima:** 20 VUs
- **Gráfico completo:** [orcamento-post.html](https://fabriciobcv.github.io/PI2-CargoBrasil/k6/orcamento-post.html)


### Duração Média das Requisições
![Request Duration POST](k6/images/post/RequestDuration.png)

### Tempo Médio Bloqueado
![Request Blocked POST](k6/images/post/RequestBlocked.png)

### Vazão de Requisições
![Request Rate POST](k6/images/post/RequestRate.png)

### Tempo Médio de Espera
![Request Waiting POST](k6/images/post/RequestWaiting.png)

### Requisições X Usuários simultâneos(VUs)
![VUs POST](k6/images/post/VUs.png)

## Serviço 2: GET /orcamento
**Tipo de operação:** leitura
- **Arquivos envolvidos:**
  - [`src/main/java/.../api/OrcamentoController.java`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/app/src/main/java/com/pi2/cargobrasil/api/OrcamentoController.java)
  - [`src/main/java/.../service/OrcamentoService.java`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/app/src/main/java/com/pi2/cargobrasil/service/OrcamentoService.java)
  - [`src/main/java/.../domain/Orcamento.java`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/app/src/main/java/com/pi2/cargobrasil/domain/Orcamento.java)
  - [`src/main/java/.../domain/dto/OrcamentoDTO.java`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/app/src/main/java/com/pi2/cargobrasil/domain/dto/OrcamentoDTO.java)
  - [`src/main/java/.../api/OrcamentoConverter.java`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/app/src/main/java/com/pi2/cargobrasil/api/OrcamentoConverter.java)

- **Código de medição:**
  - [`/k6/orcamentos-get-test.js`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/k6/orcamentos-get-test.js)
  - [`/k6/orcamentos-get.html`](https://github.com/fabriciobcv/PI2-CargoBrasil/blob/main/k6/orcamentos-get.html)
- **Data da medição:** 29/06/2025
- **Configurações utilizadas:**
  - Máquina local: Windows 10, 16GB RAM, Java 17, Spring Boot 3, porta 8080
  - Banco de dados H2 Local
  - 10 → 20 usuários simultâneos, carga por 40 segundos

### Métricas:
- **Latência média:** 4.46 ms
- **Vazão:** 22.21 req/s
- **Concorrência máxima:** 20 VUs
- **Gráfico completo:** [orcamentos-get.html](https://fabriciobcv.github.io/PI2-CargoBrasil/k6/orcamentos-get.html)

### Duração Média das Requisições
![Request Duration GET](k6/images/get/RequestDuration.png)

### Tempo Médio Bloqueado
![Request Blocked GET](k6/images/get/RequestBlocked.png)

### Vazão de Requisições
![Request Rate GET](k6/images/get/RequestRate.png)

### Tempo Médio de Espera
![Request Waiting GET](k6/images/get/RequestWaiting.png)

### Requisições X Usuários simultâneos(VUs)
![VUs GET](k6/images/get/VUs.png)