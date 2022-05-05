package pt.ipleiria.ti.classes;

import java.util.UUID;

public class Categoria {

    private final String id;
    private String nome;

    public Categoria(String nome) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
