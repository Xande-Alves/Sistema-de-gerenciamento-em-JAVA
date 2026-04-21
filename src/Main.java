public class Main {
    public static void main(String[] args) {
        Cliente cliente = Cliente.getInstanciaCliente();
        Fornecedor fornecedor = Fornecedor.getInstanciaFornecedor();
        Funcionario funcionario = Funcionario.getInstanciaFuncionario();
        Estoque estoque = Estoque.getInstanciaEstoque();
        Login login = Login.getInstanciaLogin();
        Menu menu = Menu.getInstanciaMenu();
        Produto produto = Produto.getInstanciaProduto();
        Venda venda = Venda.getInstanciaVenda();

//        cliente.inicializarClientes();
//        funcionario.inicializarFuncionario();
//        fornecedor.inicializarFornecedor();
//        produto.inicializarProduto();

        funcionario.setSistemaLogin(login);
        login.setSistemaMenu(menu);
        login.setSistemaFuncionario(funcionario);
        menu.setSistemaFuncionario(funcionario);
        menu.setSistemaCliente(cliente);
        menu.setSistemaLogin(login);
        menu.setSistemaProduto(produto);
        menu.setSistemaFornecedor(fornecedor);
        menu.setSistemaVenda(venda);
        menu.setSistemaEstoque(estoque);
        produto.setSistemaFornecedor(fornecedor);
        produto.setSistemaMenu(menu);
        venda.setSistemaFuncionario(funcionario);
        venda.setSistemaMenu(menu);
        venda.setSistemaCliente(cliente);
        venda.setSistemaProduto(produto);
        venda.setSistemaLogin(login);
        venda.setSistemaEstoque(estoque);
        estoque.setSistemaProduto(produto);



        login.efetuarLogin(funcionario.exportaListaFuncionario(),funcionario);
        //System.out.println("===============================AQUI===============================");
    }
}