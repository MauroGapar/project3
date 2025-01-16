package dto;

import entity.Funcionario;
import java.time.LocalDate;

public class FuncionarioDTO {

    public static Funcionario toEntity(FuncionarioDTO funcionarioDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static FuncionarioDTO fromEntity(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    private Long id;
    private String nome;
    private String nif;
    private LocalDate dataContratacao;
    private double salario;

    // Construtor padrão
    public FuncionarioDTO(Funcionario funcionario, String nome1, String cargo) {}

    // Construtor com parâmetros
    public FuncionarioDTO(Long id, String nome, String nif, LocalDate dataContratacao, double salario) {
        this.id = id;
        this.nome = nome;
        this.nif = nif;
        this.dataContratacao = dataContratacao;
        this.salario = salario;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Método para exibir informações do DTO
    @Override
    public String toString() {
        return "FuncionarioDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nif='" + nif + '\'' +
                ", dataContratacao=" + dataContratacao +
                ", salario=" + salario +
                '}';
    }
}