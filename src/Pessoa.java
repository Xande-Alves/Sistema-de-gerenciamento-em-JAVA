import java.util.List;
import java.util.Scanner;

public abstract class Pessoa extends Endereco {
    Scanner scanner = new Scanner(System.in);

    protected String nome;
    protected String cpf;
    protected String email;
    protected String telefone;

    public void cadastrarPessoa () {
        System.out.print("Nome: ");
        this.nome = scanner.nextLine();
        System.out.print("CPF: ");
        this.cpf = scanner.nextLine();
        System.out.print("E-mail: ");
        this.email = scanner.nextLine();
        System.out.print("Telefone: ");
        this.telefone = scanner.nextLine();
        cadastrarEndereco();
    }

    public void mostrarDadosPessoa() {
        System.out.println("Nome: "+this.getNome());
        System.out.println("CPF: "+this.getCpf());
        System.out.println("E-mail: "+this.getEmail());
        System.out.println("Telefone: "+this.getTelefone());
        mostrarEndereco();
    }

    public void alteraDadosPessoa() {
        System.out.print("Nome (enter para não alterar): ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) {
            this.setNome(nome);
        }
        System.out.print("CPF (enter para não alterar): ");
        String cpf = scanner.nextLine();
        if (!cpf.isEmpty()) {
            this.setCpf(cpf);
        }
        System.out.print("E-mail (enter para não alterar): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            this.setEmail(email);
        }
        System.out.print("Telefone (enter para não alterar): ");
        String telefone = scanner.nextLine();
        if (!telefone.isEmpty()) {
            this.setTelefone(telefone);
        }
        alterarEndereco();
    }

    public void consultarPessoaPorNome(List<? extends Pessoa> lista) {
        System.out.print("Digite o nome que deseja consultar: ");
        String nomeConsulta = scanner.next();

        for (Pessoa p : lista) {
            if (p.getNome().toLowerCase().contains(nomeConsulta.toLowerCase())) {
                System.out.println(p.getIdentificacao());
                p.mostrarDadosPessoa();
            }
            System.out.println("==================================================================");
        }
    }

    public void consultarPessoaPorCpf(List<? extends Pessoa> lista) {
        System.out.print("Digite o CPF que deseja consultar: ");
        String cpfConsulta = scanner.next();

        for (Pessoa p : lista) {
            if (p.getCpf().contains(cpfConsulta)) {
                System.out.println(p.getIdentificacao());
                p.mostrarDadosPessoa();
            }
            System.out.println("==================================================================");
        }
    }

    public void consultarPessoaPorEmail(List<? extends Pessoa> lista) {
        System.out.print("Digite o E-mail que deseja consultar: ");
        String emailConsulta = scanner.next();

        for (Pessoa p : lista) {
            if (p.getEmail().toLowerCase().contains(emailConsulta.toLowerCase())) {
                System.out.println(p.getIdentificacao());
                p.mostrarDadosPessoa();
            }
            System.out.println("==================================================================");
        }
    }

    public void consultarPessoaPorTelefone(List<? extends Pessoa> lista) {
        System.out.print("Digite o telefone que deseja consultar: ");
        String telefoneConsulta = scanner.next();

        for (Pessoa p : lista) {
            if (p.getTelefone().contains(telefoneConsulta)) {
                System.out.println(p.getIdentificacao());
                p.mostrarDadosPessoa();
            }
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
