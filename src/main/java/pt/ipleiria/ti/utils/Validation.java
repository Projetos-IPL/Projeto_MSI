package pt.ipleiria.ti.utils;

import pt.ipleiria.ti.datamodel.ErrorMessage;

public class Validation {

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
}
