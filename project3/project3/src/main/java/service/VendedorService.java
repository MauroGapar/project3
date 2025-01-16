package service;

import dto.VendedorDTO;
import entity.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VendedorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    // Criar um novo vendedor
    public VendedorDTO criarVendedor(VendedorDTO vendedorDTO) {
        Vendedor vendedor = VendedorDTO.toEntity(vendedorDTO); // Converter DTO para Entity
        vendedor = vendedorRepository.save(vendedor); // Salvar no banco de dados
        return VendedorDTO.fromEntity(vendedor); // Retornar o DTO correspondente
    }

    // Atualizar as informações de um vendedor
    public VendedorDTO atualizarVendedor(Long id, VendedorDTO vendedorDTO) {
        Optional<Vendedor> vendedorOptional = vendedorRepository.findById(id);
        if (vendedorOptional.isPresent()) {
            Vendedor vendedor = vendedorOptional.get();
            vendedor.setNome(vendedorDTO.getNome());
            vendedor.setNif(vendedorDTO.getNif());
            vendedor.setDataContratacao(vendedorDTO.getDataContratacao());
            vendedor.setSalario(vendedorDTO.getSalario());
           
            vendedor = vendedorRepository.save(vendedor); // Atualizar no banco de dados
            return VendedorDTO.fromEntity(vendedor); // Retornar o DTO atualizado
        }
        return null; // Ou lançar uma exceção personalizada
    }

    // Buscar um vendedor pelo ID
    public VendedorDTO buscarVendedorPorId(Long id) {
        Optional<Vendedor> vendedorOptional = vendedorRepository.findById(id);
        return vendedorOptional.map(VendedorDTO::fromEntity).orElse(null);
    }

    // Buscar todos os vendedores
    public List<VendedorDTO> buscarTodosVendedores() {
        List<Vendedor> vendedores = vendedorRepository.findAll();
        return vendedores.stream()
                .map(VendedorDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // Excluir um vendedor pelo ID
    public boolean excluirVendedor(Long id) {
        Optional<Vendedor> vendedorOptional = vendedorRepository.findById(id);
        if (vendedorOptional.isPresent()) {
            vendedorRepository.delete(vendedorOptional.get());
            return true;
        }
        return false; // Ou lançar uma exceção personalizada
    }
}