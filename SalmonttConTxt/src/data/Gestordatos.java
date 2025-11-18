package data;

import model.CentroCultivo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Gestordatos {

    public List<CentroCultivo> cargardatos(String resourceName) {

        List<CentroCultivo> lista = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();

        try {
            InputStream inputStream = classLoader.getResourceAsStream(resourceName);
            if (inputStream == null) {
                System.out.println("no se encontro el recurso " + resourceName);
                return lista;
            }

            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String linea;
                int nroLineas = 0;

                while ((linea = bufferedReader.readLine()) != null) {
                    nroLineas ++;
                    if (linea.trim().isEmpty()) continue;

                    String[] partes = linea.split(";");
                    if(partes.length!=3){
                        System.out.println("Linea " + nroLineas + " es invalida");
                        continue;
                    }
                    int toneladas = Integer.parseInt(partes[2].trim());
                    String comuna = partes[1].trim();
                    String nombre = partes[0].trim();

                    CentroCultivo  centroCultivo = new CentroCultivo(toneladas, comuna, nombre);
                    lista.add(centroCultivo);

                }

            } catch (Exception ex) {

            }

        } catch (NullPointerException ex) {

        }

        return lista;
    }
}

