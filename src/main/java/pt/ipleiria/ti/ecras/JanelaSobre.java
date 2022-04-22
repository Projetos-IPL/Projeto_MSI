package pt.ipleiria.ti.ecras;

import javax.swing.*;
import java.io.IOException;

public class JanelaSobre extends JFrame {
    private JPanel rootPanel;

    public JanelaSobre(String windowTitle) throws IOException {
        super(windowTitle);

        setContentPane(rootPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setResizable(false);
        pack();

        setLocationRelativeTo(null);
    }
}
