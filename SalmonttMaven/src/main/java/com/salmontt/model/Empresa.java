package com.salmontt.model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nombre;
    private List<CentroCultivo> centros;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.centros = new ArrayList<>();
    }

    public void agregarCentro(CentroCultivo centro) {
        centros.add(centro);
    }

    public List<CentroCultivo> getCentros() {
        return centros;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombr e='" + nombre + '\'' +
                ", cantidadCentros=" + centros.size() +
                '}';
    }
}
