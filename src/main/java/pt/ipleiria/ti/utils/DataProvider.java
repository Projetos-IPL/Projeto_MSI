package pt.ipleiria.ti.utils;

import pt.ipleiria.ti.datamodel.Categoria;
import pt.ipleiria.ti.datamodel.ErrorMessage;
import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.datamodel.Unidade;
import pt.ipleiria.ti.datamodel.stock.StockEntrada;
import pt.ipleiria.ti.datamodel.stock.StockQuebra;
import pt.ipleiria.ti.datamodel.stock.StockSaida;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DataProvider {

    private static final DataProvider instance = new DataProvider();
    private final LinkedList<Categoria> categorias;
    private final LinkedList<Unidade> unidades;
    private final LinkedList<Produto> produtos;
    private final LinkedList<StockEntrada> stockEntrada;
    private final LinkedList<StockSaida> stockSaida;
    private final LinkedList<StockQuebra> stockQuebra;

    public DataProvider() {
        this.categorias = new LinkedList<>();
        this.unidades = new LinkedList<>();
        this.produtos = new LinkedList<>();

        this.stockEntrada = new LinkedList<>();
        this.stockSaida = new LinkedList<>();
        this.stockQuebra = new LinkedList<>();

        this.categorias.addAll(Arrays.asList(Categoria.values()));
        this.unidades.addAll(Arrays.asList(Unidade.values()));

        for (Categoria c : this.categorias) {
            Produto produto = new Produto("Produto", "Produto", Unidade.UNI, c, 123);
            this.produtos.add(produto);
            this.stockEntrada.add(new StockEntrada(produto, LocalDate.now(), 10, "abc"));
        }
    }

    public static DataProvider getInstance() {
        return instance;
    }

    public LinkedList<Categoria> getCategorias() {
        return this.categorias;
    }

    public LinkedList<Unidade> getUnidades() {
        return this.unidades;
    }

    public LinkedList<Produto> getProdutos() {
        return this.produtos;
    }

    public int getProdutoIndex(Produto produto) {
        return this.produtos.indexOf(produto);
    }

    public void editarProduto(Produto produtoAntigo, Produto produtoNovo) {
        this.produtos.remove(produtoAntigo);
        this.produtos.add(produtoNovo);
    }

    public LinkedList<StockEntrada> getStockEntrada() {
        return this.stockEntrada;
    }

    public LinkedList<StockSaida> getStockSaida() {
        return this.stockSaida;
    }

    public LinkedList<StockQuebra> getStockQuebra() {
        return this.stockQuebra;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    public void adicionarStockEntrada(StockEntrada stockEntrada) {
        boolean valido = Validation.isStockEntradaValido(stockEntrada.getData(), stockEntrada.getQuantidade());

        if (valido) {
            this.stockEntrada.add(stockEntrada);
            stockEntrada.getProduto().setQuantidadeStock(stockEntrada.getQuantidade());
        }
    }

    public void adicionarStockSaida(StockSaida stockSaida) {
        boolean valido = Validation.isStockSaidaValido(stockSaida);

        if (valido) {
            this.stockSaida.add(stockSaida);
        }
    }

    public void adicionarStockQuebra(StockQuebra stockQuebra) {
        int quantidadeStockAtual = stockQuebra.getProduto().getQuantidadeStock();

        if (stockQuebra.getQuantidade() > quantidadeStockAtual) {
            Error.showErrorMessage(ErrorMessage.QUANTIDADE_STOCK_QUEBRA_INVALIDA);
        } else {
            this.stockQuebra.add(stockQuebra);
        }
    }

    public List<StockEntrada> getStockEntradaForProduto(Produto produto) {
        return stockEntrada.stream()
                .filter(s -> s.getProduto() == produto).toList();
    }

    public List<StockQuebra> getStockQuebraForProduto(Produto produto) {
        return stockQuebra.stream()
                .filter(s -> s.getProduto() == produto).toList();
    }

    public List<StockSaida> getStockSaidaForProduto(Produto produto) {
        return stockSaida.stream()
                .filter(s -> s.getProduto() == produto).toList();
    }
}
