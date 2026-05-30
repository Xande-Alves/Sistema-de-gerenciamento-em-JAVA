import controladores.ControladorLogin;
import repositorio.Repositorio;

public class Main {
    public static void main(String[] args) {
//        ControladorLogin controladorLogin = ControladorLogin.getInstanciaControladorLogin();
//        Repositorio repositorio = Repositorio.getInstanciaRepositorio();

//        cliente.inicializarClientes();
//        funcionario.inicializarFuncionario();
//        fornecedor.inicializarFornecedor();
//        produto.inicializarProduto();

        ControladorLogin.getInstanciaControladorLogin().efetuarLogin(Repositorio.getInstanciaRepositorio().getListaFuncionarios());

        //controladorLogin.efetuarLogin(repositorio.getListaFuncionarios());
    }
}