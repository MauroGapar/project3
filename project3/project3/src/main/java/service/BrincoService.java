package service;

import dto.BrincoDTO;
import entity.Brinco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BrincoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrincoService {

    @Autowired
    private BrincoRepository brincoRepository;

    // Criar um novo brinco
    public BrincoDTO criarBrinco(BrincoDTO brincoDTO) {
        Brinco brinco = BrincoDTO.toEntity(brincoDTO); // Converter DTO para Entity
        brinco = brincoRepository.save(brinco); // Salvar no banco de dados
        return BrincoDTO.fromEntity(brinco); // Retornar o DTO correspondente
    }

    // Atualizar as informações de um brinco
    public BrincoDTO atualizarBrinco(Long id, BrincoDTO brincoDTO) {
        Optional<Brinco> brincoOptional = brincoRepository.findById(id);
        if (brincoOptional.isPresent()) {
            Brinco brinco = brincoOptional.get();
            brinco.setNome(brincoDTO.getNome());
            brinco.setMaterial(brincoDTO.getMaterial());
            brinco.setPeso(brincoDTO.getPeso());
            brinco.setPreco(brincoDTO.getPreco());
            brinco.setQuantidadeEstoque(brincoDTO.getQuantidadeEstoque());
            brinco.setDesign(brincoDTO.getDesign());
            brinco = brincoRepository.save(brinco); // Atualizar no banco de dados
            return BrincoDTO.fromEntity(brinco); // Retornar o DTO atualizado
        }
        return null; // Ou lançar uma exceção personalizada
    }

    // Buscar um brinco pelo ID
    public BrincoDTO buscarBrincoPorId(Long id) {
        Optional<Brinco> brincoOptional = brincoRepository.findById(id);
        return brincoOptional.map(BrincoDTO::fromEntity).orElse(null);
    }

    // Buscar todos os brincos
    public List<BrincoDTO> buscarTodosBrincos() {
        List<Brinco> brincos = brincoRepository.findAll();
        return brincos.stream()
                .map(BrincoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // Excluir um brinco pelo ID
    public boolean excluirBrinco(Long id) {
        Optional<Brinco> brincoOptional = brincoRepository.findById(id);
        if (brincoOptional.isPresent()) {
            brincoRepository.delete(brincoOptional.get());
            return true;
        }
        return false; // Ou lançar uma exceção personalizada
    }
}