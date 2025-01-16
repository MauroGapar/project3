package repository;

import entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // Consultar um Pedido pelo ID
    Optional<Pedido> findById(Long id);

    // Buscar Pedidos por Cliente
    List<Pedido> findByClienteId(Long clienteId);

    // Buscar Pedidos por Status
    List<Pedido> findByStatus(Pedido.StatusPedido status);

    // Buscar Pedidos por Data
    List<Pedido> findByDataPedidoBetween(Date startDate, Date endDate);

    // Buscar Pedidos por Valor Total maior que um valor específico
    List<Pedido> findByValorTotalGreaterThan(Double valorTotal);

    
}