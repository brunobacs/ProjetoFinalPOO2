package Services;

import Interfaces.ClienteService;
import Models.Clientes.ClientePJ;

import java.util.TreeMap;

public class ClientePJService implements ClienteService<ClientePJ> {
    private TreeMap<Integer, ClientePJ> cnpjCadastrados;

    public ClientePJService(){
        this.cnpjCadastrados = new TreeMap<>();
    }

    @Override
    public void addCliente (ClientePJ cliente){
        if (cnpjCadastrados.containsKey(cliente.getId())){
            return;
        }
        this.cnpjCadastrados.put(cliente.getId(), cliente);
    }

    @Override
    public void removerCliente (ClientePJ cliente){
        int idToRemove = cliente.getId();
        this.cnpjCadastrados.remove(idToRemove);
    }

    @Override
    public ClientePJ buscarCliente (ClientePJ cliente){
        int idToFind = cliente.getId();
        return this.cnpjCadastrados.get(idToFind);
    }

    public ClientePJ buscarClientePorID (int idPJ){
        return this.cnpjCadastrados.get(idPJ);
    }

    @Override
    public void alterarNomeCliente (String novoNome, ClientePJ cliente){
        if (buscarCliente(cliente) == null){
            System.out.println("Cliente nao cadastrado na base de dados");
        }
        ClientePJ novoCliente = new ClientePJ(novoNome, cliente.getId());
        this.cnpjCadastrados.remove(cliente.getId());
        this.cnpjCadastrados.put(novoCliente.getId(), novoCliente);
    }
    @Override
    public void alterarCPFCliente (int novoCPF, ClientePJ cliente){
        if (buscarCliente(cliente)==null){
            System.out.println("Cliente nao cadastrado na base de dados");
        }
        removerCliente(cliente);
        ClientePJ novoCliente = new ClientePJ(cliente.getNome(), novoCPF);
        addCliente(novoCliente);
    }
}
