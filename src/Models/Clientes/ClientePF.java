package Models.Clientes;

public class ClientePF extends Cliente{

    public ClientePF(String nome, Integer id) {
        super(nome, id);
    }

    @Override
    public String identificarTipo() {
        return "Pessoa Física";
    }
}
