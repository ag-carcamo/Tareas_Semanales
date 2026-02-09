package carcasoft.cl.SpeedFast;

public class PedidoEncomienda extends Pedido{

    public PedidoEncomienda(int idPedido, String descripcion, double precio, double distanciaKm, String direccion, String cliente, String contacto, String nombreRepartidor) {
        super(idPedido, descripcion, precio, distanciaKm, direccion, cliente, contacto, nombreRepartidor);
    }

    //calculos en base a la semana anterior
    @Override
    public int calcularTiempoEntrega() {
        return 20 + (int) Math.round((distanciaKm * 1.5));

    }
}