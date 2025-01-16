package dto;

import entity.Brinco;

public class BrincoDTO {

    
    private Long id;
    private String nome;
    private String material;
    private double peso;
    private double preco;
    private int quantidadeEstoque;
    private String design; // Estilo ou modelo do brinco

    // Construtor padrão
    public BrincoDTO() {}

    // Construtor com parâmetros
    public BrincoDTO(Long id, String nome, String material, double peso, double preco, int quantidadeEstoque, String design) {
        this.id = id;
        this.nome = nome;
        this.material = material;
        this.peso = peso;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.design = design;
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

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    // Método para exibir informações do DTO
    @Override
    public String toString() {
        return "BrincoDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", material='" + material + '\'' +
                ", peso=" + peso +
                ", preco=" + preco +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", design='" + design + '\'' +
                '}';
    }
    
    // Converter Entity para DTO
    public static BrincoDTO fromEntity(Brinco brinco) {
        return new BrincoDTO(
            brinco.getId(),
            brinco.getNome(),
            brinco.getMaterial(),
            brinco.getPeso(),
            brinco.getPreco(),
            brinco.getQuantidadeEstoque(),
            brinco.getDesign()
        );
    }

    // Converter DTO para Entity
    public static Brinco toEntity(BrincoDTO brincoDTO) {
        Brinco brinco = new Brinco();
        brinco.setId(brincoDTO.getId());
        brinco.setNome(brincoDTO.getNome());
        brinco.setMaterial(brincoDTO.getMaterial());
        brinco.setPeso(brincoDTO.getPeso());
        brinco.setPreco(brincoDTO.getPreco());
        brinco.setQuantidadeEstoque(brincoDTO.getQuantidadeEstoque());
        brinco.setDesign(brincoDTO.getDesign());
        return brinco;
    }
}