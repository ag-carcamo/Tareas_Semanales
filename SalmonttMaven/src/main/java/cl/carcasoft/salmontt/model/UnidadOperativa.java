package cl.carcasoft.salmontt.model;

public class UnidadOperativa {

    protected String nombre;
    protected String comuna;

    public UnidadOperativa() {
    }

    public UnidadOperativa(String nombre, String comuna) {
        this.nombre = nombre;
        this.comuna = comuna;
    }

    public String getNombre() {
        return nombre;
    }

    public String getComuna() {
        return comuna;
    }

    @Override
    public String toString() {
        return "UnidadOperativa{" +
                "nombre='" + nombre + '\'' +
                ", comuna='" + comuna + '\'' +
                '}';
    }

    public void mostrarInformacion() {
        System.out.println("Unidad Operativa");
        System.out.println("Nombre: " + nombre);
        System.out.println("Comuna: " + comuna);
    }

}

