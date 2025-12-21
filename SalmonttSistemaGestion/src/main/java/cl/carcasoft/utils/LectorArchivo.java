package cl.carcasoft.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LectorArchivo {

    public static ArrayList<String> leerLineas(String ruta) {
        ArrayList<String> lineas = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File(ruta));
            while (sc.hasNextLine()) {
                lineas.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo nose pudo encontrar");
        }

        return lineas;
    }
}
