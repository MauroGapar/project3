package service;

import dto.JoiaDTO;
import entity.Joia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.JoiaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JoiaService {

    public JoiaService(JoiaRepository joiaRepository1) {
    }

    @Autowired
    private JoiaRepository joiaRepository;

    // Criar uma nova joia
    public JoiaDTO criarJoia(JoiaDTO joiaDTO) {
        Joia joia = JoiaDTO.toEntity(joiaDTO); // Converter DTO para Entity
        joia = joiaRepository.save(joia); // Salvar no banco de dados
        return JoiaDTO.fromEntity(joia); // Retornar o DTO correspondente
    }

    // Atualizar as informações de uma joia
    public JoiaDTO atualizarJoia(Long id, JoiaDTO joiaDTO) {
        Optional<Joia> joiaOptional = joiaRepository.findById(id);
        if (joiaOptional.isPresent()) {
            Joia joia = joiaOptional.get();
            joia.setNome(joiaDTO.getNome());
            joia.setTipo(joiaDTO.getTipo());
            joia.setMaterial(joiaDTO.getMaterial());
            joia.setPeso(joiaDTO.getPeso());
            joia.setPreco(joiaDTO.getPreco());
            joia.setQuantidadeEstoque(joiaDTO.getQuantidadeEstoque());
            joia = joiaRepository.save(joia); // Atualizar no banco de dados
            return JoiaDTO.fromEntity(joia); // Retornar o DTO atualizado
        }
        return null; // Ou lançar uma exceção personalizada
    }

    // Buscar uma joia pelo ID
    public JoiaDTO buscarJoiaPorId(Long id) {
        Optional<Joia> joiaOptional = joiaRepository.findById(id);
        return joiaOptional.map(JoiaDTO::fromEntity).orElse(null);
    }

    // Buscar todas as joias
    public List<JoiaDTO> buscarTodasJoias() {
        List<Joia> joias = joiaRepository.findAll();
        return joias.stream()
                .map(JoiaDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // Excluir uma joia pelo ID
    public boolean excluirJoia(Long id) {
        Optional<Joia> joiaOptional = joiaRepository.findById(id);
        if (joiaOptional.isPresent()) {
            joiaRepository.delete(joiaOptional.get());
            return true;
        }
        return false; // Ou lançar uma exceção personalizada
    }
}