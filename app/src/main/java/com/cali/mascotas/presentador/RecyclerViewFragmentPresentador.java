package com.cali.mascotas.presentador;

import android.content.Context;

import com.cali.mascotas.db.miConstructoorMascotas;
import com.cali.mascotas.iRescyclerViewFragmentview;
import com.cali.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresentador implements iRecyclerViewFragmentPresenter{
    private iRecyclerViewFragmentPresenter iRecyclerViewFragmentPresenter;
    private Context context;
    private miConstructoorMascotas constructoorMascotas;
    private ArrayList<Mascota> mascotas;
    private  iRescyclerViewFragmentview iRescyclerViewFragmentview;

    public RecyclerViewFragmentPresentador(iRescyclerViewFragmentview iRescyclerViewFragmentview, Context context) {
        this.iRescyclerViewFragmentview = iRescyclerViewFragmentview;
        this.context = context;
        obtemerMascotasDatos();

    }


    @Override
    public void obtemerMascotasDatos() {
        constructoorMascotas = new miConstructoorMascotas(context);
        mascotas = constructoorMascotas.obtenerDatos();
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        iRescyclerViewFragmentview.inicializarAdaptadorRV(iRescyclerViewFragmentview.crearAdaptador(mascotas));
        iRescyclerViewFragmentview.generarLinearLayoutVertical();
    }
}
