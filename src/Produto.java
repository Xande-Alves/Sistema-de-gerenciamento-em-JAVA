import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto {
    private final Scanner scanner = new Scanner(System.in);
    private Fornecedor sistemaFornecedor;
    private Menu sistemaMenu;

    private final List<Produto> listaProdutos = new ArrayList<>();
    private final int idProduto;
    private int idFornecedor;
    private String nome;
    private String descricao;
    private Double precoVenda;
    private Double precoCompra;
    private Double quantidade;
    private Double quantidadeEstoque;
    private static Produto produtoInstancia;

    private Produto(int idProduto, int idFornecedor, String nome, String descricao, Double precoCompra, Double precoVenda, Double quantidadeEstoque) {
        this.idProduto = idProduto;
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.descricao = descricao;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public static Produto getInstanciaProduto() {
        if (produtoInstancia == null) {
            produtoInstancia = new Produto(0,0,null,null,null,null, null);
        }
        return produtoInstancia;
    }

    // METODO APENAS PARA TESTES EM VENDAS
    public void inicializarProduto() {
        Produto p1 = new Produto(1,1,"cola","gruda",5.0,10.0,10.0);
        Produto p2 = new Produto(2,1,"prego","leva",5.0,20.0,20.0);
        Produto p3 = new Produto(3,1,"martelo","bate",5.0,30.0, 30.0);
        listaProdutos.add(p1);
        listaProdutos.add(p2);
        listaProdutos.add(p3);

    }

    public void cadastrarProduto() {
        System.out.println("=======================CADASTRO DE PRODUTOS=======================");
        int idProduto = listaProdutos.size() + 1;
        boolean existeFornecedor = false;

        System.out.print("Informe o ID do fornecedor: ");
        int idFornecedor = Integer.parseInt(scanner.nextLine());
        for (Fornecedor fornec : sistemaFornecedor.exportaListaFornecedor()) {
            if (fornec.getIdFornecedor() == idFornecedor) {
                existeFornecedor = true;
                break;
            }
        }
        if (!existeFornecedor) {
            System.out.println("ID de fornecedor inexistente.");
            sistemaMenu.escolhaMenuProduto();
        }
        System.out.print("Informe o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Informe a descrição do produto: ");
        String descricao = scanner.nextLine();
        System.out.print("Informe o preço de compra do produto: ");
        Double precoCompra = Double.parseDouble(scanner.nextLine());
        System.out.print("Informe a quantidade de estoque: ");
        Double quantidadeEstoque = Double.parseDouble(scanner.nextLine());

        Double precoVenda = calculaPrecoVenda(precoCompra);
        
        Produto produto = new Produto(idProduto,idFornecedor,nome,descricao,precoCompra,precoVenda,quantidadeEstoque);

        listaProdutos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
        System.out.println("==================================================================");
    }

    public void atualizarProduto() {
        System.out.println("===================ATUALIZAR CADASTRO DE PRODUTO==================");
        System.out.print("Informe o ID do produto: ");
        int idProduto = Integer.parseInt(scanner.nextLine());
        boolean existeProduto = false;

        for (Produto p : listaProdutos) {
            if (p.getIdProduto() == idProduto) {
                mostrarProduto(p);
                System.out.println("==================================================================");

                System.out.print("Informe o novo ID do fornecedor (enter para não alterar): ");
                String idFornecedor = scanner.nextLine();
                boolean existeFornecedor = false;
                for (Fornecedor fornec : sistemaFornecedor.exportaListaFornecedor()) {
                    if (idFornecedor.isEmpty()) {
                        existeFornecedor = true;
                        break;
                    } else {
                        if (fornec.getIdFornecedor() == Integer.parseInt(idFornecedor)) {
                            existeFornecedor = true;
                            break;
                        }
                    }
                }
                if (!existeFornecedor) {
                    System.out.println("ID de fornecedor inexistente.");
                    sistemaMenu.escolhaMenuProduto();
                }
                if (!idFornecedor.isEmpty()) {
                    int idFornecedorInt = Integer.parseInt(idFornecedor);
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
                System.out.print("Informe o novo preço de compra do produto (enter para não alterar): ");
                String precoCompra = scanner.nextLine();
                if (!precoCompra.isEmpty()) {
                    Double precoCompraDouble = Double.parseDouble(precoCompra);
                    p.setPrecoCompra(precoCompraDouble);
                    Double precoVenda = calculaPrecoVenda(precoCompraDouble);
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
        for(Produto p : listaProdutos) {
            mostrarProduto(p);
            System.out.println("==================================================================");
        }
    }

    public void consultarProdutoIdFornecedor() {
        System.out.print("Informe o ID do fornecedor: ");
        int idFornec = Integer.parseInt(scanner.nextLine());
        for (Produto p : listaProdutos) {
            if (p.getIdFornecedor() == idFornec) {
                mostrarProduto(p);
                System.out.println("==================================================================");
            }
        }
    }

    public void consultarProdutoNome() {
        System.out.print("Informe o nome do produto: ");
        String nomeProduto = scanner.nextLine();
        for (Produto p : listaProdutos) {
            if (p.getNome().toLowerCase().contains(nomeProduto.toLowerCase())) {
                mostrarProduto(p);
                System.out.println("==================================================================");
            }
        }
    }

    public void consultarProdutoDescricao() {
        System.out.print("Informe parte da descrição do produto: ");
        String descricaoProduto = scanner.nextLine();
        for (Produto p : listaProdutos) {
            if (p.getDescricao().toLowerCase().contains(descricaoProduto.toLowerCase())) {
                mostrarProduto(p);
                System.out.println("==================================================================");
            }
        }
    }

    public void mostrarProduto(Produto p) {
        System.out.println("ID Produto: " + p.getIdProduto());
        System.out.println("ID Fornecedor: " + p.getIdFornecedor());
        System.out.println("Nome: " + p.getNome());
        System.out.println("Descrição: " + p.getDescricao());
        System.out.println("Preço de compra: "+p.getPrecoCompra());
        System.out.println("Preço de venda: "+p.getPrecoVenda());
        System.out.println("Quantidade em estoque: "+p.getQuantidadeEstoque());
    }

    public Double calculaPrecoVenda (Double precoCompra) {
        return precoCompra*120/100;
    }

    public List<Produto> exportaListaProduto() {
        return listaProdutos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrecoCompra(Double preco) {
        this.precoCompra = preco;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double preco) {
        this.precoVenda = preco;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setSistemaFornecedor(Fornecedor sistemaFornecedor) {
        this.sistemaFornecedor = sistemaFornecedor;
    }

    public void setSistemaMenu(Menu sistemaMenu) {
        this.sistemaMenu = sistemaMenu;
    }
}
