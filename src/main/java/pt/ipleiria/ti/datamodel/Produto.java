package pt.ipleiria.ti.datamodel;

import java.util.UUID;

public class Produto {

    private final String id;
    private String descricao;
    private Unidade unidade;
    private Categoria categoria;

    public Produto(String descricao, Unidade unidade, Categoria categoria) {
        this.id = UUID.randomUUID().toString();
        this.descricao = descricao;
        this.unidade = unidade;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
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

    @Override
    public String toString() {
        return this.descricao + " : " + this.unidade + " | " + this.categoria.descricao;
    }
}
