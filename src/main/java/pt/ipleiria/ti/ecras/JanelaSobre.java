package pt.ipleiria.ti.ecras;

import javax.swing.*;

public class JanelaSobre extends JFrame {
    private JPanel rootPanel;

    public JanelaSobre(String windowTitle) {
        super(windowTitle);

        setContentPane(rootPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 200);

        setAlwaysOnTop(true);
        setResizable(false);
        pack();

        setLocationRelativeTo(null);
    }
}
