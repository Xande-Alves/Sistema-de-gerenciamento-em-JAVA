package controladores;
import entidades.Endereco;
import utilitarios.LeitorConsole;


import java.util.Scanner;

public class ControladorEndereco {
    private final Scanner scanner = new Scanner(System.in);
    private final LeitorConsole leitor = new LeitorConsole(scanner);
    private static ControladorEndereco instanciaControladorEndereco;

    private ControladorEndereco() {

    }

    public static ControladorEndereco getInstanciaControladorEndereco() {
        if (instanciaControladorEndereco == null) {
            instanciaControladorEndereco = new ControladorEndereco();
        }
        return instanciaControladorEndereco;
    }

    public void cadastrarEndereco(Endereco e) {
        e.setLogradouro(leitor.lerTexto("Logradouro: "));
        e.setNumero(leitor.lerTexto("Número: "));
        e.setBairro(leitor.lerTexto("Bairro: "));
        e.setCidade(leitor.lerTexto("Cidade: "));
        e.setEstado(leitor.lerTexto("Estado: "));
        e.setCep(leitor.lerCep("CEP: "));
    }

    public void mostrarEndereco(Endereco e) {
        System.out.println("Logradouro: "+e.getLogradouro());
        System.out.println("Número: "+e.getNumero());
        System.out.println("Bairro: "+e.getBairro());
        System.out.println("Cidade: "+e.getCidade());
        System.out.println("Estado: "+e.getEstado());
        System.out.println("CEP: "+e.getCep());
    }

    public void alterarEndereco(Endereco e) {
        String logradouro = leitor.lerTextoOpcional("Logradouro (enter para não alterar): ");
        if (!logradouro.isEmpty()) {
            e.setLogradouro(logradouro);
        }

        String numero = leitor.lerTextoOpcional("Número (enter para não alterar): ");
        if (!numero.isEmpty()) {
            e.setNumero(numero);
        }

        String bairro = leitor.lerTextoOpcional("Bairro (enter para não alterar): ");
        if (!bairro.isEmpty()) {
            e.setBairro(bairro);
        }

        String cidade = leitor.lerTextoOpcional("Cidade (enter para não alterar): ");
        if (!cidade.isEmpty()) {
            e.setCidade(cidade);
        }

        String estado = leitor.lerTextoOpcional("Estado (enter para não alterar): ");
        if (!estado.isEmpty()) {
            e.setEstado(estado);
        }

        String cep = leitor.lerCepOpcional("CEP (enter para não alterar): ");
        if (!cep.isEmpty()) {
            e.setCep(cep);
        }

    }
}
