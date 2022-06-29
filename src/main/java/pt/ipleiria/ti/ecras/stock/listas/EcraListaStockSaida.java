package pt.ipleiria.ti.ecras.stock.listas;

import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.datamodel.stock.StockSaida;
import pt.ipleiria.ti.ecras.geral.EcraPrincipal;
import pt.ipleiria.ti.utils.BaseScreen;

import javax.swing.*;

public class EcraListaStockSaida extends BaseScreen {
    private final DefaultListModel<StockSaida> listaStockModel = new DefaultListModel<>();
    private final Produto selectedProduct;
    private JPanel rootPanel;
    private JList<StockSaida> listaStock;
    private JButton btnVoltar;


    public EcraListaStockSaida(String windowTitle, Produto produto) {
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

        for (StockSaida stock : super.dataProvider.getStockSaidaForProduto(selectedProduct)) {
            listaStockModel.addElement(stock);
        }
    }
}
