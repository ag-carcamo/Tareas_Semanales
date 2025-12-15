package cl.carcasoft.salmontt.model;

public class Proveedor implements Registrable {

    private String nombreEmpresa;
    private String servicio;

    public Proveedor(String nombreEmpresa, String servicio) {
        this.nombreEmpresa = nombreEmpresa;
        this.servicio = servicio;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getServicio() {
        return servicio;
    }

    @Override
    public String mostrarResumen() {
        return "Proveedor - Empresa: " + nombreEmpresa +
                ", Servicio: " + servicio;
    }
}

