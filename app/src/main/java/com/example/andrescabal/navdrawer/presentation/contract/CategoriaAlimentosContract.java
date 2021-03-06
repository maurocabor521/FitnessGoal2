package com.example.andrescabal.navdrawer.presentation.contract;

import android.content.Context;

import com.example.andrescabal.navdrawer.domain.model.Alimento;

import java.util.List;

/**
 * Created by Andrés Cabal on 7/05/2018.
 */

public interface CategoriaAlimentosContract {

    interface Presenter{
       List<Alimento> getListaAlimentos();
       //devuelve el resultado lista, no va a lc caso de uso
        List<String> getLstNombreAlimentos();
        //llama el caso de uso
        void loadListaAlimentos();

        void crearReceta(Context context,String nombre, List<String>alimentos);
    }
    interface View{
        void disableButtons();
        void showListaAlimentos();
        void getAdapter();
    }
}
