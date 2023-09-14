import Models.Aluguel;
import Models.Clientes.Cliente;
import Models.Clientes.ClientePF;
import Models.Clientes.ClientePJ;
import Models.Veiculos.Veiculo;
import Models.Veiculos.VeiculoMed;
import Models.Veiculos.VeiculoPeq;
import Models.Veiculos.VeiculoSUV;
import Services.AluguelService;
import Services.ClientePFService;
import Services.ClientePJService;
import Services.PortfolioVeiculos;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Math.ceil;

public class Main {
    public static void main(String[] args) {

        double total = 0.0;

        //Services
        PortfolioVeiculos portfolio = new PortfolioVeiculos();
        AluguelService AluguelPFService = new AluguelService(portfolio);
        AluguelService AluguelPJService = new AluguelService(portfolio);
        ClientePFService pfService = new ClientePFService();
        ClientePJService pjService = new ClientePJService();

        // Instanciar clientes PF
        ClientePF pessoaFisica1 = new ClientePF("Jesus", 12394);
        ClientePF pessoaFisica2 = new ClientePF("Maria", 15694);
        ClientePF pessoaFisica3 = new ClientePF("Jose", 14421);
        ClientePF pessoa171 = new ClientePF("Estelionatalio", 12394);

        //Cadastrar clientes PF
        pfService.addCliente(pessoaFisica1);
        pfService.addCliente(pessoaFisica2);
        pfService.addCliente(pessoaFisica3);
        pfService.addCliente(pessoa171);

        ClientePF clienteDesejado = pfService.buscarCliente(pessoaFisica1);
        if (clienteDesejado.getId() == 12394){
            if (clienteDesejado.getNome().equalsIgnoreCase("Jesus")){
            total = total + 1.0;
            }
        }

        pfService.alterarNomeCliente("Marieta", pessoaFisica2);
        ClientePF clienteAlterado = pfService.buscarClientePorId(pessoaFisica2.getId());
        if (clienteAlterado.getNome().equalsIgnoreCase("Marieta")){
            total = total + 1.0;
        }


        // Instanciar clientes PJ
        ClientePJ empresa1 = new ClientePJ("Romcy", 5134124);
        ClientePJ empresaErrada = new ClientePJ("Gentilandia", 5134124);
        ClientePJ empresa2 = new ClientePJ("Mesbla", 7890213);
        ClientePJ empresa3 = new ClientePJ("Lojas Brasileiras", 13211);

        //Cadastrar PJ
        pjService.addCliente(empresa1);
        pjService.addCliente(empresaErrada);
        pjService.addCliente(empresa2);
        pjService.addCliente(empresa3);

        // Alterar nome PJ
        ClientePJ pjDesejado = pjService.buscarCliente(empresa2);
        if (pjDesejado.getId() == 7890213  && pjDesejado.getNome().equalsIgnoreCase("Mesbla")) {
                total = total + 1.0;
        }

        pjService.alterarNomeCliente("Supermercado Romcyio", empresa1);
        ClientePJ empresaAlterada = pjService.buscarClientePorID(empresa1.getId());
        if (empresaAlterada.getNome().equalsIgnoreCase("Supermercado Romcyio")){
            total = total + 1.0;
        }

// ---------------------------------------------------------
        //Instanciar Veiculos Pequenos
        VeiculoPeq hatch1 = new VeiculoPeq(
                "aio1239",
                true,
                "HB20"
        );

        VeiculoPeq hatch2 = new VeiculoPeq(
                "rau1999",
                true,
                "Corcel73"
        );

        VeiculoPeq hatch3 = new VeiculoPeq(
                "bui0987",
                true,
                "Ka"
        );

        VeiculoPeq hatchClonado = new VeiculoPeq(
                "aio1230",
                true,
                "Celta"
        );

        //Instanciar Veiculos Médios
        VeiculoMed sedan1 = new VeiculoMed(
                "abc1239",
                true,
                "HB20Sedan"
        );
        VeiculoMed sedan2 = new VeiculoMed(
                "cba3124",
                true,
                "Siena"
        );

        VeiculoMed sedan3 = new VeiculoMed(
                "auu4000",
                true,
                "A4"
        );

        VeiculoMed sedanClonado= new VeiculoMed(
                "auu4000",
                true,
                "CorsaSedan99"
        );

        //Instanciar Veiculos SUV
        VeiculoSUV suv1 = new VeiculoSUV(
                "hoh4540",
                true,
                "Hilux44"
        );

        VeiculoSUV suv2 = new VeiculoSUV(
                "kio9087",
                true,
                "D20"
        );

        VeiculoSUV suv3 = new VeiculoSUV(
                "bop2990",
                true,
                "Compass"
        );
        VeiculoSUV suvClonado = new VeiculoSUV(
                "bop2990",
                true,
                "Fusca"
        );


        //Cadastrar os veículos;
        portfolio.addVeiculo(hatch1);
        portfolio.addVeiculo(hatch2);
        portfolio.addVeiculo(hatch3);
        portfolio.addVeiculo(hatchClonado);
        portfolio.addVeiculo(sedan1);
        portfolio.addVeiculo(sedan2);
        portfolio.addVeiculo(sedan3);
        portfolio.addVeiculo(sedanClonado);
        portfolio.addVeiculo(suv1);
        portfolio.addVeiculo(suv2);
        portfolio.addVeiculo(suv3);
        portfolio.addVeiculo(suvClonado);

        // buscar veiculo
        Veiculo placaDesejada = portfolio.getVeiculoPorPlaca("bop2990");
        if (placaDesejada.getNome().equalsIgnoreCase("Compass")) {
            total = total + 1.0;
        }

        //Alterar nome do veiculo HB20 por Fusquinha
        portfolio.alterarNomeVeiculo("Fusquinha", hatch1);
        Veiculo carroComNovoNome = portfolio.getVeiculoPorPlaca(hatch1.getPlaca());
        if (carroComNovoNome.getNome().equalsIgnoreCase("Fusquinha")){
            total = total + 1.0;
        }

      //   Buscar um veículo por parte do nome;------------------ Está com erro

        Map<String, Veiculo> mesmoNome = portfolio.buscarVeiculoPorNome("Fusaquinha");
        if(mesmoNome==null){
            total+=0.5;

            portfolio.alterarNomeVeiculo("Fuscao Preto D20", suv2);
            Map<String, Veiculo> BuscadosPorParteDoNome = portfolio.buscarVeiculoPorParteDoNome("Fus");
            if (BuscadosPorParteDoNome !=null){
                Veiculo fuscao123 = BuscadosPorParteDoNome.get("aio1239");
                Veiculo fuscaoPreto = BuscadosPorParteDoNome.get("kio9087");
                if (fuscao123.getNome().equalsIgnoreCase("Fusquinha")
                        && fuscaoPreto.getNome().equalsIgnoreCase("Fuscao Preto D20")){
                    total += 0.5;
                }

            }
        }
//-------------------------

        // -------------------------------------------------

        //Alugar um veículo para pessoa física e jurídica;

        LocalDateTime inicio1 = LocalDateTime.of(2023, 9, 13, 14, 30); // 14h30 de 13/09/2023
        LocalDateTime fim1 = LocalDateTime.of(2023, 9, 17, 18, 0); // 18h de 17/09/2023

        LocalDateTime inicio2 = LocalDateTime.of(2023, 9, 7, 14, 30); // 14h30 de 13/09/2023
        LocalDateTime fim2 = LocalDateTime.of(2023, 9, 27, 11, 0); // 18h de 17/09/2023



        AluguelPFService.alugarVeiculo(pessoaFisica1, "bop2990", inicio1, fim1, "Fortaleza");
        // +1
        AluguelPJService.alugarVeiculo(empresa1, "hoh4540", inicio2, fim2, "Sao Paulo");
        // +1
        // Aluguel indisponivel
        AluguelPFService.alugarVeiculo(pessoaFisica3, "hoh4540", inicio1, fim2, "Joao Pessoa");
        // +1


        //Devolver um veículo para pessoa física e jurídica;
        AluguelPFService.devolverVeiculo(pessoaFisica1);
        // +1
        AluguelPJService.devolverVeiculo(empresa1);
        // +1

        System.out.println((total + 5 )+ " de 12");
    }

}