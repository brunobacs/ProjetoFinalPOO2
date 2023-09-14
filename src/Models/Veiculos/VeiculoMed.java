package Models.Veiculos;

public class VeiculoMed extends Veiculo{
    public VeiculoMed(String placa, Boolean disponivel, String nome) {
        super(placa, disponivel, nome);
    }

    public VeiculoMed() {
    }

    @Override
    public double precoDiaria() {return 150.0;}


    @Override
    public String identificarTipo() {
        return "Veiculo Médio";
    }
}
