package model;

public class Direccion {

    private String Region;
    private String Ciudad;
    private String Calle;
    private int numero;


    public Direccion(String region, String ciudad, String calle, int numero) {
        Region = region;
        Ciudad = ciudad;
        Calle = calle;
        this.numero = numero;
    }

    public String getRegion() {
        return Region;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public String getCalle() {
        return Calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public void setCalle(String calle) {
        Calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "Region='" + Region + '\'' +
                ", Ciudad='" + Ciudad + '\'' +
                ", Calle='" + Calle + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
