package pt.ipleiria.ti.ecras;

import javax.swing.*;

public class EcraQuebraStock extends BaseScreen {

    private JPanel rootPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JButton cancelarButton;
    private JButton registarButton;


    public EcraQuebraStock(String windowTitle) {
        super(windowTitle);

        super.getScreen().setSize(600, 400);
        super.setupScreen(rootPanel);

        cancelarButton.addActionListener(e -> {
            setVisible(false);
            dispose();
        });

        registarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Por implementar.");
        });
    }
}
