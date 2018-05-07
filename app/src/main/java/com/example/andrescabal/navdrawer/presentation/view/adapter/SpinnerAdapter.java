package com.example.andrescabal.navdrawer.presentation.view.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.andrescabal.navdrawer.presentation.contract.MainContract;

import java.util.List;

/**
 * Created by Andrés Cabal on 6/05/2018.
 */

public class SpinnerAdapter {
    private Spinner spinner;
    private List<String> lstNombresAlimentos;
    private View view;
    Context context;

    public SpinnerAdapter(Context context,List<String> lstNombresAlimentos ) {
        this.lstNombresAlimentos = lstNombresAlimentos;
        this.context = context;
    }

    public SpinnerAdapter(View view, List<String> lstNombresAlimentos) {
    }

    public ArrayAdapter construirAdapter() {

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, lstNombresAlimentos);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
        //spinner.setAdapter(adapter);
    }
}
