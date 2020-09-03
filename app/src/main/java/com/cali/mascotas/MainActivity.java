package com.cali.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

import com.cali.mascotas.adapter.MascotaAdaptador;
import com.cali.mascotas.adapter.pageAdapter;
import com.cali.mascotas.fragment.Perfil;
import com.cali.mascotas.fragment.RecyclerViewFragment;
import com.cali.mascotas.pojo.Mascota;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private  Toolbar toolbar;
    private TabLayout tLayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        tLayout = findViewById(R.id.tabLayout);
        viewpager = findViewById(R.id.viewPager);
        setUpViewPager();


       // Toolbar miActionBar = findViewById(R.id.miActionBar);
       // setSupportActionBar(miActionBar);

       // TextView tvNombre = findViewById(R.id.tvPrueba);

      //  registerForContextMenu(tvNombre);


        /*

         */

        if (toolbar != null){
            setSupportActionBar(toolbar);

        }
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
                break;
            case R.id.iContacto:
                Intent intent1 = new Intent(this, contacto.class);
                startActivity(intent1);
                break;

            case R.id.iAcercaDe:
                Intent intent2 = new Intent(this, AcercaDe.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflate = new MenuInflater(this);
        getMenuInflater().inflate(R.menu.menu_contexto, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.mEdit:
                Toast.makeText(this, getResources().getString(R.string.menu_edit), Toast.LENGTH_SHORT).show();
                break;
            case R.id.mDelete:
                Toast.makeText(this, getResources().getString(R.string.menu_delete), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }



    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new Perfil());
        return  fragments;
    }
    private  void  setUpViewPager(){
        viewpager.setAdapter(new pageAdapter(getSupportFragmentManager(), agregarFragments()));
        tLayout.setupWithViewPager(viewpager);

        tLayout.getTabAt(0).setIcon(R.drawable.icons8_dog_house_64);
        tLayout.getTabAt(1).setIcon(R.drawable.icons8_year_of_dog_30);
    }





}
