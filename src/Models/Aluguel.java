package Models;

import Models.Clientes.Cliente;
import Models.Veiculos.Veiculo;

import java.time.LocalDateTime;

public class Aluguel {
    private Veiculo veiculo;
    private Cliente cliente;
    private LocalDateTime dataAluguel;
    private LocalDateTime dataDevolucao;
    private String local;

    public Aluguel(Veiculo veiculo, Cliente cliente, LocalDateTime dataAluguel, LocalDateTime dataDevolucao, String local) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
        this.local = local;
    }

    public Aluguel() {
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDateTime dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
