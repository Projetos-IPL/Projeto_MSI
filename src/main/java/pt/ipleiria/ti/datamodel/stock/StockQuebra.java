package pt.ipleiria.ti.datamodel.stock;

import pt.ipleiria.ti.datamodel.Produto;

import java.time.LocalDate;

public class StockQuebra extends Stock {

    public StockQuebra(Produto produto, LocalDate data, int quantidade, String lote) {
        super(produto, data, quantidade, lote);
    }

    @Override
    public String toString() {
        return "(QUEBRA) " + super.toString();
    }
}
