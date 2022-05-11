package pt.ipleiria.ti.ecras;
import pt.ipleiria.ti.datamodel.Categoria;
import pt.ipleiria.ti.datamodel.Unidade;
import pt.ipleiria.ti.utils.BaseScreen;

import javax.swing.*;

public class EcraAdicionarProduto extends BaseScreen {
    private JPanel rootPanel;
    private JTextField inputNome;
    private JTextField inputDescricao;
    private JTextField inputPreco;
    private JComboBox<Categoria> inputCategoria;
    private JComboBox<Unidade> inputUnidade;
    private JLabel NomeProduto;
    private JLabel DescricaoProduto;
    private JLabel CategoriaProduto;
    private JLabel precoProduto;
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
    }
}
