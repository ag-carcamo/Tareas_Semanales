package cl.carcasoft.model;

import cl.carcasoft.utils.RutInvalidoException;

public class Rut {

    private String numero;
    private String digitoVeridicador;

    public Rut(String numero, String digitoVeridicador) {
        if (numero == null || numero.isEmpty()) {
            throw new RutInvalidoException("El número de rut no puede estar vacoo");
        }
        if (digitoVeridicador == null || digitoVeridicador.isEmpty()) {
            throw new RutInvalidoException("El digito verificador no puede estar vacio");
        }

        this.numero = numero;
        this.digitoVeridicador = digitoVeridicador;
    }

    public String getNumero() {
        return numero;
    }

    public String getDv() {
        return digitoVeridicador;
    }

    @Override
    public String toString() {
        return numero + "-" + digitoVeridicador;
    }
}
