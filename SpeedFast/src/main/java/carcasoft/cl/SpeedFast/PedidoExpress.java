package carcasoft.cl.SpeedFast;

public class PedidoExpress extends Pedido{

    public PedidoExpress(int idPedido, String descripcion, double precio, double distanciaKm, String direccion, String cliente, String contacto, String nombreRepartidor) {
        super(idPedido, descripcion, precio, distanciaKm, direccion, cliente, contacto, nombreRepartidor);
    }

    //calculos en base a la semana anterior
    @Override
    public int calcularTiempoEntrega() {
        if (distanciaKm>5)
            return 15;
        else return 10;

    }
}
