package service;

import dto.FuncionarioDTO;
import entity.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FuncionarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    public FuncionarioService(FuncionarioRepository funcionarioRepository1) {
    }

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Criar um novo funcionário
    public FuncionarioDTO criarFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario(
                funcionarioDTO.getNome(),
                funcionarioDTO.getNif(),
                funcionarioDTO.getDataContratacao(),
                funcionarioDTO.getSalario()
        );
        funcionario = funcionarioRepository.save(funcionario);
        return new FuncionarioDTO(funcionario, nome, cargo);
    }

    // Atualizar as informações de um funcionário
    public FuncionarioDTO atualizarFuncionario(Long id, FuncionarioDTO funcionarioDTO) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        if (funcionarioOptional.isPresent()) {
            Funcionario funcionario = funcionarioOptional.get();
            funcionario.setNome(funcionarioDTO.getNome());
            funcionario.setNif(funcionarioDTO.getNif());
            funcionario.setDataContratacao(funcionarioDTO.getDataContratacao());
            funcionario.setSalario(funcionarioDTO.getSalario());
            funcionario = funcionarioRepository.save(funcionario);
            return new FuncionarioDTO(funcionario, nome, cargo);
        }
        return null; // Ou lançar uma exceção personalizada, se necessário
    }

    // Buscar um funcionário pelo ID
    public FuncionarioDTO buscarFuncionarioPorId(Long id) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        return funcionarioOptional.map(funcionario -> new FuncionarioDTO(funcionario, nome, cargo)).orElse(null);
    }

    // Buscar todos os funcionários
    public List<FuncionarioDTO> buscarTodosFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream()
                .map(FuncionarioDTO::new)
                .collect(Collectors.toList());
    }

    // Excluir um funcionário pelo ID
    public boolean excluirFuncionario(Long id) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        if (funcionarioOptional.isPresent()) {
            funcionarioRepository.delete(funcionarioOptional.get());
            return true;
        }
        return false; // Ou lançar uma exceção personalizada
    }
}