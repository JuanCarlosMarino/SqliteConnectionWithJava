/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Clases;

/**
 *
 * @author JUAN MARIÑO
 */
public class Cancion {
    private int ID;
    private String nombre;
    private String artista;
    private String genero;

    public Cancion() {
    }

    public Cancion(int ID, String nombre, String artista, String genero) {
        this.ID = ID;
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
    }
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Cancion{" + "ID=" + ID + ", nombre=" + nombre + ", artista=" + artista + ", genero=" + genero + '}';
    }  
    
    
}
