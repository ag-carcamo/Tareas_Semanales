package exp3_s8_agustin_carcamo;

import java.util.Scanner;
import java.util.ArrayList;

public class Exp3_S8_Agustin_Carcamo {
    static ArrayList<Integer> asientosSeleccion = new ArrayList<>();
    static ArrayList<String> clienteSeleccion = new ArrayList<>();
    static ArrayList<String> posicionSeleccion = new ArrayList<>();
    static ArrayList<Integer> valorSeleccion = new ArrayList<>();
    static ArrayList<Integer> clienteDescuento = new ArrayList<>();
    static ArrayList<Integer> montosFinales = new ArrayList<>();
    static ArrayList<String> funcionSeleccion = new ArrayList<>();
    static String[] funciones = {"La Casa de Bernarda Alba", "Hamlet", "Don Quijote"};
    static int idCompra = 0;

    public static void ventaEntradas(Scanner sc){
        int asiento = 0;
        int publico = 0;

        System.out.println("Seleccione la función del Teatro Moro a la que desea asistir:");
        for (int i = 0; i < funciones.length; i++) {
            System.out.println((i + 1) + "- " + funciones[i]);
        }

        int opcionFuncion = 0;
        while (opcionFuncion < 1 || opcionFuncion > funciones.length) {
            opcionFuncion = sc.nextInt();
            if (opcionFuncion < 1 || opcionFuncion > funciones.length) {
                System.out.println("Debe ingresar una opción válida (1-" + funciones.length + ").");
            }
        }
        String funcionElegida = funciones[opcionFuncion - 1];
        funcionSeleccion.add(funcionElegida);

        System.out.println("Ha seleccionado la función: " + funcionElegida);
        System.out.println("A continuación, seleccione su asiento.\n");

        System.out.println("=========== MAPA DE BUTACAS ===========");
        System.out.println("          [ PLATEA ALTA ]");
        System.out.println("  1  2  3    4  5  6  7    8  9 10");
        System.out.println(" 11 12 13   14 15 16 17   18 19 20");
        System.out.println(" 21 22 23   24 25 26 27   28 29 30");
        System.out.println();
        System.out.println("           [ GENERALES ]");
        System.out.println(" 31 32 33   34 35 36 37   38 39 40");
        System.out.println(" 41 42 43   44 45 46 47   48 49 50");
        System.out.println(" 51 52 53   54 55 56 57   58 59 60");
        System.out.println();
        System.out.println("              [ VIP ]");
        System.out.println("   61 62 63 64 65 66 67 68 69 70");
        System.out.println("======================================");
        System.out.println("Platea alta: $12.000 | Generales: $8.000 | Vip: $32.000");
        System.out.print("Ingrese el número de asiento (1 al 70): ");

        while (asiento < 1 || asiento > 70 || asientosSeleccion.contains(asiento)) {
            asiento = sc.nextInt();
            if (asiento < 1 || asiento > 70) {
                System.out.println("Debe ingresar un asiento existente (1 al 70).");
            }
            if (asientosSeleccion.contains(asiento)) {
                System.out.println("El asiento seleccionado está ocupado, intente con otro (1 al 70).");
            }
        }
        asientosSeleccion.add(asiento);

        if (asiento >= 1 && asiento <= 30) {
            valorSeleccion.add(12000);
            posicionSeleccion.add("Platea alta");
        } else if (asiento >= 31 && asiento <= 60) {
            valorSeleccion.add(8000);
            posicionSeleccion.add("Asiento general");
        } else {
            valorSeleccion.add(32000);
            posicionSeleccion.add("Zona VIP");
        }

        System.out.println("¿Es usted estudiante o de la tercera edad?");
        System.out.println("1-Estudiante");
        System.out.println("2-Tercera edad");
        System.out.println("3-Público general");

        while (publico < 1 || publico > 3) {
            publico = sc.nextInt();
            if (publico < 1 || publico > 3) {
                System.out.println("Debe ingresar una opción válida (1–3).");
            }
        }

        switch (publico) {
            case 1:
                clienteSeleccion.add("Estudiante");
                clienteDescuento.add(10);
                break;
            case 2:
                clienteSeleccion.add("Tercera Edad");
                clienteDescuento.add(15);
                break;
            case 3:
                clienteSeleccion.add("Público General");
                clienteDescuento.add(0);
                break;
        }

        int montoFinal = valorSeleccion.get(idCompra) - (valorSeleccion.get(idCompra) * clienteDescuento.get(idCompra) / 100);
        montosFinales.add(montoFinal);

        System.out.println("----Resumen de compra----");
        System.out.println("Función: " + funcionSeleccion.get(idCompra));
        System.out.println("Asiento N°: " + asientosSeleccion.get(idCompra));
        System.out.println("Cliente: " + clienteSeleccion.get(idCompra));
        System.out.println("Zona: " + posicionSeleccion.get(idCompra));
        System.out.println("Valor del asiento: $" + valorSeleccion.get(idCompra));
        System.out.println("Descuento aplicado: " + clienteDescuento.get(idCompra) + "%");
        System.out.println("Total a pagar: $" + montoFinal);
        idCompra++;
    }

    public static void modificacionCompra(Scanner sc){
        if (asientosSeleccion.isEmpty()){
            System.out.println("No hay compras registradas para modificar o eliminar.");
            return;
        }

        System.out.println("=========== COMPRAS REGISTRADAS ===========");
        for (int i = 0; i < asientosSeleccion.size(); i++){
            System.out.println("Compra N°" + (i + 1) +
                               " | Función: " + funcionSeleccion.get(i) +
                               " | Asiento: " + asientosSeleccion.get(i) +
                               " | Cliente: " + clienteSeleccion.get(i) +
                               " | Zona: " + posicionSeleccion.get(i) +
                               " | Total: $" + montosFinales.get(i));
        }
        System.out.println("===========================================");

        System.out.println("Ingrese el número de compra que desea modificar o eliminar:");
        int eleccion = sc.nextInt() - 1;

        if (eleccion < 0 || eleccion >= asientosSeleccion.size()){
            System.out.println("Número de compra no válido.");
            return;
        }

        System.out.println("Seleccione una opción:");
        System.out.println("1- Eliminar compra");
        System.out.println("2- Cambiar tipo de cliente");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Compra N°" + (eleccion + 1) + " eliminada correctamente.");
                asientosSeleccion.remove(eleccion);
                clienteSeleccion.remove(eleccion);
                posicionSeleccion.remove(eleccion);
                valorSeleccion.remove(eleccion);
                clienteDescuento.remove(eleccion);
                montosFinales.remove(eleccion);
                funcionSeleccion.remove(eleccion);
                break;

            case 2:
                System.out.println("Seleccione nuevo tipo de cliente:");
                System.out.println("1- Estudiante (10%)");
                System.out.println("2- Tercera edad (15%)");
                System.out.println("3- Público general (0%)");
                int nuevo = sc.nextInt();

                switch (nuevo) {
                    case 1:
                        clienteSeleccion.set(eleccion, "Estudiante");
                        clienteDescuento.set(eleccion, 10);
                        break;
                    case 2:
                        clienteSeleccion.set(eleccion, "Tercera Edad");
                        clienteDescuento.set(eleccion, 15);
                        break;
                    case 3:
                        clienteSeleccion.set(eleccion, "Público General");
                        clienteDescuento.set(eleccion, 0);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        return;
                }

                int nuevoTotal = valorSeleccion.get(eleccion) -
                        (valorSeleccion.get(eleccion) * clienteDescuento.get(eleccion) / 100);
                montosFinales.set(eleccion, nuevoTotal);

                System.out.println("Datos actualizados correctamente.");
                System.out.println("Nuevo cliente: " + clienteSeleccion.get(eleccion) +
                                   " | Total a pagar: $" + nuevoTotal);
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean menu = true;

        while (menu) {
            System.out.println("\nBienvenido al Teatro Moro, ingrese la opción numérica correspondiente:");
            System.out.println("1- Comprar entradas");
            System.out.println("2- Modificar compra");
            System.out.println("3- Salir del menú");

            int opcionMenu = sc.nextInt();
            switch (opcionMenu) {
                case 1:
                    ventaEntradas(sc);
                    break;
                case 2:
                    modificacionCompra(sc);
                    break;
                case 3:
                    System.out.println("Hasta luego, gracias por su visita.");
                    menu = false;
                    break;
                default:
                    System.out.println("Debe seleccionar una opción válida");
                    break;
            }
        }
    }
}
