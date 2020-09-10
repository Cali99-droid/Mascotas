package com.cali.mascotas.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cali.mascotas.R;
import com.cali.mascotas.adapter.FotoAdapter;
import com.cali.mascotas.adapter.MascotaAdaptador;
import com.cali.mascotas.pojo.Foto;
import com.cali.mascotas.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Perfil extends Fragment {

    ArrayList<Foto> fotos;
    private RecyclerView listaFotos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        fotos = new ArrayList<>();
        listaFotos = v.findViewById(R.id.rvPerfil);


       GridLayoutManager llm = new GridLayoutManager(getActivity(), 2);
      //  LinearLayoutManager llm = new LinearLayoutManager(getActivity());
       // llm.setOrientation(LinearLayoutManager.VERTICAL)

        listaFotos.setLayoutManager(llm);
        inicializarFotos();
       // inicializarAdap();

        return v;
    }
    public  void inicializarFotos(){
        fotos.add(new Foto(R.drawable.perro3));
        fotos.add(new Foto(R.drawable.perro4));
        fotos.add(new Foto(R.drawable.perro5));
        fotos.add(new Foto(R.drawable.perro6));
        fotos.add(new Foto(R.drawable.perro1));
        fotos.add(new Foto(R.drawable.perro1));
        fotos.add(new Foto(R.drawable.perro1));
    }
 /*

    public void inicializarAdap(){

        Mascota mascota = new Mascota("Catty",4,2,R.drawable.perro1, fotos);
        FotoAdapter adap = new FotoAdapter(mascota.getFotos());
        listaFotos.setAdapter(adap);
    }

         */



}
