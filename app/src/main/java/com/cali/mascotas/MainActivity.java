package com.cali.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Toolbar miActionBar = findViewById(R.id.miActionBar);
       // setSupportActionBar(miActionBar);

        mascotas = new ArrayList<>();
        listaMascotas = findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializar();
        inicializarAdap();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_favorite:
                Intent intent = new Intent(this, detalle_mascota.class);
                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

    public void inicializar(){

        mascotas.add(new Mascota("Catty",4,2,R.drawable.perro1));
        mascotas.add(new Mascota("Sol",3,4,R.drawable.perro2));
        mascotas.add(new Mascota("Luna",2,5,R.drawable.perro3));
        mascotas.add(new Mascota("Job",4,3,R.drawable.perro4));
        mascotas.add(new Mascota("Rambo",1,2,R.drawable.perro7));
        mascotas.add(new Mascota("Koki",1,2,R.drawable.perro6));

    }


    public void inicializarAdap(){
        MascotaAdaptador adap = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adap);
    }


}
