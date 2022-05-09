package pt.ipleiria.ti.ecras;

import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.utils.BaseScreen;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EcraPrincipal extends BaseScreen {
    private JPanel rootPanel;
    private JTextField inputPesquisa;
    private JPanel panelPesquisa;
    private JPanel panelLista;
    private JList<Produto> listaProdutos;

    public EcraPrincipal(String windowTitle) {
        super(windowTitle);

        super.getScreen().setSize(800, 600);
        super.setupScreen(rootPanel);
        super.getScreen().setDefaultCloseOperation(EXIT_ON_CLOSE);

        // init
        DefaultListModel<Produto> listaProdutosModel = new DefaultListModel<>();

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

        menuProdutos_editar.addActionListener(e -> {
            var ecraEditarProduto = new EcraEditarProduto("Editar Produto");
            ecraEditarProduto.setVisible(true);
        });

        menuProdutos_remover.addActionListener(e -> JOptionPane.showMessageDialog(null, "Por implementar."));

        menuStock_entrada.addActionListener(e -> {
            var ecraEntradaStock = new EcraEntradaStock("Entrada de Stock");
            ecraEntradaStock.setVisible(true);
        });

        menuStock_saida.addActionListener(e -> {
            var ecraSaidaStock = new EcraSaidaStock("Saída de Stock");
            ecraSaidaStock.setVisible(true);
        });

        menuStock_quebra.addActionListener(e -> {
            var ecraQuebraStock = new EcraQuebraStock("Quebra de Stock");
            ecraQuebraStock.setVisible(true);
        });



        // search bar

        inputPesquisa.addActionListener(e -> System.out.println("inputPesquisa = " + inputPesquisa.getText()));

        // populate model
        for (Produto produto : super.dataProvider.getProdutos()) {
            listaProdutosModel.addElement(produto);
        }

        listaProdutos.setModel(listaProdutosModel);
        listaProdutos.setFixedCellHeight(30);

        // click on items
        listaProdutos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedIndex = listaProdutos.getSelectedIndex();

                    if (selectedIndex >= 0) {
                        Produto produto = dataProvider.getProdutos().get(selectedIndex);
                        System.out.println(produto.getId() + " - " + produto);
                    }
                }
            }
        });

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // setup Windows look and feel
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        new EcraPrincipal("Ecrã Principal").setVisible(true);
    }
}
