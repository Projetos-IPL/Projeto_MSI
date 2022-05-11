package pt.ipleiria.ti.utils;

import pt.ipleiria.ti.datamodel.Categoria;
import pt.ipleiria.ti.datamodel.Produto;
import pt.ipleiria.ti.datamodel.Unidade;
import pt.ipleiria.ti.datamodel.stock.StockEntrada;
import pt.ipleiria.ti.datamodel.stock.StockQuebra;
import pt.ipleiria.ti.datamodel.stock.StockSaida;

import java.util.Arrays;
import java.util.LinkedList;

public class DataProvider {

    private final LinkedList<Categoria> categorias;
    private final LinkedList<Unidade> unidades;
    private final LinkedList<Produto> produtos;
    private LinkedList<StockEntrada> stockEntrada;
    private LinkedList<StockSaida> stockSaida;
    private LinkedList<StockQuebra> stockQuebra;

    public DataProvider() {
        this.categorias = new LinkedList<>();
        this.unidades = new LinkedList<>();
        this.produtos = new LinkedList<>();

        this.categorias.addAll(Arrays.asList(Categoria.values()));
        this.unidades.addAll(Arrays.asList(Unidade.values()));

        for (Categoria c : this.categorias) {
            this.produtos.add(new Produto("Produto", Unidade.UNI, c));
        }
    }

    public LinkedList<Categoria> getCategorias() {
        return categorias;
    }

    public LinkedList<Unidade> getUnidades() {
        return unidades;
    }

    public LinkedList<Produto> getProdutos() {
        return produtos;
    }

    public LinkedList<StockEntrada> getStockEntrada() {
        return stockEntrada;
    }

    public LinkedList<StockSaida> getStockSaida() {
        return stockSaida;
    }

    public LinkedList<StockQuebra> getStockQuebra() {
        return stockQuebra;
    }
}
