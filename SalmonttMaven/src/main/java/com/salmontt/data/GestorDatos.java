package com.salmontt.data;

import com.salmontt.model.CentroCultivo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {

    public List<CentroCultivo> cargarDatos(String resourceName) {

        List<CentroCultivo> lista = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();

        try {
            InputStream inputStream = classLoader.getResourceAsStream(resourceName);
            if (inputStream == null) {
                System.out.println("No se encontró el recurso: " + resourceName);
                return lista;
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String linea;
            int nroLineas = 0;

            while ((linea = bufferedReader.readLine()) != null) {
                nroLineas++;
                if (linea.trim().isEmpty()) continue;

                String[] partes = linea.split(";");
                if (partes.length != 3) {
                    System.out.println("Línea " + nroLineas + " es inválida");
                    continue;
                }

                String nombre = partes[0].trim();
                String comuna = partes[1].trim();
                int toneladas = Integer.parseInt(partes[2].trim());

                CentroCultivo centroCultivo = new CentroCultivo(toneladas, comuna, nombre);
                lista.add(centroCultivo);
            }

        } catch (Exception ex) {
            System.out.println("Error al cargar datos: " + ex.getMessage());
        }

        return lista;
    }
}
