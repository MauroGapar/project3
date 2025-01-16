package service;

import dto.GerenteDTO;
import entity.Gerente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.GerenteRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository gerenteRepository;

    // Criar um novo gerente
    public GerenteDTO criarGerente(GerenteDTO gerenteDTO) {
        Gerente gerente = GerenteDTO.toEntity(gerenteDTO); // Converter DTO para Entity
        gerente = gerenteRepository.save(gerente); // Salvar no banco de dados
        return GerenteDTO.fromEntity(gerente); // Retornar o DTO correspondente
    }

    // Atualizar as informações de um gerente
    public GerenteDTO atualizarGerente(Long id, GerenteDTO gerenteDTO) {
        Optional<Gerente> gerenteOptional = gerenteRepository.findById(id);
        if (gerenteOptional.isPresent()) {
            Gerente gerente = gerenteOptional.get();
            gerente.setNome(gerenteDTO.getNome());
            gerente.setNif(gerenteDTO.getNif());
            gerente.setDataContratacao(gerenteDTO.getDataContratacao());
            gerente.setSalario(gerenteDTO.getSalario());
            gerente.setMetaVendas(gerenteDTO.getMetaVendas());
            gerente = gerenteRepository.save(gerente); // Atualizar no banco de dados
            return GerenteDTO.fromEntity(gerente); // Retornar o DTO atualizado
        }
        return null; // Ou lançar uma exceção personalizada
    }

    // Buscar um gerente pelo ID
    public GerenteDTO buscarGerentePorId(Long id) {
        Optional<Gerente> gerenteOptional = gerenteRepository.findById(id);
        return gerenteOptional.map(GerenteDTO::fromEntity).orElse(null);
    }

    // Buscar todos os gerentes
    public List<GerenteDTO> buscarTodosGerentes() {
        List<Gerente> gerentes = gerenteRepository.findAll();
        return gerentes.stream()
                .map(GerenteDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // Excluir um gerente pelo ID
    public boolean excluirGerente(Long id) {
        Optional<Gerente> gerenteOptional = gerenteRepository.findById(id);
        if (gerenteOptional.isPresent()) {
            gerenteRepository.delete(gerenteOptional.get());
            return true;
        }
        return false; // Ou lançar uma exceção personalizada
    }
}