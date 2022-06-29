package pt.ipleiria.ti.datamodel;

public enum ErrorMessage {

    PRODUTO_NOME_VAZIO("O nome do produto é inválido!"),
    PRODUTO_NOME_CARACTERES("O nome do produto tem de ter, pelo menos, 3 caracteres."),
    PRODUTO_VALOR_NEGATIVO("O valor do produto tem de ser positivo!"),
    PRODUTO_FORMULARIO_INVALIDO("Corrija o formulário!"),
    EDICAO_PRODUTO_NULO("Selecione um produto da lista"),
    NUMERO_INVALIDO("Número inválido!"),
    VALOR_PRODUTO_FALTA("Insira o valor do produto!"),
    QUANTIDADE_STOCK_SAIDA_INVALIDA("Quantidade de stock de saída inválida!"),
    QUANTIDADE_STOCK_QUEBRA_INVALIDA("Quantidade de stock de quebra inválida!"),
    DATA_INFERIR_30_DIAS("A data de validade do produto não pode ser inferior a 30 dias!"),
    DATA_VALIDADE_INFERIOR_HOJE("A data de validade tem de ser superior a hoje!"),
    QUANTIDADE_STOCK_ENTRADA_INVALIDA("Quantidade de stock de entrada inválida!"),
    DATA_STOCK_SAIDA_INFERIOR_ATUAL("A data do stock de saída tem de ser superior à data atual!"),
    DATA_STOCK_SAIDA_INFERIOR_STOCK_ENTRADA("A data do stock de saída tem de ser superior à data do stock de entrada!"),
    STOCK_SAIDA_LOTE_INVALIDO("O lote é inválido!");

    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
