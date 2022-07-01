package pt.ipleiria.ti.datamodel.stock;

import pt.ipleiria.ti.datamodel.Produto;

import java.time.LocalDate;

public abstract class Stock {

    private final Produto produto;
    private final LocalDate data;
    private final int quantidade;
    private final String lote;

    public Stock(Produto produto, LocalDate data, int quantidade, String lote) {
        this.produto = produto;
        this.data = data;
        this.quantidade = quantidade;
        this.lote = lote;
    }

    public Produto getProduto() {
        return produto;
    }

    public LocalDate getData() {
        return data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getLote() {
        return lote;
    }

    @Override
    public String toString() {
        return "Produto: " + produto.getNome() + " | Quant. " + quantidade + " (" + produto.getUnidade().toString() +
                ") | Lote: " + lote + " | Data: " + data.toString();
    }
}
