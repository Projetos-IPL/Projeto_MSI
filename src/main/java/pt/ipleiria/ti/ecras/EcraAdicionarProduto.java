package pt.ipleiria.ti.ecras;

import pt.ipleiria.ti.datamodel.enums.Categoria;
import pt.ipleiria.ti.datamodel.enums.Unidade;

import javax.swing.*;

public class EcraAdicionarProduto extends BaseScreen {
    private JPanel rootPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JComboBox<String> inputCategoria;
    private JComboBox<String> inputUnidade;
    private JLabel NomeProduto;
    private JLabel DescriçãoProduto;
    private JLabel CategoriaProduto;
    private JLabel PreçoProduto;
    private JButton adicionarProdutoButton;

    public EcraAdicionarProduto(String windowTitle) {
        super(windowTitle);

        super.getScreen().setSize(600, 400);
        super.setupScreen(rootPanel);

        // populate lists
        for (Categoria categoria : super.dataProvider.getCategorias()) {
            inputCategoria.addItem(categoria.descricao);
        }

        for (Unidade unidade : super.dataProvider.getUnidades()) {
            inputUnidade.addItem(unidade.descricao);
        }
    }
}
