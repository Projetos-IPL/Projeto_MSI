package pt.ipleiria.ti.ecras.stock;

import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.datamodel.stock.StockEntrada;
import pt.ipleiria.ti.utils.BaseScreen;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class EcraEntradaStock extends BaseScreen {
    private JPanel rootPanel;
    private JComboBox<Produto> inputProduto;
    private JTextField inputLote;
    private JTextField inputQuantidade;
    private JTextField inputDataValidade;
    private JLabel labelUnidade;
    private JLabel labelProduto;
    private JLabel labelDataEntrada;
    private JLabel labelLote;
    private JLabel labelQuantidade;
    private JLabel labelPrazoValidade;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JPanel panelInputs;
    private JTextField inputDataEntrada;

    public EcraEntradaStock(String windowTitle) {
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

        adicionarButton.addActionListener(e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(inputDataValidade.getText(), formatter);

            super.dataProvider.adicionarStockEntrada(new StockEntrada(
                    (Produto) this.inputProduto.getSelectedItem(),
                    date,
                    Integer.parseInt(inputQuantidade.getText()),
                    inputLote.getText()
            ));

            super.closeScreen();
        });
    }
}
