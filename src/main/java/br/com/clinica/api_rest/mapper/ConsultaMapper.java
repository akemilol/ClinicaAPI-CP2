package br.com.clinica.api_rest.mapper;

import br.com.clinica.api_rest.dto.ConsultaRequest;
import br.com.clinica.api_rest.dto.ConsultaResponse;
import br.com.clinica.api_rest.entity.Cliente;
import br.com.clinica.api_rest.entity.Consulta;
import br.com.clinica.api_rest.entity.Medico;

public class ConsultaMapper {

    public static Consulta toEntity(ConsultaRequest dto, Cliente cliente, Medico medico) {
        Consulta consulta = new Consulta();
        consulta.setDataHora(dto.getDataHora());
        consulta.setMotivo(dto.getMotivo());
        consulta.setCliente(cliente);
        consulta.setMedico(medico);
        return consulta;
    }

    public static ConsultaResponse toResponse(Consulta consulta) {
        ConsultaResponse dto = new ConsultaResponse();
        dto.setId(consulta.getId());
        dto.setDataHora(consulta.getDataHora());
        dto.setMotivo(consulta.getMotivo());
        dto.setNomeCliente(consulta.getCliente().getNome());
        dto.setNomeMedico(consulta.getMedico().getNome());
        return dto;
    }
}
