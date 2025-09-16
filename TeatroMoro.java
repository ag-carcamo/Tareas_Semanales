import java.util.Scanner;
import java.util.ArrayList;

public class TeatroMoro {
    
    //Contador global de entradas
    static int idEntradas = 1;
    //creacion de lista para informacion de entradas
    static ArrayList<Entradas> listaEntradas = new ArrayList<>();
    static String nombreTeatro = "Teatro Moro";
    static int capacidadMaxima = 100;
    static int entradasVendidas = 0;

    //-----------Metodo de compra de entradas------------------------------------------------------------------------------------------
    public static void comprarEntrada(Entradas A, Scanner sc) {
        int cantidad = 0;
        do {
            System.out.println("¿Cuántas entradas desea comprar? (minimo 1 / maximo de 30)");
            cantidad = sc.nextInt();
            if (cantidad < 1 || cantidad > 30) {
                System.out.println("Debe ingresar una cantidad valida de entradas.");
            } else if (entradasVendidas + cantidad > capacidadMaxima) {
                System.out.println("No hay suficientes asientos disponibles. Capacidad restante: " + (capacidadMaxima - entradasVendidas));
                cantidad = 0;
            }
        } while (cantidad < 1 || cantidad > 30);

        A.cantidad = cantidad;
        entradasVendidas += cantidad;

        do {
            System.out.println("Por favor, introduzca que tipo de asiento desea con las opciones numericas:\n1-Vip\n2-Platea\n3-General");
            A.tipoEntrada = sc.nextInt();
        } while (A.tipoEntrada < 1 || A.tipoEntrada > 3);

        do {
            System.out.println("Por favor, introduzca que tipo de publico es con las opciones numericas:\n1-Estudiante\n2-Adulto mayor\n3-Publico general");
            A.tipoUsuario = sc.nextInt();
        } while (A.tipoUsuario < 1 || A.tipoUsuario > 3);

        if (A.tipoUsuario == 1) {
            System.out.println("¿Usted pertenece a Duoc Uc? 1-SI/2-NO  ");
            A.tipoInstitucion = sc.nextInt();
        }

        A.idEntradas = idEntradas++;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean salidaMenu = true;
        
        System.out.println("Bienvenido al " + nombreTeatro + " (Capacidad máxima: " + capacidadMaxima + " asientos)");

        //Inicio de menu
        while (salidaMenu){
            //opciones de menu
            System.out.println("--Seleccione que desea hacer a continuacion");
            System.out.println("1- Comprar entrada");
            System.out.println("2- Ver promociones");
            System.out.println("3- Buscar entrada");
            System.out.println("4- Eliminar entrada");
            System.out.println("5- Salir del menu");
            
            //Respuesta al menu
            int controlMenu = sc.nextInt();
            
            //Resultados de la respuesta al menu
            switch(controlMenu) {
                case 1:
                        Entradas A = new Entradas();
                        //Metodo de compra de entradas
                        comprarEntrada(A, sc);
                        
                        //metodo para dar la informacion de la compra
                        A.darInformacion();
                        
                        //agregar informacion a la lista
                        listaEntradas.add(A);
                        
                        break;
                        
                case 2:
                    System.out.println("Estas son las promociones que tenemos actualmente: ");
                    System.out.println("10% de descuento para estudiantes");
                    System.out.println("15% de descuento para la tercera edad");
                    System.out.println("15% de descuento en la compra de 3 boletos o mas para publico general");
                    System.out.println("99% de descuento por convenio Duoc Uc");
                    break; 
                    
                case 3:
                    System.out.println("Ingrese el número de compra que desea buscar:");
                    int idBusqueda = sc.nextInt();
                    boolean encontrada = false;
                    for (Entradas e : listaEntradas) {
                        if (e.idEntradas == idBusqueda) {
                            System.out.println("Entrada encontrada:");
                            e.darInformacion();
                            encontrada = true;
                            break;
                        }
                    }
                        if (!encontrada) {
                            System.out.println("No se encontró ninguna entrada con ese número.");
                        }
                        break;
                case 4:
                    System.out.println("Ingrese el número de compra que desea eliminar:");
                    int idEliminar = sc.nextInt();
                    boolean eliminada = false;

                    for (int i = 0; i < listaEntradas.size(); i++) {
                        if (listaEntradas.get(i).idEntradas == idEliminar) {
                            entradasVendidas -= listaEntradas.get(i).cantidad;
                            listaEntradas.remove(i);
                            System.out.println("La entrada con número " + idEliminar + " ha sido eliminada.");
                            eliminada = true;
                            break;
                        }
                    }

                    if (!eliminada) {
                        System.out.println("No se encontró ninguna entrada con ese número.");
                    }
                    break;

                    
                case 5:
                    System.out.println("Resumen de todas las entradas compradas:");
                    if (listaEntradas.size() == 0) {
                        System.out.println("No hay entradas registradas.");
                    } 
                    else {
                        for (Entradas e : listaEntradas) {
                            e.darInformacion();
                            System.out.println("-------------------------------------");
                        }
                    }
                    salidaMenu = false;
                    break;
            }
        }
    }
}

class Entradas {
    int idEntradas;
    int tipoEntrada;
    int tipoUsuario;
    int tipoInstitucion;
    int cantidad;
    double precioEntrada = 0;
    double precioFinal = 0;
    
    public void darInformacion() {
        switch (tipoEntrada){
            case 1:
                System.out.println("Tipo de asiento es:Vip ");
                precioEntrada = 20000;
                break;
            case 2:
                System.out.println("Tipo de asiento es:Platea ");
                precioEntrada = 18000;
                break;
            case 3:
                System.out.println("Tipo de asiento es:General ");
                precioEntrada = 15000;
                break;
        }
        switch (tipoUsuario){
            case 1:
                System.out.println("Su tipo de usuario es: Estudiante ");
                if (tipoInstitucion == 1) {
                    System.out.println("Es apto para el convenio de descuento Duoc Uc");
                    precioEntrada = precioEntrada *0.01;
                } else {
                    precioEntrada = precioEntrada *0.90;
                }
                break;
            case 2:
                System.out.println("Tipo de usuario es: Adulto mayor ");
                precioEntrada = precioEntrada *0.85;
                break;
            case 3:
                System.out.println("Tipo de usuario es: Publico general ");
                if (cantidad >= 3) {
                    System.out.println("Se aplico un 15% de descuento por comprar 3 o más entradas.");
                    precioEntrada = precioEntrada *0.85;
                }
                break;
        }

        precioFinal = precioEntrada * cantidad;

        System.out.println("Cantidad de entradas: " + cantidad);
        System.out.println("Valor unitario: " + precioEntrada);
        System.out.println("Total a pagar: " + precioFinal);
        System.out.println("Su numero compra es la: " + idEntradas);
    }
}
