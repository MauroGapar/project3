
package entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Colar extends Joia {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double comprimento; // comprimento do colar

    // Construtores
    public Colar() {}

    public Colar(String nome, String material, double peso, double preco, int quantidadeEstoque, double comprimento) {
        super(nome, "colar", material, peso, preco, quantidadeEstoque); // Chama o construtor da classe Joia
        this.comprimento = comprimento;
    }

    // Getter e Setter
    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    // Método toString() sobrescrito para incluir o comprimento do colar
    @Override
    public String toString() {
        return "Colar{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", tipo='" + getTipo() + '\'' +
                ", material='" + getMaterial() + '\'' +
                ", peso=" + getPeso() +
                ", preco=" + getPreco() +
                ", quantidadeEstoque=" + getQuantidadeEstoque() +
                ", comprimento=" + comprimento +
                '}';
    }
}
