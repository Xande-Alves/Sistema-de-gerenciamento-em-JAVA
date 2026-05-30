package entidades;

import java.util.Scanner;

public class Endereco {
    //private final Scanner scanner = new Scanner(System.in);

    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

//    public void cadastrarEndereco() {
//        System.out.print("Logradouro: ");
//        this.logradouro = scanner.nextLine();
//        System.out.print("Número: ");
//        this.numero = scanner.nextLine();
//        System.out.print("Bairro: ");
//        this.bairro = scanner.nextLine();
//        System.out.print("Cidade: ");
//        this.cidade = scanner.nextLine();
//        System.out.print("Estado: ");
//        this.estado = scanner.nextLine();
//        while (true) {
//            System.out.print("CEP: ");
//            String cepDigitado = scanner.nextLine();
//
//            // remove traços e espaços, caso o usuário digite
//            cepDigitado = cepDigitado.replaceAll("[^0-9]", "");
//
//            // valida se possui exatamente 8 números
//            if (cepDigitado.matches("\\d{8}")) {
//                // formata para 00000-000
//                this.cep = cepDigitado.substring(0, 5) + "-" +
//                        cepDigitado.substring(5);
//                break;
//            } else {
//                System.out.print("O CEP deve conter 8 números. ");
//            }
//        }
//    }
//
//    public void mostrarEndereco() {
//        System.out.println("Logradouro: "+this.getLogradouro());
//        System.out.println("Número: "+this.getNumero());
//        System.out.println("Bairro: "+this.getBairro());
//        System.out.println("Cidade: "+this.getCidade());
//        System.out.println("Estado: "+this.getEstado());
//        System.out.println("CEP: "+this.getCep());
//    }
//
//    public void alterarEndereco() {
//        System.out.print("Logradouro (enter para não alterar): ");
//        String logradouro = scanner.nextLine();
//        if (!logradouro.isEmpty()) {
//            this.setLogradouro(logradouro);
//        }
//        System.out.print("Número (enter para não alterar): ");
//        String numero = scanner.nextLine();
//        if (!numero.isEmpty()) {
//            this.setNumero(numero);
//        }
//        System.out.print("Bairro (enter para não alterar): ");
//        String bairro = scanner.nextLine();
//        if (!bairro.isEmpty()) {
//            this.setBairro(bairro);
//        }
//        System.out.print("Cidade (enter para não alterar): ");
//        String cidade = scanner.nextLine();
//        if (!cidade.isEmpty()) {
//            this.setCidade(cidade);
//        }
//        System.out.print("Estado (enter para não alterar): ");
//        String estado = scanner.nextLine();
//        if (!estado.isEmpty()) {
//            this.setEstado(estado);
//        }
//        while (true) {
//            System.out.print("CEP (enter para não alterar): ");
//            String cepDigitado = scanner.nextLine();
//
//            if (!cepDigitado.isEmpty()) {
//                // remove traços e espaços, caso o usuário digite
//                cepDigitado = cepDigitado.replace("-", "").trim();
//
//                // valida se possui exatamente 8 números
//                if (cepDigitado.matches("\\d{8}")) {
//                    // formata para 00000-000
//                    this.setCep(cepDigitado.substring(0, 5) + "-" +
//                            cepDigitado.substring(5));
//                    break;
//                } else {
//                    System.out.print("O CEP deve conter 8 números. ");
//                }
//            } else {
//                break;
//            }
//        }
//    }



    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
