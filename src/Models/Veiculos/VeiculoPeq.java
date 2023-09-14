package Models.Veiculos;

public class VeiculoPeq extends Veiculo{
    public VeiculoPeq(String placa, Boolean disponivel, String nome) {
        super(placa, disponivel, nome);
    }

    public VeiculoPeq() {
    }
    @Override
    public double precoDiaria() {return 100.0;}


    @Override
    public String identificarTipo() {
        return "Veiculo Pequeno";
    }
}
