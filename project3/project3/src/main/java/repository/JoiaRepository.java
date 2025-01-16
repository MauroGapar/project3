package repository;

import entity.Joia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JoiaRepository extends JpaRepository<Joia, Long> {

    
    
    // Buscar uma Joia pelo nome
    Optional<Joia> findByNome(String nome);

    // Outros métodos personalizados podem ser adicionados conforme necessário.
}
