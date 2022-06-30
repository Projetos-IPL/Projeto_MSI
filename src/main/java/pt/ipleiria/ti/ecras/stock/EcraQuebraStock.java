package pt.ipleiria.ti.ecras.stock;

import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.datamodel.stock.StockQuebra;
import pt.ipleiria.ti.utils.BaseScreen;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class EcraQuebraStock extends BaseScreen {

    private JPanel rootPanel;
    private JTextField txtDataStock;
    private JTextField txtQuantidade;
    private JTextField txtLote;
    private JComboBox<Produto> cbProduto;
    private JButton cancelarButton;
    private JButton registarButton;
    private JLabel labelUnidade;


    public EcraQuebraStock(String windowTitle) {
        super(windowTitle);

        super.getScreen().setSize(600, 400);
        super.setupScreen(rootPanel);

        // populate list
        for (Produto produto : super.dataProvider.getProdutos()) {
            cbProduto.addItem(produto);
        }

        labelUnidade.setText(((Produto) Objects.requireNonNull(cbProduto.getSelectedItem())).getUnidade().descricao);

        cbProduto.addActionListener(e -> labelUnidade.setText(((Produto) cbProduto.getSelectedItem()).getUnidade().descricao));

        cancelarButton.addActionListener(e -> super.closeScreen());

        registarButton.addActionListener(e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(txtDataStock.getText(), formatter);

            StockQuebra stock = new StockQuebra(
                    (Produto) cbProduto.getSelectedItem(),
                    date,
                    Integer.parseInt(txtQuantidade.getText()),
                    txtLote.getText()
            );

            super.dataProvider.adicionarStockQuebra(stock);

            super.closeScreen();
        });
    }
}
