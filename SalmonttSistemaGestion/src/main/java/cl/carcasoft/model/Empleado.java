package cl.carcasoft.model;

public class Empleado extends Persona implements Registrable{
    private String cargo;
    private double sueldo;
    private String area;

    public Empleado() {
    }

    public Empleado(String nombre, Direccion direccion, Rut rut, String cargo, double sueldo, String area) {
        super(nombre, direccion, rut);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public void registrar() {
        System.out.println("Registro empleado: " + getNombre());
    }

    @Override
    public void mostrarDatos() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "cargo='" + cargo + '\'' +
                ", sueldo=" + sueldo +
                ", area='" + area + '\'' +
                '}';
    }
}
