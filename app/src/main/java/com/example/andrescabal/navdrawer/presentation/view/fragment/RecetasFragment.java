package com.example.andrescabal.navdrawer.presentation.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.andrescabal.navdrawer.R;
import com.example.andrescabal.navdrawer.domain.model.Alimento;
import com.example.andrescabal.navdrawer.presentation.contract.CategoriaAlimentosContract;
import com.example.andrescabal.navdrawer.presentation.presenter.CategoriaAlimentosPresenter;
import com.example.andrescabal.navdrawer.presentation.view.activity.CategoriaAlimentosActivity;
import com.example.andrescabal.navdrawer.presentation.view.adapter.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecetasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.

 */
public class RecetasFragment extends Fragment implements CategoriaAlimentosContract.View,View.OnClickListener {


    private CategoriaAlimentosContract.Presenter presenter;
    private SpinnerAdapter spinnerAdapter;
    private List<String> lstNombresAlimentos;
    private Spinner spinner;
    CategoriaAlimentosActivity categoriaAlimentosActivity;
    private Button btnAgregarAlimento;
    private EditText etListaAlim;



    private OnFragmentInteractionListener mListener;

    public RecetasFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_recetas, container, false);


        View view = inflater.inflate(R.layout.fragment_recetas, container, false);
        btnAgregarAlimento=view.findViewById(R.id.btIngresarAlimento);
        btnAgregarAlimento.setOnClickListener(this);
        etListaAlim=view.findViewById(R.id.etListaAlimentos);
        //presenter=new C


        //lstNombresAlimentos = new ArrayList<>(0);
        lstNombresAlimentos = new ArrayList<>();
        /*lstNombresAlimentos.add("casa");
        lstNombresAlimentos.add("carro");
        lstNombresAlimentos.add("moto");*/
        spinner = (Spinner) view.findViewById(R.id.spinner);
        presenter = new CategoriaAlimentosPresenter(this);
        presenter.loadListaAlimentos();
        Toast.makeText(getContext(), "on create presenter fragment", Toast.LENGTH_SHORT).show();

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void disableButtons() {

    }

    @Override
    public void showListaAlimentos() {
        lstNombresAlimentos = presenter.getLstNombreAlimentos();
        int sizeList = lstNombresAlimentos.size();

        if (lstNombresAlimentos != null) {
            Toast.makeText(getContext(), "lista con nombre " + sizeList, Toast.LENGTH_SHORT).show();
        }
        //Context context;

        //context = getContext();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Alimento alimento = presenter.getListaAlimentos().get(position);
                etListaAlim.setText("Nombre: "+ String.valueOf(alimento.getNameAlimento()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, lstNombresAlimentos);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btIngresarAlimento:
                //etListaAlim.setText();
                break;
        }
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public static RecetasFragment getInstance() {
        return new RecetasFragment();
    }
}
