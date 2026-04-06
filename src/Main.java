public class Main {
    public static void main(String[] args) {
        Login sistemaLogin = new Login();
        Funcionario sistemaFuncionario = new Funcionario(0,null,true,null,null,null,"adm","123","12345");
        Menu sistemaMenu = new Menu();
        Cliente sistemaCliente = new Cliente( 0);
        Produto sistemaProduto = new Produto(0,0,null,null,null,null, null);
        Fornecedor sistemaFornecedor = new Fornecedor(0,"","");
        Venda sistemaVenda = new Venda(0,0,0);
        Estoque sistemaEstoque = new Estoque();

//        sistemaCliente.inicializarClientes();
//        sistemaFuncionario.inicializarFuncionario();
//        sistemaFornecedor.inicializarFornecedor();
//        sistemaProduto.inicializarProduto();

        sistemaFuncionario.setSistemaLogin(sistemaLogin);
        sistemaLogin.setSistemaMenu(sistemaMenu);
        sistemaLogin.setSistemaFuncionario(sistemaFuncionario);
        sistemaMenu.setSistemaFuncionario(sistemaFuncionario);
        sistemaMenu.setSistemaCliente(sistemaCliente);
        sistemaMenu.setSistemaLogin(sistemaLogin);
        sistemaMenu.setSistemaProduto(sistemaProduto);
        sistemaMenu.setSistemaFornecedor(sistemaFornecedor);
        sistemaMenu.setSistemaVenda(sistemaVenda);
        sistemaMenu.setSistemaEstoque(sistemaEstoque);
        sistemaProduto.setSistemaFornecedor(sistemaFornecedor);
        sistemaProduto.setSistemaMenu(sistemaMenu);
        sistemaVenda.setSistemaFuncionario(sistemaFuncionario);
        sistemaVenda.setSistemaMenu(sistemaMenu);
        sistemaVenda.setSistemaCliente(sistemaCliente);
        sistemaVenda.setSistemaProduto(sistemaProduto);
        sistemaVenda.setSistemaLogin(sistemaLogin);
        sistemaVenda.setSistemaEstoque(sistemaEstoque);
        sistemaEstoque.setSistemaProduto(sistemaProduto);


        sistemaLogin.efetuarLogin(sistemaFuncionario.exportaListaFuncionario(),sistemaFuncionario);
    }
}