package pt.ipleiria.ti.ecras.stock;

import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.datamodel.stock.StockEntrada;
import pt.ipleiria.ti.ecras.geral.EcraPrincipal;
import pt.ipleiria.ti.utils.BaseScreen;

import javax.swing.*;

public class EcraListaStockEntrada extends BaseScreen {
    private final DefaultListModel<StockEntrada> listaStockModel = new DefaultListModel<>();
    private final Produto selectedProduct;
    private JPanel rootPanel;
    private JList<StockEntrada> listaStock;
    private JButton btnVoltar;

    public EcraListaStockEntrada(String windowTitle, Produto selectedProduct) {
        super(windowTitle);

        super.getScreen().setSize(600, 400);
        super.setupScreen(rootPanel);

        this.selectedProduct = selectedProduct;

        atualizarListaStock();

        // actions
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

        for (StockEntrada stock : super.dataProvider.getStockEntradaForProduto(selectedProduct)) {
            listaStockModel.addElement(stock);
        }
    }
}
