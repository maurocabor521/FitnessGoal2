package com.example.andrescabal.navdrawer.domain.usecase.impl;

import com.example.andrescabal.navdrawer.domain.model.Receta;

/**
 * Created by Andrés Cabal on 6/05/2018.
 */

public interface RecetasUseCase {
    void getAllRecetas();
    void setReceta(Receta receta);
    void getReceta();
}
