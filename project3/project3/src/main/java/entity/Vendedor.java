
package entity;

import java.time.LocalDate;
import javax.persistence.Entity;

@Entity
public class Vendedor extends Funcionario {

    // Atributos específicos de Vendedor
    private double comissao;

    // Construtores
    public Vendedor() {}

    public Vendedor(String nome, String nif, LocalDate dataContratacao, double salario, double comissao) {
        super(nome, nif, dataContratacao, salario); // Chama o construtor da classe base Funcionario
        this.comissao = comissao;
    }

    // Getters e Setters
    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    // Método para calcular o salário total (salário + comissão)
    public double calcularSalarioTotal() {
        return getSalario() + comissao;
    }

    // Método toString() sobrescrito para incluir a comissão
    @Override
    public String toString() {
        return "Vendedor{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", nif='" + getNif() + '\'' +
                ", dataContratacao=" + getDataContratacao() +
                ", salario=" + getSalario() +
                ", comissao=" + comissao +
                '}';
    }
}