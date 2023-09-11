package Services;

import Interfaces.PagarAluguel;
import Models.Aluguel;
import Models.Veiculos.VeiculoMed;

import java.sql.SQLOutput;

public class PrecoVeiculoMed implements PagarAluguel<VeiculoMed> {

    double diariasVM;
    @Override
    public double calcularPrecoFinal(Aluguel aluguel) {
        AluguelService alugaServ = new AluguelService();
        double totalDiarias = alugaServ.calcularDiarias(aluguel);
        this.diariasVM = totalDiarias;
        return totalDiarias * 150.0;
    }

    @Override
    public void pagarConta(Aluguel aluguel) {
        System.out.println(
                "Voce pagou R$" + calcularPrecoFinal(aluguel)
                        + "por " + diariasVM
                        + " diarias. Voce pode devolver o veiculo no seguinte local: "
                        + aluguel.getLocal());
    }
}
