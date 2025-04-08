package br.com.clinica.api_rest.service;

import br.com.clinica.api_rest.controller.MedicoController;
import br.com.clinica.api_rest.dto.MedicoRequest;
import br.com.clinica.api_rest.dto.MedicoResponse;
import br.com.clinica.api_rest.entity.Especialidade;
import br.com.clinica.api_rest.entity.Medico;
import br.com.clinica.api_rest.mapper.MedicoMapper;
import br.com.clinica.api_rest.repository.EspecialidadeRepository;
import br.com.clinica.api_rest.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public List<MedicoResponse> findAll() {
        return medicoRepository.findAll().stream()
                .map(MedicoMapper::toResponse)
                .peek(medico -> medico.add(linkTo(methodOn(MedicoController.class).findById(medico.getId())).withSelfRel()))
                .collect(Collectors.toList());
    }

    public MedicoResponse findById(Long id) {
        Medico medico = medicoRepository.findById(id).orElseThrow();
        MedicoResponse dto = MedicoMapper.toResponse(medico);
        dto.add(linkTo(methodOn(MedicoController.class).findById(id)).withSelfRel());
        return dto;
    }

    public MedicoResponse create(MedicoRequest request) {
        List<Especialidade> especialidades = especialidadeRepository.findAllById(request.getEspecialidadeIds());
        Medico medico = MedicoMapper.toEntity(request, especialidades);
        medicoRepository.save(medico);
        return MedicoMapper.toResponse(medico);
    }

    public void delete(Long id) {
        medicoRepository.deleteById(id);
    }
}
