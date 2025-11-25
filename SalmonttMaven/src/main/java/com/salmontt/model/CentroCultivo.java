package com.salmontt.model;

public class CentroCultivo {
    private int toneladas;
    private String comuna;
    private String nombre;

    public CentroCultivo() {
    }

    public CentroCultivo(int toneladas, String comuna, String nombre) {
        this.toneladas = toneladas;
        this.comuna = comuna;
        this.nombre = nombre;
    }

    public int getToneladas() {
        return toneladas;
    }

    public String getComuna() {
        return comuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setToneladas(int toneladas) {
        this.toneladas = toneladas;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CentroCultivo{" +
                "toneladas=" + toneladas +
                ", comuna='" + comuna + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
