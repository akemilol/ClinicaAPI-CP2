package br.com.clinica.api_rest.repository;

import br.com.clinica.api_rest.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
