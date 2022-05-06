package pt.ipleiria.ti.datamodel;

public enum Unidade {

    KG("Quilograma"),
    LT("Litro"),
    G("Grama"),
    UNI("Unitário");

    public final String descricao;

    Unidade(String descricao) {
        this.descricao = descricao;
    }
}
