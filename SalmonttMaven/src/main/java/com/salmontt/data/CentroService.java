package com.salmontt.data;

import com.salmontt.model.CentroCultivo;

import java.util.ArrayList;
import java.util.List;

public class CentroService {

    public List<CentroCultivo> buscarPorComuna(List<CentroCultivo> lista, String comunaBuscada) {
        List<CentroCultivo> resultado = new ArrayList<>();

        for (CentroCultivo centro : lista) {
            if (centro.getComuna().equalsIgnoreCase(comunaBuscada)) {
                resultado.add(centro);
            }
        }

        return resultado;
    }
}
