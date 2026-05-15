import java.util.List;
import java.util.Scanner;

public abstract class Pessoa extends Endereco {
    private final Scanner scanner = new Scanner(System.in);

    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    public void cadastrarPessoa () {
        System.out.print("Nome: ");
        this.nome = scanner.nextLine();

        while (true) {
            System.out.print("CPF: ");
            String cpfDigitado = scanner.nextLine();

            cpfDigitado = cpfDigitado.replaceAll("[^0-9]", "");

            if (cpfDigitado.matches("\\d{11}")) {
                this.cpf =
                        cpfDigitado.substring(0, 3) + "." +
                                cpfDigitado.substring(3, 6) + "." +
                                cpfDigitado.substring(6, 9) + "-" +
                                cpfDigitado.substring(9, 11);
                break;
            } else {
                System.out.println("O CPF deve conter 11 números.");
            }
        }

        while (true) {
            System.out.print("E-mail: ");
            this.email = scanner.nextLine().trim();

            if (this.email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                break;
            } else {
                System.out.println("Formato de e-mail inválido.");
            }
        }

        while (true) {
            System.out.print("Telefone celular (com DDD): ");
            String telefoneDigitado = scanner.nextLine();

            telefoneDigitado = telefoneDigitado.replaceAll("[^0-9]", "");

            if (telefoneDigitado.matches("\\d{11}")) {
                this.telefone =
                        "(" + telefoneDigitado.substring(0, 2) + ") " +
                                telefoneDigitado.substring(2, 7) + "-" +
                                telefoneDigitado.substring(7);
                break;
            } else {
                System.out.println("Informe um telefone com 11 números (DDD + celular).");
            }
        }
        cadastrarEndereco();
    }

    public void mostrarDadosPessoa() {
        System.out.println("Nome: "+this.getNome());
        System.out.println("CPF: "+this.getCpf());
        System.out.println("E-mail: "+this.getEmail());
        System.out.println("Telefone celular: "+this.getTelefone());
        mostrarEndereco();
    }

    public void alteraDadosPessoa() {
        System.out.print("Nome (enter para não alterar): ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) {
            this.setNome(nome);
        }

        while (true) {
            System.out.print("CPF (enter para não alterar): ");
            String cpfDigitado = scanner.nextLine();

            if (!cpfDigitado.isEmpty()) {
                cpfDigitado = cpfDigitado.replaceAll("[^0-9]", "");

                if (cpfDigitado.matches("\\d{11}")) {
                    cpfDigitado =
                            cpfDigitado.substring(0, 3) + "." +
                                    cpfDigitado.substring(3, 6) + "." +
                                    cpfDigitado.substring(6, 9) + "-" +
                                    cpfDigitado.substring(9, 11);
                    this.setCpf(cpfDigitado);
                    break;
                } else {
                    System.out.println("O CPF deve conter 11 números.");
                }
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("E-mail (enter para não alterar): ");
            String emailDigitado = scanner.nextLine().trim();

            if (!emailDigitado.isEmpty()) {
                if (emailDigitado.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                    this.setEmail(emailDigitado);
                    break;
                } else {
                    System.out.println("Formato de e-mail inválido.");
                }
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Telefone celular (enter para não alterar): ");
            String telefoneDigitado = scanner.nextLine();

            if (!telefoneDigitado.isEmpty()) {
                telefoneDigitado = telefoneDigitado.replaceAll("[^0-9]", "");

                if (telefoneDigitado.matches("\\d{11}")) {
                    telefoneDigitado =
                            "(" + telefoneDigitado.substring(0, 2) + ") " +
                                    telefoneDigitado.substring(2, 7) + "-" +
                                    telefoneDigitado.substring(7);
                    this.setTelefone(telefoneDigitado);
                    break;
                } else {
                    System.out.println("Informe um telefone com 11 números (DDD + celular).");
                }
            } else {
                break;
            }


        }
        alterarEndereco();
    }

    public void consultarPessoaPorNome(List<? extends Pessoa> lista) {
        System.out.print("Digite o nome que deseja consultar: ");
        String nomeConsulta = scanner.next();
        boolean existeRegistro = false;
        System.out.println("RESULTADOS DA PESQUISA:");
        for (Pessoa p : lista) {
            if (p.getNome().toLowerCase().contains(nomeConsulta.toLowerCase())) {
                System.out.println(p.getIdentificacao());
                p.mostrarDadosPessoa();
                existeRegistro = true;
                System.out.println("==================================================================");
            }
        }
        if (!existeRegistro) {
            System.out.println("==================================================================");
            System.out.println("Não existe registro para os dados informados.");
            System.out.println("==================================================================");
        }
    }

    public void consultarPessoaPorCpf(List<? extends Pessoa> lista) {
        System.out.print("Digite o CPF que deseja consultar (apenas números): ");
        String cpfConsulta = scanner.next();
        boolean existeRegistro = false;
        System.out.println("RESULTADOS DA PESQUISA:");
        for (Pessoa p : lista) {
            if (p.getCpf().replaceAll("[^0-9]", "").contains(cpfConsulta)) {
                System.out.println(p.getIdentificacao());
                p.mostrarDadosPessoa();
                existeRegistro = true;
                System.out.println("==================================================================");
            }
        }
        if (!existeRegistro) {
            System.out.println("==================================================================");
            System.out.println("Não existe registro para os dados informados.");
            System.out.println("==================================================================");
        }
    }

    public void consultarPessoaPorEmail(List<? extends Pessoa> lista) {
        System.out.print("Digite o E-mail que deseja consultar: ");
        String emailConsulta = scanner.next();
        boolean existeRegistro = false;
        System.out.println("RESULTADOS DA PESQUISA:");
        for (Pessoa p : lista) {
            if (p.getEmail().toLowerCase().contains(emailConsulta.toLowerCase())) {
                System.out.println(p.getIdentificacao());
                p.mostrarDadosPessoa();
                existeRegistro = true;
                System.out.println("==================================================================");
            }
        }
        if (!existeRegistro) {
            System.out.println("==================================================================");
            System.out.println("Não existe registro para os dados informados.");
            System.out.println("==================================================================");
        }
    }

    public void consultarPessoaPorTelefone(List<? extends Pessoa> lista) {
        System.out.print("Digite o telefone celular que deseja consultar (apenas números): ");
        String telefoneConsulta = scanner.next();
        boolean existeRegistro = false;
        System.out.println("RESULTADOS DA PESQUISA:");
        for (Pessoa p : lista) {
            if (p.getTelefone().replaceAll("[^0-9]", "").contains(telefoneConsulta)) {
                System.out.println(p.getIdentificacao());
                p.mostrarDadosPessoa();
                existeRegistro = true;
                System.out.println("==================================================================");
            }
        }
        if (!existeRegistro) {
            System.out.println("==================================================================");
            System.out.println("Não existe registro para os dados informados.");
            System.out.println("==================================================================");
        }
    }

    public String getIdentificacao() {
        return "";
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
