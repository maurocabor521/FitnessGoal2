package com.example.andrescabal.navdrawer.repository.impl;

import com.example.andrescabal.navdrawer.domain.model.Alimento;
import com.example.andrescabal.navdrawer.helpers.Callback;
import com.example.andrescabal.navdrawer.helpers.Retrofit_Singleton;
import com.example.andrescabal.navdrawer.repository.AlimentosRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by Andrés Cabal on 6/05/2018.
 */

public class AlimentosRepositotyImpl implements AlimentosRepository {

    //RestAdapter
    interface AlimentoService {
        @GET("alimentos.json")
        Call<List<Alimento>> getAll();
    }

    @Override
    public List<Alimento> getAllAlimentos() throws Exception{
        try {
            Retrofit retrofit = Retrofit_Singleton.getInstance();
            AlimentoService alimentoService = retrofit.create(AlimentoService.class);

            Call<List<Alimento>> call = alimentoService.getAll();

            Response<List<Alimento>> response = call.execute();
            return response.body();
        } catch (Exception e) {
            throw e;
        }

    }







}
