package br.com.clinica.api_rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.List;

public class MedicoRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "CRM é obrigatório")
    private String crm;

    @Size(min = 10, max = 15, message = "Telefone deve ter entre 10 e 15 caracteres")
    private String telefone;

    @NotEmpty(message = "Pelo menos uma especialidade deve ser informada")
    private List<Long> especialidadeIds;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Long> getEspecialidadeIds() {
        return especialidadeIds;
    }

    public void setEspecialidadeIds(List<Long> especialidadeIds) {
        this.especialidadeIds = especialidadeIds;
    }
}
