package pt.ipleiria.ti.ecras.stock;

import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.datamodel.stock.StockSaida;
import pt.ipleiria.ti.utils.BaseScreen;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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

        labelUnidade.setText(((Produto) Objects.requireNonNull(inputProduto.getSelectedItem())).getUnidade().descricao);

        // change units on product change
        inputProduto.addActionListener(e -> labelUnidade.setText(((Produto) inputProduto.getSelectedItem()).getUnidade().descricao));

        // actions
        cancelarButton.addActionListener(e -> super.closeScreen());

        removerButton.addActionListener(e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(inputData.getText(), formatter);

            super.dataProvider.adicionarStockSaida(new StockSaida(
                    (Produto) inputProduto.getSelectedItem(),
                    date,
                    Integer.parseInt(inputQuantidade.getText()),
                    inputLote.getText()
            ));

            super.closeScreen();
        });
    }
}
