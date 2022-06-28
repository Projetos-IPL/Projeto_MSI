package pt.ipleiria.ti.datamodel.stock;

import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.utils.Data;

public abstract class Stock {

    private Produto produto;
    private Data data;
    private int quantidade;
    private String lote;

    public Stock(Produto produto, Data data, int quantidade, String lote) {
        this.produto = produto;
        this.data = data;
        this.quantidade = quantidade;
        this.lote = lote;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    @Override
    public String toString() {
        return "Produto: " + produto.getNome() + " | Quant. " + quantidade + " (" + produto.getUnidade().toString() +
                ") | Lote: " + lote + " | Data: " + data.toString();
    }
}
