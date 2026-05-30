package controladores;

import entidades.Funcionario;
import entidades.Login;
import menus.MenuControleAcesso;
import repositorio.Repositorio;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ControladorLogin {
    private final Scanner scanner = new Scanner(System.in);
    private static ControladorLogin controladorLoginInstancia;

    public static ControladorLogin getInstanciaControladorLogin() {
        if (controladorLoginInstancia == null) {
            controladorLoginInstancia = new ControladorLogin();
        }
        return controladorLoginInstancia;
    }

    public void cadastrarAcesso(Funcionario func, List<Funcionario> listaFunc) {
        while (true) {
            boolean aceite = true;
            System.out.print("Digite o login do funcionário: ");
            String login = scanner.nextLine();
            for (Funcionario f : listaFunc) {
                if (Objects.equals(f.getLogin(),login) || Objects.equals(login,"adm")) {
                    System.out.println("Login já está em uso. Digite outro login.");
                    aceite = false;
                    break;
                }
            }
            if (aceite) {
                func.setLogin(login);
                break;
            }
        }
        System.out.print("Digite a senha do funcionário: ");
        String senha = scanner.nextLine();
        func.setSenha(senha);
        String acesso;
        if (Objects.equals(func.getCargo(),"vendedor")) {
            acesso = "14";
        } else if (Objects.equals(func.getCargo(),"gerente de vendas")) {
            acesso = "1234";
        } else if (Objects.equals(func.getCargo(),"estoquista")) {
            acesso = "35";
        } else if (Objects.equals(func.getCargo(),"gerente de estoque")) {
            acesso = "235";
        } else {
            acesso = "";
        }
        func.setNivelAcesso(acesso);
    }

    public void alterarAcesso(Funcionario func, List<Funcionario> listaFunc) {
        while (true) {
            boolean aceite = true;
            System.out.print("Digite o novo login do funcionário: ");
            String novoLogin = scanner.nextLine();
            for (Funcionario f : listaFunc) {
                if (Objects.equals(f.getLogin(),novoLogin) || Objects.equals(novoLogin,"adm")) {
                    System.out.println("Login já está em uso. Digite outro login.");
                    aceite = false;
                }
            }
            if (aceite) {
                func.setLogin(novoLogin);
                break;
            }
        }
        System.out.print("Qual a nova senha do funcionário? ");
        String novaSenha = scanner.nextLine();
        func.setSenha(novaSenha);
        String novoAcesso;
        if (Objects.equals(func.getCargo(),"vendedor")) {
            novoAcesso = "14";
        } else if (Objects.equals(func.getCargo(),"gerente de vendas")) {
            novoAcesso = "1234";
        } else if (Objects.equals(func.getCargo(),"estoquista")) {
            novoAcesso = "35";
        } else if (Objects.equals(func.getCargo(),"gerente de estoque")) {
            novoAcesso = "235";
        } else {
            novoAcesso = "";
        }
        func.setNivelAcesso(novoAcesso);
    }

    public void mostrarAcesso(Funcionario func) {
        System.out.println("Login: "+func.getLogin());
        System.out.println("Senha: "+func.getSenha());
        System.out.println("Nível de acesso: "+func.getNivelAcesso());
    }

    public void efetuarLogin(List<Funcionario> listaFunc) {
        System.out.println("==============================SisGer==============================");
        while (true) {
            System.out.print("Login: ");
            String entradaLogin = scanner.nextLine();
            boolean encontrado = false;
            if (Objects.equals("adm",entradaLogin)) {
                System.out.print("Senha: ");
                String entradaSenha = scanner.nextLine();
                if (Objects.equals("123",entradaSenha)) {
                    Login.getInstanciaLogin().setLoginAtual("adm");
                    Login.getInstanciaLogin().setNivelAcessoAtual("12345");
                    MenuControleAcesso.getInstanciaMenuControleAcesso().escolhaModulo();
                    break;
                } else {
                    System.out.println("Credenciais inválidas.");
                }
            } else {
                for (Funcionario f : listaFunc) {
                    if (Objects.equals(f.getLogin(), entradaLogin)) {
                        encontrado = true;
                        System.out.print("Senha: ");
                        String entradaSenha = scanner.nextLine();
                        if (Objects.equals(f.getSenha(),entradaSenha)) {
                            Login.getInstanciaLogin().setLoginAtual(f.getLogin());
                            Login.getInstanciaLogin().setNivelAcessoAtual(f.getNivelAcesso());
                            MenuControleAcesso.getInstanciaMenuControleAcesso().escolhaModulo();
                            break;
                        } else {
                            System.out.println("Credenciais inválidas.");
                        }
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Login não encontrado.");
                }
            }
        }
    }

    public boolean permitirAcesso (int modulo) {
        return Login.getInstanciaLogin().getNivelAcessoAtual().contains(String.valueOf(modulo));
    }

    public int verificaVendedorParaVenda() {
        for (Funcionario f : Repositorio.getInstanciaRepositorio().getListaFuncionarios()) {
            if (Objects.equals(f.getLogin(),Login.getInstanciaLogin().getLoginAtual()) && Objects.equals(f.getCargo().toLowerCase(),"vendedor")) {
                return f.getIdFuncionario();
            }
        }
        return -1;
    }

    public String verificaGerenteDeVendasParaVenda() {
        String cargo;
        for (Funcionario f : Repositorio.getInstanciaRepositorio().getListaFuncionarios()) {
            if (Objects.equals(f.getLogin(),Login.getInstanciaLogin().getLoginAtual())) {
                if (Objects.equals(f.getCargo().toLowerCase(),"gerente de vendas")) {
                    cargo = f.getCargo();
                    return cargo;
                }
            }
        }
        return "negativo";
    }
}
