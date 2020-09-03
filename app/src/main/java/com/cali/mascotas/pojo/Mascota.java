package com.cali.mascotas.pojo;

import java.util.ArrayList;

public class Mascota {

    private String nombre;
    private int edad;
    private  int rank;
    private int foto;
    private ArrayList<Foto> fotos;



    public Mascota(String nombre, int edad, int rank, int foto, ArrayList<Foto> fotos) {
        this.nombre = nombre;
        this.edad = edad;
        this.rank = rank;
        this.foto = foto;

        this.fotos = fotos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
    public ArrayList<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<Foto> fotos) {
        this.fotos = fotos;
    }
}
