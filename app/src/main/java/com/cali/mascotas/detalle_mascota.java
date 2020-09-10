package com.cali.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.cali.mascotas.adapter.MascotaAdaptador;
import com.cali.mascotas.db.miConstructoorMascotas;
import com.cali.mascotas.pojo.Foto;
import com.cali.mascotas.pojo.Mascota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class detalle_mascota extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> primerosMascota;
    private RecyclerView listaMascotas;
    ArrayList<Foto> fotos;
    miConstructoorMascotas constructoorMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);

        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        mascotas = new ArrayList<>();
        listaMascotas = findViewById(R.id.rvIMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

       // inicializarFotos();
        inicializar();
        inicializarAdap();



    }

    public void inicializar(){
      constructoorMascotas = new miConstructoorMascotas(this);
      mascotas =  constructoorMascotas.obtenerDatos();
        Collections.sort(mascotas, (o1, o2) ->
                new Integer(constructoorMascotas.obtenerLikesMascota(o2))
                        .compareTo(new Integer(constructoorMascotas.obtenerLikesMascota(o1))));
         primerosMascota = new ArrayList<>();

        for (Mascota mascota:mascotas
             ) {
            if (primerosMascota.size() <5){
                primerosMascota.add(mascota);
            }

        }

    }



    public void inicializarAdap(){
        MascotaAdaptador adap = new MascotaAdaptador(primerosMascota, this);
        listaMascotas.setAdapter(adap);
    }

    public  void inicializarFotos(){
        fotos = new ArrayList<>();
        fotos.add(new Foto(R.drawable.perro2));
        fotos.add(new Foto(R.drawable.perro2));
        fotos.add(new Foto(R.drawable.perro2));
        fotos.add(new Foto(R.drawable.perro2));
        fotos.add(new Foto(R.drawable.perro2));
    }
}
