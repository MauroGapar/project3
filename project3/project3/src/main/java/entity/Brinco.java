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
public class Brinco extends Joia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String design; // Estilo ou modelo do brinco

    // Construtores
    public Brinco() {}

    public Brinco(String nome, String material, double peso, double preco, int quantidadeEstoque, String design) {
        super(nome, "brinco", material, peso, preco, quantidadeEstoque); // Chama o construtor da classe Joia
        this.design = design;
    }

    // Getter e Setter
    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    // Método toString() sobrescrito para incluir o design do brinco
    @Override
    public String toString() {
        return "Brinco{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", tipo='" + getTipo() + '\'' +
                ", material='" + getMaterial() + '\'' +
                ", peso=" + getPeso() +
                ", preco=" + getPreco() +
                ", quantidadeEstoque=" + getQuantidadeEstoque() +
                ", design='" + design + '\'' +
                '}';
    }
}