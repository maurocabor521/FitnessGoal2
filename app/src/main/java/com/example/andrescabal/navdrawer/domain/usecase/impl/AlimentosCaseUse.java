package com.example.andrescabal.navdrawer.domain.usecase.impl;

import com.example.andrescabal.navdrawer.domain.model.Alimento;

/**
 * Created by Andrés Cabal on 6/05/2018.
 */

public interface AlimentosCaseUse {
    void getAllAlimentos();
    void setAlimento(Alimento alimento);
    void getAlimento(String name);
}
