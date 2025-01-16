package service;

import dto.ColarDTO;
import entity.Colar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ColarRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColarService {

    @Autowired
    private ColarRepository colarRepository;

    // Criar um novo colar
    public ColarDTO criarColar(ColarDTO colarDTO) {
        Colar colar = ColarDTO.toEntity(colarDTO); // Converter DTO para Entity
        colar = colarRepository.save(colar); // Salvar no banco de dados
        return ColarDTO.fromEntity(colar); // Retornar o DTO correspondente
    }

    // Atualizar as informações de um colar
    public ColarDTO atualizarColar(Long id, ColarDTO colarDTO) {
        Optional<Colar> colarOptional = colarRepository.findById(id);
        if (colarOptional.isPresent()) {
            Colar colar = colarOptional.get();
            colar.setNome(colarDTO.getNome());
            colar.setMaterial(colarDTO.getMaterial());
            colar.setPeso(colarDTO.getPeso());
            colar.setPreco(colarDTO.getPreco());
            colar.setQuantidadeEstoque(colarDTO.getQuantidadeEstoque());
            colar.setComprimento(colarDTO.getComprimento());
            colar = colarRepository.save(colar); // Atualizar no banco de dados
            return ColarDTO.fromEntity(colar); // Retornar o DTO atualizado
        }
        return null; // Ou lançar uma exceção personalizada
    }

    // Buscar um colar pelo ID
    public ColarDTO buscarColarPorId(Long id) {
        Optional<Colar> colarOptional = colarRepository.findById(id);
        return colarOptional.map(ColarDTO::fromEntity).orElse(null);
    }

    // Buscar todos os colares
    public List<ColarDTO> buscarTodosColares() {
        List<Colar> colares = colarRepository.findAll();
        return colares.stream()
                .map(ColarDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // Excluir um colar pelo ID
    public boolean excluirColar(Long id) {
        Optional<Colar> colarOptional = colarRepository.findById(id);
        if (colarOptional.isPresent()) {
            colarRepository.delete(colarOptional.get());
            return true;
        }
        return false; // Ou lançar uma exceção personalizada
    }
}