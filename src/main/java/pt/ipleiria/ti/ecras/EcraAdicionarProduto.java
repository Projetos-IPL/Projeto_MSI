package pt.ipleiria.ti.ecras;

import pt.ipleiria.ti.datamodel.Categoria;
import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.datamodel.Unidade;
import pt.ipleiria.ti.utils.BaseScreen;
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
            if (Validation.isProdutoValido(inputNome.getText(), inputPreco.getText())) {
                Produto produto = new Produto(
                        this.inputNome.getText(),
                        this.inputDescricao.getText(),
                        (Unidade) this.inputUnidade.getSelectedItem(),
                        (Categoria) this.inputCategoria.getSelectedItem()
                );

                super.dataProvider.adicionarProduto(produto);

                this.dispose();
                new EcraPrincipal("Ecrã Principal").setVisible(true);
            }
        });

        cancelarButton.addActionListener(e -> this.dispose());
    }
}
