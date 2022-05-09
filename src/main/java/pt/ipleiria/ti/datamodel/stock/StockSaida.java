package pt.ipleiria.ti.datamodel.stock;

import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.utils.Data;

public class StockSaida extends Stock {

    public StockSaida(Produto produto, Data data, int quantidade, String lote) {
        super(produto, data, quantidade, lote);
    }
}
