package com.example.andrescabal.navdrawer.repository.impl;

import com.example.andrescabal.navdrawer.domain.model.Alimento;
import com.example.andrescabal.navdrawer.domain.model.Receta;
import com.example.andrescabal.navdrawer.repository.RecetasRepository;

import java.util.List;

/**
 * Created by Andrés Cabal on 6/05/2018.
 */

public class RecetasRepositorySqlite implements RecetasRepository {
    @Override
    public List<Receta> getRecetas(String nombre) throws Exception {
        return null;
    }

    @Override
    public void deleteRecetas() throws Exception {

    }

    @Override
    public void insertTopTracks(List<Receta> lstRecetas) throws Exception {

    }
}
