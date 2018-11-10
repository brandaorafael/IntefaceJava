package Estrutura;

public class Produto {

    private String nome;
    private Double valor;
    private String image;

    public Produto(String nome, Double valor, String image) {
        this.nome = nome;
        this.valor = valor;
        this.image = image;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return nome;
    }
}
