package pt.ipleiria.ti.datamodel;

public enum Unidade {
    
    UNI("Unitário"),
    KG("Quilograma");

    public final String descricao;

    Unidade(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}