package br.com.clinica.api_rest.mapper;

import br.com.clinica.api_rest.dto.MedicoRequest;
import br.com.clinica.api_rest.dto.MedicoResponse;
import br.com.clinica.api_rest.entity.Medico;
import br.com.clinica.api_rest.entity.Especialidade;
import java.util.List;

import java.util.stream.Collectors;

public class MedicoMapper {

    public static Medico toEntity(MedicoRequest dto, List<Especialidade> especialidades) {
        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());
        medico.setTelefone(dto.getTelefone());
        medico.setEspecialidades(especialidades);
        return medico;
    }

    public static MedicoResponse toResponse(Medico medico) {
        MedicoResponse dto = new MedicoResponse();
        dto.setId(medico.getId());
        dto.setNome(medico.getNome());
        dto.setCrm(medico.getCrm());
        dto.setTelefone(medico.getTelefone());
        dto.setEspecialidades(medico.getEspecialidades().stream()
                .map(Especialidade::getNome)  // Aqui, se você tiver uma classe `Especialidade` com o nome da especialidade
                .collect(Collectors.toList()));
        return dto;
    }
}
