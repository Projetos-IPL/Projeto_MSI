package pt.ipleiria.ti.datamodel;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.UUID;

public class Produto {
    
    private final String id;
    private final String nome;
    private final String descricao;
    private final Unidade unidade;
    private final Categoria categoria;
    private final double valor;
    private int quantidadeStock;

    public Produto(String nome, String descricao, Unidade unidade, Categoria categoria, double valor) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.descricao = descricao;
        this.unidade = unidade;
        this.categoria = categoria;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidadeStock() {
        return quantidadeStock;
    }

    public void setQuantidadeStock(int quantidadeStock) {
        this.quantidadeStock = quantidadeStock;
    }

    @Override
    public String toString() {
        NumberFormat format = new DecimalFormat("#0.00");

        return this.nome + " (" + this.descricao + ") : " + this.unidade + " | " + this.categoria.descricao + " | " +
                "Preço: " + format.format(this.valor) + " € | Stock: " + this.quantidadeStock;
    }
}
