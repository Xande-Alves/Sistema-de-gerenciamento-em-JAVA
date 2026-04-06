import java.util.ArrayList;
import java.util.List;

public class Fornecedor extends Pessoa {
    List<Fornecedor> listaFornecedores = new ArrayList<>();

    int idFornecedor;
    String representaEmpresaNome;
    String representaEmpresaCnpj;

    public Fornecedor (int idFornecedor, String nomeEmpresa, String cnpjEmpresa) {
        this.representaEmpresaNome = nomeEmpresa;
        this.representaEmpresaCnpj = cnpjEmpresa;
        this.idFornecedor = idFornecedor;
    }

//    public void inicializarFornecedor() {
//        Fornecedor f1 = new Fornecedor(1,"bela","111");
//        listaFornecedores.add(f1);
//    }

    public void cadastrarFornecedor() {
        int idFornecedor = listaFornecedores.size() + 1;
        Fornecedor fornec = new Fornecedor(idFornecedor,"", "");

        fornec.cadastrarPessoa();
        System.out.print("Insira o nome da empresa que o fornecedor representa: ");
        String nomeEmpresa = scanner.nextLine();
        fornec.setRepresentaEmpresaNome(nomeEmpresa);
        System.out.print("Insira o CNPJ da empresa que o fornecedor representa: ");
        String cnpjEmpresa = scanner.nextLine();
        fornec.setRepresentaEmpresaCnpj(cnpjEmpresa);

        listaFornecedores.add(fornec);
        System.out.println("Fornecedor cadastrado com sucesso!");
        System.out.println("==================================================================");
    }

    public void atualizarFornecedor() {
        System.out.print("Informe o ID do fornecedor: ");
        int idFornecedor = Integer.parseInt(scanner.nextLine());

        for (Fornecedor fornec : listaFornecedores) {
            if (fornec.getIdFornecedor() == idFornecedor) {
                System.out.println("ID: "+fornec.getIdFornecedor());
                fornec.mostrarDadosPessoa();
                System.out.println("Nome da empresa: "+fornec.getRepresentaEmpresaNome());
                System.out.println("CNPJ da empresa: "+fornec.getRepresentaEmpresaCnpj());
                System.out.println("==================================================================");

                fornec.alteraDadosPessoa();
                System.out.print("Informe o novo nome da empresa (enter para não alterar): ");
                String novoNomeEmpresa = scanner.nextLine();
                if (!novoNomeEmpresa.isEmpty()) {
                    fornec.setRepresentaEmpresaNome(novoNomeEmpresa);
                }
                System.out.print("Informe o novo CNPJ da empresa (enter para não alterar): ");
                String novoCnpjEmpresa = scanner.nextLine();
                if (!novoCnpjEmpresa.isEmpty()) {
                    fornec.setRepresentaEmpresaCnpj(novoCnpjEmpresa);
                }
                System.out.print("Cadastro atualizado com sucesso!");
            } else {
                System.out.println("ID de fornecedor não existe.");
            }
        }
        System.out.println("==================================================================");
    }

    public void listarFornecedores() {
        for(Fornecedor fornec : listaFornecedores) {
            System.out.println("ID fornecedor: "+fornec.getIdFornecedor());
            fornec.mostrarDadosPessoa();
            System.out.println("Nome da empresa: "+fornec.getRepresentaEmpresaNome());
            System.out.println("CNPJ da empresa: "+fornec.getRepresentaEmpresaCnpj());

            System.out.println("==================================================================");
        }
    }

    public void consultarFornecedorNome() { consultarPessoaPorNome(listaFornecedores); }

    public void consultarFornecedorCpf() {
        consultarPessoaPorCpf(listaFornecedores);
    }

    public void consultarFornecedorEmail() {
        consultarPessoaPorEmail(listaFornecedores);
    }

    public void consultarFornecedorTelefone() {
        consultarPessoaPorTelefone(listaFornecedores);
    }

    public void consultarFornecedorNomeEmpresa() {
        System.out.print("Informe o nome da empresa do fornecedor: ");
        String nomeEmpresa = scanner.nextLine();
        for (Fornecedor fornec : listaFornecedores) {
            if (fornec.getRepresentaEmpresaNome().toLowerCase().contains(nomeEmpresa.toLowerCase())) {
                System.out.println("ID Fornecedor: " + fornec.getIdFornecedor());
                fornec.mostrarDadosPessoa();
                System.out.println("Nome da empresa: "+fornec.getRepresentaEmpresaNome());
                System.out.println("CNPJ da empresa: "+fornec.getRepresentaEmpresaCnpj());
                System.out.println("==================================================================");
            }
        }
    }

    public void consultarFornecedorCnpjEmpresa() {
        System.out.print("Informe o CNPJ da empresa do fornecedor: ");
        String cnpjEmpresa = scanner.nextLine();
        for (Fornecedor fornec : listaFornecedores) {
            if (fornec.getRepresentaEmpresaCnpj().toLowerCase().contains(cnpjEmpresa.toLowerCase())) {
                System.out.println("ID Fornecedor: " + fornec.getIdFornecedor());
                fornec.mostrarDadosPessoa();
                System.out.println("Nome da empresa: "+fornec.getRepresentaEmpresaNome());
                System.out.println("CNPJ da empresa: "+fornec.getRepresentaEmpresaCnpj());
                System.out.println("==================================================================");
            }
        }
    }

    public List<Fornecedor> exportaListaFornecedor() {
        return listaFornecedores;
    }

    public int getIdFornecedor() {
        return idFornecedor;
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
