package com.example.andrescabal.navdrawer.domain.usecase.impl;

import android.content.Context;
import android.view.View;

import com.example.andrescabal.navdrawer.domain.model.Receta;
import com.example.andrescabal.navdrawer.presentation.contract.CategoriaAlimentosContract;

import java.util.List;

/**
 * Created by Andrés Cabal on 6/05/2018.
 */

public interface RecetasUseCase {
    void getAllRecetas();
    void setReceta(Context context, String nombre, List<String>alimentos);
    void getReceta();
}
