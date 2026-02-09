package carcasoft.cl.SpeedFast;

import java.util.LinkedList;
import java.util.Queue;

public class ZonaDeCarga {

    private final Queue<Pedido> pedidos = new LinkedList<>();

    public synchronized void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido agregado a la zona de carga: " + pedido);
    }

    public synchronized Pedido retirarPedido() {
        return pedidos.poll();
    }
}
