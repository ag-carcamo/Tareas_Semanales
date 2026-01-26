package carcasoft.cl.SpeedFast;


public class Main {
    public static void main(String[] args) {

        //creacion manual de los atributos
        Pedido p1 = new PedidoComida(1,"hamburguesa italiana con papas fritas",9.990,11,"Palacio de kamisama 302","Sr. Dende","+56 983362202","Goku");
        Pedido p2 = new PedidoEncomienda(2,"Esfera del dragon de 4 estrellas",56.990,210,"Nave de freezer 503","Freezer","+56 99999999","Zarbon castro");
        Pedido p3 = new PedidoExpress(3,"creatina monohidratada",39.990,4,"Culebras verdes 302","Harnold Suarez","+56 923344556","mike thiz");
        Pedido p4 = new PedidoComida(4,"hamburguesa italiana con papas fritas",9.990,11,"Palacio de kamisama 302","Sr. Dende","+56 983362202",null);

        //Asignacion automatica en caso de que el nombre este vacio
        p1.asignarRepartidor();
        p1.mostrarResumen();
        p1.despachar();


        // Asignación manual
        p2.asignarRepartidor("Carlos Soto");
        p2.mostrarResumen();
        p2.despachar();

        // Cancelacion de pedido
        p3.asignarRepartidor(); // o asignación manual si quieres
        p3.mostrarResumen();
        p3.cancelar();

        //ejemplo de asignacion automatica de repartidor
        p4.asignarRepartidor();
        p4.mostrarResumen();
        p4.despachar();

        //ver el historial
        p1.verHistorial();



    }
}