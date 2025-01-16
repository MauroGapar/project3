package repository;

import entity.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {

    
    // consulta: Buscar um Gerente pelo nome
    Optional<Gerente> findByNome(String nome);

   
}
