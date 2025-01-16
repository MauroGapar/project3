package dto;

import entity.Vendedor;
import java.time.LocalDate;

public class VendedorDTO {

    private Long id;
    private String nome;
    private String nif;
    private LocalDate dataContratacao;
    private double salario;
    private double comissao;

    // Construtor padrão
    public VendedorDTO() {}

    // Construtor com parâmetros
    public VendedorDTO(Long id, String nome, String nif, LocalDate dataContratacao, double salario, double comissao) {
        this.id = id;
        this.nome = nome;
        this.nif = nif;
        this.dataContratacao = dataContratacao;
        this.salario = salario;
        this.comissao = comissao;
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

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    // Método para exibir informações do DTO
    @Override
    public String toString() {
        return "VendedorDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nif='" + nif + '\'' +
                ", dataContratacao=" + dataContratacao +
                ", salario=" + salario +
                ", comissao=" + comissao +
                '}';
    }
    // Converter Entity para DTO
    public static VendedorDTO fromEntity(Vendedor vendedor) {
        return new VendedorDTO(
            vendedor.getId(),
            vendedor.getNome(),
            vendedor.getNif(),
            vendedor.getDataContratacao(),
            vendedor.getSalario(),
            vendedor.getComissao()
        );
    }

    // Converter DTO para Entity
    public static Vendedor toEntity(VendedorDTO vendedorDTO) {
        Vendedor vendedor = new Vendedor();
        vendedor.setId(vendedorDTO.getId());
        vendedor.setNome(vendedorDTO.getNome());
        vendedor.setNif(vendedorDTO.getNif());
        vendedor.setDataContratacao(vendedorDTO.getDataContratacao());
        vendedor.setSalario(vendedorDTO.getSalario());
        vendedor.setComissao(vendedorDTO.getComissao());
        return vendedor;
    }
    
    
    
}
