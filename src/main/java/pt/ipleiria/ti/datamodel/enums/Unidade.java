package pt.ipleiria.ti.datamodel.enums;

public enum Unidade {

    KG("Quilograma"),
    UNI("Unitário");

    public final String descricao;

    Unidade(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
