package br.com.clinica.api_rest.repository;

import br.com.clinica.api_rest.entity.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
}
