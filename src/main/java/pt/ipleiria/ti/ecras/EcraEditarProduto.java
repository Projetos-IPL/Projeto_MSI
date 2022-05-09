package pt.ipleiria.ti.ecras;

import pt.ipleiria.ti.datamodel.Categoria;
import pt.ipleiria.ti.datamodel.Unidade;

import javax.swing.*;

public class EcraEditarProduto extends BaseScreen {

    private JPanel rootPanel;
    private JTextField inputNome;
    private JTextField inputDescricao;
    private JComboBox <String> inputCategoria;
    private JTextField inputValor;
    private JComboBox <String> inputUnidade;
    private JButton buttonEditar;

    public EcraEditarProduto(String windowTitle) {
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
