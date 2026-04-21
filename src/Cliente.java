import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa {
    private final List<Cliente> listaClientes = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    // METODO APENAS PARA TESTES EM VENDAS
    public void inicializarClientes() {
        Cliente c1 = new Cliente(1);
        listaClientes.add(c1);
    }

    private final int idCliente;
    private static Cliente clienteInstancia;

    private Cliente(int id) {
        this.idCliente = id;
    }

    public static Cliente getInstanciaCliente() {
        if (clienteInstancia == null) {
            clienteInstancia = new Cliente(0);
        }
        return clienteInstancia;
    }

    public void cadastrarCliente () {
        System.out.println("=======================CADASTRO DE CLIENTES=======================");
        int idCliente = listaClientes.size() + 1;

        Cliente c = new Cliente(idCliente);
        c.cadastrarPessoa();

        listaClientes.add(c);
        System.out.println("Cliente cadastrado com sucesso.");
        System.out.println("==================================================================");
    }

    public void atualizarCliente() {
        System.out.println("==================ATUALIZAR CADASTRO DE CLIENTES==================");
        System.out.print("Informe o ID do cliente: ");
        int idCliente = Integer.parseInt(scanner.nextLine());
        boolean existeCliente = false;

        for (Cliente c : listaClientes) {
            if (c.getIdCliente() == idCliente) {
                System.out.println("CLIENTE ENCONTRADO:");
                System.out.println("ID: "+c.getIdCliente());
                c.mostrarDadosPessoa();
                System.out.println("==================================================================");

                c.alteraDadosPessoa();
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
        for (Cliente c : listaClientes) {
            System.out.println("ID Cliente: " + c.getIdCliente());
            c.mostrarDadosPessoa();
            System.out.println("==================================================================");
        }
    }

    public void consultarClientesNome() {
        consultarPessoaPorNome(listaClientes);
    }

    public void consultarClientesCpf() {
        consultarPessoaPorCpf(listaClientes);
    }

    public void consultarClientesEmail() {
        consultarPessoaPorEmail(listaClientes);
    }

    public void consultarClientesTelefone() {
        consultarPessoaPorTelefone(listaClientes);
    }

    public List<Cliente> exportaListaCliente() {
        return listaClientes;
    }

    @Override
    public String getIdentificacao() {
        return "ID Cliente: " + getIdCliente();
    }

    public int getIdCliente() {
        return idCliente;
    }
}
