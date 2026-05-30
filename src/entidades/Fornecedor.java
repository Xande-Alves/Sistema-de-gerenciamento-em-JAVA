package entidades;

public class Fornecedor extends Pessoa {

    private final int idFornecedor;
    private String representaEmpresaNome;
    private String representaEmpresaCnpj;

    public Fornecedor (int idFornecedor, String nomeEmpresa, String cnpjEmpresa) {
        this.representaEmpresaNome = nomeEmpresa;
        this.representaEmpresaCnpj = cnpjEmpresa;
        this.idFornecedor = idFornecedor;
    }

//    private final Scanner scanner = new Scanner(System.in);
//    private static Fornecedor fornecedorInstancia;
//
//    private Fornecedor (int idFornecedor, String nomeEmpresa, String cnpjEmpresa) {
//        this.representaEmpresaNome = nomeEmpresa;
//        this.representaEmpresaCnpj = cnpjEmpresa;
//        this.idFornecedor = idFornecedor;
//    }
//
//    public static Fornecedor getInstanciaFornecedor() {
//        if (fornecedorInstancia==null) {
//            fornecedorInstancia = new Fornecedor(0,"","");
//        }
//        return fornecedorInstancia;
//    }
//
//    // METODO APENAS PARA TESTES EM VENDAS
////    public void inicializarFornecedor() {
////        entidades.Fornecedor f1 = new entidades.Fornecedor(1,"bela","111");
////        listaFornecedores.add(f1);
////    }
//
//    public void cadastrarFornecedor() {
//        System.out.println("======================CADASTRO DE FORNECEDORES====================");
//        int idFornecedor = Repositorio.getInstanciaRepositorio().getListaFornecedores().size() + 1;
//        Fornecedor fornec = new Fornecedor(idFornecedor,"", "");
//
//        fornec.cadastrarPessoa();
//        System.out.print("Insira o nome da empresa que o fornecedor representa: ");
//        String nomeEmpresa = scanner.nextLine();
//        fornec.setRepresentaEmpresaNome(nomeEmpresa);
//        String cnpjEmpresa;
//        while (true) {
//            System.out.print("Insira o CNPJ da empresa que o fornecedor representa: ");
//            String cnpjDigitado = scanner.nextLine();
//            cnpjDigitado = cnpjDigitado.replaceAll("[^0-9]", "");
//
//            if (cnpjDigitado.matches("\\d{14}")) {
//                cnpjEmpresa = cnpjDigitado.substring(0,2) + "." + cnpjDigitado.substring(2,5) + "." + cnpjDigitado.substring(5,8) + "/" + cnpjDigitado.substring(8,12) + "-" + cnpjDigitado.substring(12);
//                break;
//            } else {
//                System.out.print("O CEP deve conter 14 números. ");
//            }
//        }
//        fornec.setRepresentaEmpresaCnpj(cnpjEmpresa);
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
//            Menu.getInstanciaMenu().escolhaMenuProduto();
//        }
//
//        Repositorio.getInstanciaRepositorio().getListaFornecedores().add(fornec);
//        System.out.println("entidades.Fornecedor cadastrado com sucesso!");
//        System.out.println("==================================================================");
//    }
//
//    public void atualizarFornecedor() {
//        System.out.println("==============ATUALIZAÇÃO DE CADASTRO DE FORNECEDORES=============");
//        int idFornecedor;
//        while (true) {
//            try {
//                System.out.print("Informe o ID do fornecedor: ");
//                idFornecedor = Integer.parseInt(scanner.nextLine());
//                break;
//            } catch (NumberFormatException e) {
//                System.out.print("Digite apenas números inteiros. ");
//            }
//        }
//        boolean existeFornecedor = false;
//
//        for (Fornecedor fornec : Repositorio.getInstanciaRepositorio().getListaFornecedores()) {
//            if (fornec.getIdFornecedor() == idFornecedor) {
//                System.out.println("ID: "+fornec.getIdFornecedor());
//                fornec.mostrarDadosPessoa();
//                System.out.println("Nome da empresa: "+fornec.getRepresentaEmpresaNome());
//                System.out.println("CNPJ da empresa: "+fornec.getRepresentaEmpresaCnpj());
//                System.out.println("==================================================================");
//
//                fornec.alteraDadosPessoa();
//                System.out.print("Informe o novo nome da empresa (enter para não alterar): ");
//                String novoNomeEmpresa = scanner.nextLine();
//                if (!novoNomeEmpresa.isEmpty()) {
//                    fornec.setRepresentaEmpresaNome(novoNomeEmpresa);
//                }
//
//                while (true) {
//                    System.out.print("Informe o novo CNPJ da empresa (enter para não alterar): ");
//                    String cnpjDigitado = scanner.nextLine();
//                    if (!cnpjDigitado.isEmpty()) {
//                        cnpjDigitado = cnpjDigitado.replaceAll("[^0-9]", "");
//
//                        if (cnpjDigitado.matches("\\d{14}")) {
//                            String novoCnpjEmpresa = cnpjDigitado.substring(0,2) + "." + cnpjDigitado.substring(2,5) + "." + cnpjDigitado.substring(5,8) + "/" + cnpjDigitado.substring(8,12) + "-" + cnpjDigitado.substring(12);
//                            fornec.setRepresentaEmpresaCnpj(novoCnpjEmpresa);
//                            break;
//                        } else {
//                            System.out.print("O CEP deve conter 14 números. ");
//                        }
//                    } else {
//                        break;
//                    }
//                }
//                existeFornecedor = true;
//                System.out.println("Cadastro atualizado com sucesso!");
//            }
//        }
//        if (!existeFornecedor) {
//            System.out.println("ID de fornecedor não existe.");
//        }
//        System.out.println("==================================================================");
//    }
//
//    public void listarFornecedores() {
//        System.out.println("=======================LISTA DE FORNECEDORES======================");
//        for(Fornecedor fornec : Repositorio.getInstanciaRepositorio().getListaFornecedores()) {
//            System.out.println("ID fornecedor: "+fornec.getIdFornecedor());
//            fornec.mostrarDadosPessoa();
//            System.out.println("Nome da empresa: "+fornec.getRepresentaEmpresaNome());
//            System.out.println("CNPJ da empresa: "+fornec.getRepresentaEmpresaCnpj());
//
//            System.out.println("==================================================================");
//        }
//    }
//
//    @Override
//    public void mostrarDadosPessoa() {
//        super.mostrarDadosPessoa();
//        System.out.println("Nome da empresa: " + this.getRepresentaEmpresaNome());
//        System.out.println("CNPJ da empresa: " + this.getRepresentaEmpresaCnpj());
//    }
//
//    public void consultarFornecedorNome() { consultarPessoaPorNome(Repositorio.getInstanciaRepositorio().getListaFornecedores()); }
//
//    public void consultarFornecedorCpf() {
//        consultarPessoaPorCpf(Repositorio.getInstanciaRepositorio().getListaFornecedores());
//    }
//
//    public void consultarFornecedorEmail() {
//        consultarPessoaPorEmail(Repositorio.getInstanciaRepositorio().getListaFornecedores());
//    }
//
//    public void consultarFornecedorTelefone() {
//        consultarPessoaPorTelefone(Repositorio.getInstanciaRepositorio().getListaFornecedores());
//    }
//
//    public void consultarFornecedorNomeEmpresa() {
//        System.out.print("Informe o nome da empresa do fornecedor: ");
//        String nomeEmpresa = scanner.nextLine();
//        boolean existeFornecedor = false;
//        for (Fornecedor fornec : Repositorio.getInstanciaRepositorio().getListaFornecedores()) {
//            if (fornec.getRepresentaEmpresaNome().toLowerCase().contains(nomeEmpresa.toLowerCase())) {
//                System.out.println("ID entidades.Fornecedor: " + fornec.getIdFornecedor());
//                fornec.mostrarDadosPessoa();
//                System.out.println("==================================================================");
//                existeFornecedor = true;
//            }
//        }
//        if (!existeFornecedor) {
//            System.out.println("==================================================================");
//            System.out.println("Não existe registro de fornecedor para os dados informados.");
//            System.out.println("==================================================================");
//        }
//    }
//
//    public void consultarFornecedorCnpjEmpresa() {
//        System.out.print("Informe o CNPJ da empresa do fornecedor (apenas números): ");
//        String cnpjEmpresa = scanner.nextLine();
//        boolean existeFornecedor = false;
//        for (Fornecedor fornec : Repositorio.getInstanciaRepositorio().getListaFornecedores()) {
//            if (fornec.getRepresentaEmpresaCnpj().replaceAll("[^0-9]", "").contains(cnpjEmpresa)) {
//                System.out.println("ID entidades.Fornecedor: " + fornec.getIdFornecedor());
//                fornec.mostrarDadosPessoa();
//                System.out.println("==================================================================");
//                existeFornecedor = true;
//            }
//        }
//        if (!existeFornecedor) {
//            System.out.println("==================================================================");
//            System.out.println("Não existe registro de fornecedor para os dados informados.");
//            System.out.println("==================================================================");
//        }
//    }


    public int getIdFornecedor() {
        return idFornecedor;
    }

    @Override
    public String getIdentificacao() {
        return "ID entidades.Fornecedor: " + getIdFornecedor();
    }

    public String getRepresentaEmpresaNome() {
        return representaEmpresaNome;
    }

    public void setRepresentaEmpresaNome(String representaEmpresaNome) {
        this.representaEmpresaNome = representaEmpresaNome;
    }

    public String getRepresentaEmpresaCnpj() {
        return representaEmpresaCnpj;
    }

    public void setRepresentaEmpresaCnpj(String representaEmpresaCnpj) {
        this.representaEmpresaCnpj = representaEmpresaCnpj;
    }
}
