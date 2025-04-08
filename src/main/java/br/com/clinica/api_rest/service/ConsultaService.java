package br.com.clinica.api_rest.service;

import br.com.clinica.api_rest.dto.ConsultaRequest;
import br.com.clinica.api_rest.dto.ConsultaResponse;
import br.com.clinica.api_rest.entity.Cliente;
import br.com.clinica.api_rest.entity.Consulta;
import br.com.clinica.api_rest.entity.Medico;
import br.com.clinica.api_rest.mapper.ConsultaMapper;
import br.com.clinica.api_rest.repository.ClienteRepository;
import br.com.clinica.api_rest.repository.ConsultaRepository;
import br.com.clinica.api_rest.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import br.com.clinica.api_rest.controller.ConsultaController;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public List<ConsultaResponse> findAll() {
        return consultaRepository.findAll().stream()
                .map(ConsultaMapper::toResponse)
                .peek(c -> c.add(linkTo(methodOn(ConsultaController.class).findById(c.getId())).withSelfRel()))
                .collect(Collectors.toList());
    }

    public ConsultaResponse findById(Long id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow();
        ConsultaResponse dto = ConsultaMapper.toResponse(consulta);
        dto.add(linkTo(methodOn(ConsultaController.class).findById(id)).withSelfRel());
        return dto;
    }

    public ConsultaResponse create(ConsultaRequest request) {
        Cliente cliente = clienteRepository.findById(request.getClienteId()).orElseThrow();
        Medico medico = medicoRepository.findById(request.getMedicoId()).orElseThrow();

        Consulta consulta = ConsultaMapper.toEntity(request, cliente, medico);
        consultaRepository.save(consulta);

        return ConsultaMapper.toResponse(consulta);
    }

    public void delete(Long id) {
        consultaRepository.deleteById(id);
    }
}
