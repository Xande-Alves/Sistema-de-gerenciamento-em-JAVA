import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {
    private final List<Funcionario> listaFuncionarios = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final int idFuncionario;
    private Double salario;
    private boolean ativo;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;
    private String cargo;
    private String login;
    private String senha;
    private String nivelAcesso;
    private Login sistemaLogin;
    private static Funcionario funcionarioInstancia;

    // METODO APENAS PARA TESTES EM VENDAS
    public void inicializarFuncionario() {
        Funcionario f1 = new Funcionario(1,5.0,true,null,null,"vendedor","vendedor","123","4");
        Funcionario f2 = new Funcionario(2,5.0,true,null,null,"gerente de vendas","gerente","123","1234");
        listaFuncionarios.add(f1);
        listaFuncionarios.add(f2);
    }

    private Funcionario(int idFuncionario, Double salario, boolean ativo, LocalDate dataAdmissao, LocalDate dataDemissao, String cargo, String login, String senha, String nivelAcesso) {
        this.idFuncionario = idFuncionario;
        this.salario = salario;
        this.ativo = ativo;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    public static Funcionario getInstanciaFuncionario() {
        if (funcionarioInstancia == null) {
            funcionarioInstancia = new Funcionario(0,null,true,null,null,null,"adm","123","12345");
        }
        return funcionarioInstancia;
    }

    public void cadastrarFuncionario () {
        System.out.println("=====================CADASTRO DE FUNCIONÁRIOS======================");
        Double salario = null;
        boolean ativo = false;
        LocalDate dataAd = null;
        LocalDate dataDem = null;
        String cargo = null;
        String login = null;
        String senha = null;
        String nivelAcesso = null;

        int idFuncionario = listaFuncionarios.size() + 1;

        Funcionario func = new Funcionario(idFuncionario,salario,ativo,dataAd,dataDem,cargo,login,senha,nivelAcesso);

        func.cadastrarPessoa();

        listaFuncionarios.add(func);
        System.out.println("Funcionário cadastrado com sucesso.");
        System.out.println("==================================================================");
    }

    public void atualizarFuncionario() {
        System.out.println("================ATUALIZAR CADASTRO DE FUNCIONÁRIOS=================");
        int idFuncionario;
        while (true) {
            try {
                System.out.print("Informe o ID do funcionário: ");
                idFuncionario = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }
        boolean existeFuncionario = false;

        for (Funcionario func : listaFuncionarios) {
            if (func.getIdFuncionario() == idFuncionario) {
                System.out.println("ID: "+func.getIdFuncionario());
                func.mostrarDadosPessoa();
                System.out.println("==================================================================");

                func.alteraDadosPessoa();
                existeFuncionario = true;
                System.out.println("Cadastro atualizado com sucesso!");
            }
        }
        if (!existeFuncionario) {
            System.out.println("ID de funcionário não existe.");
        }
        System.out.println("==================================================================");
    }

    public void listarFuncionarios () {
        System.out.println("=======================LISTA DE FUNCIONÁRIOS=======================");
        for (Funcionario func : listaFuncionarios) {
            System.out.println("ID Funcionário: " + func.getIdFuncionario());
            func.mostrarDadosPessoa();
            System.out.println("==================================================================");
        }
    }

    public void consultarFuncionarioNome() { consultarPessoaPorNome(listaFuncionarios); }

    public void consultarFuncionarioCpf() {
        consultarPessoaPorCpf(listaFuncionarios);
    }

    public void consultarFuncionarioEmail() {
        consultarPessoaPorEmail(listaFuncionarios);
    }

    public void consultarFuncionarioTelefone() {
        consultarPessoaPorTelefone(listaFuncionarios);
    }

    public void consultarFuncionarioCargo() {
        System.out.print("Informe o cargo do funcionário: ");
        String cargo = scanner.nextLine();
        boolean existeRegistro = false;
        System.out.println("RESULTADOS DA PESQUISA:");
        for (Funcionario func : listaFuncionarios) {
            if (func.isAtivo()) {
                if (func.getCargo().toLowerCase().contains(cargo.toLowerCase())) {
                    System.out.println("ID Funcionário: " + func.getIdFuncionario());
                    func.mostrarDadosPessoa();
                    existeRegistro = true;
                    System.out.println("==================================================================");
                }
            }
        }
        if (!existeRegistro) {
            System.out.println("==================================================================");
            System.out.println("Não existe registro para os dados informados.");
            System.out.println("==================================================================");
        }
    }

    public void contrataFuncionario() {
        System.out.println("====================CONTRATAÇÃO DE FUNCIONÁRIO====================");
        int idFunc;
        while (true) {
            try {
                System.out.print("Informe o ID de funcionário cadastrado para efetuar contratação: ");
                idFunc = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }

        boolean existeFuncionario = false;

        for (Funcionario func : listaFuncionarios) {
            if (func.getIdFuncionario() == idFunc) {
                if (!func.isAtivo()) {
                    existeFuncionario = true;
                    LocalDate data;
                    while (true) {
                        try {
                            System.out.print("Qual a data de contratação efetiva do funcionário? (dd/mm/aaaa): ");
                            String dataAdm = scanner.nextLine().trim();
                            data = LocalDate.parse(dataAdm, formatador);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.print("Informe uma data válida no formato dd/mm/aaaa. ");
                        }
                    }
                    func.setDataAdmissao(data);
                    func.setAtivo(true);

                    String cargo;
                    while (true) {
                        try {
                            System.out.print("1 - Vendedor\n2 - Gerente de Vendas\n3 - Estoquista\n4 - Gerente de Estoque\nQual o cargo para qual o funcionário foi contratado? ");
                            int escolhaCargo = Integer.parseInt(scanner.nextLine());
                            if (escolhaCargo == 1) {
                                cargo = "vendedor";
                                break;
                            } else if (escolhaCargo == 2) {
                                cargo = "gerente de vendas";
                                break;
                            } else if (escolhaCargo == 3) {
                                cargo = "estoquista";
                                break;
                            } else if (escolhaCargo == 4) {
                                cargo = "gerente de estoque";
                                break;
                            } else {
                                System.out.print("Escolha inválida. ");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Digite apenas números inteiros.");
                        }
                    }
                    func.setCargo(cargo);

                    double salario;
                    while (true) {
                        try {
                            System.out.print("Qual será o salário do funcionário? ");
                            String salarioStr = scanner.nextLine();
                            salario = Double.parseDouble(salarioStr.replace(",", "."));
                            break;
                        } catch (Exception e) {
                            System.out.print("O salário deve ser informado em números. ");
                        }
                    }
                    func.setSalario(salario);

                    sistemaLogin.cadastrarAcesso(func, listaFuncionarios);
                    System.out.println("Funcionário contratado com sucesso.");
                } else {
                    System.out.println("O funcionário contratado com data de admissão em " + func.getDataAdmissao() + ".");
                }
            }
        }
        if (!existeFuncionario) {
            System.out.println("ID de funcionário não existe.");
        }
    }

    public void alteraCargo() {
        System.out.println("======================MUDANÇA DE CARGO DE FUNCIONÁRIO=====================");
        int idFunc;
        while (true) {
            try {
                System.out.print("Informe o ID de funcionário para mudança de cargo: ");
                idFunc = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }

        boolean existeFuncionario = false;
        for (Funcionario func : listaFuncionarios) {
            if (func.getIdFuncionario() == idFunc) {
                if (func.isAtivo()) {
                    String cargo;
                    String novoAcesso;
                    while (true) {
                        try {
                            System.out.print("1 - Vendedor\n2 - Gerente de Vendas\n3 - Estoquista\n4 - Gerente de Estoque\nQual o novo cargo do funcionário? ");
                            int escolhaCargo = Integer.parseInt(scanner.nextLine());
                            if (escolhaCargo == 1) {
                                cargo = "vendedor";
                                novoAcesso = "14";
                                break;
                            } else if (escolhaCargo == 2) {
                                cargo = "gerente de vendas";
                                novoAcesso = "1234";
                                break;
                            } else if (escolhaCargo == 3) {
                                cargo = "estoquista";
                                novoAcesso = "35";
                                break;
                            } else if (escolhaCargo == 4) {
                                cargo = "gerente de estoque";
                                novoAcesso = "235";
                                break;
                            } else {
                                System.out.print("Escolha inválida. ");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Digite apenas números inteiros.");
                        }
                    }
                    func.setCargo(cargo);
                    func.setNivelAcesso(novoAcesso);
                    System.out.println("Cargo de funcionário alterado com sucesso.");
                } else {
                    System.out.println("O funcionário não está contratado.");
                }
                existeFuncionario = true;
            }
        }
        if (!existeFuncionario) {
            System.out.println("ID de funcionário não existe.");
        }
    }

    public void alteraSalario() {
        System.out.println("========================MUDANÇA DE SALÁRIO========================");
        int idFunc;
        while (true) {
            try {
                System.out.print("Informe o ID de funcionário para mudança de salário: ");
                idFunc = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }

        boolean existeFuncionario = false;
        for (Funcionario func : listaFuncionarios) {
            if (func.getIdFuncionario() == idFunc) {
                if (func.isAtivo()) {
                    double salario;
                    while (true) {
                        try {
                            System.out.print("Qual será o novo salário do funcionário? ");
                            String salarioStr = scanner.nextLine();
                            salario = Double.parseDouble(salarioStr.replace(",", "."));
                            break;
                        } catch (Exception e) {
                            System.out.print("O salário deve ser informado em números. ");
                        }
                    }
                    func.setSalario(salario);
                    System.out.println("Mudança de salário efetuada com sucesso.");
                } else {
                    System.out.println("O funcionário não está contratado.");
                }
                existeFuncionario = true;
            }
        }
        if (!existeFuncionario) {
            System.out.println("ID de funcionário não existe.");
        }
    }

    public void desligaFuncionario() {
        System.out.println("====================DESLIGAMENTO DE FUNCIONÁRIO===================");
        int idFunc;
        while (true) {
            try {
                System.out.print("Informe o ID de funcionário para desligamento: ");
                idFunc = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }

        boolean existeFuncionario = false;
        for (Funcionario func : listaFuncionarios) {
            if (func.getIdFuncionario() == idFunc) {
                if (func.isAtivo()) {
                    LocalDate data;
                    while (true) {
                        try {
                            System.out.print("Informe a data de desligamento (dd/mm/aaaa): ");
                            String dataAdm = scanner.nextLine().trim();
                            data = LocalDate.parse(dataAdm, formatador);
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.print("Informe uma data válida no formato dd/mm/aaaa. ");
                        }
                    }
                    func.setDataDemissao(data);
                    func.setAtivo(false);
                    System.out.println("Funcionário desligado com sucesso.");
                } else {
                    System.out.println("O funcionário não está contratado.");
                }
                existeFuncionario = true;
            }
        }
        if (!existeFuncionario) {
            System.out.println("ID de funcionário não existe.");
        }
    }

    public void atualizarAcesso() {
        System.out.println("===============ATUALIZAÇÃO DE ACESSO DE FUNCIONÁRIO===============");
        int idFuncionario;
        while (true) {
            try {
                System.out.print("Informe o ID do funcionário: ");
                idFuncionario = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }

        boolean existeFuncionario = false;
        for (Funcionario func : listaFuncionarios) {
            if (func.getIdFuncionario() == idFuncionario) {
                if (func.isAtivo()) {
                    System.out.println("ID do funcionário: "+func.getIdFuncionario());
                    func.mostrarDadosPessoa();

                    System.out.println("==================================================================");

                    sistemaLogin.alterarAcesso(func, listaFuncionarios);
                    System.out.println("Acesso atualizado com sucesso!");
                    System.out.println("ID: "+func.getIdFuncionario());
                    sistemaLogin.mostrarAcesso(func);
                } else {
                    System.out.println("Funcionário não está contratado.");
                }
                existeFuncionario = true;
            }
        }
        if (!existeFuncionario) {
            System.out.println("ID de funcionário não existe.");
        }
        System.out.println("==================================================================");
    }

    public List<Funcionario> exportaListaFuncionario() {
        return listaFuncionarios;
    }

    @Override
    public void mostrarDadosPessoa() {
        super.mostrarDadosPessoa();
        if (isAtivo()) {
            System.out.println("Situação: Ativo");
            System.out.println("Cargo: " + this.getCargo());
            System.out.println("Salário: " + this.getSalario());
            System.out.println("Data de admissão: " + this.getDataAdmissao());
            if (this.getDataDemissao() != null) {
                System.out.println("Data de demissão: " + this.getDataDemissao());
            }
            System.out.println("Login: " + this.getLogin());
            System.out.println("Senha: " + this.getSenha());
            System.out.println("Acesso: " + this.getNivelAcesso());
        } else {
            System.out.println("Situação: Inativo");
        }
    }

    @Override
    public String getIdentificacao() {
        return "ID Funcionário: " + getIdFuncionario();
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public void setSistemaLogin (Login sistemaLogin) {
        this.sistemaLogin = sistemaLogin;
    }
}
