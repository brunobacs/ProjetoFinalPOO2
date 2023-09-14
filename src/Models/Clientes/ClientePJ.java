package Models.Clientes;

public class ClientePJ extends Cliente{
    public ClientePJ(String nome, Integer id) {
        super(nome, id);
    }
    @Override
    public String identificarTipo() {
        return "Pessoa Jurídica";
    }
}
