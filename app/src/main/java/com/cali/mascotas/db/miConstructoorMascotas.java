package com.cali.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.cali.mascotas.R;
import com.cali.mascotas.pojo.Foto;
import com.cali.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class miConstructoorMascotas {

    private static final int LIKE = 1;
    private Context context;
    private  ArrayList<Mascota> mascotas;

    public miConstructoorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
/*
        ArrayList<Foto> fotos   = new ArrayList<>();;
        fotos.add(new Foto(R.drawable.perro2));
        fotos.add(new Foto(R.drawable.perro2));
        fotos.add(new Foto(R.drawable.perro2));
        fotos.add(new Foto(R.drawable.perro2));
        fotos.add(new Foto(R.drawable.perro2));
        ArrayList<Mascota> mascotas  = new ArrayList<>();
        mascotas.add(new Mascota("Catty",4,2,R.drawable.perro1, fotos));
        mascotas.add(new Mascota("Sol",3,4,R.drawable.perro2, fotos));
        mascotas.add(new Mascota("Luna",2,5,R.drawable.perro3, fotos));
        mascotas.add(new Mascota("Job",4,3,R.drawable.perro4, fotos));
        mascotas.add(new Mascota("Rambo",1,2,R.drawable.perro7, fotos));
        mascotas.add(new Mascota("Koki",1,2,R.drawable.perro6, fotos));
     return mascotas;

 */
             BaseDatos db = new BaseDatos(context);
             insertarTresMascotas(db);

             return  db.obtenerMascotas();
    }

    public void insertarTresMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Frez");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, "12");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro2);

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Lobo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, "2");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro1);

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Marty");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, "6");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro7);

        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Jack");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, "1");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro4);

        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Fond");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, "4");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro5);

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Mike");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, "4");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro6);

        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Bob");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_EDAD, "4");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro3);

        db.insertarMascota(contentValues);
    }

    public  void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLES_LIKES_MASCOTAS_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLES_LIKES_MASCOTAS_NUMERO, LIKE);
        db.insertarLikeMascota(contentValues);

    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }


}
