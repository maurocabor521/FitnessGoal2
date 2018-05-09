package com.example.andrescabal.navdrawer.presentation.view.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import android.widget.ListView;
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
public class RecetasFragment extends Fragment implements CategoriaAlimentosContract.View, View.OnClickListener {


    private CategoriaAlimentosContract.Presenter presenter;
    private SpinnerAdapter spinnerAdapter;
    private List<String> lstNombresAlimentos;
    private List<String> lst_NomAli_de_Receta;
    private List<Alimento> lst_Alimentos;
    private Spinner spinner;
    CategoriaAlimentosActivity categoriaAlimentosActivity;
    private Button btnAgregarAlimento;
    private Button btnAgregarReceta;
    private EditText etListaAlim;
    private String nomAlim;
    private ListView lv_nombreAlimentos;
    private Context context;
    private EditText et_nombreReceta;


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
        et_nombreReceta = view.findViewById(R.id.et_nombreReceta);

        btnAgregarAlimento = view.findViewById(R.id.btIngresarAlimento);
        btnAgregarAlimento.setOnClickListener(this);

        btnAgregarReceta = view.findViewById(R.id.bt_IngresarReceta);
        btnAgregarReceta.setOnClickListener(this);

        etListaAlim = view.findViewById(R.id.etListaAlimentos);
        lv_nombreAlimentos = view.findViewById(R.id.lv_alimentos);
        //presenter=new C

        context = getContext();
        //lstNombresAlimentos = new ArrayList<>(0);
        lstNombresAlimentos = new ArrayList<String>();
        //lstNombresAlimentos.add("Seleccione");

        lst_Alimentos = new ArrayList<Alimento>();
        /*lstNombresAlimentos.add("casa");
        lstNombresAlimentos.add("carro");
        lstNombresAlimentos.add("moto");*/
        spinner = (Spinner) view.findViewById(R.id.spinner);

        presenter = new CategoriaAlimentosPresenter(this);
        presenter.loadListaAlimentos();
        Toast.makeText(getContext(), "on create presenter fragment", Toast.LENGTH_SHORT).show();


        lst_NomAli_de_Receta = new ArrayList<String>();
        //showListView();

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
        lst_Alimentos = presenter.getListaAlimentos();
        //lst_NomAli_de_Receta = new ArrayList<String>();
        //context = getContext();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                if (position != 0) {
                    Alimento alimento = presenter.getListaAlimentos().get(position - 1);
                    //etListaAlim.setText("Nombre: " + String.valueOf(alimento.getNameAlimento()));
                    //lst_NomAli_de_Receta.add(String.valueOf(alimento.getNameAlimento()));

                    lst_NomAli_de_Receta.add(String.valueOf(alimento.getNameAlimento())
                            + " - " + String.valueOf(alimento.getCalorias()));
                    showListView();

                } else {
                    //etListaAlim.setText("");

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // showListView();
        spinnerAdapter = new SpinnerAdapter(getContext(), lstNombresAlimentos, this, spinner);
        spinner = spinnerAdapter.getSpinner();

        //ArrayAdapter adapter=spinnerAdapter;
      /*  ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, lstNombresAlimentos);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter.add("Seleccione: ");
        spinner.setAdapter(adapter);*/
        //spinner.setAdapter(spinnerAdapter);
    }

    public void addLista(String nombre) {
        lst_NomAli_de_Receta.add(nombre);
    }

    public void showListView() {
        List<String> cad = new ArrayList<String>();
        cad.add("uno");
        cad.add("dos");
        cad.add("tres");
        ArrayAdapter<String> adapterListView = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, lst_NomAli_de_Receta);
        lv_nombreAlimentos.setAdapter(adapterListView);
        Toast.makeText(getContext(), "lista cad:" + cad.size(), Toast.LENGTH_SHORT).show();
        lv_nombreAlimentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String informacion="Id: "+lst_NomAli_de_Receta.get(position-1)+"\n";
                //Toast.makeText(getContext(),"nombre: "+informacion,Toast.LENGTH_SHORT).show();
            }
        });
    }

    // no se esta usando
    public void getAdapter() {
        // spinnerAdapter.construirAdapter();
        spinner = spinnerAdapter.getSpinner();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_IngresarReceta:
                // presenter.crearReceta(context,nombre,lst_NomAli_de_Receta);
                String nombre =String.valueOf(et_nombreReceta.getText()) ;
                presenter.crearReceta(getContext(),nombre,lst_NomAli_de_Receta);
                Toast.makeText(getContext(),"onclick: ",Toast.LENGTH_SHORT).show();
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
