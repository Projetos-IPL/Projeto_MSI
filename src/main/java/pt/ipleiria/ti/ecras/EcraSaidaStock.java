package pt.ipleiria.ti.ecras;

import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.utils.BaseScreen;

import javax.swing.*;

public class EcraSaidaStock extends BaseScreen {
    private JPanel rootPanel;
    private JTextField inputData;
    private JComboBox<Produto> inputProduto;
    private JTextField inputLote;
    private JTextField inputQuantidade;
    private JLabel NomeProduto;
    private JLabel DataProduto;
    private JLabel LoteProduto;
    private JLabel QuantidadeProduto;
    private JLabel labelUnidade;
    private JButton removerButton;
    private JButton cancelarButton;

    public EcraSaidaStock(String windowTitle) {
        super(windowTitle);

        super.getScreen().setSize(600, 400);
        super.setupScreen(rootPanel);

        // populate list
        for (Produto produto : super.dataProvider.getProdutos()) {
            inputProduto.addItem(produto);
        }
    }
}
