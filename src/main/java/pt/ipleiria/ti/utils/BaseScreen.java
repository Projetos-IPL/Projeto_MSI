package pt.ipleiria.ti.utils;

import pt.ipleiria.ti.ecras.geral.EcraPrincipal;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class BaseScreen extends JFrame {

    protected final DataProvider dataProvider;

    public BaseScreen(String windowTitle) {
        super("Gumbo | " + windowTitle);
        this.dataProvider = DataProvider.getInstance();
    }

    protected void setupScreen(JPanel rootPanel) {
        setContentPane(rootPanel);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeScreen();
            }
        });

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
