package pt.ipleiria.ti.ecras;

import javax.swing.*;

public class EcraEntradaStock extends BaseScreen {
    private JPanel rootPanel;
    private JComboBox inputProduto;
    private JTextField inputDataEntrada;
    private JTextField inputLote;
    private JTextField inputQuantidade;
    private JTextField inputDataValidade;
    private JLabel labelUnidade;
    private JLabel labelProduto;
    private JLabel labelDataEntrada;
    private JLabel labelLote;
    private JLabel labelQuantidade;
    private JLabel labelPrazoValidade;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JPanel panelInputs;

    public EcraEntradaStock(String windowTitle) {
        super(windowTitle);

        super.getScreen().setSize(600, 400);
        super.setupScreen(rootPanel);

        cancelarButton.addActionListener(e -> {
            setVisible(false);
            dispose();
        });

        adicionarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Por implementar.");
        });
    }
}
