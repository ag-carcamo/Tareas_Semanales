package cl.carcasoft.model;

public class Proveedor extends Persona implements Registrable {

    private String rubro;

    public Proveedor(String nombre, Direccion direccion, Rut rut, String rubro) {
        super(nombre, direccion, rut);
        this.rubro = rubro;
    }

    @Override
    public void registrar() {
        System.out.println("Registro proveedor: " + getNombre());
    }

    @Override
    public void mostrarDatos() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "rubro='" + rubro + '\'' +
                "} " + super.toString();
    }
}
