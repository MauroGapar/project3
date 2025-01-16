package repository;

import entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    // Consultar um Pagamento pelo ID
    Optional<Pagamento> findById(Long id);

    // Buscar Pagamentos por Pedido
    List<Pagamento> findByPedidoId(Long pedidoId);

    // Buscar Pagamentos por Método de Pagamento
    List<Pagamento> findByMetodoPagamento(Pagamento.MetodoPagamento metodoPagamento);

    // Buscar Pagamentos por Data
    List<Pagamento> findByDataPagamentoBetween(Date startDate, Date endDate);

    // Buscar Pagamentos por Valor maior que um valor específico
    List<Pagamento> findByValorGreaterThan(Double valor);

    // Outros métodos personalizados podem ser adicionados conforme necessário.
}