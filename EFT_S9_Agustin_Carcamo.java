//Buenas profe, por ser la transversal comente quisa de mas, pero intento demostrar de que comprendo el codigo
//espero que no sea algo negativo

//REQUISITOS ENCONTRADOS PARA EL SISTEMA:
//1-funciones para cada opcion del menu: comprar boletos, eliminar compras, editar compras, mostrar lista de ventas, mostrar lista de asientos y imprimir boleta
//2-robustez y depuracion del sistema: con el uso de rangos para los parametros y Try catch, me asegure de que cada entrada de datos este fortificada para posibles entradas erroneas por parte del usuario
//3-diseño intuitivo y facil de usar: Esto lo justifico, en base a que el menu es claro, todo sigue un secuencia logica, ves los asientos, pones el numero que quieres, tus datos y al final un entendible y facil resumen de la compra
//igualmente los mensajes de error me parecen claros y se comunica que sale mal, y que datos SI se deben introducir


package eft_s9_agustin_carcamo;

import java.util.Scanner;

public class EFT_S9_Agustin_Carcamo {
    //Declaracion de variables globales, con limite de 111, ya que son 110 asientos en total.
    //decidi dejar la posicion 0 vacia, para simplicidad del codigo, aunque entiendo que es un desperdicio me parecio algo minimo
    //igualmente justifico el uso de arrays y no de arrayList, ya que se cuantos boletos maximos se pueden vender
    static boolean[] asientos = new boolean[111];
    static String[] nombres = new String[111];
    static int[] edad = new int[111];
    static int[] genero = new int[111];
    static int[] estadoEstudiantil = new int[111];
    static int[] descuentos = new int[111];
    static int[] precioBase= new int[111];
    static double[] precioFinal= new double[111];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcionMenu=0;
        //con el uso de un while me aseguro de que de se puedan hacer varias compras
        //ademas de dar respuestas a ingreso de datos erroneos
        while(opcionMenu!=7){
            System.out.println("Bienvenido al teatro moro, seleccione una opcion porfavor:");
            System.out.println("1- Comprar entrada");
            System.out.println("2- Mostrar Ventas realizadas");
            System.out.println("3- Modificar Ventas");
            System.out.println("4- Eliminar una venta");
            System.out.println("5- Mostrar asientos disponibles");
            System.out.println("6- Imprimir Boleta");
            System.out.println("7- salir del menu");
            //uso de try-catch para evitar errores y que se caiga el codigo, solo lo comentare esta vez 
            //ya que comentarlo en cada uso seria redundante
            try {
                opcionMenu= sc.nextInt();
            } catch (Exception e) {
                System.out.println("Error: Ingrese solo numeros del 1 al 7");
                sc.nextLine();
                continue;
            }
            if(opcionMenu==7){
                System.out.println("Gracias por su visita ¡¡hasta pronto!!");
            }
            if(opcionMenu <1 || opcionMenu>7){
                System.out.println("Debe ingresar una opcion del 1 al 7");
            }
        switch(opcionMenu){
            case 1:
                compraEntradas(sc);
                break;
            case 2:
                mostrarVentas(sc);
                break;
            case 3:
                ModificarVentas(sc);
                break;
            case 4:
                eliminarVentas(sc);
                break;
            case 5:
                mostrarAsientos(sc);
                break;
            case 6:
                imprimirBoleta(sc);
                break;
        }
        }
    }
    public static void compraEntradas(Scanner sc){
        //variables locales
        int asiento=0;
        boolean asientoValido=false;
        //no se si es un desproposito, pero quise hacer un intento de mapa para el teatro que fuese medianamente estetico.
        System.out.println("Aqui tiene un mapa del teatro:");
        System.out.println("=========== MAPA DE BUTACAS DEL TEATRO MORO ===========");
        System.out.println("--------------------------------------------------------");

        
        System.out.println("                   [ PLATEA ALTA ]");
        System.out.println("  01 02 03 04 05     06 07 08 09 10     11 12 13 14 15");
        System.out.println("  16 17 18 19 20     21 22 23 24 25     26 27 28 29 30");
        System.out.println();

        
        System.out.println("                   [ PLATEA BAJA ]");
        System.out.println("  31 32 33 34 35     36 37 38 39 40     41 42 43 44 45");
        System.out.println("  46 47 48 49 50     51 52 53 54 55     56 57 58 59 60");
        System.out.println();

        
        System.out.println("                      [ PALCO ]");
        System.out.println("          61 62 63 64 65     66 67 68 69 70");
        System.out.println("          71 72 73 74 75     76 77 78 79 80");
        System.out.println();

        
        System.out.println("                     [ GALERIA ]");
        System.out.println("81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100");
        System.out.println();

       
        System.out.println("                       [ VIP ]");
        System.out.println("          101 102 103 104 105 106 107 108 109 110");
        System.out.println("--------------------------------------------------------");
        System.out.println("Los valores de los asientos son los siguientes:");
        System.out.println("1- VIP $12.000");
        System.out.println("2- Palco $10.000");
        System.out.println("3- Platea Baja $8.000");
        System.out.println("4- Platea Alta $6.000");
        System.out.println("5- Galeria $4.000");
        System.out.println("Introduzca que asiento desea: ");
        //con el uso de la variable asientoValido, compruebo de que amenos de que el dato ingresado
        //corresponda a los parametros correctos, se vuelva apreguntar hasta que se de una respuesta correcta
        //parametros "equivocados" serian, numeros fuera de rango, osea asientos que no existen, numeros de asientos ya ocupados
        //o el ingreso de datos no numericos como char, double o String
        while(!asientoValido){
            try {
                asiento = sc.nextInt();
                if (asiento<1 || asiento>110) {
                    System.out.println("Numero invalido, Debe estar entre 1 y 110");
                }
                else if(asientos[asiento]){
                    System.out.println("Ese asiento ya está ocupado, Elija otro");
                }
                else{
                asientos[asiento] = true;
                asientoValido = true;
                }
            } catch (Exception e) {
                System.out.println("Error, debe ingresar numeros validos");
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.println("Ingrese su nombre: ");
        nombres[asiento] = sc.nextLine();
        
        boolean edadValida = false;
        while(!edadValida){
            System.out.println("Ingrese su edad: ");
            try {
                edad[asiento] = sc.nextInt();
            } catch (Exception e){
                System.out.println("Error, ingrese un numero valido para edad");
                sc.nextLine();
            }
            if (edad[asiento]>0 && edad[asiento]<120){
                edadValida = true;
            }
            else{
                System.out.println("Debe ingresar una edad real");
            }
        }

        boolean generoValido = false;
        while(!generoValido){
            System.out.println("Ingrese su Genero(1-Masculino/2-Femenino)");
            try {
                genero[asiento] = sc.nextInt();
            } catch (Exception e){
                System.out.println("Error, debe ingresar 1 o 2");
                sc.nextLine();
            }
            if(genero[asiento]==1 || genero[asiento]==2){
                generoValido = true;
            }
            else{
                System.out.println("Debe ingresar una opcion valida, 1 o 2");
            }
        }

        boolean estadoValido = false;
        while(!estadoValido){
            System.out.println("¿usted es estudiante?(1-Si/2-No)");
            try {
                estadoEstudiantil[asiento] = sc.nextInt();
            } catch (Exception e){
                System.out.println("Error, debe ingresar 1 o 2");
                sc.nextLine();
            }
            if(estadoEstudiantil[asiento]==1 || estadoEstudiantil[asiento]==2){
                estadoValido = true;
            }
            else{
                System.out.println("Debe ingresar una opcion valida, 1 o 2");
            }
        }
        
        //asignacion de descuento segun valores de las variables
        //lo puse en orden de prioridad, ya que a si me aseguro de que siempre se le otorgue el descuento mas grande al cliente
        if(edad[asiento]>=60){
            descuentos[asiento]=30;
        }
        else if(estadoEstudiantil[asiento]==1){
            descuentos[asiento]=25;
        }
        else if(genero[asiento]==2){
            descuentos[asiento]=7;
        }
        else if(edad[asiento]>=17){
            descuentos[asiento]=5;
        }
        else{
            descuentos[asiento]=0;
        }
        
        
        // Asignacion de precios segun rango de asientos
        if (asiento >= 101 && asiento <= 110) precioBase[asiento] = 12000;
        else if (asiento >= 61 && asiento <= 80) precioBase[asiento] = 10000;
        else if (asiento >= 31 && asiento <= 60) precioBase[asiento] = 8000;
        else if (asiento >= 1 && asiento <= 30) precioBase[asiento] = 6000;   
        else if (asiento >= 81 && asiento <= 100) precioBase[asiento] = 4000;
        
        //calculo del precio final
        precioFinal[asiento] = precioBase[asiento] - (precioBase[asiento] * descuentos[asiento] / 100.0);
        
        //resumen de la compra
        System.out.println("-------------------------------------------");
        System.out.println("Compra registrada con exito");
        System.out.println("Cliente: " + nombres[asiento]);
        System.out.println("Edad: " + edad[asiento]);
        System.out.println("Genero: " + (genero[asiento] == 1 ? "Masculino" : "Femenino"));
        System.out.println("Estudiante: " + (estadoEstudiantil[asiento] == 1 ? "Si" : "No"));
        System.out.println("Asiento N: " + asiento);
        System.out.println("El precio del asiento: $"+precioBase[asiento]);
        System.out.println("Descuento asociado: "+descuentos[asiento]+"%");
        System.out.println("Precio final: $"+precioFinal[asiento]);
        
        System.out.println("-------------------------------------------");

        
    }
    public static void mostrarVentas(Scanner sc){
        //variables locales
        int contadorVentas = 0;
        //repasa el arreglo para comprobar cuantos estan ocupados, osea en true, ya que inicialmente todos estan en false hasta que se hace una compra y cambia a true
        for(int i=1; i<=110; i++){
            if(asientos[i]){
                contadorVentas++;
            }
        }
        
        System.out.println("        --- RESUMEN DE VENTAS ---");
        System.out.println("Cantidad total de ventas realizadas: " + contadorVentas);
        //si el contador es 0, obviamente es por falta de ventas, por lo que se termina la funcion
        if(contadorVentas == 0){
            System.out.println("Aun no se han registrado ventas");
            System.out.println("-------------------------------------------");
            return;
        }
        //se vuelve a recorrer asientos, hasta que la posicion i sea true, entonces se imprimen los datos de la posicion i en cada array
        System.out.println("Detalle de ventas registradas:");
        for(int i=1; i<=110; i++){
            if(asientos[i]){
                System.out.println("-------------------------------------------");
                System.out.println("Asiento N: " + i);
                System.out.println("Cliente: " + nombres[i]);
                System.out.println("Edad: " + edad[i]);
                System.out.println("Genero: " + (genero[i] == 1 ? "Masculino" : "Femenino"));
                System.out.println("Estudiante: " + (estadoEstudiantil[i] == 1 ? "Si" : "No"));
                System.out.println("Descuento aplicado: " + descuentos[i] + "%");
                System.out.println("Precio final: $" + (int)precioFinal[i]);
            }
        }
        System.out.println("-------------------------------------------");
    }
    public static void ModificarVentas(Scanner sc){
        //variables locales
        int asiento = 0;
        boolean asientoValido = false;
        boolean edadValida = false;
        boolean generoValido = false;
        boolean estadoValido = false;
        boolean hayVentas = false;
        
    //se asegura de que alla ventas para modificar y no quedar en un bucle infinito
    for (boolean vendido : asientos) {
        if (vendido) {
            hayVentas = true;
            break;
        }
    }

    if (!hayVentas) {
        System.out.println("No existen ventas registradas");
        return;
    }
        System.out.println("----------- MODIFICAR VENTA -----------");
        //se valida igual que en la funcion de compra, casi un copy paste, pero adaptado
        while(!asientoValido){
            System.out.print("Ingrese el numero de asiento que desea modificar: ");
            try {
                asiento = sc.nextInt();
                if(asiento < 1 || asiento > 110){
                    System.out.println("Numero de asiento invalido, debe estar entre 1 y 110");
                } else if(!asientos[asiento]){
                    System.out.println("No hay ninguna venta registrada en ese asiento");
                } else {
                    asientoValido = true;
                }
            } catch (Exception e){
                System.out.println("Error, debe ingresar un numero valido");
                sc.nextLine();
            }
        }

        sc.nextLine();
        System.out.print("Nuevo nombre (actual: " + nombres[asiento] + "): ");
        nombres[asiento] = sc.nextLine();

        while(!edadValida){
            System.out.print("Nueva edad (actual: " + edad[asiento] + "): ");
            try {
                edad[asiento] = sc.nextInt();
                if(edad[asiento] > 0 && edad[asiento] < 120){
                    edadValida = true;
                } else {
                    System.out.println("Debe ingresar una edad real");
                    sc.nextLine();
                }
            } catch (Exception e){
                System.out.println("Error, ingrese un numero valido para edad");
                sc.nextLine();
            }
        }

        while(!generoValido){
            System.out.print("Nuevo genero (1=Masculino / 2=Femenino): ");
            try {
                genero[asiento] = sc.nextInt();
                if(genero[asiento] == 1 || genero[asiento] == 2){
                    generoValido = true;
                } else {
                    System.out.println("Debe ingresar una opcion valida, 1 o 2");
                }
            } catch (Exception e){
                System.out.println("Error, ingrese 1 o 2");
                sc.nextLine();
            }
        }

        
        while(!estadoValido){
            System.out.print("¿Es estudiante? (1=Si / 2=No): ");
            try {
                estadoEstudiantil[asiento] = sc.nextInt();
                if(estadoEstudiantil[asiento] == 1 || estadoEstudiantil[asiento] == 2){
                    estadoValido = true;
                } else {
                    System.out.println("Debe ingresar una opcion valida, 1 o 2");
                }
            } catch (Exception e){
                System.out.println("Error, ingrese 1 o 2");
                sc.nextLine();
            }
        }

        if(edad[asiento] >= 60){
            descuentos[asiento] = 30;
        } else if(estadoEstudiantil[asiento] == 1){
            descuentos[asiento] = 25;
        } else if(genero[asiento] == 2){
            descuentos[asiento] = 7;
        } else if(edad[asiento] >= 17){
            descuentos[asiento] = 5;
        } else {
            descuentos[asiento] = 0;
        }

        precioFinal[asiento] = precioBase[asiento] - (precioBase[asiento] * descuentos[asiento] / 100.0);

        System.out.println("-------------------------------------------");
        System.out.println("Datos modificados correctamente");
        System.out.println("Nuevo resumen:");
        System.out.println("Cliente: " + nombres[asiento]);
        System.out.println("Edad: " + edad[asiento]);
        System.out.println("Genero: " + (genero[asiento] == 1 ? "Masculino" : "Femenino"));
        System.out.println("Estudiante: " + (estadoEstudiantil[asiento] == 1 ? "Si" : "No"));
        System.out.println("Descuento actualizado: " + descuentos[asiento] + "%");
        System.out.println("Nuevo precio final: $" + (int)precioFinal[asiento]);
        System.out.println("-------------------------------------------");
    }
    public static void eliminarVentas(Scanner sc){
        int asiento =0;
        System.out.println("----------- ELIMINAR VENTA -----------");
        System.out.print("Ingrese el número de asiento que desea eliminar: ");
        try{
            asiento = sc.nextInt();
        }catch(Exception e){
            System.out.println("Debe ingresar una opcion numerica valida");
            sc.nextLine();
        }
        

        if(asiento < 1 || asiento > 110){
            System.out.println("Numero invalido. Debe estar entre 1 y 110");
            return;
        }

        if(!asientos[asiento]){
            System.out.println("Ese asiento no tiene una venta registrada");
            return;
        }

        System.out.println("¿Esta seguro que desea eliminar la venta del asiento " + asiento + "? (1=Si / 2=No)");
        int confirmacion = sc.nextInt();
        if(confirmacion != 1){
            System.out.println("Operacion cancelada.");
            return;
        }
        //al elegir eliminar la compra, se cambian los valores al por defecto y se deja el asiento en false, osea libre, para que en compra se pueda volver a llenar la informacion de las arrays correspondietes
        asientos[asiento] = false;
        nombres[asiento] = null;
        edad[asiento] = 0;
        genero[asiento] = 0;
        estadoEstudiantil[asiento] = 0;
        descuentos[asiento] = 0;
        precioBase[asiento] = 0;
        precioFinal[asiento] = 0;

        System.out.println("Venta eliminada correctamente, el asiento ahora esta disponible");
        System.out.println("-------------------------------------------");
    }
    public static void mostrarAsientos(Scanner sc){
        int disponibles = 0;
        int ocupados = 0;

        System.out.println("         ESTADO DE LOS ASIENTOS");
        System.out.println("-------------------------------------------");

        System.out.println("Asientos ocupados:");
        for(int i = 1; i <= 110; i++){
            if(asientos[i]){
                System.out.print(i + " ");
                ocupados++;
            }
        }

        System.out.println("\n-------------------------------------------");
        System.out.println("Asientos disponibles:");
        for(int i = 1; i <= 110; i++){
            if(!asientos[i]){
                System.out.print(i + " ");
                disponibles++;
            }
        }

        System.out.println("\n-------------------------------------------");
        System.out.println("Total ocupados: " + ocupados);
        System.out.println("Total disponibles: " + disponibles);
        System.out.println("-------------------------------------------");
    }
    public static void imprimirBoleta(Scanner sc){
        int asiento=0;
        System.out.println("           IMPRESION DE BOLETA");
        System.out.println("-------------------------------------------");
        System.out.print("Ingrese el numero de asiento: ");
        try {   
            asiento = sc.nextInt();
        } catch (Exception e) {
                System.out.println("Debe ingresar una opcion numerica valida");
                sc.nextLine();
            }
            

        if(asiento < 1 || asiento > 110){
            System.out.println("Numero de asiento invalido");
            return;
        }

        if(!asientos[asiento]){
            System.out.println("No existe ninguna venta registrada en ese asiento");
            return;
        }

        System.out.println("-------------------------------------------");
        System.out.println("        TEATRO MORO - BOLETA DE COMPRA");
        System.out.println("-------------------------------------------");
        System.out.println("Asiento N: " + asiento);
        System.out.println("Cliente: " + nombres[asiento]);
        System.out.println("Edad: " + edad[asiento]);
        System.out.println("Genero: " + (genero[asiento] == 1 ? "Masculino" : "Femenino"));
        System.out.println("Estudiante: " + (estadoEstudiantil[asiento] == 1 ? "Si" : "No"));
        System.out.println("Descuento aplicado: " + descuentos[asiento] + "%");
        System.out.println("Precio base: $" + precioBase[asiento]);
        System.out.println("Precio final a pagar: $" + (int)precioFinal[asiento]);
        System.out.println("-------------------------------------------");
    }
    
}