package br.com.clinica.api_rest.controller;

import br.com.clinica.api_rest.dto.ConsultaRequest;
import br.com.clinica.api_rest.dto.ConsultaResponse;
import br.com.clinica.api_rest.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public List<ConsultaResponse> findAll() {
        return consultaService.findAll();
    }

    @GetMapping("/{id}")
    public ConsultaResponse findById(@PathVariable Long id) {
        return consultaService.findById(id);
    }

    @PostMapping
    public ConsultaResponse create(@RequestBody @Valid ConsultaRequest request) {
        return consultaService.create(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        consultaService.delete(id);
    }
}
