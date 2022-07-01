package pt.ipleiria.ti.datamodel.stock;

import pt.ipleiria.ti.datamodel.Produto;

import java.time.LocalDate;

public class StockEntrada extends Stock {

    private LocalDate dataValidade;

    public StockEntrada(Produto produto, LocalDate data, int quantidade, String lote) {
        super(produto, data, quantidade, lote);
    }

    @Override
    public String toString() {
        return "(ENTRADA) " + super.toString();
    }
}
