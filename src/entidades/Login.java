package entidades;

public class Login {
    private String loginAtual;
    private String nivelAcessoAtual;
    private static Login loginInstancia;

//    private final Scanner scanner = new Scanner(System.in);

    private Login() {

    }

    public static Login getInstanciaLogin() {
        if (loginInstancia == null) {
            loginInstancia = new Login();
        }
        return loginInstancia;
    }

//    public void cadastrarAcesso(Funcionario func, List<Funcionario> listaFunc) {
//        while (true) {
//            boolean aceite = true;
//            System.out.print("Digite o login do funcionário: ");
//            String login = scanner.nextLine();
//            for (Funcionario f : listaFunc) {
//                if (Objects.equals(f.getLogin(),login) || Objects.equals(login,"adm")) {
//                    System.out.println("entidades.Login já está em uso. Digite outro login.");
//                    aceite = false;
//                    break;
//                }
//            }
//            if (aceite) {
//                func.setLogin(login);
//                break;
//            }
//        }
//        System.out.print("Digite a senha do funcionário: ");
//        String senha = scanner.nextLine();
//        func.setSenha(senha);
//        String acesso;
//        if (Objects.equals(func.getCargo(),"vendedor")) {
//            acesso = "14";
//        } else if (Objects.equals(func.getCargo(),"gerente de vendas")) {
//            acesso = "1234";
//        } else if (Objects.equals(func.getCargo(),"estoquista")) {
//            acesso = "35";
//        } else if (Objects.equals(func.getCargo(),"gerente de estoque")) {
//            acesso = "235";
//        } else {
//            acesso = "";
//        }
//        func.setNivelAcesso(acesso);
//    }
//
//    public void alterarAcesso(Funcionario func, List<Funcionario> listaFunc) {
//        while (true) {
//            boolean aceite = true;
//            System.out.print("Digite o novo login do funcionário: ");
//            String novoLogin = scanner.nextLine();
//            for (Funcionario f : listaFunc) {
//                if (Objects.equals(f.getLogin(),novoLogin) || Objects.equals(novoLogin,"adm")) {
//                    System.out.println("entidades.Login já está em uso. Digite outro login.");
//                    aceite = false;
//                }
//            }
//            if (aceite) {
//                func.setLogin(novoLogin);
//                break;
//            }
//        }
//        System.out.print("Qual a nova senha do funcionário? ");
//        String novaSenha = scanner.nextLine();
//        func.setSenha(novaSenha);
//        String novoAcesso;
//        if (Objects.equals(func.getCargo(),"vendedor")) {
//            novoAcesso = "14";
//        } else if (Objects.equals(func.getCargo(),"gerente de vendas")) {
//            novoAcesso = "1234";
//        } else if (Objects.equals(func.getCargo(),"estoquista")) {
//            novoAcesso = "35";
//        } else if (Objects.equals(func.getCargo(),"gerente de estoque")) {
//            novoAcesso = "235";
//        } else {
//            novoAcesso = "";
//        }
//        func.setNivelAcesso(novoAcesso);
//    }
//
//    public void mostrarAcesso(Funcionario func) {
//        System.out.println("entidades.Login: "+func.getLogin());
//        System.out.println("Senha: "+func.getSenha());
//        System.out.println("Nível de acesso: "+func.getNivelAcesso());
//    }
//
//    public void efetuarLogin(List<Funcionario> listaFunc) {
//        System.out.println("==============================SisGer==============================");
//        while (true) {
//            System.out.print("entidades.Login: ");
//            String entradaLogin = scanner.nextLine();
//            boolean encontrado = false;
//            if (Objects.equals("adm",entradaLogin)) {
//                System.out.print("Senha: ");
//                String entradaSenha = scanner.nextLine();
//                if (Objects.equals("123",entradaSenha)) {
//                    setLoginAtual("adm");
//                    setNivelAcessoAtual("12345");
//                    Menu.getInstanciaMenu().escolhaModulo();
//                    break;
//                } else {
//                    System.out.println("Credenciais inválidas.");
//                }
//            } else {
//                for (Funcionario f : listaFunc) {
//                    if (Objects.equals(f.getLogin(), entradaLogin)) {
//                        encontrado = true;
//                        System.out.print("Senha: ");
//                        String entradaSenha = scanner.nextLine();
//                        if (Objects.equals(f.getSenha(),entradaSenha)) {
//                            setLoginAtual(f.getLogin());
//                            setNivelAcessoAtual(f.getNivelAcesso());
//                            Menu.getInstanciaMenu().escolhaModulo();
//                            break;
//                        } else {
//                            System.out.println("Credenciais inválidas.");
//                        }
//                        break;
//                    }
//                }
//                if (!encontrado) {
//                    System.out.println("entidades.Login não encontrado.");
//                }
//            }
//        }
//    }
//
//    public boolean permitirAcesso (int modulo) {
//        return nivelAcessoAtual.contains(String.valueOf(modulo));
//    }
//
//    public int verificaVendedorParaVenda() {
//        for (Funcionario f : Repositorio.getInstanciaRepositorio().getListaFuncionarios()) {
//            if (Objects.equals(f.getLogin(),this.loginAtual) && Objects.equals(f.getCargo().toLowerCase(),"vendedor")) {
//                return f.getIdFuncionario();
//            }
//        }
//        return -1;
//    }
//
//    public String verificaGerenteDeVendasParaVenda() {
//        String cargo;
//        for (Funcionario f : Repositorio.getInstanciaRepositorio().getListaFuncionarios()) {
//            if (Objects.equals(f.getLogin(),this.loginAtual)) {
//                if (Objects.equals(f.getCargo().toLowerCase(),"gerente de vendas")) {
//                    cargo = f.getCargo();
//                    return cargo;
//                }
//            }
//        }
//        return "negativo";
//    }

    public void setLoginAtual(String loginAtual) {
        this.loginAtual = loginAtual;
    }

    public void setNivelAcessoAtual(String nivelAcessoAtual) {
        this.nivelAcessoAtual = nivelAcessoAtual;
    }

    public String getLoginAtual() {
        return loginAtual;
    }

    public String getNivelAcessoAtual() {
        return nivelAcessoAtual;
    }
}

