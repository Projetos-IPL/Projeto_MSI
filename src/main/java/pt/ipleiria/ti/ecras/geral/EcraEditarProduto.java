package pt.ipleiria.ti.ecras.geral;

import pt.ipleiria.ti.datamodel.Categoria;
import pt.ipleiria.ti.datamodel.ErrorMessage;
import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.datamodel.Unidade;
import pt.ipleiria.ti.utils.BaseScreen;
import pt.ipleiria.ti.utils.Error;
import pt.ipleiria.ti.utils.Validation;

import javax.swing.*;

public class EcraEditarProduto extends BaseScreen {

    private JPanel rootPanel;
    private JTextField inputNome;
    private JTextField inputDescricao;
    private JTextField inputPreco;
    private JComboBox<Categoria> inputCategoria;
    private JComboBox<Unidade> inputUnidade;
    private JButton editarProdutoButton;
    private JButton cancelarButton;

    public EcraEditarProduto(String windowTitle, Produto produtoSelecionado) {
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

        editarProdutoButton.addActionListener(e -> {
            // validar formulário
            boolean produtoValido = Validation.isProdutoValido(inputNome.getText(), inputPreco.getText());

            if (produtoValido) {
                Produto produtoNovo = new Produto(
                        this.inputNome.getText(),
                        this.inputDescricao.getText(),
                        (Unidade) this.inputUnidade.getSelectedItem(),
                        (Categoria) this.inputCategoria.getSelectedItem(),
                        Double.parseDouble(this.inputPreco.getText())
                );

                super.dataProvider.editarProduto(produtoSelecionado, produtoNovo);

                super.closeScreen();
            } else {
                Error.showErrorMessage(ErrorMessage.PRODUTO_FORMULARIO_INVALIDO);
            }
        });

        cancelarButton.addActionListener(e -> super.closeScreen());

        this.inputNome.setText(produtoSelecionado.getNome());
        this.inputDescricao.setText(produtoSelecionado.getDescricao());
        this.inputCategoria.setSelectedItem(produtoSelecionado.getCategoria());
        this.inputUnidade.setSelectedItem(produtoSelecionado.getUnidade());
        this.inputPreco.setText(String.valueOf(produtoSelecionado.getValor()));

        this.editarProdutoButton.setText("Editar Produto");
    }
}
