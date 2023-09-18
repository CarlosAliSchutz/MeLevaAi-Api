package br.com.cwi.api.repository;

import br.com.cwi.api.domain.Corrida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorridaRepository extends JpaRepository<Corrida, Long> {

}
