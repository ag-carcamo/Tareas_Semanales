package cl.carcasoft.app;

import cl.carcasoft.data.GestorDatos;
import cl.carcasoft.model.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String ruta = "src/main/resources/datos.txt";

        List<Registrable> registros = GestorDatos.cargarRegistros(ruta);
        List<Producto> productos = GestorDatos.cargarProductos(ruta);

        System.out.println("Registros:");

        for (Registrable r : registros) {
            r.registrar();
            r.mostrarDatos();

            if (r instanceof Cliente) {
                System.out.println("Tipo: Cliente");
            } else if (r instanceof Empleado) {
                System.out.println("Tipo: Empleado");
            } else if (r instanceof Proveedor) {
                System.out.println("Tipo: Proveedor");
            }

            System.out.println("----------------");
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese codigo de producto a buscar: ");
        String codigo = sc.nextLine();

        System.out.println("Resultado de busqueda: ");
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println(p);
                break;
            }
        }

        System.out.print("Ingrese precio minimo para filtrar: ");
        double precioMin = sc.nextDouble();

        System.out.println("Resultado de busqueda: ");
        for (Producto p : productos) {
            if (p.getPrecio() >= precioMin) {
                System.out.println(p);
            }
        }
    }
}
