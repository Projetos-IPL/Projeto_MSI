package pt.ipleiria.ti.utils;

import pt.ipleiria.ti.datamodel.Data;
import pt.ipleiria.ti.datamodel.ErrorMessage;
import pt.ipleiria.ti.datamodel.stock.StockEntrada;
import pt.ipleiria.ti.datamodel.stock.StockSaida;

import java.time.LocalDate;

public class Validation {

    private static final DataProvider dataProvider = DataProvider.getInstance();

    /**
     * Valida o formulário de Adicionar Produto.
     * <p>
     * - Nome está preenchido
     * - Nome tem pelo menos 3 caracteres
     * - Valor é maior que 0
     *
     * @param nomeProduto  O nome do produto
     * @param valorProduto O valor do produto
     * @return Se o formulário está ou não válido.
     */
    public static boolean isProdutoValido(String nomeProduto, String valorProduto) {
        boolean valido = true;
        float valor = -1;

        if (valorProduto.isBlank()) {
            valido = false;
            Error.showErrorMessage(ErrorMessage.VALOR_PRODUTO_FALTA);
        }

        try {
            valor = Float.parseFloat(valorProduto);
        } catch (NumberFormatException e) {
            valido = false;
            Error.showErrorMessage(ErrorMessage.NUMERO_INVALIDO);
        }

        if (valor != -1) {
            if (valor < 0) {
                valido = false;
                Error.showErrorMessage(ErrorMessage.PRODUTO_VALOR_NEGATIVO);
            }
        }

        if (valido && nomeProduto.trim().isBlank()) {
            valido = false;
            Error.showErrorMessage(ErrorMessage.PRODUTO_NOME_VAZIO);
        } else if (valido && nomeProduto.trim().length() < 3) {
            valido = false;
            Error.showErrorMessage(ErrorMessage.PRODUTO_NOME_CARACTERES);
        } else if (valido && valor < 0) {
            valido = false;
            Error.showErrorMessage(ErrorMessage.PRODUTO_VALOR_NEGATIVO);
        }

        return valido;
    }

    public static boolean isStockEntradaValido(LocalDate dataValidade, int quantidade) {
        boolean valido = true;

        if (Data.getDatesDiff(dataValidade).toDays() < 0) {
            valido = false;
            Error.showErrorMessage(ErrorMessage.DATA_INFERIR_30_DIAS);
        } else if (valido && dataValidade.toEpochDay() < LocalDate.now().toEpochDay()) {
            valido = false;
            Error.showErrorMessage(ErrorMessage.DATA_VALIDADE_INFERIOR_HOJE);
        } else if (valido && quantidade <= 0) {
            valido = false;
            Error.showErrorMessage(ErrorMessage.QUANTIDADE_STOCK_ENTRADA_INVALIDA);
        }

        return valido;
    }

    public static boolean isStockSaidaValido(StockSaida stockSaida) {
        boolean valido = true;
        boolean found = false;
        boolean loteFound = false;
        int quantidadeStock = 0;
        LocalDate dataEntradaStock = null;

        for (StockEntrada s : dataProvider.getStockEntradaForProduto(stockSaida.getProduto())) {
            if (s.getProduto() == stockSaida.getProduto() && s.getLote() == stockSaida.getLote()) {
                found = true;
                quantidadeStock = s.getQuantidade();
                dataEntradaStock = s.getData();
                break;
            }
        }

        for (StockEntrada s : dataProvider.getStockEntradaForProduto(stockSaida.getProduto())) {
            if (s.getLote() == stockSaida.getLote()) {
                loteFound = true;
                break;
            }
        }

        if (found) {
            if (stockSaida.getQuantidade() != quantidadeStock) {
                valido = false;
                Error.showErrorMessage(ErrorMessage.QUANTIDADE_STOCK_SAIDA_INVALIDA);
            } else if (valido && stockSaida.getData().toEpochDay() < LocalDate.now().toEpochDay()) {
                valido = false;
                Error.showErrorMessage(ErrorMessage.DATA_STOCK_SAIDA_INFERIOR_ATUAL);
            } else if (valido && stockSaida.getData().toEpochDay() < dataEntradaStock.toEpochDay()) {
                valido = false;
                Error.showErrorMessage(ErrorMessage.DATA_STOCK_SAIDA_INFERIOR_STOCK_ENTRADA);
            } else if (valido && loteFound) {
                valido = false;
                Error.showErrorMessage(ErrorMessage.STOCK_SAIDA_LOTE_INVALIDO);
            }
        }

        return valido;
    }
}
