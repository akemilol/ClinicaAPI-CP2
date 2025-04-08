package br.com.clinica.api_rest.service;

import br.com.clinica.api_rest.controller.ClienteController;
import br.com.clinica.api_rest.dto.ClienteRequest;
import br.com.clinica.api_rest.dto.ClienteResponse;
import br.com.clinica.api_rest.entity.Cliente;
import br.com.clinica.api_rest.mapper.ClienteMapper;
import br.com.clinica.api_rest.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<ClienteResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(ClienteMapper::toResponse)
                .peek(c -> c.add(linkTo(methodOn(ClienteController.class).findById(c.getId())).withSelfRel()))
                .collect(Collectors.toList());
    }

    public ClienteResponse findById(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow();
        ClienteResponse dto = ClienteMapper.toResponse(cliente);
        dto.add(linkTo(methodOn(ClienteController.class).findById(id)).withSelfRel());
        return dto;
    }

    public ClienteResponse create(ClienteRequest request) {
        Cliente cliente = ClienteMapper.toEntity(request);
        repository.save(cliente);
        return ClienteMapper.toResponse(cliente);
    }

    public ClienteResponse update(Long id, ClienteRequest request) {
        Cliente cliente = repository.findById(id).orElseThrow();
        cliente.setNome(request.getNome());
        cliente.setEmail(request.getEmail());
        cliente.setCpf(request.getCpf());
        cliente.setDataNascimento(request.getDataNascimento());
        cliente.setTelefone(request.getTelefone());
        return ClienteMapper.toResponse(repository.save(cliente));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
