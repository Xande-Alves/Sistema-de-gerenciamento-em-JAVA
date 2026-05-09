import java.util.Scanner;

public class Estoque  {
    private final Scanner scanner = new Scanner(System.in);
    private Produto sistemaProduto;
    static Estoque estoqueInstancia;

    private Estoque() {

    }

    public static Estoque getInstanciaEstoque() {
        if (estoqueInstancia == null) {
            estoqueInstancia = new Estoque();
        }
        return estoqueInstancia;
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
        System.out.print("Informe o ID do produto: ");
        int idProduto = Integer.parseInt(scanner.nextLine());
        for (Produto p : sistemaProduto.exportaListaProduto()) {
            if (p.getIdProduto() == idProduto) {
                sistemaProduto.mostrarProduto(p);
                System.out.print("Aumentar a quantidade do estoque do produto em quanto? ");
                String aumentaEstoqueStr = scanner.nextLine();
                double aumentaEstoque = Double.parseDouble(aumentaEstoqueStr.replace(",", "."));
                p.setQuantidadeEstoque(p.getQuantidadeEstoque()+aumentaEstoque);
                System.out.println("Estoque do produto aumentado em "+aumentaEstoque+".");
            }
        }
    }

    public void diminuiProduto() {
        System.out.println("=========================DIMINUIR ESTOQUE=========================");
        System.out.print("Informe o ID do produto: ");
        int idProduto = Integer.parseInt(scanner.nextLine());
        for (Produto p : sistemaProduto.exportaListaProduto()) {
            if (p.getIdProduto() == idProduto) {
                sistemaProduto.mostrarProduto(p);
                System.out.print("Diminuir a quantidade do estoque do produto em quanto? ");
                String diminuiEstoqueStr = scanner.nextLine();
                double diminuiEstoque = Double.parseDouble(diminuiEstoqueStr.replace(",", "."));
                p.setQuantidadeEstoque(p.getQuantidadeEstoque()-diminuiEstoque);
                System.out.println("Estoque do produto diminuído em "+diminuiEstoque+".");
            }
        }
    }

    public void avisosEstoque() {
        System.out.println("=========================AVISOS DE ESTOQUE========================");
        System.out.print("Qual a quantidade de produto a ser pesquisada? ");
        String quantidadeProdutoStr = scanner.nextLine();
        double quantidadeProduto = Double.parseDouble(quantidadeProdutoStr.replace(",", "."));
        for (Produto p : sistemaProduto.exportaListaProduto()) {
            if (p.getQuantidadeEstoque() <= quantidadeProduto) {
                sistemaProduto.mostrarProduto(p);
                System.out.println("==================================================================");
            }
        }
    }

    public void setSistemaProduto(Produto sistemaProduto) {
        this.sistemaProduto = sistemaProduto;
    }
}
