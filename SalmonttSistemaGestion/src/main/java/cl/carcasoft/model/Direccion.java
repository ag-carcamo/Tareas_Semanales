package cl.carcasoft.model;

public class Direccion {
    private String region;
    private String comuna;
    private String calle;
    private String numero;

    public Direccion() {
    }

    public Direccion(String region, String comuna, String calle, String numero) {
        this.region = region;
        this.comuna = comuna;
        this.calle = calle;
        this.numero = numero;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "region='" + region + '\'' +
                ", comuna='" + comuna + '\'' +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
