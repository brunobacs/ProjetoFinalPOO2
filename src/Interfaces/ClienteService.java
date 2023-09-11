package Interfaces;

import Models.Clientes.ClientePF;

public interface ClienteService<T> {
    void addCliente (T cliente);
    void removerCliente (T clientePF);
    T buscarCliente (T clientePF);
    void alterarNomeCliente (String novoNome, T cliente);
    void alterarCPFCliente (int novoCPF, T cliente);

}
