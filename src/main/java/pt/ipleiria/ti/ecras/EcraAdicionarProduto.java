package pt.ipleiria.ti.ecras;

import pt.ipleiria.ti.classes.BaseScreen;

import javax.swing.*;

public class EcraAdicionarProduto extends BaseScreen {
    private JPanel rootPanel;

    public EcraAdicionarProduto(String windowTitle) {
        super(windowTitle);

        super.getScreen().setSize(800, 600);
        super.setupScreen(rootPanel);
    }
}
