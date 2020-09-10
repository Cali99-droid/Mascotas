package com.cali.mascotas;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.cali.mascotas.adapter.MascotaAdaptador;
import com.cali.mascotas.pojo.Mascota;

import java.util.ArrayList;

public interface iRescyclerViewFragmentview {

     void generarLinearLayoutVertical();

      MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) ;

      void inicializarAdaptadorRV(MascotaAdaptador adaptador) ;
}
