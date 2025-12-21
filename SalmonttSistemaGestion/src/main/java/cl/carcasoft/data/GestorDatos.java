package cl.carcasoft.data;

import cl.carcasoft.model.*;
import cl.carcasoft.utils.LectorArchivo;

import java.util.ArrayList;
import java.util.List;

public class GestorDatos {

    public static List<Registrable> cargarRegistros(String rutaArchivo) {

        List<Registrable> registros = new ArrayList<>();

        for (String linea : LectorArchivo.leerLineas(rutaArchivo)) {

            String[] p = linea.split(";");

            String tipo = p[0];

            switch (tipo) {

                case "CLIENTE": {
                    Rut rut = new Rut(p[2], p[3]);
                    Direccion dir = new Direccion(p[4], p[5], p[6], p[7]);
                    Cliente cliente = new Cliente(
                            p[1],
                            dir,
                            rut,
                            Integer.parseInt(p[8])
                    );
                    registros.add(cliente);
                    break;
                }

                case "EMPLEADO": {
                    Rut rut = new Rut(p[2], p[3]);
                    Direccion dir = new Direccion(p[4], p[5], p[6], p[7]);
                    Empleado empleado = new Empleado(
                            p[1],
                            dir,
                            rut,
                            p[8],
                            Double.parseDouble(p[9]),
                            p[10]
                    );
                    registros.add(empleado);
                    break;
                }

                case "PROVEEDOR": {
                    Rut rut = new Rut(p[2], p[3]);
                    Direccion dir = new Direccion(p[4], p[5], p[6], p[7]);
                    Proveedor proveedor = new Proveedor(
                            p[1],
                            dir,
                            rut,
                            p[8]
                    );
                    registros.add(proveedor);
                    break;
                }

                default:
                    break;
            }
        }
        return registros;
    }

    public static List<Producto> cargarProductos(String rutaArchivo) {

        List<Producto> productos = new ArrayList<>();

        for (String linea : LectorArchivo.leerLineas(rutaArchivo)) {

            String[] p = linea.split(";");

            if (p[0].equals("PRODUCTO")) {
                Producto producto = new Producto(
                        p[1],
                        p[2],
                        Double.parseDouble(p[3])
                );
                productos.add(producto);
            }
        }
        return productos;
    }
}
