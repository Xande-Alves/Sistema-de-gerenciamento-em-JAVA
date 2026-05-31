import controladores.ControladorLogin;
import repositorio.Repositorio;

public class Main {
    public static void main(String[] args) {
        ControladorLogin.getInstanciaControladorLogin().efetuarLogin(Repositorio.getInstanciaRepositorio().getListaFuncionarios());
    }
}