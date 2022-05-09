package pt.ipleiria.ti.datamodel.enums;

public enum Categoria {

    FRUTA("Fruta"),
    LEGUME("Legume"),
    LATICINIO("Laticínio"),
    FUNGO("Fungo"),
    ESPECIARIA("Especiaria"),
    VERDURA("Verdura"),
    SEMENTE("Semente"),
    DOCE("Doce"),
    SALGADO("Salgado"),
    OUTRO("Outro");

    public final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
