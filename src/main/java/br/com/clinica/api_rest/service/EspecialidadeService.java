package br.com.clinica.api_rest.service;

import br.com.clinica.api_rest.controller.EspecialidadeController;
import br.com.clinica.api_rest.dto.EspecialidadeRequest;
import br.com.clinica.api_rest.dto.EspecialidadeResponse;
import br.com.clinica.api_rest.entity.Especialidade;
import br.com.clinica.api_rest.mapper.EspecialidadeMapper;
import br.com.clinica.api_rest.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Service
public class EspecialidadeService {

    @Autowired
    private EspecialidadeRepository repository;

    public List<EspecialidadeResponse> findAll() {
        return repository.findAll().stream()
                .map(EspecialidadeMapper::toResponse)
                .peek(e -> e.add(linkTo(methodOn(EspecialidadeController.class).findById(e.getId())).withSelfRel()))
                .collect(Collectors.toList());
    }

    public EspecialidadeResponse findById(Long id) {
        Especialidade especialidade = repository.findById(id).orElseThrow();
        EspecialidadeResponse dto = EspecialidadeMapper.toResponse(especialidade);
        dto.add(linkTo(methodOn(EspecialidadeController.class).findById(id)).withSelfRel());
        return dto;
    }

    public EspecialidadeResponse create(EspecialidadeRequest request) {
        Especialidade especialidade = EspecialidadeMapper.toEntity(request);
        repository.save(especialidade);
        return EspecialidadeMapper.toResponse(especialidade);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
