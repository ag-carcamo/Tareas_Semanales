package cl.carcasoft.salmontt.model;

public class CentroCultivo extends UnidadOperativa implements Registrable {

    private int toneladas;

    public CentroCultivo(String nombre, String comuna) {
        super(nombre, comuna);
    }

    public CentroCultivo(int toneladas, String comuna, String nombre) {
        super(nombre, comuna);
        this.toneladas = toneladas;
    }

    public int getToneladas() {
        return toneladas;
    }

    public void setToneladas(int toneladas) {
        this.toneladas = toneladas;
    }

    @Override
    public String toString() {
        return "CentroCultivo{" +
                "toneladas=" + toneladas +
                ", comuna='" + comuna + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Centro de Cultivo");
        System.out.println("Nombre: " + nombre);
        System.out.println("Comuna: " + comuna);
        System.out.println("Toneladas: " + toneladas);
    }
    @Override
    public String mostrarResumen() {
        return "Centro de Cultivo - Nombre: " + nombre +
                ", Comuna: " + comuna +
                ", Toneladas: " + toneladas;
    }


}
