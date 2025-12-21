package cl.carcasoft.model;

public class Cliente extends Persona implements Registrable{
    private int tipoCliente;

    public Cliente(String nombre, Direccion direccion, Rut rut) {
        super(nombre, direccion, rut);
    }

    public Cliente(String nombre, Direccion direccion, Rut rut, int tipoCliente) {
        super(nombre, direccion, rut);
        this.tipoCliente = tipoCliente;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public void registrar() {
        System.out.println("Registro cliente: " + getNombre());
    }

    @Override
    public void mostrarDatos() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "tipoCliente=" + tipoCliente +
                '}';
    }
}
