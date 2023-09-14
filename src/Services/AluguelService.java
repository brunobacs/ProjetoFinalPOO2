package Services;

import Models.Aluguel;
import Models.Clientes.Cliente;
import Models.Veiculos.Veiculo;
import com.sun.source.tree.Tree;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.TreeMap;

import static java.lang.Math.ceil;

public class AluguelService {

    private PortfolioVeiculos portfolioVeiculos;
    private TreeMap<Integer, Veiculo> veiculosAlugados;

    private TreeMap<Integer, Aluguel> alugueis;

    public AluguelService(PortfolioVeiculos portfolioVeiculos) {
        this.portfolioVeiculos = portfolioVeiculos;
        this.veiculosAlugados = new TreeMap<>();
        this.alugueis = new TreeMap<>();
    }

    public void alugarVeiculo (Cliente cliente, String placa, LocalDateTime inicio, LocalDateTime fim, String local){
        // RN5: Os veículos que estiverem alugados não poderão estar disponíveis;
        Veiculo veiculo = portfolioVeiculos.getVeiculoPorPlaca(placa);
        if (veiculo != null && veiculo.isDisponivel()) {
            veiculo.setDisponivel(false);
            veiculosAlugados.put(cliente.getId(), veiculo);
            Aluguel aluguel = new Aluguel(
                    veiculo,
                    cliente,
                    inicio,
                    fim,
                    local
            );
            alugueis.put(cliente.getId(), aluguel);

            System.out.println(veiculo.identificarTipo() + ", de nome: " +  veiculo.getNome() + ", " + "com placa " + placa + " alugado com sucesso para o cliente " + cliente.identificarTipo() + " "  +  cliente.getNome());
        } else {
            System.out.println("Veículo com placa " + placa + " não está disponível para aluguel.");
        }
    }
    public Aluguel devolverVeiculo (Cliente cliente){
        Integer idCliente = cliente.getId();
        Veiculo veiculo = veiculosAlugados.get(idCliente);
        Aluguel aluguel = alugueis.get(idCliente);

        if (idCliente == null){
            System.out.println("Não há registro de aluguel veículo para o cliente: " + cliente.getNome());
            return null;
        }

        veiculo.setDisponivel(true);
        veiculosAlugados.remove(idCliente);

        System.out.println("O cliente: " + cliente.getNome() + ", " + cliente.identificarTipo() +
                ", pagou R$" + calcularTotalDevido(idCliente)
                + " por " + diariasComputadas(idCliente)
                + " diarias. O " + veiculo.identificarTipo() +
                " pode ser devolvido no seguinte local: " + aluguel.getLocal());

//        System.out.println("O veículo alugado por " + cliente.identificarTipo() + ": " +
//                cliente.getNome() + ", de id: " + cliente.getId() + " foi devolvido com sucesso"
//                );

        alugueis.remove(idCliente);
        return aluguel;
    };

    public double diariasComputadas (int idCliente){
        Aluguel aluguel = alugueis.get(idCliente);
        LocalDateTime dataBuscaCarro = aluguel.getDataAluguel();
        LocalDateTime dataDevolverCarro = aluguel.getDataDevolucao();

        Duration diferenca = Duration.between(dataBuscaCarro, dataDevolverCarro);
        double diarias = ceil(diferenca.toHours() / 24.0);

        if (diarias <=0){
            return 0.0;
        }
        return diarias;
    }

    public double calcularTotalDevido(int idCliente){
        Aluguel aluguel = alugueis.get(idCliente);
        Veiculo carroAlugado = aluguel.getVeiculo();
        double diarias = diariasComputadas (idCliente);

        if (diarias > 3 && diarias <5){
            diarias = diarias * 0.9; //10% de desconto
        }
        if (diarias > 5){ diarias = diarias *0.95;} // 5% de desconto

        double preco = carroAlugado.precoDiaria();
        return preco*diarias;
    }
}