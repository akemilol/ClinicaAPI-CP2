package br.com.clinica.api_rest.mapper;

import br.com.clinica.api_rest.dto.ClienteRequest;
import br.com.clinica.api_rest.dto.ClienteResponse;
import br.com.clinica.api_rest.entity.Cliente;

public class ClienteMapper {

    public static Cliente toEntity(ClienteRequest dto) {
        Cliente c = new Cliente();
        c.setNome(dto.getNome());
        c.setEmail(dto.getEmail());
        c.setCpf(dto.getCpf());
        c.setDataNascimento(dto.getDataNascimento());
        c.setTelefone(dto.getTelefone());
        return c;
    }

    public static ClienteResponse toResponse(Cliente c) {
        ClienteResponse dto = new ClienteResponse();
        dto.setId(c.getId());
        dto.setNome(c.getNome());
        dto.setEmail(c.getEmail());
        dto.setCpf(c.getCpf());
        dto.setDataNascimento(c.getDataNascimento());
        dto.setTelefone(c.getTelefone());
        return dto;
    }
}
