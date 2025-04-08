package br.com.clinica.api_rest.repository;

import br.com.clinica.api_rest.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
