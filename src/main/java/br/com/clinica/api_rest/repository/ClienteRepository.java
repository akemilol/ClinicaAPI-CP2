package br.com.clinica.api_rest.repository;

import br.com.clinica.api_rest.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
