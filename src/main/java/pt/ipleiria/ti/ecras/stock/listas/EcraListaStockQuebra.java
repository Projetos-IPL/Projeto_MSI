package pt.ipleiria.ti.ecras.stock.listas;

import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.datamodel.stock.StockQuebra;
import pt.ipleiria.ti.ecras.geral.EcraPrincipal;
import pt.ipleiria.ti.utils.BaseScreen;

import javax.swing.*;

public class EcraListaStockQuebra extends BaseScreen {
    private final DefaultListModel<StockQuebra> listaStockModel = new DefaultListModel<>();
    private final Produto selectedProduct;
    private JPanel rootPanel;
    private JList<StockQuebra> listaStock;
    private JButton btnVoltar;

    public EcraListaStockQuebra(String windowTitle, Produto produto) {
        super(windowTitle);

        super.getScreen().setSize(600, 400);
        super.setupScreen(rootPanel);

        this.selectedProduct = produto;

        atualizarListaStock();

        btnVoltar.addActionListener(e -> {
            new EcraPrincipal("Ecrã Principal").setVisible(true);
            this.dispose();
        });

        listaStock.setModel(listaStockModel);
        listaStock.setFixedCellHeight(30);

        setLocationRelativeTo(null);
    }

    private void atualizarListaStock() {
        listaStock.removeAll();
        listaStockModel.clear();

        for (StockQuebra stock : super.dataProvider.getStockQuebraForProduto(selectedProduct)) {
            listaStockModel.addElement(stock);
        }
    }
}
