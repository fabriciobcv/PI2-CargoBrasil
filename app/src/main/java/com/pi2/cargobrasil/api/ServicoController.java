package com.pi2.cargobrasil.api;

import com.pi2.cargobrasil.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servico")
public class ServicoController {
    @Autowired
    private ServicoService service;
}
