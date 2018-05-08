package com.example.andrescabal.navdrawer.presentation.presenter;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import com.example.andrescabal.navdrawer.domain.model.Alimento;
import com.example.andrescabal.navdrawer.domain.model.Receta;
import com.example.andrescabal.navdrawer.domain.usecase.impl.AlimentosCaseUse;
import com.example.andrescabal.navdrawer.domain.usecase.impl.RecetasUseCase;
import com.example.andrescabal.navdrawer.domain.usecase.impl.impl.AlimentosCaseUseImpl;
import com.example.andrescabal.navdrawer.domain.usecase.impl.impl.RecetasCaseUseImpl;
import com.example.andrescabal.navdrawer.helpers.Callback;
import com.example.andrescabal.navdrawer.presentation.contract.CategoriaAlimentosContract;
import com.example.andrescabal.navdrawer.presentation.view.fragment.RecetasFragment;
import com.example.andrescabal.navdrawer.repository.AlimentosRepository;
import com.example.andrescabal.navdrawer.repository.impl.AlimentosRepositotyImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrés Cabal on 7/05/2018.
 */

public class CategoriaAlimentosPresenter implements CategoriaAlimentosContract.Presenter {

    private CategoriaAlimentosContract.View view;
    private AlimentosCaseUse alimentosCaseUse;
    private RecetasUseCase recetasUseCase;
    private List<Alimento> lstAlimentos;
    private List<String> lstNombresAlimentos;
    private AlimentosRepository alimentosRepository;
    private RecetasFragment recetasFragment;

    public CategoriaAlimentosPresenter(CategoriaAlimentosContract.View view) {
         this.view = view;
        this.alimentosCaseUse = new AlimentosCaseUseImpl();
        this.recetasUseCase = new RecetasCaseUseImpl();
        this.lstAlimentos = new ArrayList<>(0);
        this.alimentosRepository = new AlimentosRepositotyImpl();
        lstNombresAlimentos = new ArrayList<>(0);
        //cargarAlimentos();
        this.recetasFragment=new RecetasFragment();
    }

    @Override
    public List<Alimento> getListaAlimentos() {
        // Toast.makeText(v)
        //return alimentosCaseUse.getListaAlimentos();

       /* lstNombresAlimentos.add("casa");
        lstNombresAlimentos.add("carro");
        lstNombresAlimentos.add("moto");*/

        return lstAlimentos;
        //Toast.makeText(t)
    }

    @Override
    public List<String> getLstNombreAlimentos() {
        return lstNombresAlimentos;
    }


    @Override
    public void loadListaAlimentos() {
        alimentosCaseUse.getlstAlimentos(new Callback<List<Alimento>>() {
            @Override
            public void success(List<Alimento> result) {
                lstAlimentos.clear();
                lstAlimentos.addAll(result);

                lstNombresAlimentos.clear();
                for (Alimento alimento : lstAlimentos) {
                    lstNombresAlimentos.add(alimento.getNameAlimento());
                }
                view.showListaAlimentos();
            }

            @Override
            public void error(Exception error) {
                error.printStackTrace();
            }
        });
    }


}
