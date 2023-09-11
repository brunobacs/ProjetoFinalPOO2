package Models.Clientes;

import java.util.TreeMap;

public abstract class Cliente {
    String nome;
    Integer id;

    public Cliente(String nome, Integer id) {
        this.nome = nome;
        this.id = id;
    }

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                nome + '\'';
    }
}
