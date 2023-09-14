package Services;

import Interfaces.VeiculoService;
import Models.Clientes.ClientePF;
import Models.Veiculos.Veiculo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PortfolioVeiculos implements VeiculoService {

    private TreeMap<String, Veiculo> portfolioDisponivel;

    public PortfolioVeiculos(){
        this.portfolioDisponivel = new TreeMap<>();
    }
    @Override
    public void addVeiculo(Veiculo veiculo) {
        if (portfolioDisponivel.containsKey(veiculo.getPlaca())){
            return;
        }

        this.portfolioDisponivel.put(veiculo.getPlaca(),veiculo);
    }

    @Override
    public void removerVeiculo(Veiculo veiculo) {
        this.portfolioDisponivel.remove(veiculo);
    }

    @Override
    public Map<String, Veiculo> buscarVeiculoPorNome(String nome) {
        Map<String, Veiculo> veiculosComMesmoNome = new HashMap<>();

        for (Map.Entry<String, Veiculo> entry : portfolioDisponivel.entrySet()) {
            Veiculo veiculo = entry.getValue();
            if (veiculo.getNome().equals(nome)) {
                veiculosComMesmoNome.put(entry.getKey(), veiculo);
            }
        }

        if (!veiculosComMesmoNome.isEmpty()) {
            return veiculosComMesmoNome;
        }

        return null;
    }

    @Override
    public Map<String, Veiculo> buscarVeiculoPorParteDoNome(String parteDoNome) {
        Map<String, Veiculo> veiculosEncontrados = new HashMap<>();

        for (Map.Entry<String, Veiculo> entry : portfolioDisponivel.entrySet()) {
            Veiculo veiculo = entry.getValue();
            String nomeDoVeiculo = veiculo.getNome();

            if (nomeDoVeiculo.toLowerCase().contains(parteDoNome.toLowerCase())) {
                veiculosEncontrados.put(veiculo.getPlaca(), veiculo);
            }
        }

        return veiculosEncontrados;
    }


    @Override
    public void alterarNomeVeiculo(String novoNome, Veiculo veiculo) {
        if (portfolioDisponivel.get(veiculo.getPlaca()) == null){
            System.out.println("Veiculo nao cadastrado no portfolio");
        }
        Veiculo veiculoExistente = portfolioDisponivel.get(veiculo.getPlaca());
        veiculoExistente.setNome(novoNome);

        this.portfolioDisponivel.remove(veiculo.getPlaca());
        this.portfolioDisponivel.put(veiculoExistente.getPlaca(), veiculoExistente);
    }

    @Override
    public void alterarPlaca(String novaPlaca, Veiculo veiculo) {
        if (portfolioDisponivel.containsKey(veiculo.getPlaca())) {
            Veiculo veiculoExistente = portfolioDisponivel.get(veiculo.getPlaca());
            portfolioDisponivel.remove(veiculo.getPlaca());
            veiculoExistente.setPlaca(novaPlaca);
            portfolioDisponivel.put(veiculoExistente.getPlaca(), veiculoExistente);
        } else {
            System.out.println("Veículo não encontrado no portfólio.");
        }
    }

    public Veiculo getVeiculoPorPlaca(String placa){
        return this.portfolioDisponivel.get(placa);
    }

}
