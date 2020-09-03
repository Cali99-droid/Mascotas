package com.cali.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cali.mascotas.adapter.MascotaAdaptador;
import com.cali.mascotas.pojo.Foto;
import com.cali.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class detalle_mascota extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    ArrayList<Foto> fotos;

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
        inicializarFotos();
        inicializar();
        inicializarAdap();

    }

    public void inicializar(){

        mascotas.add(new Mascota("Catty",4,2,R.drawable.perro1, fotos));
        mascotas.add(new Mascota("Sol",3,4,R.drawable.perro2, fotos));
        mascotas.add(new Mascota("Luna",2,5,R.drawable.perro3, fotos));
        mascotas.add(new Mascota("Job",4,3,R.drawable.perro4, fotos));
        mascotas.add(new Mascota("Rambo",1,2,R.drawable.perro7, fotos));

    }

    public void inicializarAdap(){
        MascotaAdaptador adap = new MascotaAdaptador(mascotas);
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
