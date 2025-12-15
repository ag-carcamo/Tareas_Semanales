package cl.carcasoft.salmontt.ui;

import cl.carcasoft.salmontt.data.GestorEntidades;
import cl.carcasoft.salmontt.model.*;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        GestorEntidades gestor = new GestorEntidades();

        while (true) {

            String op = JOptionPane.showInputDialog("Seleccione que tipo de entidad desea registrar: \n"+
                    "1 Centro\n" +
                            "2 Planta\n" +
                            "3 Empleado\n" +
                            "4 Proveedor\n" +
                            "5 Mostrar\n" +
                            "0 Salir"
            );

            if (op == null || op.equals("0")) {
                break;
            }

            if (op.equals("1")) {

                String nombre = JOptionPane.showInputDialog("Nombre de centro");
                String comuna = JOptionPane.showInputDialog("Comuna");
                int ton = Integer.parseInt(
                        JOptionPane.showInputDialog("Toneladas")
                );

                gestor.agregarEntidad(
                        new CentroCultivo(ton, comuna, nombre)
                );

            } else if (op.equals("2")) {

                String nombre = JOptionPane.showInputDialog("Nombre de planta");
                String comuna = JOptionPane.showInputDialog("Comuna");
                int cap = Integer.parseInt(
                        JOptionPane.showInputDialog("Capacidad")
                );

                gestor.agregarEntidad(
                        new PlantaProceso(nombre, comuna, cap)
                );

            } else if (op.equals("3")) {

                String nombre = JOptionPane.showInputDialog("Nombre de empleado");
                String cargo = JOptionPane.showInputDialog("Cargo");

                gestor.agregarEntidad(
                        new Empleado(nombre, cargo)
                );

            } else if (op.equals("4")) {

                String emp = JOptionPane.showInputDialog("Empresa");
                String serv = JOptionPane.showInputDialog("Servicio");

                gestor.agregarEntidad(
                        new Proveedor(emp, serv)
                );

            } else if (op.equals("5")) {

                String texto = "";

                for (Registrable r : gestor.getEntidades()) {

                    if (r instanceof CentroCultivo) {
                        texto += "Centro: ";
                    } else if (r instanceof PlantaProceso) {
                        texto += "Planta: ";
                    } else if (r instanceof Empleado) {
                        texto += "Empleado: ";
                    } else if (r instanceof Proveedor) {
                        texto += "Proveedor: ";
                    }

                    texto += r.mostrarResumen() + "\n";
                }

                if (texto.equals("")) {
                    texto = "No hay datos";
                }

                JOptionPane.showMessageDialog(null, texto);
            }
        }
    }
}
