package Services;

import Interfaces.PagarAluguel;
import Models.Aluguel;
import Models.Veiculos.VeiculoSUV;

public class PrecoVeiculoSUV implements PagarAluguel<VeiculoSUV> {
    double diariasSUV;
    @Override
    public double calcularPrecoFinal(Aluguel aluguel) {
        AluguelService alugaServ = new AluguelService();
        double totalDiarias = alugaServ.calcularDiarias(aluguel);
        this.diariasSUV = totalDiarias;
        return totalDiarias * 200.0;
    }
    @Override
    public void pagarConta(Aluguel aluguel) {
        System.out.println("Voce pagou R$" + calcularPrecoFinal(aluguel)
                + "por " + diariasSUV + " diarias."
                + "Voce pode devolver o veiculo no seguinte local: " + aluguel.getLocal());
    }
}
