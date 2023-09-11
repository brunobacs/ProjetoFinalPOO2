package Interfaces;

public interface VeiculoService <T>{
    void addVeiculo(T veiculo);
    void removerVeiculo(T veiculo);
    T buscarVeiculoPorNome (String nome);
    void alterarNomeVeiculo(T veiculo);
    void alterarPlaca(String novaPlaca, T veiculo);
}
