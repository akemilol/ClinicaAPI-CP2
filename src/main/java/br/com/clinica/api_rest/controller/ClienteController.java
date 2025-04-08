package br.com.clinica.api_rest.controller;

import br.com.clinica.api_rest.dto.ClienteRequest;
import br.com.clinica.api_rest.dto.ClienteResponse;
import br.com.clinica.api_rest.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteResponse> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ClienteResponse findById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public ClienteResponse create(@RequestBody @Valid ClienteRequest request) {
        return clienteService.create(request);
    }

    @PutMapping("/{id}")
    public ClienteResponse update(@PathVariable Long id, @RequestBody @Valid ClienteRequest request) {
        return clienteService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteService.delete(id);
    }
}
