import data.Gestordatos;
import model.CentroCultivo;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Gestordatos gestor = new Gestordatos();

        List<CentroCultivo> lista = gestor.cargardatos("centros.txt");

        System.out.println("lista de centros:");
        for (CentroCultivo c : lista) {
            System.out.println(c.toString());
        }

        System.out.println("\nnCentros que tengan mas de 1000 toneladas: ");
        for (CentroCultivo c : lista) {
            if (c.getToneladas() > 1000) {
                System.out.println(c.toString());
            }
        }
    }
}