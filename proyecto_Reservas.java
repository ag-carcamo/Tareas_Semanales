package exp2_s6_agustin_carcamo;
//los requisitos principales para el sistema son en un principio, menú principal con opciones, las cuales son:
//Reservar asiento.
//Edición de reserva para cambiar de reserva a una compra
//Compra directa
//Generacion de Boletas

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Duration;

public class proyecto_Reservas {
    static int[] listaColumna = new int[50];
    static char[] listaFila = new char[50];
    static LocalDateTime[] tiemposReserva = new LocalDateTime[50];
    static boolean[] pagada = new boolean[50];
    static int contador = 0;
    static int valorEntrada = 15000;

    public static void comprarEntrada(Scanner sc) {
        char fila;
        int columna;
        int entradaMultiple = 0;
        int cantidadCompra = 1;

        System.out.println("La entrada cuesta 15.000, aqui tiene un mapa de los asientos.");
        System.out.println("""
        [A1][A2][A3]  [A4][A5][A6][A7]  [A8][A9][A10]
        [B1][B2][B3]  [B4][B5][B6][B7]  [B8][B9][B10]
        [C1][C2][C3]  [C4][C5][C6][C7]  [C8][C9][C10]
        [D1][D2][D3]  [D4][D5][D6][D7]  [D8][D9][D10]
        [E1][E2][E3]  [E4][E5][E6][E7]  [E8][E9][E10]
        """);

        while (entradaMultiple != 2) {
            System.out.println("Por favor, digite la fila que desea, de la A a la E.");
            do {
                fila = sc.next().toUpperCase().charAt(0);
                if (fila < 'A' || fila > 'E') {
                    System.out.println("Debe ingresar una opcion valida. La fila debe estar entre A y E.");
                }
            } while (fila < 'A' || fila > 'E');

            System.out.println("Por favor, digite la columna que desea, de 1 a 10.");
            do {
                columna = sc.nextInt();
                if (columna < 1 || columna > 10) {
                    System.out.println("Debe ingresar una opcion valida. La columna debe estar entre 1 y 10.");
                }
            } while (columna < 1 || columna > 10);

            boolean ocupado = false;
            LocalDateTime ahora = LocalDateTime.now();
            for (int i = 0; i < contador; i++) {
                boolean mismaSilla = listaFila[i] == fila && listaColumna[i] == columna;
                boolean reservaActiva = (tiemposReserva[i] != null) && (Duration.between(tiemposReserva[i], ahora).toMinutes() < 1);
                if (mismaSilla && (pagada[i] || reservaActiva)) {
                    ocupado = true;
                    break;
                }
            }

            if (ocupado) {
                System.out.println("Ese asiento no esta disponible en este momento.");
            } else {
                if (contador >= listaFila.length) {
                    System.out.println("Capacidad de registro completa.");
                    break;
                }
                listaFila[contador] = fila;
                listaColumna[contador] = columna;
                pagada[contador] = true;
                tiemposReserva[contador] = LocalDateTime.now();
                System.out.println("El asiento seleccionado es: " + listaFila[contador] + listaColumna[contador] + ".");
                System.out.println("Su numero de compra es: " + contador + ".");
                contador = contador + 1;
                System.out.println("¿Desea comprar otro asiento? 1-SI / 2-NO.");
                entradaMultiple = sc.nextInt();
                switch (entradaMultiple) {
                    case 1:
                        cantidadCompra = cantidadCompra + 1;
                        break;
                    case 2:
                        System.out.println("El total de su compra es " + valorEntrada * cantidadCompra + ".");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
            }
        }
    }

    public static void reservaAsiento(Scanner sc) {
        char fila;
        int columna;

        System.out.println("Ingrese fila (A-E).");
        do {
            fila = sc.next().toUpperCase().charAt(0);
        } while (fila < 'A' || fila > 'E');

        System.out.println("Ingrese columna (1-10).");
        do {
            columna = sc.nextInt();
        } while (columna < 1 || columna > 10);

        boolean ocupado = false;
        LocalDateTime ahora = LocalDateTime.now();
        for (int i = 0; i < contador; i++) {
            boolean mismaSilla = listaFila[i] == fila && listaColumna[i] == columna;
            boolean reservaActiva = (tiemposReserva[i] != null) && (Duration.between(tiemposReserva[i], ahora).toMinutes() < 1);
            if (mismaSilla && (pagada[i] || reservaActiva)) {
                ocupado = true;
                break;
            }
        }

        if (ocupado) {
            System.out.println("Ese asiento ya esta reservado o comprado.");
            return;
        }

        if (contador >= listaFila.length) {
            System.out.println("Capacidad de registro completa.");
            return;
        }

        listaFila[contador] = fila;
        listaColumna[contador] = columna;
        tiemposReserva[contador] = LocalDateTime.now();
        pagada[contador] = false;
        System.out.println("Reserva creada en " + fila + columna + ".");
        System.out.println("Numero de reserva: " + contador + ".");
        contador++;
    }

    public static void editarReserva(Scanner sc) {
        System.out.println("Ingrese numero de reserva para pagar.");
        int num = sc.nextInt();

        if (num >= 0 && num < contador) {
            if (pagada[num]) {
                System.out.println("Esa reserva ya esta pagada.");
                return;
            }
            if (tiemposReserva[num] == null) {
                System.out.println("Reserva invalida.");
                return;
            }
            Duration diff = Duration.between(tiemposReserva[num], LocalDateTime.now());
            if (diff.toMinutes() < 1) {
                pagada[num] = true;
                System.out.println("Reserva pagada con exito.");
                System.out.println("Asiento: " + listaFila[num] + listaColumna[num] + ".");
                System.out.println("Valor: " + valorEntrada + ".");
            } else {
                System.out.println("La reserva ha expirado.");
            }
        } else {
            System.out.println("Numero de reserva invalido.");
        }
    }

    public static void imprimirBoleta(Scanner sc) {
        System.out.println("Por favor, introduzca su numero de compra.");
        int numeroCompra = sc.nextInt();

        if (numeroCompra >= 0 && numeroCompra < contador) {
            if (pagada[numeroCompra]) {
                System.out.println("---- BOLETA ----");
                System.out.println("Asiento: " + listaFila[numeroCompra] + listaColumna[numeroCompra] + ".");
                System.out.println("Valor: " + valorEntrada + ".");
                System.out.println("----------------");
            } else {
                System.out.println("Esa reserva no ha sido pagada.");
            }
        } else {
            System.out.println("Numero de compra invalido.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu = 0;

        while (menu != 5) {
            System.out.println("Bienvenido al teatro Moro, por favor seleccione una opcion para continuar.");
            System.out.println("1- Reservar un asiento.");
            System.out.println("2- Pagar una reserva.");
            System.out.println("3- Comprar entradas.");
            System.out.println("4- Imprimir boletas.");
            System.out.println("5- Salir del menu.");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    reservaAsiento(sc);
                    break;
                case 2:
                    editarReserva(sc);
                    break;
                case 3:
                    comprarEntrada(sc);
                    break;
                case 4:
                    imprimirBoleta(sc);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Debe seleccionar una opcion valida.");
            }
        }
    }
}
