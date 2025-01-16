package repository;

import entity.Colar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColarRepository extends JpaRepository<Colar, Long> {

    
    
    // Exemplo: Buscar um Colar pelo comprimento
    Optional<Colar> findByComprimento(double comprimento);

    // Outros métodos personalizados podem ser adicionados conforme necessário.
}
