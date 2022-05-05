package pt.ipleiria.ti.ecras;

import pt.ipleiria.ti.classes.BaseScreen;

import javax.swing.*;

public class EcraPrincipal extends BaseScreen {
    private JPanel rootPanel;
    private JTextField inputPesquisa;
    private JPanel panelPesquisa;
    private JPanel panelLista;

    public EcraPrincipal(String windowTitle) {
        super(windowTitle);

        super.getScreen().setSize(800, 600);
        super.setupScreen(rootPanel);
        super.getScreen().setDefaultCloseOperation(EXIT_ON_CLOSE);

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
            var janelaSobre = new JanelaSobre("Sobre");
            janelaSobre.setVisible(true);
        });

        menuProdutos_novo.addActionListener(e -> {
            var ecraAdicionarProduto = new EcraAdicionarProduto("Adicionar Produto");
            ecraAdicionarProduto.setVisible(true);
        });

        menuStock_entrada.addActionListener(e -> {
            var ecraEntradaStock = new EcraEntradaStock("Entrada de Stock");
            ecraEntradaStock.setVisible(true);
        });

        inputPesquisa.addActionListener(e -> {
            System.out.println("inputPesquisa = " + inputPesquisa.getText());
        });

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        new EcraPrincipal("Ecrã Principal").setVisible(true);
    }
}
