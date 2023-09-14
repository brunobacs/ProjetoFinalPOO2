package Models.Veiculos;

public class VeiculoSUV extends Veiculo{
    public VeiculoSUV(String placa, Boolean disponivel, String nome) {
        super(placa, disponivel, nome);
    }

    public VeiculoSUV() {
    }
    @Override
    public double precoDiaria() {return 200.0;}

    @Override
    public String identificarTipo() {
        return "Veiculo SUV";
    }
}
