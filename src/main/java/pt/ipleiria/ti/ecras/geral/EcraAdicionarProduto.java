package pt.ipleiria.ti.ecras.geral;

import pt.ipleiria.ti.datamodel.Categoria;
import pt.ipleiria.ti.datamodel.ErrorMessage;
import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.datamodel.Unidade;
import pt.ipleiria.ti.utils.BaseScreen;
import pt.ipleiria.ti.utils.Error;
import pt.ipleiria.ti.utils.Validation;

import javax.swing.*;

public class EcraAdicionarProduto extends BaseScreen {
    private JPanel rootPanel;
    private JTextField inputNome;
    private JTextField inputDescricao;
    private JTextField inputPreco;
    private JComboBox<Categoria> inputCategoria;
    private JComboBox<Unidade> inputUnidade;
    private JButton adicionarProdutoButton;
    private JButton cancelarButton;

    public EcraAdicionarProduto(String windowTitle) {
        super(windowTitle);

        super.getScreen().setSize(600, 400);
        super.setupScreen(rootPanel);

        // populate lists
        for (Categoria categoria : super.dataProvider.getCategorias()) {
            inputCategoria.addItem(categoria);
        }

        for (Unidade unidade : super.dataProvider.getUnidades()) {
            inputUnidade.addItem(unidade);
        }

        // default values
        this.inputPreco.setText("0");

        adicionarProdutoButton.addActionListener(e -> {
            // validar formulário
            boolean produtoValido = Validation.isProdutoValido(inputNome.getText(), inputPreco.getText());

            if (produtoValido) {
                Produto produto = new Produto(
                        this.inputNome.getText(),
                        this.inputDescricao.getText(),
                        (Unidade) this.inputUnidade.getSelectedItem(),
                        (Categoria) this.inputCategoria.getSelectedItem(),
                        Double.parseDouble(this.inputPreco.getText())
                );

                super.dataProvider.adicionarProduto(produto);

                super.closeScreen();
            } else {
                Error.showErrorMessage(this, ErrorMessage.PRODUTO_FORMULARIO_INVALIDO);
            }
        });

        cancelarButton.addActionListener(e -> super.closeScreen());
    }
}
