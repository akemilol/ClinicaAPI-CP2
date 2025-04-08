package br.com.clinica.api_rest.controller;

import br.com.clinica.api_rest.dto.EspecialidadeRequest;
import br.com.clinica.api_rest.dto.EspecialidadeResponse;
import br.com.clinica.api_rest.service.EspecialidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @GetMapping
    public List<EspecialidadeResponse> findAll() {
        return especialidadeService.findAll();
    }

    @GetMapping("/{id}")
    public EspecialidadeResponse findById(@PathVariable Long id) {
        return especialidadeService.findById(id);
    }

    @PostMapping
    public EspecialidadeResponse create(@RequestBody @Valid EspecialidadeRequest request) {
        return especialidadeService.create(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        especialidadeService.delete(id);
    }
}
