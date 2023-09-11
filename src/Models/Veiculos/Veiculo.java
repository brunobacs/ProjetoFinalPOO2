package Models.Veiculos;

public abstract class Veiculo {
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
}
