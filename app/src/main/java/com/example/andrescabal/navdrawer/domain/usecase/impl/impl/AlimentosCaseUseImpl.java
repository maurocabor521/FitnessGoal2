package com.example.andrescabal.navdrawer.domain.usecase.impl.impl;

import android.os.AsyncTask;

import com.example.andrescabal.navdrawer.domain.model.Alimento;
import com.example.andrescabal.navdrawer.domain.usecase.impl.AlimentosCaseUse;
import com.example.andrescabal.navdrawer.helpers.Callback;
import com.example.andrescabal.navdrawer.helpers.ThreadExecutor;
import com.example.andrescabal.navdrawer.repository.AlimentosRepository;
import com.example.andrescabal.navdrawer.repository.impl.AlimentosRepositotyImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrés Cabal on 6/05/2018.
 */

public class AlimentosCaseUseImpl implements AlimentosCaseUse {

    private AlimentosRepository alimentosRepository;
   // private List<String> lstNombresAlimentos;
    private List<Alimento> lstAlimentos;

    public AlimentosCaseUseImpl() {
        this.alimentosRepository = new AlimentosRepositotyImpl();
        //lstNombresAlimentos = new ArrayList<>(0);
        //lstAlimentos = new ArrayList<>(0);
    }

    @Override
    public void getListaAlimentos() {

    }

    @Override
    public void setAlimento(Alimento alimento) {

    }

    @Override
    public void getAlimento(String name) {

    }

    @Override
    public void getlstAlimentos(final Callback<List<Alimento>> callback) {
        new ThreadExecutor<List<Alimento>>()
                .execute(new ThreadExecutor.Task<List<Alimento>>() {
                    @Override
                    public List<Alimento> execute() throws Exception {
                        //Llamo al metodo sincrono del UseCase
                        return getlstAlimentos();
                    }

                    @Override
                    public void finish(Exception error, List<Alimento> result) {
                        if (error == null) {
                            callback.success(result);
                        } else {
                            callback.error(error);
                        }
                    }
                });
    }

    @Override
    public List<Alimento> getlstAlimentos() throws Exception {

        return alimentosRepository.getAllAlimentos();
    }


}


