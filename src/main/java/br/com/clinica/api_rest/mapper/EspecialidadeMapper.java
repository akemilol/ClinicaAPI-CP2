package br.com.clinica.api_rest.mapper;

import br.com.clinica.api_rest.dto.EspecialidadeRequest;
import br.com.clinica.api_rest.dto.EspecialidadeResponse;
import br.com.clinica.api_rest.entity.Especialidade;

public class EspecialidadeMapper {

    public static Especialidade toEntity(EspecialidadeRequest dto) {
        Especialidade e = new Especialidade();
        e.setNome(dto.getNome());
        e.setDescricao(dto.getDescricao());
        return e;
    }

    public static EspecialidadeResponse toResponse(Especialidade e) {
        EspecialidadeResponse dto = new EspecialidadeResponse();
        dto.setId(e.getId());
        dto.setNome(e.getNome());
        dto.setDescricao(e.getDescricao());
        return dto;
    }
}
