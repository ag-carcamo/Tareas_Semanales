package cl.carcasoft.salmontt.model;

public class PlantaProceso extends UnidadOperativa implements Registrable {


    private int capacidadProceso;


    public PlantaProceso(String nombre, String comuna, int capacidadProceso) {
        super(nombre, comuna);
        this.capacidadProceso = capacidadProceso;
    }

    public int getCapacidadProceso() {
        return capacidadProceso;
    }

    @Override
    public String toString() {
        return "PlantaProceso{" +
                "capacidadProceso=" + capacidadProceso +
                ", comuna='" + comuna + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Planta de Procesamiento");
        System.out.println("Nombre: " + nombre);
        System.out.println("Comuna: " + comuna);
        System.out.println("Capacidad de procesamiento: " + capacidadProceso);
    }
    @Override
    public String mostrarResumen() {
        return "Planta de procesamiento - Nombre: " + nombre +
                ", Comuna: " + comuna +
                ", Capacidad: " + capacidadProceso;
    }


}
