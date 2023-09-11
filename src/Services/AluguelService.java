package Services;

import Models.Aluguel;

import java.time.Duration;
import java.time.LocalDateTime;

import static java.lang.Math.ceil;

public class AluguelService {

    public AluguelService() {
    }

    public double calcularDiarias(Aluguel aluguel){

        LocalDateTime dataBuscaCarro = aluguel.getDataAluguel();
        LocalDateTime dataDevolverCarro = aluguel.getDataDevolucao();

        Duration diferenca = Duration.between(dataBuscaCarro, dataDevolverCarro);
        double diarias = ceil(diferenca.toHours() / 24.0);

        if (diarias <=0){
            return 0.0;
        }
        return diarias;
    }
}
