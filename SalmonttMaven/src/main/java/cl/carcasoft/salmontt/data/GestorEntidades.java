package cl.carcasoft.salmontt.data;

import cl.carcasoft.salmontt.model.*;

import java.util.ArrayList;
import java.util.List;

public class GestorEntidades {

    private List<Registrable> entidades;

    public GestorEntidades() {
        entidades = new ArrayList<>();
    }

    public void agregarEntidad(Registrable entidad) {
        entidades.add(entidad);
    }

    public List<Registrable> getEntidades() {
        return entidades;
    }
}
