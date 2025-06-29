package com.pi2.cargobrasil.api;

import com.pi2.cargobrasil.domain.Orcamento;
import com.pi2.cargobrasil.domain.dto.OrcamentoDTO;
import com.pi2.cargobrasil.service.ServicoService;
import com.pi2.cargobrasil.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrcamentoConverter {

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private UsuarioService usuarioService;

    public OrcamentoDTO toDto(Orcamento orcamento){
        if(orcamento == null){
            return null;
        }
        OrcamentoDTO orcamentoDTO = new OrcamentoDTO();

        orcamentoDTO.setId(orcamento.getId());
        orcamentoDTO.setCustoEmbalagem(orcamento.getCustoEmbalagem());
        orcamentoDTO.setTaxaDesistencia(orcamento.getTaxaDesistencia());
        orcamentoDTO.setValor(orcamento.getValor());
        orcamentoDTO.setPrazo(orcamento.getPrazo());
        orcamentoDTO.setServicoId(orcamento.getServico().getId());
        orcamentoDTO.setFuncionarioOrcamentoId(orcamento.getFuncionarOrcamentoId().getId());

        return orcamentoDTO;
    }

    public Orcamento toEntity(OrcamentoDTO orcamentoDTO){
        if(orcamentoDTO == null){
            return null;
        }
        Orcamento orcamento = new Orcamento();

        orcamento.setId(orcamentoDTO.getId());
        orcamento.setCustoEmbalagem(orcamentoDTO.getCustoEmbalagem());
        orcamento.setTaxaDesistencia(orcamentoDTO.getTaxaDesistencia());
        orcamento.setValor(orcamentoDTO.getValor());
        orcamento.setPrazo(orcamentoDTO.getPrazo());
        orcamento.setServico(servicoService.findById(orcamentoDTO.getServicoId()).get());
        orcamento.setFuncionarOrcamentoId(usuarioService.findById(orcamentoDTO.getFuncionarioOrcamentoId()).get());

        return orcamento;
    }
}
