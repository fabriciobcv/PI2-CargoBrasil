package com.pi2.cargobrasil.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Servico {
    private Long id;
    private Produto produto;
    private Pagamento pagamento;
    private Status status;
    private Usuario remetente;
    private Usuario destinario;
    private Endereco enderecoBusca;
    private Endereco enderecoEntrega;
}
