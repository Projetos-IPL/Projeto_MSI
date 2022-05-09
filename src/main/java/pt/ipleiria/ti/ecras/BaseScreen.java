package pt.ipleiria.ti.ecras;

import pt.ipleiria.ti.utils.DataProvider;

import javax.swing.*;

public abstract class BaseScreen extends JFrame {

    protected final DataProvider dataProvider;

    public BaseScreen(String windowTitle) {
        super(windowTitle);
        this.dataProvider = new DataProvider();
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
