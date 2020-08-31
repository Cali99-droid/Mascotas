package com.cali.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class detalle_mascota extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        mascotas = new ArrayList<>();
        listaMascotas = findViewById(R.id.rvIMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializar();
        inicializarAdap();

    }

    public void inicializar(){

        mascotas.add(new Mascota("Catty",4,2,R.drawable.perro1));
        mascotas.add(new Mascota("Sol",3,4,R.drawable.perro2));
        mascotas.add(new Mascota("Luna",2,5,R.drawable.perro3));
        mascotas.add(new Mascota("Job",4,3,R.drawable.perro4));
        mascotas.add(new Mascota("Rambo",1,2,R.drawable.perro7));

    }

    public void inicializarAdap(){
        MascotaAdaptador adap = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adap);
    }
}
