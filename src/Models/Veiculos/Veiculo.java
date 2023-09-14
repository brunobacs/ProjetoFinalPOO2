package Models.Veiculos;

import Interfaces.IdentificarTipo;

public abstract class Veiculo implements IdentificarTipo {
    String placa;
    String nome;
    Boolean disponivel;

    public Veiculo(String placa, Boolean disponivel, String nome) {
        this.placa = placa;
        this.disponivel = disponivel;
        this.nome = nome;
    }
    public Veiculo() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isDisponivel (){return this.disponivel;}

    public abstract double precoDiaria();

}
