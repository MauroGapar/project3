package repository;

import entity.Brinco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrincoRepository extends JpaRepository<Brinco, Long> {

    
    
    // Exemplo: Buscar um Brinco pelo design
    Optional<Brinco> findByDesign(String design);

    // Outros métodos personalizados podem ser adicionados conforme necessário.
}
