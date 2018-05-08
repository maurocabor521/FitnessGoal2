package com.example.andrescabal.navdrawer.domain.usecase.impl;

import com.example.andrescabal.navdrawer.domain.model.Alimento;
import com.example.andrescabal.navdrawer.helpers.Callback;

import java.util.List;

/**
 * Created by Andrés Cabal on 6/05/2018.
 */

public interface AlimentosCaseUse {
    void getListaAlimentos();
    void setAlimento(Alimento alimento);
    void getAlimento(String name);

    void getlstAlimentos(Callback<List<Alimento>> callback);
    List<Alimento> getlstAlimentos() throws Exception;
}
