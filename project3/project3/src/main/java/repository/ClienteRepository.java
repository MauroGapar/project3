package repository;

import entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    
    
    // Exemplo: Buscar um Cliente por nome
    Optional<Cliente> findByNome(String nome);

    // Exemplo: Buscar um Cliente por CPF
    Optional<Cliente> findByCpf(String cpf);

    // Outros métodos personalizados podem ser adicionados conforme necessário.
}
