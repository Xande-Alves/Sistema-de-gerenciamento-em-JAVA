package entidades;

public class Cliente extends Pessoa {

    private final int idCliente;

    public Cliente(int id) {
        this.idCliente = id;
    }

    @Override
    public String getIdentificacao() {
        return "ID entidades.Cliente: " + getIdCliente();
    }

    public int getIdCliente() {
        return idCliente;
    }
}
