package controladores;
import entidades.Endereco;


import java.util.Scanner;

public class ControladorEndereco {
    private final Scanner scanner = new Scanner(System.in);
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
        System.out.print("Logradouro: ");
        e.setLogradouro(scanner.nextLine());
        System.out.print("Número: ");
        e.setNumero(scanner.nextLine());
        System.out.print("Bairro: ");
        e.setBairro(scanner.nextLine());
        System.out.print("Cidade: ");
        e.setCidade(scanner.nextLine());
        System.out.print("Estado: ");
        e.setEstado(scanner.nextLine());
        while (true) {
            System.out.print("CEP: ");
            String cepDigitado = scanner.nextLine();

            // remove traços e espaços, caso o usuário digite
            cepDigitado = cepDigitado.replaceAll("[^0-9]", "");

            // valida se possui exatamente 8 números
            if (cepDigitado.matches("\\d{8}")) {
                // formata para 00000-000
                e.setCep(cepDigitado.substring(0, 5) + "-" +
                        cepDigitado.substring(5));
                break;
            } else {
                System.out.print("O CEP deve conter 8 números. ");
            }
        }
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
        System.out.print("Logradouro (enter para não alterar): ");
        String logradouro = scanner.nextLine();
        if (!logradouro.isEmpty()) {
            e.setLogradouro(logradouro);
        }
        System.out.print("Número (enter para não alterar): ");
        String numero = scanner.nextLine();
        if (!numero.isEmpty()) {
            e.setNumero(numero);
        }
        System.out.print("Bairro (enter para não alterar): ");
        String bairro = scanner.nextLine();
        if (!bairro.isEmpty()) {
            e.setBairro(bairro);
        }
        System.out.print("Cidade (enter para não alterar): ");
        String cidade = scanner.nextLine();
        if (!cidade.isEmpty()) {
            e.setCidade(cidade);
        }
        System.out.print("Estado (enter para não alterar): ");
        String estado = scanner.nextLine();
        if (!estado.isEmpty()) {
            e.setEstado(estado);
        }
        while (true) {
            System.out.print("CEP (enter para não alterar): ");
            String cepDigitado = scanner.nextLine();

            if (!cepDigitado.isEmpty()) {
                // remove traços e espaços, caso o usuário digite
                cepDigitado = cepDigitado.replace("-", "").trim();

                // valida se possui exatamente 8 números
                if (cepDigitado.matches("\\d{8}")) {
                    // formata para 00000-000
                    e.setCep(cepDigitado.substring(0, 5) + "-" +
                            cepDigitado.substring(5));
                    break;
                } else {
                    System.out.print("O CEP deve conter 8 números. ");
                }
            } else {
                break;
            }
        }
    }
}
