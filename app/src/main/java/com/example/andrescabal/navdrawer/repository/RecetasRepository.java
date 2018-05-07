package com.example.andrescabal.navdrawer.repository;

import com.example.andrescabal.navdrawer.domain.model.Alimento;
import com.example.andrescabal.navdrawer.domain.model.Receta;

import java.util.List;

/**
 * Created by Andrés Cabal on 6/05/2018.
 */

public interface RecetasRepository  {

    List<Receta> getRecetas(String nombre) throws Exception;

    void deleteRecetas() throws Exception;

    void insertTopTracks(List<Receta> lstRecetas) throws Exception;
}
