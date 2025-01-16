package dto;

import entity.Joia;

public class JoiaDTO {

    
    private Long id;
    private String nome;
    private String tipo; // "colar", "brinco", "anel"
    private String material;
    private double peso;
    private double preco;
    private int quantidadeEstoque;

    // Construtor padrão
    public JoiaDTO() {}

    // Construtor com parâmetros
    public JoiaDTO(Long id, String nome, String tipo, String material, double peso, double preco, int quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.material = material;
        this.peso = peso;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    // Método para exibir informações do DTO
    @Override
    public String toString() {
        return "JoiaDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", material='" + material + '\'' +
                ", peso=" + peso +
                ", preco=" + preco +
                ", quantidadeEstoque=" + quantidadeEstoque +
                '}';
    }
    
    // Converter Entity para DTO
    public static JoiaDTO fromEntity(Joia joia) {
        return new JoiaDTO(
            joia.getId(),
            joia.getNome(),
            joia.getTipo(),
            joia.getMaterial(),
            joia.getPeso(),
            joia.getPreco(),
            joia.getQuantidadeEstoque()
        );
    }

    // Converter DTO para Entity
    public static Joia toEntity(JoiaDTO joiaDTO) {
        Joia joia = new Joia();
        joia.setId(joiaDTO.getId());
        joia.setNome(joiaDTO.getNome());
        joia.setTipo(joiaDTO.getTipo());
        joia.setMaterial(joiaDTO.getMaterial());
        joia.setPeso(joiaDTO.getPeso());
        joia.setPreco(joiaDTO.getPreco());
        joia.setQuantidadeEstoque(joiaDTO.getQuantidadeEstoque());
        return joia;
    }
    
    
    
}