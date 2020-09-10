package com.cali.mascotas.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cali.mascotas.db.BaseDatos;
import com.cali.mascotas.db.miConstructoorMascotas;
import com.cali.mascotas.pojo.Mascota;
import com.cali.mascotas.R;
import com.cali.mascotas.presentador.RecyclerViewFragmentPresentador;

import java.util.ArrayList;

import static android.widget.Toast.*;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;
    RecyclerViewFragmentPresentador rvPresentadpr;


    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {

        this.mascotas = mascotas;
        this.activity = activity;

    }

    @NonNull
    @Override
    public MascotaAdaptador.MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_mascota, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaAdaptador.MascotaViewHolder holder, int position) {

        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvRank.setText(String.valueOf(mascota.getRank()));

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(activity, "diste like a "+mascota.getNombre(), LENGTH_SHORT).show();
                miConstructoorMascotas constructoorMascotas = new miConstructoorMascotas(activity);
                constructoorMascotas.darLikeMascota(mascota);

                holder.tvRank.setText(constructoorMascotas.obtenerLikesMascota(mascota)+"");
                mascotas.set(0, mascota);

            }



        });


    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRank;
        private ImageButton btnLike;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvRank = itemView.findViewById(R.id.tvRank);
            btnLike = itemView.findViewById(R.id.btnBlanco);

        }
    }
}
