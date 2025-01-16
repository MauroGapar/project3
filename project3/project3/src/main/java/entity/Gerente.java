
package entity;

import com.alibaba.cola.domain.Entity;
import java.time.LocalDate;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Gerente extends Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Atributos específicos de Gerente
    private double metaVendas;

    // Construtores
    public Gerente() {}

    public Gerente(String nome, String nif, LocalDate dataContratacao, double salario, double metaVendas) {
        super(nome, nif, dataContratacao, salario); // Chama o construtor da classe base Funcionario
        this.metaVendas = metaVendas;
    }

    // Getters e Setters
    public double getMetaVendas() {
        return metaVendas;
    }

    public void setMetaVendas(double metaVendas) {
        this.metaVendas = metaVendas;
    }

    // Método para calcular o salário total (salário + bônus baseado na meta de vendas)
    public double calcularSalarioTotal() {
        return getSalario() + (metaVendas * 0.1); // Exemplo: bônus de 10% sobre a meta atingida
    }

    // Método toString() sobrescrito para incluir a meta de vendas
    @Override
    public String toString() {
        return "Gerente{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", nif='" + getNif() + '\'' +
                ", dataContratacao=" + getDataContratacao() +
                ", salario=" + getSalario() +
                ", metaVendas=" + metaVendas +
                '}';
    }
}
