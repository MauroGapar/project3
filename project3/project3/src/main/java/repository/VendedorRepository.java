package repository;

import entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    // Aqui você pode adicionar consultas personalizadas, se necessário.
    
    // Exemplo: Buscar um Vendedor pelo nome
    Optional<Vendedor> findByNome(String nome);

    // Outros métodos personalizados podem ser adicionados conforme necessário.
}
