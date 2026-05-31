package menus;

import controladores.ControladorLogin;
import repositorio.Repositorio;

import java.util.Scanner;

public class MenuControleAcesso {
    private final Scanner scanner = new Scanner(System.in);
    private static MenuControleAcesso menuControleAcessoInstancia;
    private int escolhaModulo;
    private MenuControleAcesso() {

    }

    public static MenuControleAcesso getInstanciaMenuControleAcesso() {
        if (menuControleAcessoInstancia == null) {
            menuControleAcessoInstancia = new MenuControleAcesso();
        }
        return menuControleAcessoInstancia;
    }

    public void escolhaModulo() {
        while (true) {
            System.out.println("==============================SISGER==============================");
            while (true) {
                try {
                    System.out.println("1 - Clientes\n2 - Funcionário\n3 - Produtos\n4 - Vendas\n5 - Estoque\n6 - Sair");
                    System.out.print("Selecione o módulo que deseja acessar: ");
                    escolhaModulo = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Digite apenas números inteiros.");
                }
            }

            if (escolhaModulo == 1) {
                if (ControladorLogin.getInstanciaControladorLogin().permitirAcesso(escolhaModulo)) {
                    System.out.println("Bem vindo ao módulo Clientes!");
                    MenuEntidade.getInstanciaMenuEntidade().escolhaMenuCliente();
                } else {
                    System.out.println("O usuário não tem acesso a esse módulo.");
                }
            } else if (escolhaModulo == 2) {
                if (ControladorLogin.getInstanciaControladorLogin().permitirAcesso(escolhaModulo)) {
                    System.out.println("Bem vindo ao módulo Funcionário!");
                    MenuEntidade.getInstanciaMenuEntidade().escolhaMenuFuncionario();
                } else {
                    System.out.println("O usuário não tem acesso a esse módulo.");
                }
            } else if (escolhaModulo == 3) {
                if (ControladorLogin.getInstanciaControladorLogin().permitirAcesso(escolhaModulo)) {
                    System.out.println("Bem vindo ao módulo Produtos!");
                    MenuEntidade.getInstanciaMenuEntidade().escolhaMenuProduto();
                } else {
                    System.out.println("O usuário não tem acesso a esse módulo.");
                }
            } else if (escolhaModulo == 4) {
                if (ControladorLogin.getInstanciaControladorLogin().permitirAcesso(escolhaModulo)) {
                    System.out.println("Bem vindo ao módulo Vendas!");
                    MenuEntidade.getInstanciaMenuEntidade().escolhaMenuVendas();
                } else {
                    System.out.println("O usuário não tem acesso a esse módulo.");
                }
            } else if (escolhaModulo == 5) {
                if (ControladorLogin.getInstanciaControladorLogin().permitirAcesso(escolhaModulo)) {
                    System.out.println("Bem vindo ao módulo Estoque!");
                    MenuEntidade.getInstanciaMenuEntidade().escolhaMenuEstoque();
                } else {
                    System.out.println("O usuário não tem acesso a esse módulo.");
                }
            } else if (escolhaModulo == 6) {
                ControladorLogin.getInstanciaControladorLogin().efetuarLogin(Repositorio.getInstanciaRepositorio().getListaFuncionarios());
                break;
            } else {
                System.out.println("Módulo inválido.");
            }
        }
    }

    public int getEscolhaModulo() {
        return escolhaModulo;
    }
}
