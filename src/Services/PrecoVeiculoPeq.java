package Services;

import Interfaces.PagarAluguel;
import Models.Aluguel;
import Models.Veiculos.VeiculoPeq;

public class PrecoVeiculoPeq implements PagarAluguel<VeiculoPeq> {

    double diariasVP;
    @Override
    public double calcularPrecoFinal(Aluguel aluguel) {
        AluguelService alugaServ = new AluguelService();
        double totalDiarias = alugaServ.calcularDiarias(aluguel);
        this.diariasVP = totalDiarias;
        return totalDiarias * 100.0;
    }

    @Override
    public void pagarConta(Aluguel aluguel) {
        System.out.println("Voce pagou R$" + calcularPrecoFinal(aluguel)
                + "por " + diariasVP + " diarias."
                + "Voce pode devolver o veiculo no seguinte local: " + aluguel.getLocal());
    }
}
