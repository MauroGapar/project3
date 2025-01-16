package service;

import dto.PagamentoDTO;
import entity.Pagamento;
import entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PagamentoRepository;
import repository.PedidoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

    public PagamentoService(PagamentoRepository pagamentoRepository1) {
    }

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    // Criar um novo pagamento
    public PagamentoDTO criarPagamento(PagamentoDTO pagamentoDTO) {
        // Buscar o pedido relacionado ao pagamento
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(pagamentoDTO.getPedidoId());
        if (!pedidoOptional.isPresent()) {
            return null; // Pedido não encontrado, retornar null ou lançar exceção
        }

        Pedido pedido = pedidoOptional.get();

        // Converter o DTO para a entidade Pagamento
        Pagamento pagamento = PagamentoDTO.toEntity(pagamentoDTO, pedido);
        pagamento = pagamentoRepository.save(pagamento); // Salvar no banco de dados

        return PagamentoDTO.fromEntity(pagamento); // Retornar o DTO com os dados salvos
    }

    // Atualizar um pagamento existente
    public PagamentoDTO atualizarPagamento(Long id, PagamentoDTO pagamentoDTO) {
        Optional<Pagamento> pagamentoOptional = pagamentoRepository.findById(id);
        if (!pagamentoOptional.isPresent()) {
            return null; // Pagamento não encontrado, retornar null ou lançar exceção
        }

        Pagamento pagamento = pagamentoOptional.get();

        // Atualizar os dados do pagamento
        pagamento.setValor(pagamentoDTO.getValor());
        pagamento.setDataPagamento(pagamentoDTO.getDataPagamento());
        pagamento.setMetodoPagamento(Pagamento.MetodoPagamento.valueOf(pagamentoDTO.getMetodoPagamento()));

        pagamento = pagamentoRepository.save(pagamento); // Atualizar no banco de dados

        return PagamentoDTO.fromEntity(pagamento); // Retornar o DTO atualizado
    }

    // Buscar um pagamento pelo ID
    public PagamentoDTO buscarPagamentoPorId(Long id) {
        Optional<Pagamento> pagamentoOptional = pagamentoRepository.findById(id);
        return pagamentoOptional.map(PagamentoDTO::fromEntity).orElse(null);
    }

    // Buscar todos os pagamentos
    public List<PagamentoDTO> buscarTodosPagamentos() {
        List<Pagamento> pagamentos = pagamentoRepository.findAll();
        return pagamentos.stream()
                .map(PagamentoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // Excluir um pagamento
    public boolean excluirPagamento(Long id) {
        Optional<Pagamento> pagamentoOptional = pagamentoRepository.findById(id);
        if (pagamentoOptional.isPresent()) {
            pagamentoRepository.delete(pagamentoOptional.get());
            return true;
        }
        return false; // Pagamento não encontrado, retornar false
    }
}