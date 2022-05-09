package pt.ipleiria.ti.datamodel.stock;

import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.utils.Data;

public class StockEntrada extends Stock {

    private Data dataValidade;

    public StockEntrada(Produto produto, Data data, int quantidade, String lote) {
        super(produto, data, quantidade, lote);
    }

    public Data getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }
}
