package com.pi2.cargobrasil.api;

import com.pi2.cargobrasil.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orcamento")
public class OrcamentoController {
    @Autowired
    private OrcamentoService service;
}
