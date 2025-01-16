
package dto;

import entity.Anel;

public class AnelDTO {

    
    private Long id;
    private String nome;
    private String material;
    private double peso;
    private double preco;
    private int quantidadeEstoque;
    private String tamanho; // Tamanho do anel

    // Construtor padrão
    public AnelDTO() {}

    // Construtor com parâmetros
    public AnelDTO(Long id, String nome, String material, double peso, double preco, int quantidadeEstoque, String tamanho) {
        this.id = id;
        this.nome = nome;
        this.material = material;
        this.peso = peso;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.tamanho = tamanho;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    // Método para exibir informações do DTO
    @Override
    public String toString() {
        return "AnelDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", material='" + material + '\'' +
                ", peso=" + peso +
                ", preco=" + preco +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", tamanho='" + tamanho + '\'' +
                '}';
    }
    
    // Converter Entity para DTO
    public static AnelDTO fromEntity(Anel anel) {
        return new AnelDTO(
            anel.getId(),
            anel.getNome(),
            anel.getMaterial(),
            anel.getPeso(),
            anel.getPreco(),
            anel.getQuantidadeEstoque(),
            anel.getTamanho()
        );
    }

    // Converter DTO para Entity
    public static Anel toEntity(AnelDTO anelDTO) {
        Anel anel = new Anel();
        anel.setId(anelDTO.getId());
        anel.setNome(anelDTO.getNome());
        anel.setMaterial(anelDTO.getMaterial());
        anel.setPeso(anelDTO.getPeso());
        anel.setPreco(anelDTO.getPreco());
        anel.setQuantidadeEstoque(anelDTO.getQuantidadeEstoque());
        anel.setTamanho(anelDTO.getTamanho());
        return anel;
    }
    
}