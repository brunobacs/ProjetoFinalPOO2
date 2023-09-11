package Services;

import Interfaces.ClienteService;
import Models.Clientes.ClientePF;

import java.util.TreeMap;

public class ClientePFService implements ClienteService<ClientePF> {
    TreeMap<Integer, ClientePF> cpfCadastrados;

    @Override
    public void addCliente (ClientePF cliente){
        this.cpfCadastrados.put(cliente.getId(), cliente);
    }

    @Override
    public void removerCliente (ClientePF clientePF){
        int idToRemove = clientePF.getId();
        this.cpfCadastrados.remove(idToRemove);
    }

    @Override
    public ClientePF buscarCliente (ClientePF clientePF){
        int idToFind = clientePF.getId();
        return this.cpfCadastrados.get(idToFind);
    }
    @Override
    public void alterarNomeCliente (String novoNome, ClientePF clientePF){
        if (buscarCliente(clientePF) == null){
            System.out.println("Cliente nao cadastrado na base de dados");
        }
        ClientePF novoCliente = new ClientePF(novoNome, clientePF.getId());
        this.cpfCadastrados.remove(clientePF.getId());
        this.cpfCadastrados.put(novoCliente.getId(), novoCliente);
    }
    @Override
    public void alterarCPFCliente (int novoCPF, ClientePF clientePF){
        if (buscarCliente(clientePF)==null){
            System.out.println("Cliente nao cadastrado na base de dados");
        }
        removerCliente(clientePF);
        ClientePF novoCliente = new ClientePF(clientePF.getNome(), novoCPF);
        addCliente(novoCliente);
    }

}
