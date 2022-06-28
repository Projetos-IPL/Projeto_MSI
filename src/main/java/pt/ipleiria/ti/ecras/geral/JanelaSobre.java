package pt.ipleiria.ti.ecras.geral;

import pt.ipleiria.ti.utils.BaseScreen;

import javax.swing.*;

public class JanelaSobre extends BaseScreen {
    private JPanel rootPanel;

    public JanelaSobre(String windowTitle) {
        super(windowTitle);

        super.getScreen().setSize(400, 200);
        super.setupScreen(rootPanel);
        super.getScreen().setAlwaysOnTop(true);
    }
}
