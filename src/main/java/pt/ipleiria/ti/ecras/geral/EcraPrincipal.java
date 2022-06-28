package pt.ipleiria.ti.ecras.geral;

import pt.ipleiria.ti.datamodel.ErrorMessage;
import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.ecras.stock.EcraEntradaStock;
import pt.ipleiria.ti.ecras.stock.EcraListaStockEntrada;
import pt.ipleiria.ti.ecras.stock.EcraQuebraStock;
import pt.ipleiria.ti.ecras.stock.EcraSaidaStock;
import pt.ipleiria.ti.utils.BaseScreen;
import pt.ipleiria.ti.utils.Error;

import javax.swing.*;

public class EcraPrincipal extends BaseScreen {
    private final DefaultListModel<Produto> listaProdutosModel = new DefaultListModel<>();
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

        // widgets
        JMenuBar painelMenu = new JMenuBar();

        JMenu menuFicheiro = new JMenu("Ficheiro");
        JMenu menuProdutos = new JMenu("Produtos");
        JMenu menuStock = new JMenu("Stock");

        JMenuItem menuFicheiro_sobre = new JMenuItem("Sobre");
        JMenuItem menuFicheiro_sair = new JMenuItem("Sair");

        JMenuItem menuProdutos_novo = new JMenuItem("Adicionar");
        JMenuItem menuProdutos_editar = new JMenuItem("Editar");
        JMenuItem menuProdutos_remover = new JMenuItem("Remover");

        JMenuItem menuStock_entrada = new JMenuItem("Entrada");
        JMenuItem menuStock_saida = new JMenuItem("Saída");
        JMenuItem menuStock_quebra = new JMenuItem("Quebra");

        JMenuItem menuStock_listaSaida = new JMenuItem("Movimentos de Saída");
        JMenuItem menuStock_listaEntrada = new JMenuItem("Movimentos de Entrada");
        JMenuItem menuStock_listaQuebra = new JMenuItem("Movimentos de Quebra");

        menuFicheiro.add(menuFicheiro_sobre);
        menuFicheiro.add(menuFicheiro_sair);

        menuProdutos.add(menuProdutos_novo);
        menuProdutos.add(menuProdutos_editar);
        menuProdutos.add(menuProdutos_remover);

        menuStock.add(menuStock_entrada);
        menuStock.add(menuStock_saida);
        menuStock.add(menuStock_quebra);
        menuStock.add(new JSeparator());
        menuStock.add(menuStock_listaEntrada);
        menuStock.add(menuStock_listaSaida);
        menuStock.add(menuStock_listaQuebra);

        painelMenu.add(menuFicheiro);
        painelMenu.add(menuProdutos);
        painelMenu.add(menuStock);

        setJMenuBar(painelMenu);

        // action listeners
        menuFicheiro_sobre.addActionListener(e -> {
            var janelaSobre = new JanelaSobre("Sobre");
            janelaSobre.setVisible(true);
        });

        menuFicheiro_sair.addActionListener(e -> System.exit(0));

        menuProdutos_novo.addActionListener(e -> {
            var ecraAdicionarProduto = new EcraAdicionarProduto("Adicionar Produto");
            ecraAdicionarProduto.setVisible(true);
            this.dispose();
        });

        menuProdutos_editar.addActionListener(e -> {
            var selectedProduct = (Produto) listaProdutos.getSelectedValue();

            if (selectedProduct == null) {
                Error.showErrorMessage(ErrorMessage.EDICAO_PRODUTO_NULO);
            } else {
                var ecraEditarProduto = new EcraEditarProduto("Editar Produto - " + selectedProduct.getNome(),
                        selectedProduct);
                ecraEditarProduto.setVisible(true);
                this.dispose();
            }
        });

        menuProdutos_remover.addActionListener(e -> {
            var selectedProduct = (Produto) listaProdutos.getSelectedValue();

            if (selectedProduct == null) {
                Error.showErrorMessage(ErrorMessage.EDICAO_PRODUTO_NULO);
            } else {
                var result = JOptionPane.showConfirmDialog(
                        this,
                        "Deseja remover o produto " + selectedProduct.getNome() + " (" + selectedProduct.getValor() + "€)?",
                        "Remover Produto",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.YES_OPTION) {
                    super.dataProvider.removerProduto(selectedProduct);
                    atualizarListaProdutos();
                }
            }
        });

        menuStock_entrada.addActionListener(e -> {
            var ecraEntradaStock = new EcraEntradaStock("Entrada de Stock");
            ecraEntradaStock.setVisible(true);
            this.dispose();
        });

        menuStock_saida.addActionListener(e -> {
            var ecraSaidaStock = new EcraSaidaStock("Saída de Stock");
            ecraSaidaStock.setVisible(true);
            this.dispose();
        });

        menuStock_quebra.addActionListener(e -> {
            var ecraQuebraStock = new EcraQuebraStock("Quebra de Stock");
            ecraQuebraStock.setVisible(true);
            this.dispose();
        });

        menuStock_listaEntrada.addActionListener(e -> {
            var selectedProduct = (Produto) listaProdutos.getSelectedValue();

            if (selectedProduct == null) {
                Error.showErrorMessage(ErrorMessage.EDICAO_PRODUTO_NULO);
            } else {
                var ecraEntradaStockLista = new EcraListaStockEntrada("Lista de Movimentos de Entrada de Stock", selectedProduct);
                ecraEntradaStockLista.setVisible(true);
                this.dispose();
            }
        });

        // search bar
        // TODO
        inputPesquisa.addActionListener(e -> System.out.println("inputPesquisa = " + inputPesquisa.getText()));

        atualizarListaProdutos();

        listaProdutos.setModel(listaProdutosModel);
        listaProdutos.setFixedCellHeight(30);

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // setup Windows look and feel
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        new EcraPrincipal("Ecrã Principal").setVisible(true);
    }

    /**
     * Atualiza a lista de produtos no ecrã principal.
     * <p>
     * 1. Remove todos os elementos do widget lista
     * 2. Remove todos os elementos do modelo da lista
     * 3. Adiciona os produtos ao modelo da lista
     */
    private void atualizarListaProdutos() {
        listaProdutos.removeAll();
        listaProdutosModel.clear();

        for (Produto produto : super.dataProvider.getProdutos()) {
            listaProdutosModel.addElement(produto);
        }
    }
}
