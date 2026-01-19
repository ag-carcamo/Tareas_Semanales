package cl.carcasoft.speedfast;

public class Main {
    public static void main(String[] args) {

        Pedido pedido1 = new PedidoComida("001", "Av. Italia 456", 4);
        Pedido pedido2 = new PedidoEncomienda("002", "Av. Independencia 123", 6);
        Pedido pedido3 = new PedidoExpress("003", "Av. Apoquindo 1500", 7);

        Pedido[] pedidos = {pedido1, pedido2, pedido3};

        for (Pedido p : pedidos) {
            p.mostrarResumen();
            System.out.println("Tiempo estimado de entrega: "
                    + p.calcularTiempoEntrega() + " minutos\n");
        }
    }
}
