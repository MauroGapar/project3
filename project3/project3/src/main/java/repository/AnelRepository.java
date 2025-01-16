package repository;

import entity.Anel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnelRepository extends JpaRepository<Anel, Long> {

    
    
    // Exemplo: Buscar um Anel pelo tamanho
    Optional<Anel> findByTamanho(String tamanho);

    // Outros métodos personalizados podem ser adicionados conforme necessário.
}
