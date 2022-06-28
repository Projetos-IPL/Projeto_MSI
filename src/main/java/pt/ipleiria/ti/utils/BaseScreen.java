package pt.ipleiria.ti.utils;

import pt.ipleiria.ti.ecras.geral.EcraPrincipal;

import javax.swing.*;

public abstract class BaseScreen extends JFrame {

    protected final DataProvider dataProvider;

    public BaseScreen(String windowTitle) {
        super("Gumbo | " + windowTitle);
        this.dataProvider = DataProvider.getInstance();
    }

    protected void setupScreen(JPanel rootPanel) {
        setContentPane(rootPanel);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();

        setLocationRelativeTo(null);
    }

    protected JFrame getScreen() {
        return this;
    }

    protected void closeScreen() {
        this.dispose();
        new EcraPrincipal("Ecrã Principal").setVisible(true);
    }
}
