package com.example.andrescabal.navdrawer.domain.usecase.impl.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;

import com.example.andrescabal.navdrawer.domain.model.Receta;
import com.example.andrescabal.navdrawer.domain.usecase.impl.RecetasUseCase;
import com.example.andrescabal.navdrawer.helpers.Constants;
import com.example.andrescabal.navdrawer.presentation.contract.CategoriaAlimentosContract;
import com.example.andrescabal.navdrawer.repository.impl.ConexionSQLiteHelper;

import java.util.List;

/**
 * Created by Andrés Cabal on 6/05/2018.
 */

public class RecetasCaseUseImpl implements RecetasUseCase {
    @Override
    public void getAllRecetas() {

    }

    @Override
    public void setReceta(Context context, String nombre, List<String> alimentos) {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(context, "recetas", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.CAMPO_NOMBRE, nombre);

        for (int i = 0; i < alimentos.size(); i++) {
            values.put(Constants.CAMPO_ALIMENTOS, alimentos.get(i));
        }

        db.insert(Constants.TABLA_RECETA, Constants.CAMPO_ID, values);
        db.close();
    }


    @Override
    public void getReceta() {

    }
}
