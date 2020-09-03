package com.cali.mascotas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cali.mascotas.R;
import com.cali.mascotas.pojo.Foto;

import java.util.ArrayList;

public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.FotoViewHolder>{

    private ArrayList<Foto> fotos;

    public FotoAdapter(ArrayList<Foto> fotos) {
        this.fotos = fotos;
    }


    @NonNull
    @Override
    public FotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_foto, parent, false);
        return new FotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FotoViewHolder holder, int position) {

        Foto foto = fotos.get(position);
        holder.ivFotos.setImageResource(foto.getFoto());
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class FotoViewHolder extends RecyclerView.ViewHolder{

    private ImageView ivFotos;


    public FotoViewHolder(@NonNull View itemView) {
        super(itemView);

        ivFotos = itemView.findViewById(R.id.ivFotos);




    }
}
}
