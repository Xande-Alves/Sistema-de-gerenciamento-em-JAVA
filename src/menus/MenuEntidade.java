package menus;

import controladores.*;
import utilitarios.LeitorConsole;

import java.util.Scanner;

public class MenuEntidade {
    private final Scanner scanner = new Scanner(System.in);
    private final LeitorConsole leitor = new LeitorConsole(scanner);
    private static MenuEntidade menuEntidadeInstancia;

    private MenuEntidade() {

    }

    public static MenuEntidade getInstanciaMenuEntidade() {
        if (menuEntidadeInstancia == null) {
            menuEntidadeInstancia = new MenuEntidade();
        }
        return menuEntidadeInstancia;
    }

    public void escolhaMenuCliente() {
        while (MenuControleAcesso.getInstanciaMenuControleAcesso().getEscolhaModulo() == 1) {
            System.out.println("===========================MENU CLIENTES==========================");
            int escolhaModuloCliente = leitor.lerInteiro(
                    "1 - Cadastrar cliente\n2 - Atualizar cliente\n3 - Consultar cliente\n4 - Listar clientes\n5 - Sair\nDigite o que deseja realizar: "
            );
            if (escolhaModuloCliente == 1) {
                ControladorCliente.getInstanciaControladorCliente().cadastrarCliente();
            } else if (escolhaModuloCliente == 2) {
                ControladorCliente.getInstanciaControladorCliente().atualizarCliente();
            } else if (escolhaModuloCliente == 3) {
                MenuConsulta.getInstanciaMenuConsulta().escolhaAtributoConsultaCliente();
            } else if (escolhaModuloCliente == 4) {
                ControladorCliente.getInstanciaControladorCliente().listarClientes();
            } else if (escolhaModuloCliente == 5) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void escolhaMenuFuncionario() {
        while (MenuControleAcesso.getInstanciaMenuControleAcesso().getEscolhaModulo() == 2) {
            System.out.println("=========================MENU FUNCIONÁRIOS=========================");
            int escolhaModuloFuncionario = leitor.lerInteiro(
                    "1 - Cadastrar funcionário\n2 - Atualizar funcionário\n3 - Consultar funcionário\n4 - Listar funcionários\n5 - Contratar funcionário\n6 - Cargo do funcionário\n7 - Salário do funcionário\n8 - Desligamento do funcionário\n9 - Alterar acesso do funcionário\n10 - Sair\nDigite o que deseja realizar: "
            );
            if (escolhaModuloFuncionario == 1) {
                ControladorFuncionario.getInstanciaControladorFuncionario().cadastrarFuncionario();
            } else if (escolhaModuloFuncionario == 2) {
                ControladorFuncionario.getInstanciaControladorFuncionario().atualizarFuncionario();
            } else if (escolhaModuloFuncionario == 3) {
                MenuConsulta.getInstanciaMenuConsulta().escolhaAtributoConsultaFuncionario();
            } else if (escolhaModuloFuncionario == 4) {
                ControladorFuncionario.getInstanciaControladorFuncionario().listarFuncionarios();
            } else if (escolhaModuloFuncionario == 5) {
                ControladorFuncionario.getInstanciaControladorFuncionario().contrataFuncionario();
            } else if (escolhaModuloFuncionario == 6) {
                ControladorFuncionario.getInstanciaControladorFuncionario().alteraCargo();
            } else if (escolhaModuloFuncionario == 7) {
                ControladorFuncionario.getInstanciaControladorFuncionario().alteraSalario();
            } else if (escolhaModuloFuncionario == 8) {
                ControladorFuncionario.getInstanciaControladorFuncionario().desligaFuncionario();
            } else if (escolhaModuloFuncionario == 9) {
                ControladorFuncionario.getInstanciaControladorFuncionario().atualizarAcesso();
            } else if (escolhaModuloFuncionario == 10) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void escolhaMenuProduto() {
        while (MenuControleAcesso.getInstanciaMenuControleAcesso().getEscolhaModulo() == 3) {
            System.out.println("===========================MENU PRODUTOS===========================");
            int escolhaModuloProduto = leitor.lerInteiro(
                    "1 - Cadastrar produto\n2 - Atualizar produto\n3 - Consultar produto\n4 - Listar produtos\n5 - Cadastrar fornecedor\n6 - Atualizar fornecedor\n7 - Consultar fornecedor\n8 - Listar fornecedores\n9 - Sair\nDigite o que deseja realizar: "
            );
            if (escolhaModuloProduto == 1) {
                ControladorProduto.getInstanciaControladorProduto().cadastrarProduto();
            } else if (escolhaModuloProduto == 2){
                ControladorProduto.getInstanciaControladorProduto().atualizarProduto();
            } else if (escolhaModuloProduto == 3) {
                MenuConsulta.getInstanciaMenuConsulta().escolhaAtributoConsultaProduto();
            } else if (escolhaModuloProduto == 4) {
                ControladorProduto.getInstanciaControladorProduto().listarProdutos();
            } else if (escolhaModuloProduto == 5) {
                ControladorFornecedor.getInstanciaControladorFornecedor().cadastrarFornecedor();
            } else if (escolhaModuloProduto == 6) {
                ControladorFornecedor.getInstanciaControladorFornecedor().atualizarFornecedor();
            } else if (escolhaModuloProduto == 7) {
                MenuConsulta.getInstanciaMenuConsulta().escolhaAtributoConsultaFornecedor();
            } else if (escolhaModuloProduto == 8) {
                ControladorFornecedor.getInstanciaControladorFornecedor().listarFornecedores();
            } else if (escolhaModuloProduto == 9) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void escolhaMenuVendas() {
        while (MenuControleAcesso.getInstanciaMenuControleAcesso().getEscolhaModulo() == 4) {
            System.out.println("============================MENU VENDAS============================");
            int escolhaModuloVenda = leitor.lerInteiro(
                    "1 - Efetuar venda\n2 - Atualizar venda\n3 - Consultar vendas\n4 - Listar vendas\n5 - Cancelar venda\n6 - Sair\nDigite o que deseja realizar: "
            );
            if (escolhaModuloVenda == 1) {
                ControladorVenda.getInstanciaControladorVenda().efetuarVenda();
            } else if (escolhaModuloVenda == 2){
                ControladorVenda.getInstanciaControladorVenda().atualizarVenda();
            } else if (escolhaModuloVenda == 3) {
                MenuConsulta.getInstanciaMenuConsulta().escolhaAtributoConsultaVendas();
            } else if (escolhaModuloVenda == 4) {
                ControladorVenda.getInstanciaControladorVenda().listarVendas();
            } else if (escolhaModuloVenda == 5) {
                ControladorVenda.getInstanciaControladorVenda().cancelarVenda();
            } else if (escolhaModuloVenda == 6) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }

    }

    public void escolhaMenuEstoque() {
        while (MenuControleAcesso.getInstanciaMenuControleAcesso().getEscolhaModulo() == 5) {
            System.out.println("===========================MENU ESTOQUE============================");
            int escolhaModuloEstoque = leitor.lerInteiro(
                    "1 - Repor estoque\n2 - Diminuir estoque\n3 - Avisos de estoque\n4 - Consultar estoque\n5 - Listar estoque\n6 - Sair\nDigite o que deseja realizar: "
            );
            if (escolhaModuloEstoque == 1) {
                ControladorEstoque.getInstanciaControladorEstoque().reporEstoqueProduto();
            } else if (escolhaModuloEstoque == 2){
                ControladorEstoque.getInstanciaControladorEstoque().diminuiProduto();
            } else if (escolhaModuloEstoque == 3) {
                ControladorEstoque.getInstanciaControladorEstoque().avisosEstoque();
            } else if (escolhaModuloEstoque == 4) {
                MenuConsulta.getInstanciaMenuConsulta().escolhaAtributoConsultaProduto();
            } else if (escolhaModuloEstoque == 5) {
                ControladorProduto.getInstanciaControladorProduto().listarProdutos();
            } else if (escolhaModuloEstoque == 6) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}
