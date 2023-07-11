package sp.senai;

import java.io.Serializable;

public class Produto implements Serializable { // Classe Serializable: passaremos dados entre as activities
    private int produtoId;
    private String produtoNome;
    private float produtoQuantidade;
    private float produtoPreco;
    // Método construtor
    public Produto(String produtoNome, float produtoQuantidade, float produtoPreco) {
        setProdutoNome(produtoNome);
        setProdutoQuantidade(produtoQuantidade);
        setProdutoPreco(produtoPreco);
    }
    // Método construtor vazio
    public Produto() {
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public float getProdutoQuantidade() {
        return produtoQuantidade;
    }

    public void setProdutoQuantidade(float produtoQuantidade) {
        this.produtoQuantidade = produtoQuantidade;
    }

    public float getProdutoPreco() {
        return produtoPreco;
    }

    public void setProdutoPreco(float produtoPreco) {
        this.produtoPreco = produtoPreco;
    }
}
