import java.util.Scanner;

public class Menu {
    int escolhaModulo;
    Funcionario sistemaFuncionario;
    Scanner scanner = new Scanner(System.in);
    Cliente sistemaCliente;
    Login sistemaLogin;
    Produto sistemaProduto;
    Fornecedor sistemaFornecedor;
    Venda sistemaVenda;
    Estoque sistemaEstoque;

    public void escolhaModulo() {
        while (true) {
            System.out.println("1 - Clientes\n2 - Funcionário\n3 - Produtos\n4 - Vendas\n5 - Estoque\n6 - Sair");
            System.out.print("Selecione o módulo que deseja acessar: ");
            escolhaModulo = Integer.parseInt(scanner.nextLine());

            if (escolhaModulo == 1) {
                if (sistemaLogin.permitirAcesso(escolhaModulo)) {
                    System.out.println("Bem vindo ao módulo Clientes!");
                    escolhaMenuCliente();
                } else {
                    System.out.println("O usuário não tem acesso a esse módulo.");
                }
            } else if (escolhaModulo == 2) {
                if (sistemaLogin.permitirAcesso(escolhaModulo)) {
                    System.out.println("Bem vindo ao módulo Funcionário!");
                    escolhaMenuFuncionario();
                } else {
                    System.out.println("O usuário não tem acesso a esse módulo.");
                }
            } else if (escolhaModulo == 3) {
                if (sistemaLogin.permitirAcesso(escolhaModulo)) {
                    System.out.println("Bem vindo ao módulo Produtos!");
                    escolhaMenuProduto();
                } else {
                    System.out.println("O usuário não tem acesso a esse módulo.");
                }
            } else if (escolhaModulo == 4) {
                if (sistemaLogin.permitirAcesso(escolhaModulo)) {
                    System.out.println("Bem vindo ao módulo Vendas!");
                    escolhaMenuVendas();
                } else {
                    System.out.println("O usuário não tem acesso a esse módulo.");
                }
            } else if (escolhaModulo == 5) {
                if (sistemaLogin.permitirAcesso(escolhaModulo)) {
                    System.out.println("Bem vindo ao módulo Estoque!");
                    escolhaMenuEstoque();
                } else {
                    System.out.println("O usuário não tem acesso a esse módulo.");
                }
            } else if (escolhaModulo == 6) {
                sistemaLogin.efetuarLogin(sistemaFuncionario.exportaListaFuncionario(),sistemaFuncionario);
                break;
            } else {
                System.out.println("Módulo inválido.");
            }
        }
    }

    public void escolhaAtributoConsultaCliente() {
        while (true) {
            System.out.println("1 - Nome\n2 - CPF\n3 - E-mail\n4 - Telefone\n5 - Sair");
            System.out.print("Deseja consultar por que dado?");
            int atributoConsultaCliente = Integer.parseInt(scanner.nextLine());
            if (atributoConsultaCliente == 1) {
                sistemaCliente.consultarClientesNome();
            } else if (atributoConsultaCliente == 2) {
                sistemaCliente.consultarClientesCpf();
            } else if (atributoConsultaCliente == 3) {
                sistemaCliente.consultarClientesEmail();
            } else if (atributoConsultaCliente == 4) {
                sistemaCliente.consultarClientesTelefone();
            } else if (atributoConsultaCliente == 5) {
                escolhaMenuCliente();
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void escolhaAtributoConsultaFuncionario() {
        while (true) {
            System.out.println("1 - Nome\n2 - CPF\n3 - E-mail\n4 - Telefone\n5 - Cargo\n6 - Sair");
            System.out.print("Deseja consultar por que dado?");
            int atributoConsultaFuncionario = Integer.parseInt(scanner.nextLine());
            if (atributoConsultaFuncionario == 1) {
                sistemaFuncionario.consultarFuncionarioNome();
            } else if (atributoConsultaFuncionario == 2) {
                sistemaFuncionario.consultarFuncionarioCpf();
            } else if (atributoConsultaFuncionario == 3) {
                sistemaFuncionario.consultarFuncionarioEmail();
            } else if (atributoConsultaFuncionario == 4) {
                sistemaFuncionario.consultarFuncionarioTelefone();
            } else if (atributoConsultaFuncionario == 5) {
                sistemaFuncionario.consultarFuncionarioCargo();
            } else if (atributoConsultaFuncionario == 6) {
                escolhaMenuFuncionario();
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void escolhaAtributoConsultaProduto() {
        while (true) {
            System.out.println("1 - ID do fornecedor\n2 - Nome\n3 - Descrição\n4 - Sair");
            System.out.print("Deseja consultar por que dado? ");
            int atributoConsultaProduto = Integer.parseInt(scanner.nextLine());
            if (atributoConsultaProduto == 1) {
                sistemaProduto.consultarProdutoIdFornecedor();
            } else if (atributoConsultaProduto == 2) {
                sistemaProduto.consultarProdutoNome();
            } else if (atributoConsultaProduto == 3) {
                sistemaProduto.consultarProdutoDescricao();
            } else if (atributoConsultaProduto == 4) {
                escolhaMenuProduto();
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void escolhaAtributoConsultaFornecedor() {
        while (true) {
            System.out.println("1 - Nome\n2 - CPF\n3 - E-mail\n4 - Telefone\n5 - Nome da empresa\n6 - CNPJ da empresa\n7 - Sair");
            System.out.print("Deseja consultar por que dado?");
            int atributoConsultaFornecedor = Integer.parseInt(scanner.nextLine());
            if (atributoConsultaFornecedor == 1) {
                sistemaFornecedor.consultarFornecedorNome();
            } else if (atributoConsultaFornecedor == 2) {
                sistemaFornecedor.consultarFornecedorCpf();
            } else if (atributoConsultaFornecedor == 3) {
                sistemaFornecedor.consultarFornecedorEmail();
            } else if (atributoConsultaFornecedor == 4) {
                sistemaFornecedor.consultarFornecedorTelefone();
            } else if (atributoConsultaFornecedor == 5) {
                sistemaFornecedor.consultarFornecedorNomeEmpresa();
            } else if (atributoConsultaFornecedor == 6) {
                sistemaFornecedor.consultarFornecedorCnpjEmpresa();
            } else if (atributoConsultaFornecedor == 7) {
                escolhaMenuProduto();
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void escolhaAtributoConsultaVendas() {
        while (true) {
            System.out.println("1 - Vendas ativas por vendedor\n2 - Vendas ativas por cliente\n3 - Vendas inativas por vendedor\n4 - Vendas inativas por cliente\n5 - Sair");
            System.out.print("Deseja consultar por que dado? ");
            int atributoConsultaProduto = Integer.parseInt(scanner.nextLine());
            if (atributoConsultaProduto == 1) {
                sistemaVenda.consultarVendaAtivaVendedor();
            } else if (atributoConsultaProduto == 2) {
                sistemaVenda.consultarVendaAtivaCliente();
            } else if (atributoConsultaProduto == 3) {
                sistemaVenda.consultarVendaInativaVendedor();
            } else if (atributoConsultaProduto == 4) {
                sistemaVenda.consultarVendaInativaCliente();
            } else if (atributoConsultaProduto == 5) {
                escolhaMenuVendas();
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void escolhaMenuCliente() {
        while (escolhaModulo == 1) {
            System.out.println("1 - Cadastrar cliente\n2 - Atualizar cliente\n3 - Consultar cliente\n4 - Listar clientes\n5 - Sair");
            int escolhaModuloCliente = Integer.parseInt(scanner.nextLine());

            if (escolhaModuloCliente == 1) {
                sistemaCliente.cadastrarCliente();
            } else if (escolhaModuloCliente == 2){
                sistemaCliente.atualizarCliente();
            } else if (escolhaModuloCliente == 3) {
                escolhaAtributoConsultaCliente();
            } else if (escolhaModuloCliente == 4) {
                sistemaCliente.listarClientes();
            } else if (escolhaModuloCliente == 5) {
                escolhaModulo();
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void escolhaMenuFuncionario() {
        while (escolhaModulo == 2) {
            System.out.println("1 - Cadastrar funcionário\n2 - Atualizar funcionário\n3 - Consultar funcionário\n4 - Listar funcionários\n5 - Contratar funcionário\n6 - Cargo do funcionário\n7 - Salário do funcionário\n8 - Desligamento do funcionário\n9 - Alterar acesso do funcionário\n10 - Sair");
            int escolhaModuloFuncionario = Integer.parseInt(scanner.nextLine());

            if (escolhaModuloFuncionario == 1) {
                sistemaFuncionario.cadastrarFuncionario();
            } else if (escolhaModuloFuncionario == 2){
                sistemaFuncionario.atualizarFuncionario();
            } else if (escolhaModuloFuncionario == 3) {
                escolhaAtributoConsultaFuncionario();
            } else if (escolhaModuloFuncionario == 4) {
                sistemaFuncionario.listarFuncionarios();
            } else if (escolhaModuloFuncionario == 5) {
                sistemaFuncionario.contrataFuncionario();
            } else if (escolhaModuloFuncionario == 6) {
                sistemaFuncionario.alteraCargo();
            } else if (escolhaModuloFuncionario == 7) {
                sistemaFuncionario.alteraSalario();
            } else if (escolhaModuloFuncionario == 8) {
                sistemaFuncionario.desligaFuncionario();
            } else if (escolhaModuloFuncionario == 9) {
                sistemaFuncionario.atualizarAcesso();
            } else if (escolhaModuloFuncionario == 10) {
                escolhaModulo();
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void escolhaMenuProduto() {
        while (escolhaModulo == 3) {
            System.out.println("1 - Cadastrar produto\n2 - Atualizar produto\n3 - Consultar produto\n4 - Listar produtos\n5 - Cadastrar fornecedor\n6 - Atualizar fornecedor\n7 - Consultar fornecedor\n8 - Listar fornecedores\n9 - Sair");
            int escolhaModuloProduto = Integer.parseInt(scanner.nextLine());

            if (escolhaModuloProduto == 1) {
                sistemaProduto.cadastrarProduto();
            } else if (escolhaModuloProduto == 2){
                sistemaProduto.atualizarProduto();
            } else if (escolhaModuloProduto == 3) {
                escolhaAtributoConsultaProduto();
            } else if (escolhaModuloProduto == 4) {
                sistemaProduto.listarProdutos();
            } else if (escolhaModuloProduto == 5) {
                sistemaFornecedor.cadastrarFornecedor();
            } else if (escolhaModuloProduto == 6) {
                sistemaFornecedor.atualizarFornecedor();
            } else if (escolhaModuloProduto == 7) {
                escolhaAtributoConsultaFornecedor();
            } else if (escolhaModuloProduto == 8) {
                sistemaFornecedor.listarFornecedores();
            } else if (escolhaModuloProduto == 9) {
                escolhaModulo();
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void escolhaMenuVendas() {
        while (escolhaModulo == 4) {
            System.out.println("1 - Efetuar venda\n2 - Atualizar venda\n3 - Consultar vendas\n4 - Listar vendas\n5 - Cancelar venda\n6 - Sair");
            int escolhaModuloVenda = Integer.parseInt(scanner.nextLine());

            if (escolhaModuloVenda == 1) {
                sistemaVenda.efetuarVenda();
            } else if (escolhaModuloVenda == 2){
                sistemaVenda.atualizarVenda();
            } else if (escolhaModuloVenda == 3) {
                escolhaAtributoConsultaVendas();
            } else if (escolhaModuloVenda == 4) {
                sistemaVenda.listarVendas();
            } else if (escolhaModuloVenda == 5) {
                sistemaVenda.cancelarVenda();
            } else if (escolhaModuloVenda == 6) {
                escolhaModulo();
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void escolhaMenuEstoque() {
        while (escolhaModulo == 5) {
            System.out.println("1 - Aumentar estoque\n2 - Diminuir estoque\n3 - Avisos de estoque\n4 - Consultar estoque\n5 - Listar estoque\n6 - Sair");
            int escolhaModuloEstoque = Integer.parseInt(scanner.nextLine());

            if (escolhaModuloEstoque == 1) {
                sistemaEstoque.compraProduto();
            } else if (escolhaModuloEstoque == 2){
                sistemaEstoque.diminuiProduto();
            } else if (escolhaModuloEstoque == 3) {
                sistemaEstoque.avisosEstoque();
            } else if (escolhaModuloEstoque == 4) {
                escolhaAtributoConsultaProduto();
            } else if (escolhaModuloEstoque == 5) {
                sistemaProduto.listarProdutos();
            } else if (escolhaModuloEstoque == 6) {
                escolhaModulo();
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void setSistemaVenda (Venda sistemaVenda) {
        this.sistemaVenda = sistemaVenda;
    }

    public void setSistemaFornecedor (Fornecedor sistemaFornecedor) {
        this.sistemaFornecedor = sistemaFornecedor;
    }

    public void setSistemaProduto (Produto sistemaProduto) {
        this.sistemaProduto = sistemaProduto;
    }

    public void setSistemaFuncionario (Funcionario sistemaFuncionario) {
        this.sistemaFuncionario = sistemaFuncionario;
    }

    public void setSistemaCliente (Cliente sistemaCliente) {
        this.sistemaCliente = sistemaCliente;
    }

    public void setSistemaLogin (Login sistemaLogin) {
        this.sistemaLogin = sistemaLogin;
    }

    public void setSistemaEstoque (Estoque sistemaEstoque) {
        this.sistemaEstoque = sistemaEstoque;
    }
}
