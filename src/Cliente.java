import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa {
    List<Cliente> listaClientes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

//    public void inicializarClientes() {
//        Cliente c1 = new Cliente(1);
//        listaClientes.add(c1);
//    }

    private final int idCliente;

    public Cliente(int id) {
        this.idCliente = id;
    }

    public void cadastrarCliente () {
        int idCliente = listaClientes.size() + 1;

        Cliente c = new Cliente(idCliente);
        c.cadastrarPessoa();

        listaClientes.add(c);
    }

    public void atualizarCliente() {
        System.out.print("Informe o ID do cliente: ");
        int idCliente = Integer.parseInt(scanner.nextLine());

        for (Cliente c : listaClientes) {
            if (c.getIdCliente() == idCliente) {
                System.out.println("ID: "+c.getIdCliente());
                c.mostrarDadosPessoa();
                System.out.println("==================================================================");

                c.alteraDadosPessoa();
                System.out.println("Cadastro atualizado com sucesso!");
            } else {
                System.out.println("ID de cliente não existe.");
            }
        }
        System.out.println("==================================================================");
    }

    public void listarClientes () {
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
