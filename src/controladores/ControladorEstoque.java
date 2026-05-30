package controladores;

import entidades.Produto;
import repositorio.Repositorio;

import java.util.Scanner;

public class ControladorEstoque {
    private final Scanner scanner = new Scanner(System.in);
    static ControladorEstoque controladorEstoqueInstancia;

    private ControladorEstoque() {

    }

    public static ControladorEstoque getInstanciaControladorEstoque() {
        if (controladorEstoqueInstancia == null) {
            controladorEstoqueInstancia = new ControladorEstoque();
        }
        return controladorEstoqueInstancia;
    }

    public String diminuiQuantidadeEstoqueVenda(Produto p) {
        if (p.getQuantidadeEstoque() < p.getQuantidade()) {
            p.setQuantidadeEstoque(p.getQuantidadeEstoque() - p.getQuantidade());
            return "Quantidade vendida é superior a quantidade estocada. Faltam: " + Math.abs(p.getQuantidadeEstoque())+".";
        } else {
            p.setQuantidadeEstoque(p.getQuantidadeEstoque() - p.getQuantidade());
            return "";
        }
    }

    public String alteraDiminuiQuantidadeEstoqueVenda(Produto p, Double alteraEstoque) {
        if (p.getQuantidadeEstoque() < Math.abs(alteraEstoque)) {
            p.setQuantidadeEstoque(p.getQuantidadeEstoque() - Math.abs(alteraEstoque));
            return "Quantidade vendida é superior a quantidade estocada. Faltam: " + Math.abs(p.getQuantidadeEstoque());
        } else {
            p.setQuantidadeEstoque(p.getQuantidadeEstoque() - Math.abs(alteraEstoque));
            return "";
        }
    }

    public void alteraAumentaQuantidadeEstoqueVenda(Produto p, Double alteraEstoque) {
        p.setQuantidadeEstoque(p.getQuantidadeEstoque()+alteraEstoque);
    }

    public void reporEstoqueProduto() {
        System.out.println("===========================REPOR ESTOQUE==========================");
        int idProduto;
        while (true) {
            try {
                System.out.print("Informe o ID do produto: ");
                idProduto = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Digite apenas números inteiros. ");
            }
        }

        boolean existeProduto = false;
        for (Produto p : Repositorio.getInstanciaRepositorio().getListaProduto()) {
            if (p.getIdProduto() == idProduto) {
                ControladorProduto.getInstanciaControladorProduto().mostrarProduto(p);
                double aumentaEstoque;
                existeProduto = true;
                while (true) {
                    try {
                        System.out.print("Aumentar a quantidade do estoque do produto em quanto? ");
                        String aumentaEstoqueStr = scanner.nextLine();
                        aumentaEstoque = Double.parseDouble(aumentaEstoqueStr.replace(",", "."));
                        break;
                    } catch (Exception e) {
                        System.out.print("A quantidade deve ser informada em números. ");
                    }
                }

                p.setQuantidadeEstoque(p.getQuantidadeEstoque()+aumentaEstoque);
                System.out.println("Estoque do produto aumentado em "+aumentaEstoque+", totalizando "+p.getQuantidadeEstoque()+".");
            }
        }
        if (!existeProduto) {
            System.out.println("ID de produto não existe.");
        }
    }

    public void diminuiProduto() {
        System.out.println("=========================DIMINUIR ESTOQUE=========================");
        int idProduto;
        while (true) {
            try {
                System.out.print("Informe o ID do produto: ");
                idProduto = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Digite apenas números inteiros. ");
            }
        }

        boolean existeProduto = false;
        for (Produto p : Repositorio.getInstanciaRepositorio().getListaProduto()) {
            if (p.getIdProduto() == idProduto) {
                ControladorProduto.getInstanciaControladorProduto().mostrarProduto(p);
                double diminuiEstoque;
                existeProduto = true;
                while (true) {
                    try {
                        System.out.print("Diminuir a quantidade do estoque do produto em quanto? ");
                        String diminuiEstoqueStr = scanner.nextLine();
                        diminuiEstoque = Double.parseDouble(diminuiEstoqueStr.replace(",", "."));
                        break;
                    } catch (Exception e) {
                        System.out.print("A quantidade deve ser informada em números. ");
                    }
                }
                p.setQuantidadeEstoque(p.getQuantidadeEstoque()-diminuiEstoque);
                System.out.println("Estoque do produto diminuído em "+diminuiEstoque+", totalizando "+p.getQuantidadeEstoque()+".");
            }
        }
        if (!existeProduto) {
            System.out.println("ID de produto não existe.");
        }
    }

    public void avisosEstoque() {
        System.out.println("=========================AVISOS DE ESTOQUE========================");
        double quantidadeProduto;
        while (true) {
            try {
                System.out.print("Qual a quantidade de produto a ser pesquisada? ");
                String quantidadeProdutoStr = scanner.nextLine();
                quantidadeProduto = Double.parseDouble(quantidadeProdutoStr.replace(",", "."));
                break;
            } catch (Exception e) {
                System.out.print("A quantidade deve ser informada em números. ");
            }
        }
        boolean existeProduto = false;
        for (Produto p : Repositorio.getInstanciaRepositorio().getListaProduto()) {
            if (p.getQuantidadeEstoque() <= quantidadeProduto) {
                ControladorProduto.getInstanciaControladorProduto().mostrarProduto(p);
                existeProduto = true;
                System.out.println("==================================================================");
            }
        }
        if (!existeProduto) {
            System.out.println("Não existe produtos com estoque abaixo da quantidade informada.");
        }
    }
}
