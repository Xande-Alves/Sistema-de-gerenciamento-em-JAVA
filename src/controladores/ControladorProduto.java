package controladores;

import entidades.Fornecedor;
import entidades.Produto;
import menus.MenuControleAcesso;
import menus.MenuEntidade;
import repositorio.Repositorio;

import java.util.Scanner;

public class ControladorProduto {
    private final Scanner scanner = new Scanner(System.in);

    private static ControladorProduto controladorProdutoInstancia;

    public static ControladorProduto getInstanciaControladorProduto() {
        if (controladorProdutoInstancia == null) {
            controladorProdutoInstancia = new ControladorProduto();
        }
        return controladorProdutoInstancia;
    }

    // METODO APENAS PARA TESTES EM VENDAS
//    public void inicializarProduto() {
//        entidades.Produto p1 = new entidades.Produto(1,1,"cola","gruda",5.0,10.0,10.0);
//        entidades.Produto p2 = new entidades.Produto(2,1,"prego","leva",5.0,20.0,20.0);
//        entidades.Produto p3 = new entidades.Produto(3,1,"martelo","bate",5.0,30.0, 30.0);
//        listaProdutos.add(p1);
//        listaProdutos.add(p2);
//        listaProdutos.add(p3);
//
//    }

    public void cadastrarProduto() {
        System.out.println("=======================CADASTRO DE PRODUTOS=======================");
        int idProduto = Repositorio.getInstanciaRepositorio().getListaProduto().size() + 1;
        boolean existeFornecedor = false;

        int idFornecedor;
        while (true) {
            try {
                System.out.print("Informe o ID do fornecedor: ");
                idFornecedor = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }
        for (Fornecedor fornec : Repositorio.getInstanciaRepositorio().getListaFornecedores()) {
            if (fornec.getIdFornecedor() == idFornecedor) {
                existeFornecedor = true;
                break;
            }
        }
        if (!existeFornecedor) {
            System.out.println("ID de fornecedor inexistente.");
            MenuEntidade.getInstanciaMenuEntidade().escolhaMenuProduto();
        }
        System.out.print("Informe o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Informe a descrição do produto: ");
        String descricao = scanner.nextLine();
        double precoCompra;
        while (true) {
            try {
                System.out.print("Informe o preço de compra do produto: ");
                String precoCompraStr = scanner.nextLine();
                precoCompra = Double.parseDouble(precoCompraStr.replace(",", "."));
                break;
            } catch (Exception e) {
                System.out.print("O preço de compra do produto deve ser informado em números. ");
            }
        }
        double quantidadeEstoque;
        while (true) {
            try {
                System.out.print("Informe a quantidade de estoque: ");
                String quantidadeEstoqueStr = scanner.nextLine();
                quantidadeEstoque = Double.parseDouble(quantidadeEstoqueStr.replace(",", "."));
                break;
            } catch (Exception e) {
                System.out.print("A quantidade de estoque deve ser informada em números. ");
            }
        }

        Double precoVenda = calculaPrecoVenda(precoCompra);

        Produto produto = new Produto(idProduto,idFornecedor,nome,descricao,precoCompra,precoVenda,quantidadeEstoque);

        int concluir;
        while (true) {
            try {
                System.out.print("Concluir o procedimento? (1 para SIM): ");
                concluir = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }
        if (concluir != 1) {
            MenuEntidade.getInstanciaMenuEntidade().escolhaMenuProduto();
        }

        Repositorio.getInstanciaRepositorio().getListaProduto().add(produto);
        System.out.println("Produto cadastrado com sucesso!");
        System.out.println("==================================================================");
    }

    public void atualizarProduto() {
        System.out.println("===================ATUALIZAR CADASTRO DE PRODUTO==================");
        int idProduto;
        while (true) {
            try {
                System.out.print("Informe o ID do produto: ");
                idProduto = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }

        boolean existeProduto = false;
        for (Produto p : Repositorio.getInstanciaRepositorio().getListaProduto()) {
            if (p.getIdProduto() == idProduto) {
                mostrarProduto(p);
                System.out.println("==================================================================");

                String idFornecedorStr;
                int idFornecedorInt;
                while (true) {
                    try {
                        System.out.print("Informe o novo ID do fornecedor (enter para não alterar): ");
                        idFornecedorStr = scanner.nextLine();
                        if (!idFornecedorStr.isEmpty()) {
                            idFornecedorInt = Integer.parseInt(idFornecedorStr);
                        } else {
                            idFornecedorInt = p.getIdFornecedor();
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Digite apenas números inteiros.");
                    }
                }
                boolean existeFornecedor = false;
                for (Fornecedor fornec : Repositorio.getInstanciaRepositorio().getListaFornecedores()) {
                    if (idFornecedorStr.isEmpty() || (fornec.getIdFornecedor() == idFornecedorInt)) {
                        existeFornecedor = true;
                        break;
                    }
                }
                if (!existeFornecedor) {
                    System.out.println("ID de fornecedor inexistente.");
                    MenuEntidade.getInstanciaMenuEntidade().escolhaMenuProduto();
                }
                if (!idFornecedorStr.isEmpty()) {
                    p.setIdFornecedor(idFornecedorInt);
                }
                System.out.print("Informe o novo nome do produto (enter para não alterar): ");
                String nome = scanner.nextLine();
                if (!nome.isEmpty()) {
                    p.setNome(nome);
                }
                System.out.print("Informe a nova descrição do produto (enter para não alterar): ");
                String descricao = scanner.nextLine();
                if (!descricao.isEmpty()) {
                    p.setDescricao(descricao);
                }
                String precoCompraStr;
                double precoCompra;
                while (true) {
                    try {
                        System.out.print("Informe o novo preço de compra do produto (enter para não alterar): ");
                        precoCompraStr = scanner.nextLine();
                        if (!precoCompraStr.isEmpty()) {
                            precoCompra = Double.parseDouble(precoCompraStr.replace(",", "."));
                        } else {
                            precoCompra = p.getPrecoCompra();
                        }
                        break;
                    } catch (Exception e) {
                        System.out.print("O preço de compra do produto deve ser informado em números. ");
                    }
                }
                if (!precoCompraStr.isEmpty()) {
                    p.setPrecoCompra(precoCompra);
                    Double precoVenda = calculaPrecoVenda(precoCompra);
                    p.setPrecoVenda(precoVenda);
                }

                existeProduto = true;
                System.out.println("Cadastro atualizado com sucesso!");
            }
        }
        if (!existeProduto) {
            System.out.println("ID de produto não existe.");
        }
        System.out.println("==================================================================");
    }

    public void listarProdutos() {
        System.out.println("=========================LISTA DE PRODUTOS========================");
        for(Produto p : Repositorio.getInstanciaRepositorio().getListaProduto()) {
            mostrarProduto(p);
            System.out.println("==================================================================");
        }
    }

    public void consultarProdutoIdFornecedor() {
        int idFornec;
        while (true) {
            try {
                System.out.print("Informe o ID do fornecedor: ");
                idFornec = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }
        boolean existeProduto = false;
        for (Produto p : Repositorio.getInstanciaRepositorio().getListaProduto()) {
            if (p.getIdFornecedor() == idFornec) {
                mostrarProduto(p);
                existeProduto = true;
                System.out.println("==================================================================");
            }
        }
        if (!existeProduto) {
            System.out.println("==================================================================");
            System.out.println("Não existe produto para os dados informados.");
            System.out.println("==================================================================");
        }
    }

    public void consultarProdutoNome() {
        System.out.print("Informe o nome do produto: ");
        String nomeProduto = scanner.nextLine();
        boolean existeProduto = false;
        for (Produto p : Repositorio.getInstanciaRepositorio().getListaProduto()) {
            if (p.getNome().toLowerCase().contains(nomeProduto.toLowerCase())) {
                mostrarProduto(p);
                existeProduto = true;
                System.out.println("==================================================================");
            }
        }
        if (!existeProduto) {
            System.out.println("==================================================================");
            System.out.println("Não existe produto para os dados informados.");
            System.out.println("==================================================================");
        }
    }

    public void consultarProdutoDescricao() {
        System.out.print("Informe parte da descrição do produto: ");
        String descricaoProduto = scanner.nextLine();
        boolean existeProduto = false;
        for (Produto p : Repositorio.getInstanciaRepositorio().getListaProduto()) {
            if (p.getDescricao().toLowerCase().contains(descricaoProduto.toLowerCase())) {
                mostrarProduto(p);
                existeProduto = true;
                System.out.println("==================================================================");
            }
        }
        if (!existeProduto) {
            System.out.println("==================================================================");
            System.out.println("Não existe produto para os dados informados.");
            System.out.println("==================================================================");
        }
    }

    public void mostrarProduto(Produto p) {
        System.out.println("ID Produto: " + p.getIdProduto());
        System.out.print("ID Fornecedor: " + p.getIdFornecedor()+" - ");
        for (Fornecedor fornec : Repositorio.getInstanciaRepositorio().getListaFornecedores()) {
            if (p.getIdFornecedor() == fornec.getIdFornecedor()) {
                System.out.println(fornec.getNome()+", da empresa "+fornec.getRepresentaEmpresaNome());
                break;
            }
        }
        System.out.println("Nome: " + p.getNome());
        System.out.println("Descrição: " + p.getDescricao());
        System.out.printf("Preço de compra: R$ %.2f%n", p.getPrecoCompra());
        System.out.printf("Preço de venda: R$ %.2f%n", p.getPrecoVenda());
        System.out.println("Quantidade em estoque: "+p.getQuantidadeEstoque());
    }

    public Double calculaPrecoVenda (Double precoCompra) {
        return precoCompra*120/100;
    }

}
