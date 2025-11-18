package model;

public class CentroCultivo {
    private int toneladas;
    private String nombre;
    private String comuna;

    public CentroCultivo() {
    }

    public CentroCultivo(int toneladas, String nombre, String comuna) {
        this.toneladas = toneladas;
        this.nombre = nombre;
        this.comuna = comuna;
    }

    public int getToneladas() {
        return toneladas;
    }

    public String getComuna() {
        return comuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setToneladas(int toneladas) {
        this.toneladas = toneladas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    @Override
    public String toString() {
        return "CentroCultivo{" +
                "toneladas=" + toneladas +
                ", nombre='" + nombre + '\'' +
                ", comuna='" + comuna + '\'' +
                '}';
    }
}
