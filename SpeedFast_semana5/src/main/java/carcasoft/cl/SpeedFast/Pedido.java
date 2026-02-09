package carcasoft.cl.SpeedFast;

import java.util.ArrayList;

//clase abstracta, solo para propositos de herencia
public abstract class Pedido implements Cancelable, Despachable, Rastreable {

    protected int idPedido;
    protected String descripcion;
    protected double precio;
    protected double distanciaKm;
    protected String direccion;
    protected String cliente;
    protected String contacto;
    protected String nombreRepartidor;

    protected static ArrayList<String> historial = new ArrayList<>();

    public Pedido(int idPedido, String descripcion, double precio, double distanciaKm, String direccion, String cliente, String contacto, String nombreRepartidor) {
        this.idPedido = idPedido;
        this.descripcion = descripcion;
        this.precio = precio;
        this.distanciaKm = distanciaKm;
        this.direccion = direccion;
        this.cliente = cliente;
        this.contacto = contacto;
        this.nombreRepartidor = nombreRepartidor;
    }

    public void asignarRepartidor() {
        if (this.nombreRepartidor == null || this.nombreRepartidor.isBlank()) {
            this.nombreRepartidor = "Repartidor Automático";
        }
        System.out.println("Repartidor asignado automáticamente: " + this.nombreRepartidor);
    }


    public void asignarRepartidor(String nombreRepartidor) {
        this.nombreRepartidor = nombreRepartidor;
    }

    public abstract int calcularTiempoEntrega();

    public void mostrarResumen() {
        System.out.println("[" + this.getClass().getSimpleName() + "]");
        System.out.println("Pedido N°" + idPedido);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Direccion: " + direccion);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Repartidor: " + nombreRepartidor);
        System.out.println("Tiempo estimado: " + calcularTiempoEntrega() + " minutos");
        System.out.println();
    }


    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", distanciaKm=" + distanciaKm +
                ", direccion='" + direccion + '\'' +
                ", cliente='" + cliente + '\'' +
                ", contacto='" + contacto + '\'' +
                ", nombreRepartidor='" + nombreRepartidor + '\'' +
                '}';
    }

    @Override
    public void despachar() {
        historial.add("Pedido N°" + idPedido + " entregado por " + nombreRepartidor);
        System.out.println("Pedido despachado correctanente.");
    }

    @Override
    public void cancelar() {
        historial.add("Pedido N°" + idPedido + " cancelado (cliente: " + cliente + ")");
        System.out.println("Pedido cancelado");
    }

    @Override
    public void verHistorial() {
        for (String h : historial) {
            System.out.println(h);
        }
    }
}
