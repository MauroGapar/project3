/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.alibaba.cola.domain.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
public class Anel extends Joia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tamanho; // Tamanho do anel

    // Construtores
    public Anel() {}

    public Anel(String nome, String material, double peso, double preco, int quantidadeEstoque, String tamanho) {
        super(nome, "anel", material, peso, preco, quantidadeEstoque); // Chama o construtor da classe Joia
        this.tamanho = tamanho;
    }

    // Getter e Setter
    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    // Método toString() sobrescrito para incluir o tamanho do anel
    @Override
    public String toString() {
        return "Anel{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", tipo='" + getTipo() + '\'' +
                ", material='" + getMaterial() + '\'' +
                ", peso=" + getPeso() +
                ", preco=" + getPreco() +
                ", quantidadeEstoque=" + getQuantidadeEstoque() +
                ", tamanho='" + tamanho + '\'' +
                '}';
    }

    public void setDescricao(String descricao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
