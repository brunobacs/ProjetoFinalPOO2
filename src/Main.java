import Models.Aluguel;
import Models.Clientes.ClientePF;
import Models.Veiculos.VeiculoPeq;

import java.time.Duration;
import java.time.LocalDateTime;

import static java.lang.Math.ceil;

public class Main {
    public static void main(String[] args) {

        Aluguel aluguel = new Aluguel();
        VeiculoPeq carrinho = new VeiculoPeq();
        ClientePF pessoaF = new ClientePF("joao", 123);
        aluguel.setVeiculo(carrinho);
        aluguel.setCliente(pessoaF);
        aluguel.setLocal("Fortaleza");

        LocalDateTime dataParaPassar1 = LocalDateTime.of(2023, 9, 10, 14, 30);
        LocalDateTime dataParaPassar2 = LocalDateTime.of(2023, 11, 3, 8, 30);
        aluguel.setDataAluguel(dataParaPassar1);
        aluguel.setDataDevolucao(dataParaPassar2);
        Duration diff = Duration.between(dataParaPassar1, dataParaPassar2);
        System.out.println(ceil(diff.toHours()/24.0) + " dias");
        System.out.println("Diferença em horas: " + diff.toHours());


        if (aluguel.getVeiculo() instanceof VeiculoPeq){
            System.out.println("carro pequeno");
        }


        System.out.println("Hello world!");
    }

}