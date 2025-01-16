/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Identificador único do pedido

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;  // Cliente associado ao pedido

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataPedido;  // Data em que o pedido foi realizado

    @ManyToMany
    @JoinTable(
            name = "pedido_joia", 
            joinColumns = @JoinColumn(name = "pedido_id"), 
            inverseJoinColumns = @JoinColumn(name = "joia_id"))
    private List<Joia> joias;  // Lista de joias no pedido

    @Column(nullable = false)
    private Double valorTotal;  // Valor total do pedido

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPedido status;  // Status do pedido (entregue, pendente, aceito, cancelado)

    // Construtores
    public Pedido() {}

    public Pedido(Cliente cliente, Date dataPedido, List<Joia> joias, Double valorTotal, StatusPedido status) {
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.joias = joias;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public List<Joia> getJoias() {
        return joias;
    }

    public void setJoias(List<Joia> joias) {
        this.joias = joias;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    // Método toString() sobrescrito
    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", dataPedido=" + dataPedido +
                ", joias=" + joias +
                ", valorTotal=" + valorTotal +
                ", status=" + status +
                '}';
    }

    // Enum para o status do pedido
    public enum StatusPedido {
        PENDENTE,
        ACEITO,
        ENTREGUE,
        CANCELADO
    }
}
