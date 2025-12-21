package cl.carcasoft.model;

public class Persona {
    private String nombre;
    private Direccion direccion;
    private Rut rut;

    public Persona() {
    }

    public Persona(String nombre, Direccion direccion, Rut rut) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Rut getRut() {
        return rut;
    }

    public void setRut(Rut rut) {
        this.rut = rut;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                ", rut=" + rut +
                '}';
    }
}
