package com.example.andrescabal.navdrawer.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.andrescabal.navdrawer.R;
import com.example.andrescabal.navdrawer.presentation.contract.CategoriaAlimentosContract;
import com.example.andrescabal.navdrawer.presentation.view.fragment.RecetasFragment;

public class CategoriaAlimentosActivity extends AppCompatActivity implements View.OnClickListener,
        RecetasFragment.OnFragmentInteractionListener {

    private Button btn_recetas;
    private Button btn_alimentos;
    private Button btn_Registros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_alimentos);
        btn_recetas = findViewById(R.id.btRecetas);
        btn_alimentos = findViewById(R.id.btAlimentos);
        btn_Registros = findViewById(R.id.btRegistros);

        btn_recetas.setOnClickListener(this);
        btn_alimentos.setOnClickListener(this);
        btn_Registros.setOnClickListener(this);

    }
/*
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
    */

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btRecetas:
               replaceFragment(RecetasFragment.getInstance(), true);

                /*android.app.FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.add(R.id.flContenedor,ingresarFragment);*/
                //fragmentTransaction.replace(R.id.flContenedor,ingresarFragment).commit();
                //goToFragment("Ingresar");
                Toast.makeText(getApplicationContext(), "Recetas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btAlimentos:
                //goToFragment("Consultar");
                break;
            case R.id.btRegistros:
                // goToFragment("Retirar");
                break;

        }
    }

    public void replaceFragment(Fragment fragment, boolean addToBackstack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.flContenedor, fragment);
        if(addToBackstack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public Context getContext(){
        Context context=this.getContext();
        return  context;
    }


}
