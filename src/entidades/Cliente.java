package entidades;

public class Cliente extends Pessoa {
    //private final Scanner scanner = new Scanner(System.in);

    private final int idCliente;
    //private static entidades.Cliente clienteInstancia;

    public Cliente(int id) {
        this.idCliente = id;
    }

//    public static entidades.Cliente getInstanciaCliente() {
//        if (clienteInstancia == null) {
//            clienteInstancia = new entidades.Cliente(0);
//        }
//        return clienteInstancia;
//    }

    // METODO APENAS PARA TESTES EM VENDAS
//    public void inicializarClientes() {
//        entidades.Cliente c1 = new entidades.Cliente(1);
//        listaClientes.add(c1);
//    }

//    public void cadastrarCliente () {
//        System.out.println("=======================CADASTRO DE CLIENTES=======================");
//        int idCliente = repositorio.Repositorio.getInstanciaRepositorio().getListaClientes().size() + 1;
//
//        entidades.Cliente c = new entidades.Cliente(idCliente);
//        c.cadastrarPessoa();
//
//        int concluir;
//        while (true) {
//            try {
//                System.out.print("Concluir o procedimento? (1 para SIM): ");
//                concluir = Integer.parseInt(scanner.nextLine());
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println("Digite apenas números inteiros.");
//            }
//        }
//        if (concluir != 1) {
//            menus.Menu.getInstanciaMenu().escolhaMenuCliente();
//        }
//
//        repositorio.Repositorio.getInstanciaRepositorio().getListaClientes().add(c);
//        System.out.println("entidades.Cliente cadastrado com sucesso com o ID "+c.getIdCliente()+".");
//        System.out.println("==================================================================");
//    }
//
//    public void atualizarCliente() {
//        System.out.println("==================ATUALIZAR CADASTRO DE CLIENTES==================");
//        int idCliente;
//        while (true) {
//            try {
//                System.out.print("Informe o ID do cliente: ");
//                idCliente = Integer.parseInt(scanner.nextLine());
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println("Digite apenas números inteiros.");
//            }
//        }
//        boolean existeCliente = false;
//
//        for (entidades.Cliente c : repositorio.Repositorio.getInstanciaRepositorio().getListaClientes()) {
//            if (c.getIdCliente() == idCliente) {
//                System.out.println("CLIENTE ENCONTRADO:");
//                System.out.println("ID: "+c.getIdCliente());
//                c.mostrarDadosPessoa();
//                System.out.println("==================================================================");
//
//                c.alteraDadosPessoa();
//                existeCliente = true;
//                System.out.println("Cadastro atualizado com sucesso!");
//            }
//        }
//        if (!existeCliente) {
//            System.out.println("ID de cliente não existe.");
//        }
//        System.out.println("==================================================================");
//    }
//
//    public void listarClientes () {
//        System.out.println("=========================LISTA DE CLIENTES=========================");
//        for (entidades.Cliente c : repositorio.Repositorio.getInstanciaRepositorio().getListaClientes()) {
//            System.out.println("ID entidades.Cliente: " + c.getIdCliente());
//            c.mostrarDadosPessoa();
//            System.out.println("==================================================================");
//        }
//    }
//
//    public void consultarClientesNome() {
//        consultarPessoaPorNome(repositorio.Repositorio.getInstanciaRepositorio().getListaClientes());
//    }
//
//    public void consultarClientesCpf() {
//        consultarPessoaPorCpf(repositorio.Repositorio.getInstanciaRepositorio().getListaClientes());
//    }
//
//    public void consultarClientesEmail() {
//        consultarPessoaPorEmail(repositorio.Repositorio.getInstanciaRepositorio().getListaClientes());
//    }
//
//    public void consultarClientesTelefone() {
//        consultarPessoaPorTelefone(repositorio.Repositorio.getInstanciaRepositorio().getListaClientes());
//    }
//
    @Override
    public String getIdentificacao() {
        return "ID entidades.Cliente: " + getIdCliente();
    }

    public int getIdCliente() {
        return idCliente;
    }
}
