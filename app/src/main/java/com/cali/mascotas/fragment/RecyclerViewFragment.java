package com.cali.mascotas.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cali.mascotas.R;
import com.cali.mascotas.adapter.MascotaAdaptador;
import com.cali.mascotas.iRescyclerViewFragmentview;
import com.cali.mascotas.pojo.Foto;
import com.cali.mascotas.pojo.Mascota;
import com.cali.mascotas.presentador.RecyclerViewFragmentPresentador;
import com.cali.mascotas.presentador.iRecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements  iRescyclerViewFragmentview{

    private RecyclerView listaMascotas;
    private iRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);


        listaMascotas = v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresentador( this, getContext());


        inicializarFotos();
        inicializar();

       return v;

    }

    public void inicializar(){

    }



    public  void inicializarFotos(){

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adap = new MascotaAdaptador(mascotas, this.getActivity());

        return adap;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

}
