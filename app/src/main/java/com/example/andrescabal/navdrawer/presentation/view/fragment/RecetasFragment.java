package com.example.andrescabal.navdrawer.presentation.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.andrescabal.navdrawer.R;
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
 * Use the {@link RecetasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecetasFragment extends Fragment implements CategoriaAlimentosContract.View {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private CategoriaAlimentosContract.Presenter presenter;
    private SpinnerAdapter spinnerAdapter;
    private List<String> lstNombresAlimentos;
    private Spinner spinner;
    CategoriaAlimentosActivity categoriaAlimentosActivity;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public RecetasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecetasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecetasFragment newInstance(String param1, String param2) {
        RecetasFragment fragment = new RecetasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_recetas, container, false);


        View view = inflater.inflate(R.layout.fragment_recetas, container, false);
        //presenter=new C


        //lstNombresAlimentos = new ArrayList<>(0);
        lstNombresAlimentos = new ArrayList<>();
        /*lstNombresAlimentos.add("casa");
        lstNombresAlimentos.add("carro");
        lstNombresAlimentos.add("moto");*/
        spinner=(Spinner)view.findViewById(R.id.spinner);
       presenter=new CategoriaAlimentosPresenter(this);
       presenter.loadListaAlimentos();
        Toast.makeText(getContext(),"on create presenter fragment",Toast.LENGTH_SHORT).show();

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
        lstNombresAlimentos=presenter.getLstNombreAlimentos();
        int sizeList=lstNombresAlimentos.size();

        if(lstNombresAlimentos!=null){
            Toast.makeText(getContext(),"lista con nombre "+sizeList,Toast.LENGTH_SHORT).show();
        }
        Context context;
        //if (view != null) {
            //categoriaAlimentosActivity=new CategoriaAlimentosActivity();
            //context=categoriaAlimentosActivity.getContext();
            context=getContext();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, lstNombresAlimentos);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public static RecetasFragment getInstance() {
        return new RecetasFragment();
    }
}
