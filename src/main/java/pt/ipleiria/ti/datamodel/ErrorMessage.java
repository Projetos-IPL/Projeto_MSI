package pt.ipleiria.ti.datamodel;

public enum ErrorMessage {
    PRODUTO_NOME_VAZIO("O nome do produto é inválido!"),
    PRODUTO_NOME_CARACTERES("O nome do produto tem de ter, pelo menos, 3 caracteres."),
    PRODUTO_VALOR_NEGATIVO("O valor do produto tem de ser positivo!"),
    PRODUTO_FORMULARIO_INVALIDO("Corrija o formulário!"),
    EDICAO_PRODUTO_NULO("Selecione um produto da lista"),
    NUMERO_INVALIDO("Número inválido!"),
    VALOR_PRODUTO_FALTA("Insira o valor do produto"),
    QUANTIDADE_STOCK_SAIDA_INVALIDA("Quantidade de stock de saída inválido!"),
    QUANTIDADE_STOCK_QUEBRA_INVALIDA("Quantidade de stock de quebra inválido!");

    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
