package pt.ipleiria.ti.ecras;

import javax.swing.*;
import java.io.IOException;

public class EcraPrincipal extends JFrame {
    private JPanel rootPanel;

    public EcraPrincipal(String windowTitle) {
        super(windowTitle);

        setContentPane(rootPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        pack();

        // widgets
        JMenuBar painelMenu = new JMenuBar();

        JMenu menuFicheiro = new JMenu("Ficheiro");
        JMenu menuProdutos = new JMenu("Produtos");
        JMenu menuStock = new JMenu("Stock");

        JMenuItem menuFicheiro_sobre = new JMenuItem("Sobre");

        JMenuItem menuProdutos_novo = new JMenuItem("Adicionar");
        JMenuItem menuProdutos_editar = new JMenuItem("Editar");
        JMenuItem menuProdutos_remover = new JMenuItem("Remover");

        JMenuItem menuStock_entrada = new JMenuItem("Entrada");
        JMenuItem menuStock_saida = new JMenuItem("Saída");
        JMenuItem menuStock_quebra = new JMenuItem("Quebra");

        menuFicheiro.add(menuFicheiro_sobre);

        menuProdutos.add(menuProdutos_novo);
        menuProdutos.add(menuProdutos_editar);
        menuProdutos.add(menuProdutos_remover);

        menuStock.add(menuStock_entrada);
        menuStock.add(menuStock_saida);
        menuStock.add(menuStock_quebra);

        painelMenu.add(menuFicheiro);
        painelMenu.add(menuProdutos);
        painelMenu.add(menuStock);

        setJMenuBar(painelMenu);

        // action listeners
        menuFicheiro_sobre.addActionListener(e -> {
            try {
                var janelaSobre = new JanelaSobre("Sobre");
                janelaSobre.setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        new EcraPrincipal("Ecrã Principal")
                .setVisible(true);
    }
}
