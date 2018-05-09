package com.example.andrescabal.navdrawer.presentation.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.andrescabal.navdrawer.presentation.contract.CategoriaAlimentosContract;
import com.example.andrescabal.navdrawer.presentation.contract.MainContract;
import com.example.andrescabal.navdrawer.presentation.view.fragment.RecetasFragment;

import java.util.List;

/**
 * Created by Andrés Cabal on 6/05/2018.
 */

public class SpinnerAdapter  {
    private Spinner spinner;
    private List<String> lstNombresAlimentos;
    //private View view;
    Context context;
    private CategoriaAlimentosContract.View view;

  /*  public SpinnerAdapter(Context context, List<String> lstNombresAlimentos, CategoriaAlimentosContract.View view) {
        this.lstNombresAlimentos = lstNombresAlimentos;
        this.context = context;
        this.view = view;
        //construirAdapter();
    }*/

    public SpinnerAdapter(Context context, List<String> lstNombresAlimentos, CategoriaAlimentosContract.View view,Spinner spinner) {
        this.spinner = spinner;
        this.lstNombresAlimentos = lstNombresAlimentos;
        this.context = context;
        this.view = view;
        construirAdapter();

    }

    /*  public SpinnerAdapter(Context context, List<String> lstNombresAlimentos ) {

        this.lstNombresAlimentos = lstNombresAlimentos;
        this.context = context;
        //spinner=context.
        construirAdapter();
    }*/

    public SpinnerAdapter(View view, List<String> lstNombresAlimentos) {
    }

    public void construirAdapter() {

        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, lstNombresAlimentos);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //return adapter;
        spinner.setAdapter(adapter);
       // view.getAdapter();
    }

    public Spinner getSpinner() {
        return spinner;
    }
}
