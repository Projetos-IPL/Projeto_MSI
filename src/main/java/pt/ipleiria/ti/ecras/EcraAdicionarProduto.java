package pt.ipleiria.ti.ecras;

import pt.ipleiria.ti.classes.BaseScreen;

import javax.swing.*;

public class EcraAdicionarProduto extends BaseScreen {
    private JPanel rootPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JLabel NomeProduto;
    private JLabel DescriçãoProduto;
    private JLabel CategoriaProduto;
    private JLabel PreçoProduto;
    private JButton adicionarProdutoButton;

    public EcraAdicionarProduto(String windowTitle) {
        super(windowTitle);

        super.getScreen().setSize(600, 400);
        super.setupScreen(rootPanel);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
