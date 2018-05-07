package com.example.andrescabal.navdrawer.domain.model;

import java.util.List;

/**
 * Created by Andrés Cabal on 6/05/2018.
 */

public class Receta {
    private String name;
    private List<Alimento> lstAlimentos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Alimento> getLstAlimentos() {
        return lstAlimentos;
    }

    public void setLstAlimentos(List<Alimento> lstAlimentos) {
        this.lstAlimentos = lstAlimentos;
    }
}
