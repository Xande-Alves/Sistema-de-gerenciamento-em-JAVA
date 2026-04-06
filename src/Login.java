import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Login {
    private Menu sistemaMenu = new Menu();
    Funcionario sistemaFuncionario;
    private String loginAtual;
    private String nivelAcessoAtual;

    Scanner scanner = new Scanner(System.in);

    public void cadastrarAcesso(Funcionario func, List<Funcionario> listaFunc) {
        while (true) {
            boolean aceite = true;
            System.out.print("Digite o login do funcionário: ");
            String login = scanner.nextLine();
            for (Funcionario f : listaFunc) {
                if (Objects.equals(f.getLogin(),login) || Objects.equals(login,"adm")) {
                    System.out.println("Login já está em uso. Digite outro login.");
                    aceite = false;
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
        System.out.print("Qual nível de acesso? (Digite o número dos modulos acessíveis: 1-Cliente, 2-Funcionário, 3-Fornecedor, 4-Vendas, 5-Estoque: ");
        String acesso = scanner.nextLine();
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
        System.out.print("Qual o novo nível de acesso? (Digite o número dos modulos acessíveis: 1-Cliente, 2-Funcionário, 3-Fornecedor, 4-Vendas, 5-Estoque: ");
        String novoAcesso = scanner.nextLine();
        func.setNivelAcesso(novoAcesso);
    }

    public void mostrarAcesso(Funcionario func) {
        System.out.println("Login: "+func.getLogin());
        System.out.println("Senha: "+func.getSenha());
        System.out.println("Nível de acesso: "+func.getNivelAcesso());
    }

    public void efetuarLogin(List<Funcionario> listaFunc, Funcionario adm) {
        while (true) {
            System.out.print("Login: ");
            String entradaLogin = scanner.nextLine();
            boolean encontrado = false;
            if (Objects.equals(adm.getLogin(),entradaLogin)) {
                System.out.print("Senha: ");
                String entradaSenha = scanner.nextLine();
                if (Objects.equals(adm.getSenha(),entradaSenha)) {
                    setLoginAtual(adm.getLogin());
                    setNivelAcessoAtual(adm.getNivelAcesso());
                    sistemaMenu.escolhaModulo();
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
                            setLoginAtual(f.getLogin());
                            setNivelAcessoAtual(f.getNivelAcesso());
                            sistemaMenu.escolhaModulo();
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
        return nivelAcessoAtual.contains(String.valueOf(modulo));
    }

    public int verificaVendedorParaVenda() {
        int idVendedor;
        for (Funcionario f : sistemaFuncionario.listaFuncionarios) {
            if (Objects.equals(f.getLogin(),this.loginAtual)) {
                if (Objects.equals(f.getCargo().toLowerCase(),"vendedor")) {
                    idVendedor = f.getIdFuncionario();
                    return idVendedor;
                }
            }
        }
        return -1;
    }

    public String verificaGerenteDeVendasParaVenda() {
        String cargo;
        for (Funcionario f : sistemaFuncionario.listaFuncionarios) {
            if (Objects.equals(f.getLogin(),this.loginAtual)) {
                if (Objects.equals(f.getCargo().toLowerCase(),"gerente de vendas")) {
                    cargo = f.getCargo();
                    return cargo;
                }
            }
        }
        return "negativo";
    }

    public void setSistemaFuncionario(Funcionario sistemaFuncionario) {
        this.sistemaFuncionario = sistemaFuncionario;
    }

    public void setSistemaMenu(Menu sistemaMenu) {
        this.sistemaMenu = sistemaMenu;
    }

    private void setLoginAtual(String loginAtual) {
        this.loginAtual = loginAtual;
    }

    private void setNivelAcessoAtual(String nivelAcessoAtual) {
        this.nivelAcessoAtual = nivelAcessoAtual;
    }
}

