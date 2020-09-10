package com.cali.mascotas.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.cali.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAMR, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA +
                "("+  ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE+" TEXT,"
                +ConstantesBaseDatos.TABLE_MASCOTA_FOTO+" INTEGER,"
                +ConstantesBaseDatos.TABLE_MASCOTA_EDAD+" INTEGER"
                +")";
        String queryCrearTablaLikesMascotas= "CREATE TABLE "+ ConstantesBaseDatos.TABLES_LIKES_MASCOTAS+"(" +
                ConstantesBaseDatos.TABLES_LIKES_MASCOTAS_ID + " INTEGER PRIMARY KEY  AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLES_LIKES_MASCOTAS_ID_MASCOTA + " INTEGER , "+
                ConstantesBaseDatos.TABLES_LIKES_MASCOTAS_NUMERO + " INTEGER, "+
                "FOREIGN KEY ("+ConstantesBaseDatos.TABLE_MASCOTA_ID+") "+
                "REFERENCES "+ ConstantesBaseDatos.TABLE_MASCOTA+"("+ConstantesBaseDatos.TABLE_MASCOTA_ID+")"+
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascotas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS  "+ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS  "+ConstantesBaseDatos.TABLES_LIKES_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActuap = new Mascota();
            mascotaActuap.setId(registros.getInt(0));
            mascotaActuap.setNombre(registros.getString(1));
            mascotaActuap.setFoto(registros.getInt(2));
            mascotaActuap.setEdad(registros.getInt(3));


            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLES_LIKES_MASCOTAS_NUMERO+")as likes"+
                                " FROM "+ ConstantesBaseDatos.TABLES_LIKES_MASCOTAS +
                                " WHERE "+ ConstantesBaseDatos.TABLES_LIKES_MASCOTAS_ID_MASCOTA+ "=" + mascotaActuap.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActuap.setRank(registrosLikes.getInt(0));
            }else{
                mascotaActuap.setRank(0);
            }

                mascotas.add(mascotaActuap);




        }
        db.close();


        return mascotas;
    }

    public  void  insertarMascota(ContentValues contentValues){

            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
            db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLES_LIKES_MASCOTAS, null , contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLES_LIKES_MASCOTAS_NUMERO+")"+
                " FROM "+ ConstantesBaseDatos.TABLES_LIKES_MASCOTAS +
                " WHERE " + ConstantesBaseDatos.TABLES_LIKES_MASCOTAS_ID_MASCOTA + " = "+mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }

}
