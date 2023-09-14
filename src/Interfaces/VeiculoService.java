package Interfaces;

import Models.Veiculos.Veiculo;

import java.util.Map;
import java.util.TreeMap;

public interface VeiculoService {
    void addVeiculo(Veiculo veiculo);
    void removerVeiculo(Veiculo veiculo);
    Map<String, Veiculo> buscarVeiculoPorNome (String nome);
    Map<String, Veiculo> buscarVeiculoPorParteDoNome (String parteDoNome);
    void alterarNomeVeiculo(String nome, Veiculo veiculo);

    void alterarPlaca(String novaPlaca, Veiculo veiculo);
}
