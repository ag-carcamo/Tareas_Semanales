package model;

public class Empleado extends Persona {
    private String cargo;
    private int sueldo;
    private boolean indefinido;

    public Empleado(String rut, String nombre, int edad, Direccion direccion, String cargo, boolean indefinido, int sueldo) {
        super(rut, nombre, edad, direccion);
        this.cargo = cargo;
        this.indefinido = indefinido;
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public int getSueldo() {
        return sueldo;
    }

    public boolean isIndefinido() {
        return indefinido;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public void setIndefinido(boolean indefinido) {
        this.indefinido = indefinido;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "cargo='" + cargo + '\'' +
                ", sueldo=" + sueldo +
                ", indefinido=" + indefinido +
                '}';
    }
}
