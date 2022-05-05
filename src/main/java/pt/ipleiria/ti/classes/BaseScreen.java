package pt.ipleiria.ti.classes;

import javax.swing.*;

public abstract class BaseScreen extends JFrame {

    public BaseScreen(String windowTitle) {
        super(windowTitle);
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
