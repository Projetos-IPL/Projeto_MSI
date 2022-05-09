package pt.ipleiria.ti.ecras;

import pt.ipleiria.ti.datamodel.Produto;

import javax.swing.*;

public class EcraSaidaStock extends BaseScreen {
    private JPanel rootPanel;
    private JTextField textField1;
    private JComboBox<Produto> inputProduto;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel NomeProduto;
    private JLabel DataProduto;
    private JLabel LoteProduto;
    private JLabel QuantidadeProduto;
    private JLabel labelUnidade;
    private JButton adicionarButton;
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
