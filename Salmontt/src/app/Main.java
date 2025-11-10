package app;

import model.Direccion;
import model.Persona;

public class Main {
    public static void main(String[] args) {
        Direccion dir1 = new Direccion("Metropolitana", "Melipilla", "Las culebras verdes", 392);
        Persona pers1 = new Persona("20.647.215-4", "Agustin Carcamo", 24, dir1);

        Direccion dir2 = new Direccion("los lagos", "palilu", "Las culebras rojas", 999);
        Persona pers2 = new Persona("20.648.645-1", "Martin Carcamo", 42, dir2);

        Direccion dir3 = new Direccion("Juan Fernandez", "Villa profunda", "El mar", 123);
        Persona pers3 = new Persona("23.634.214-K", "Felipe Camiroga", 55, dir3);
        System.out.println(pers1);
        System.out.println(pers2);
        System.out.println(pers3);

    }
}