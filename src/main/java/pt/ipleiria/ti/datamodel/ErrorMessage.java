package pt.ipleiria.ti.datamodel;

public enum ErrorMessage {
    PRODUTO_NOME_VAZIO("O nome do produto é inválido!"),
    PRODUTO_NOME_CARACTERES("O nome do produto tem de ter, pelo menos, 3 caracteres."),
    PRODUTO_VALOR_NEGATIVO("O valor do produto tem de ser positivo!"),
    PRODUTO_FORMULARIO_INVALIDO("Corriga o formulário!");

    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
