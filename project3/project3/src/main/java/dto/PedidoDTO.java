package dto;

import java.util.Date;
import java.util.List;

public class PedidoDTO {

    private Long id;  // Identificador único do pedido
    private Long clienteId;  // ID do cliente
    private Date dataPedido;  // Data em que o pedido foi realizado
    private List<Long> joiasIds;  // IDs das joias no pedido
    private Double valorTotal;  // Valor total do pedido
    private String status;  // Status do pedido

    // Construtores
    public PedidoDTO() {}

    public PedidoDTO(Long id, Long clienteId, Date dataPedido, List<Long> joiasIds, Double valorTotal, String status) {
        this.id = id;
        this.clienteId = clienteId;
        this.dataPedido = dataPedido;
        this.joiasIds = joiasIds;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public List<Long> getJoiasIds() {
        return joiasIds;
    }

    public void setJoiasIds(List<Long> joiasIds) {
        this.joiasIds = joiasIds;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Método toString() sobrescrito
    @Override
    public String toString() {
        return "PedidoDTO{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", dataPedido=" + dataPedido +
                ", joiasIds=" + joiasIds +
                ", valorTotal=" + valorTotal +
                ", status='" + status + '\'' +
                '}';
    }

    // Método de conversão de Pedido para PedidoDTO
    public static PedidoDTO fromEntity(entity.Pedido pedido) {
        List<Long> joiasIds = pedido.getJoias().stream().map(joia -> joia.getId()).toList();
        return new PedidoDTO(
                pedido.getId(),
                pedido.getCliente().getId(),
                pedido.getDataPedido(),
                joiasIds,
                pedido.getValorTotal(),
                pedido.getStatus().name()
        );
    }

    // Método de conversão de PedidoDTO para Pedido
    public static entity.Pedido toEntity(PedidoDTO pedidoDTO, entity.Cliente cliente, List<entity.Joia> joias) {
        entity.Pedido pedido = new entity.Pedido();
        pedido.setId(pedidoDTO.getId());
        pedido.setCliente(cliente);
        pedido.setDataPedido(pedidoDTO.getDataPedido());
        pedido.setJoias(joias);
        pedido.setValorTotal(pedidoDTO.getValorTotal());
        pedido.setStatus(entity.Pedido.StatusPedido.valueOf(pedidoDTO.getStatus()));
        return pedido;
    }
}