package carcasoft.cl.SpeedFast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        ZonaDeCarga zona = new ZonaDeCarga();
        System.out.println("[Zona de carga inicializada]");

        zona.agregarPedido(
                new PedidoComida(
                        2,
                        "Almuerzo",
                        10000,
                        4.0,
                        "Providencia",
                        "María López",
                        "912345678",
                        "Sin asignar"
                )
        );

        zona.agregarPedido(
                new PedidoComida(
                        3,
                        "Cena",
                        15000,
                        6.0,
                        "Ñuñoa",
                        "Carlos Soto",
                        "923456789",
                        "Sin asignar"
                )
        );

        zona.agregarPedido(
                new PedidoComida(
                        4,
                        "Desayuno",
                        8000,
                        3.0,
                        "Recoleta",
                        "Ana Torres",
                        "934567890",
                        "Sin asignar"
                )
        );



        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new Repartidor("Juan", zona));
        executor.execute(new Repartidor("Camila", zona));
        executor.execute(new Repartidor("Pedro", zona));

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("[Zona de carga vacía]");
        System.out.println("Todos los pedidos han sido entregados correctamente.");
    }
}
