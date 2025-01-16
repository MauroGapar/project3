package dto;

import entity.Gerente;
import java.time.LocalDate;

public class GerenteDTO {

    
    private Long id;
    private String nome;
    private String nif;
    private LocalDate dataContratacao;
    private double salario;
    private double metaVendas;

    // Construtor padrão
    public GerenteDTO() {}

    // Construtor com parâmetros
    public GerenteDTO(Long id, String nome, String nif, LocalDate dataContratacao, double salario, double metaVendas) {
        this.id = id;
        this.nome = nome;
        this.nif = nif;
        this.dataContratacao = dataContratacao;
        this.salario = salario;
        this.metaVendas = metaVendas;
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

    public double getMetaVendas() {
        return metaVendas;
    }

    public void setMetaVendas(double metaVendas) {
        this.metaVendas = metaVendas;
    }

    // Método para exibir informações do DTO
    @Override
    public String toString() {
        return "GerenteDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nif='" + nif + '\'' +
                ", dataContratacao=" + dataContratacao +
                ", salario=" + salario +
                ", metaVendas=" + metaVendas +
                '}';
    }
    
    // Converter Entity para DTO
    public static GerenteDTO fromEntity(Gerente gerente) {
        return new GerenteDTO(
            gerente.getId(),
            gerente.getNome(),
            gerente.getNif(),
            gerente.getDataContratacao(),
            gerente.getSalario(),
            gerente.getMetaVendas()
        );
    }

    // Converter DTO para Entity
    public static Gerente toEntity(GerenteDTO gerenteDTO) {
        Gerente gerente = new Gerente();
        gerente.setId(gerenteDTO.getId());
        gerente.setNome(gerenteDTO.getNome());
        gerente.setNif(gerenteDTO.getNif());
        gerente.setDataContratacao(gerenteDTO.getDataContratacao());
        gerente.setSalario(gerenteDTO.getSalario());
        gerente.setMetaVendas(gerenteDTO.getMetaVendas());
        return gerente;
    }
}