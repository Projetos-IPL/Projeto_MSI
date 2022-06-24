package pt.ipleiria.ti.datamodel;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.UUID;

public class Produto {

    private final String id;
    private String nome;
    private String descricao;
    private Unidade unidade;
    private Categoria categoria;
    private double valor;

    public Produto(String nome, String descricao, Unidade unidade, Categoria categoria, double valor) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.descricao = descricao;
        this.unidade = unidade;
        this.categoria = categoria;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        NumberFormat format = new DecimalFormat("#0.00");

        return this.nome + " (" + this.descricao + ") : " + this.unidade + " | " + this.categoria.descricao + " | " +
                "Preço: " + format.format(this.valor) + " €";
    }
}
