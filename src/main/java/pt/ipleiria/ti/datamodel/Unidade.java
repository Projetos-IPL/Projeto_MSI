package pt.ipleiria.ti.datamodel;

public enum Unidade {

    KG("Quilograma"),
    UNI("Unitário");

    public final String descricao;

    Unidade(String descricao) {
        this.descricao = descricao;
    }
}
