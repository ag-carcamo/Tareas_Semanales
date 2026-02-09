package carcasoft.cl.SpeedFast;

public class Repartidor implements Runnable {

    private final String nombre;
    private final ZonaDeCarga zona;

    public Repartidor(String nombre, ZonaDeCarga zona) {
        this.nombre = nombre;
        this.zona = zona;
    }

    @Override
    public void run() {
        while (true) {
            Pedido pedido = zona.retirarPedido();

            if (pedido == null) {
                System.out.println("[Repartidor " + nombre + "] Sin pedidos disponibles.");
                break;
            }

            System.out.println("[Repartidor " + nombre + "] Retirando " + pedido);
            System.out.println("[Repartidor " + nombre + "] Entrgando " + pedido);

            try {
                Thread.sleep(pedido.calcularTiempoEntrega());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            System.out.println("[Repartidor " + nombre + "] Pedido entregado: " + pedido);
        }
    }
}
