package cl.carcasoft.model;

import java.util.ArrayList;

public class OrdenDeCompra {

    private String numeroDeOrden;
    private Cliente cliente;
    private ArrayList<Producto> productos;

    public OrdenDeCompra(String numeroDeOrden, Cliente cliente) {
        this.numeroDeOrden = numeroDeOrden;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    public String getNumeroDeOrden() {
        return numeroDeOrden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    @Override
    public String toString() {
        return "OrdenDeCompra{" +
                "numeroDeOrden='" + numeroDeOrden + '\'' +
                ", cliente=" + cliente +
                ", productos=" + productos +
                ", total=" + calcularTotal() +
                '}';
    }
}
