package com.salmontt.ui;

import com.salmontt.data.CentroService;
import com.salmontt.data.GestorDatos;
import com.salmontt.model.CentroCultivo;
import com.salmontt.model.Empresa;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GestorDatos gestor = new GestorDatos();
        CentroService servicio = new CentroService();
        Scanner scanner = new Scanner(System.in);


        List<CentroCultivo> lista = gestor.cargarDatos("centros.csv");

        System.out.println("Centros cargados desde CSV: ");
        for (CentroCultivo centro : lista) {
            System.out.println(centro);
        }

        Empresa empresa = new Empresa("Salmontt");

        for (CentroCultivo centro : lista) {
            empresa.agregarCentro(centro);
        }

        System.out.println("\nEmpresa cargada:");
        System.out.println(empresa);


        System.out.println("\nIngrese una comuna para buscar :");
        String comuna = scanner.nextLine();

        List<CentroCultivo> filtrados = servicio.buscarPorComuna(lista, comuna);

        System.out.println("\nResultados de busqueda:");
        if (filtrados.isEmpty())  {
            System.out.println("No se encontraron centros en esa comuna");
        } else {
            for (CentroCultivo centro : filtrados) {
                System.out.println(centro);
            }
        }

        System.out.println("\nFin del pro grama");
    }
}
