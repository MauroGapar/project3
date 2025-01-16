package repository;

import entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    
    
    // Exemplo: Buscar um Funcionario pelo nome
    Optional<Funcionario> findByNome(String nome);

    // Outros métodos personalizados podem ser adicionados conforme necessário.
}