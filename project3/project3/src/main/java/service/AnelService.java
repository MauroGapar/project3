package service;

import dto.AnelDTO;
import entity.Anel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AnelRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnelService {

    @Autowired
    private AnelRepository anelRepository;

    // Criar um novo anel
    public AnelDTO criarAnel(AnelDTO anelDTO) {
        Anel anel = AnelDTO.toEntity(anelDTO); // Converter DTO para Entity
        anel = anelRepository.save(anel); // Salvar no banco de dados
        return AnelDTO.fromEntity(anel); // Retornar o DTO correspondente
    }

    // Atualizar as informações de um anel
    public AnelDTO atualizarAnel(Long id, AnelDTO anelDTO) {
        Optional<Anel> anelOptional = anelRepository.findById(id);
        if (anelOptional.isPresent()) {
            Anel anel = anelOptional.get();
            anel.setNome(anelDTO.getNome());
            anel.setMaterial(anelDTO.getMaterial());
            anel.setPeso(anelDTO.getPeso());
            anel.setPreco(anelDTO.getPreco());
            anel.setQuantidadeEstoque(anelDTO.getQuantidadeEstoque());
            anel.setTamanho(anelDTO.getTamanho());
            anel = anelRepository.save(anel); // Atualizar no banco de dados
            return AnelDTO.fromEntity(anel); // Retornar o DTO atualizado
        }
        return null; // Ou lançar uma exceção personalizada
    }

    // Buscar um anel pelo ID
    public AnelDTO buscarAnelPorId(Long id) {
        Optional<Anel> anelOptional = anelRepository.findById(id);
        return anelOptional.map(AnelDTO::fromEntity).orElse(null);
    }

    // Buscar todos os anéis
    public List<AnelDTO> buscarTodosAnéis() {
        List<Anel> aneis = anelRepository.findAll();
        return aneis.stream()
                .map(AnelDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // Excluir um anel pelo ID
    public boolean excluirAnel(Long id) {
        Optional<Anel> anelOptional = anelRepository.findById(id);
        if (anelOptional.isPresent()) {
            anelRepository.delete(anelOptional.get());
            return true;
        }
        return false; // Ou lançar uma exceção personalizada
    }
}