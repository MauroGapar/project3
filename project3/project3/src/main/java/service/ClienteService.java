package service;

import dto.ClienteDTO;
import entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClienteRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    public ClienteService(ClienteRepository clienteRepository1) {
    }

    @Autowired
    private ClienteRepository clienteRepository;

    // Criar um novo cliente
    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = ClienteDTO.toEntity(clienteDTO); // Converter DTO para Entity
        cliente = clienteRepository.save(cliente); // Salvar no banco de dados
        return ClienteDTO.fromEntity(cliente); // Retornar o DTO correspondente
    }

    // Atualizar as informações de um cliente
    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setNome(clienteDTO.getNome());
            cliente.setEmail(clienteDTO.getEmail());
            cliente.setTelefone(clienteDTO.getTelefone());
            cliente.setEndereco(clienteDTO.getEndereco());
            cliente = clienteRepository.save(cliente); // Atualizar no banco de dados
            return ClienteDTO.fromEntity(cliente); // Retornar o DTO atualizado
        }
        return null; // Ou lançar uma exceção personalizada
    }

    // Buscar um cliente pelo ID
    public ClienteDTO buscarClientePorId(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.map(ClienteDTO::fromEntity).orElse(null);
    }

    // Buscar todos os clientes
    public List<ClienteDTO> buscarTodosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(ClienteDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // Excluir um cliente pelo ID
    public boolean excluirCliente(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            clienteRepository.delete(clienteOptional.get());
            return true;
        }
        return false; // Ou lançar uma exceção personalizada
    }
}