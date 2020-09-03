package com.cali.mascotas.fragment;

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
import com.cali.mascotas.pojo.Foto;
import com.cali.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    ArrayList<Foto> fotos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        mascotas      = new ArrayList<>();
        fotos         = new ArrayList<>();

        listaMascotas = v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarFotos();
        inicializar();
        inicializarAdap();
       return v;

    }

    public void inicializar(){

        mascotas.add(new Mascota("Catty",4,2,R.drawable.perro1, fotos));
        mascotas.add(new Mascota("Sol",3,4,R.drawable.perro2, fotos));
        mascotas.add(new Mascota("Luna",2,5,R.drawable.perro3, fotos));
        mascotas.add(new Mascota("Job",4,3,R.drawable.perro4, fotos));
        mascotas.add(new Mascota("Rambo",1,2,R.drawable.perro7, fotos));
        mascotas.add(new Mascota("Koki",1,2,R.drawable.perro6, fotos));

    }

    public void inicializarAdap(){
        MascotaAdaptador adap = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adap);
    }

    public  void inicializarFotos(){
        fotos.add(new Foto(R.drawable.perro2));
        fotos.add(new Foto(R.drawable.perro2));
        fotos.add(new Foto(R.drawable.perro2));
        fotos.add(new Foto(R.drawable.perro2));
        fotos.add(new Foto(R.drawable.perro2));
    }
}
