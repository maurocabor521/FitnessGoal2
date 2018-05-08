package com.example.andrescabal.navdrawer.repository;

import com.example.andrescabal.navdrawer.domain.model.Alimento;
import com.example.andrescabal.navdrawer.helpers.Callback;

import java.util.List;

/**
 * Created by Andrés Cabal on 6/05/2018.
 */

public interface AlimentosRepository {

    List<Alimento> getAllAlimentos()throws Exception;

}
