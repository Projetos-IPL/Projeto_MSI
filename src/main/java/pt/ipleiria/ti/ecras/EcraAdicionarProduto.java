package pt.ipleiria.ti.ecras;

import javax.swing.*;

public class EcraAdicionarProduto extends JFrame {
    private JPanel rootPanel;

    public EcraAdicionarProduto(String windowTitle) {
        super(windowTitle);

        setContentPane(rootPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);

        setAlwaysOnTop(true);
        setResizable(false);
        pack();

        setLocationRelativeTo(null);
    }
}
