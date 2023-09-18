package br.com.cwi.api.repository;

import br.com.cwi.api.domain.Passageiro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {

    @Query("select p from Passageiro p where not exists (select c from p.corridas c where c.status <> 'FINALIZADA')")
    Page<Passageiro> findPassageirosDisponiveis(Pageable pageable);

    boolean existsByCpf(String cpf);
}
