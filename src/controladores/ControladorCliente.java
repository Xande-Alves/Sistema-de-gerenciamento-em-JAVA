package controladores;
import java.util.Scanner;

import menus.MenuControleAcesso;
import menus.MenuEntidade;
import repositorio.Repositorio;
import entidades.Cliente;


public class ControladorCliente extends ControladorPessoa{
    private final Scanner scanner = new Scanner(System.in);
    private static ControladorCliente ControladorClienteInstancia;

    private ControladorCliente() {

    }

    public static ControladorCliente getInstanciaControladorCliente() {
        if (ControladorClienteInstancia == null) {
            ControladorClienteInstancia = new ControladorCliente();
        }
        return ControladorClienteInstancia;
    }

    // METODO APENAS PARA TESTES EM VENDAS
//    public void inicializarClientes() {
//        entidades.Cliente c1 = new entidades.Cliente(1);
//        listaClientes.add(c1);
//    }

    public void cadastrarCliente () {
        System.out.println("=======================CADASTRO DE CLIENTES=======================");
        int idCliente = Repositorio.getInstanciaRepositorio().getListaClientes().size() + 1;

        Cliente c = new Cliente(idCliente);
        cadastrarPessoa(c);

        int concluir;
        while (true) {
            try {
                System.out.print("Concluir o procedimento? (1 para SIM): ");
                concluir = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }
        if (concluir != 1) {
            MenuEntidade.getInstanciaMenuEntidade().escolhaMenuCliente();
        }

        repositorio.Repositorio.getInstanciaRepositorio().getListaClientes().add(c);
        System.out.println("Cliente cadastrado com sucesso com o ID "+c.getIdCliente()+".");
        System.out.println("==================================================================");
    }

    public void atualizarCliente() {
        System.out.println("==================ATUALIZAR CADASTRO DE CLIENTES==================");
        int idCliente;
        while (true) {
            try {
                System.out.print("Informe o ID do cliente: ");
                idCliente = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }
        boolean existeCliente = false;

        for (Cliente c : Repositorio.getInstanciaRepositorio().getListaClientes()) {
            if (c.getIdCliente() == idCliente) {
                System.out.println("CLIENTE ENCONTRADO:");
                System.out.println("ID: "+c.getIdCliente());
                mostrarDadosPessoa(c);
                System.out.println("==================================================================");

                alteraDadosPessoa(c);
                existeCliente = true;
                System.out.println("Cadastro atualizado com sucesso!");
            }
        }
        if (!existeCliente) {
            System.out.println("ID de cliente não existe.");
        }
        System.out.println("==================================================================");
    }

    public void listarClientes () {
        System.out.println("=========================LISTA DE CLIENTES=========================");
        for (Cliente c : Repositorio.getInstanciaRepositorio().getListaClientes()) {
            System.out.println("ID entidades.Cliente: " + c.getIdCliente());
            mostrarDadosPessoa(c);
            System.out.println("==================================================================");
        }
    }

    public void consultarClientesNome() {
        consultarPessoaPorNome(Repositorio.getInstanciaRepositorio().getListaClientes());
    }

    public void consultarClientesCpf() {
        consultarPessoaPorCpf(Repositorio.getInstanciaRepositorio().getListaClientes());
    }

    public void consultarClientesEmail() {
        consultarPessoaPorEmail(Repositorio.getInstanciaRepositorio().getListaClientes());
    }

    public void consultarClientesTelefone() {
        consultarPessoaPorTelefone(repositorio.Repositorio.getInstanciaRepositorio().getListaClientes());
    }

}
