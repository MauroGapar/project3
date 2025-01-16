/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Identificador único do pagamento

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;  // Pedido associado ao pagamento

    @Column(nullable = false)
    private Double valor;  // Valor do pagamento

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataPagamento;  // Data em que o pagamento foi realizado

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MetodoPagamento metodoPagamento;  // Método de pagamento (cartão de crédito, transferência bancária, dinheiro)

    // Construtores
    public Pagamento() {}

    public Pagamento(Pedido pedido, Double valor, Date dataPagamento, MetodoPagamento metodoPagamento) {
        this.pedido = pedido;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    // Método toString() sobrescrito
    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", pedido=" + pedido +
                ", valor=" + valor +
                ", dataPagamento=" + dataPagamento +
                ", metodoPagamento=" + metodoPagamento +
                '}';
    }

    // Enum para o método de pagamento
    public enum MetodoPagamento {
        CARTAO_CREDITO,
        TRANSFERENCIA_BANCARIA,
        DINHEIRO
    }
}
