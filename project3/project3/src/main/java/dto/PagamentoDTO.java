package dto;

import entity.Pagamento;
import entity.Pagamento.MetodoPagamento;
import entity.Pedido;
import java.util.Date;

public class PagamentoDTO {

    private Long id;  // Identificador único do pagamento
    private Long pedidoId;  // ID do pedido associado ao pagamento
    private Double valor;  // Valor do pagamento
    private Date dataPagamento;  // Data em que o pagamento foi realizado
    private String metodoPagamento;  // Método de pagamento (cartão de crédito, transferência bancária, dinheiro)

    // Construtor padrão
    public PagamentoDTO() {}

    // Construtor com parâmetros
    public PagamentoDTO(Long id, Long pedidoId, Double valor, Date dataPagamento, String metodoPagamento) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.metodoPagamento = metodoPagamento;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    @Override
    public String toString() {
        return "PagamentoDTO{" +
                "id=" + id +
                ", pedidoId=" + pedidoId +
                ", valor=" + valor +
                ", dataPagamento=" + dataPagamento +
                ", metodoPagamento='" + metodoPagamento + '\'' +
                '}';
    }
    
    // Converter Entity para DTO
    public static PagamentoDTO fromEntity(Pagamento pagamento) {
        return new PagamentoDTO(
            pagamento.getId(),
            pagamento.getPedido() != null ? pagamento.getPedido().getId() : null, // Pega o ID do Pedido associado
            pagamento.getValor(),
            pagamento.getDataPagamento(),
            pagamento.getMetodoPagamento().name()  // Convertendo o Enum para String
        );
    }

    // Converter DTO para Entity
    public static Pagamento toEntity(PagamentoDTO pagamentoDTO, Pedido pedido) {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(pagamentoDTO.getId());
        pagamento.setPedido(pedido);  // Associa o Pedido à entidade Pagamento
        pagamento.setValor(pagamentoDTO.getValor());
        pagamento.setDataPagamento(pagamentoDTO.getDataPagamento());
        pagamento.setMetodoPagamento(MetodoPagamento.valueOf(pagamentoDTO.getMetodoPagamento())); // Convertendo de String para Enum
        return pagamento;
    }
}