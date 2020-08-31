package com.cali.mascotas;

public class Mascota {

    private String nombre;
    private int edad;
    private  int rank;
    private int foto;

    public Mascota(String nombre, int edad, int rank, int foto) {
        this.nombre = nombre;
        this.edad = edad;
        this.rank = rank;
        this.foto = foto;
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
}
