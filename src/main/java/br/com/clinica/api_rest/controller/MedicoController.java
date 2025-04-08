package br.com.clinica.api_rest.controller;

import br.com.clinica.api_rest.dto.MedicoRequest;
import br.com.clinica.api_rest.dto.MedicoResponse;
import br.com.clinica.api_rest.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<MedicoResponse> findAll() {
        return medicoService.findAll();
    }

    @GetMapping("/{id}")
    public MedicoResponse findById(@PathVariable Long id) {
        return medicoService.findById(id);
    }

    @PostMapping
    public MedicoResponse create(@RequestBody @Valid MedicoRequest request) {
        return medicoService.create(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        medicoService.delete(id);
    }
}
