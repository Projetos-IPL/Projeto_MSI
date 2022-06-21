package pt.ipleiria.ti.utils;

import javax.swing.*;

public abstract class BaseScreen extends JFrame {

    protected final DataProvider dataProvider;

    public BaseScreen(String windowTitle) {
        super("Gumbo | " + windowTitle);
        this.dataProvider = DataProvider.getInstance();
    }

    public void setupScreen(JPanel rootPanel) {
        setContentPane(rootPanel);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();

        setLocationRelativeTo(null);
    }

    public JFrame getScreen() {
        return this;
    }
}
