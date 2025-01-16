package dto;

import entity.Colar;

public class ColarDTO {

    
    private Long id;
    private String nome;
    private String material;
    private double peso;
    private double preco;
    private int quantidadeEstoque;
    private double comprimento; // comprimento do colar

    // Construtor padrão
    public ColarDTO() {}

    // Construtor com parâmetros
    public ColarDTO(Long id, String nome, String material, double peso, double preco, int quantidadeEstoque, double comprimento) {
        this.id = id;
        this.nome = nome;
        this.material = material;
        this.peso = peso;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.comprimento = comprimento;
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

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    // Método para exibir informações do DTO
    @Override
    public String toString() {
        return "ColarDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", material='" + material + '\'' +
                ", peso=" + peso +
                ", preco=" + preco +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", comprimento=" + comprimento +
                '}';
    }
    
    // Converter Entity para DTO
    public static ColarDTO fromEntity(Colar colar) {
        return new ColarDTO(
            colar.getId(),
            colar.getNome(),
            colar.getMaterial(),
            colar.getPeso(),
            colar.getPreco(),
            colar.getQuantidadeEstoque(),
            colar.getComprimento()
        );
    }

    // Converter DTO para Entity
    public static Colar toEntity(ColarDTO colarDTO) {
        Colar colar = new Colar();
        colar.setId(colarDTO.getId());
        colar.setNome(colarDTO.getNome());
        colar.setMaterial(colarDTO.getMaterial());
        colar.setPeso(colarDTO.getPeso());
        colar.setPreco(colarDTO.getPreco());
        colar.setQuantidadeEstoque(colarDTO.getQuantidadeEstoque());
        colar.setComprimento(colarDTO.getComprimento());
        return colar;
    }   
}