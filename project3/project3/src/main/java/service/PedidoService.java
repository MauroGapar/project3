package service;

import dto.PedidoDTO;
import entity.Pedido;
import entity.Cliente;
import entity.Joia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PedidoRepository;
import repository.ClienteRepository;
import repository.JoiaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    public PedidoService(PedidoRepository pedidoRepository1) {
    }

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private JoiaRepository joiaRepository;

    // Criar um novo pedido
    public PedidoDTO criarPedido(PedidoDTO pedidoDTO) {
        // Buscar o cliente relacionado ao pedido
        Optional<Cliente> clienteOptional = clienteRepository.findById(pedidoDTO.getClienteId());
        if (!clienteOptional.isPresent()) {
            return null; // Cliente não encontrado, retornar null ou lançar exceção
        }
        Cliente cliente = clienteOptional.get();

        // Buscar as joias relacionadas ao pedido
        List<Joia> joias = joiaRepository.findAllById(pedidoDTO.getJoiasIds());

        // Converter o DTO para a entidade Pedido
        Pedido pedido = PedidoDTO.toEntity(pedidoDTO, cliente, joias);
        pedido = pedidoRepository.save(pedido); // Salvar o pedido no banco de dados

        return PedidoDTO.fromEntity(pedido); // Retornar o DTO com os dados salvos
    }

    // Atualizar um pedido existente
    public PedidoDTO atualizarPedido(Long id, PedidoDTO pedidoDTO) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if (!pedidoOptional.isPresent()) {
            return null; // Pedido não encontrado, retornar null ou lançar exceção
        }

        Pedido pedido = pedidoOptional.get();

        // Buscar o cliente e as joias novamente para atualizar
        Optional<Cliente> clienteOptional = clienteRepository.findById(pedidoDTO.getClienteId());
        if (!clienteOptional.isPresent()) {
            return null; // Cliente não encontrado, retornar null ou lançar exceção
        }
        Cliente cliente = clienteOptional.get();

        List<Joia> joias = joiaRepository.findAllById(pedidoDTO.getJoiasIds());

        // Atualizar os dados do pedido
        pedido.setCliente(cliente);
        pedido.setDataPedido(pedidoDTO.getDataPedido());
        pedido.setJoias(joias);
        pedido.setValorTotal(pedidoDTO.getValorTotal());
        pedido.setStatus(Pedido.StatusPedido.valueOf(pedidoDTO.getStatus()));

        pedido = pedidoRepository.save(pedido); // Atualizar o pedido no banco de dados

        return PedidoDTO.fromEntity(pedido); // Retornar o DTO atualizado
    }

    // Buscar um pedido pelo ID
    public PedidoDTO buscarPedidoPorId(Long id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        return pedidoOptional.map(PedidoDTO::fromEntity).orElse(null);
    }

    // Buscar todos os pedidos
    public List<PedidoDTO> buscarTodosPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream()
                .map(PedidoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // Excluir um pedido
    public boolean excluirPedido(Long id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()) {
            pedidoRepository.delete(pedidoOptional.get());
            return true;
        }
        return false; // Pedido não encontrado, retornar false
    }
}