package com.juego.modelo.logica;

import com.juego.modelo.Pelicula;
import java.util.ArrayList;
import java.util.Random;

/**@author Miguel Maseda
 */



public class ServicioPelicula {

// <editor-fold defaultstate="collapsed" desc="Código patrón de diseño Singleton.">
    private static ServicioPelicula instancia;

    private ServicioPelicula() {
        peliculas = new ArrayList<>();
    }

    public static ServicioPelicula getInstancia() {
        if (instancia == null) {
            instancia = new ServicioPelicula();
        }
        return instancia;
    }// </editor-fold>

    private ArrayList<Pelicula> peliculas;
    
    public Pelicula addPelicula(String name) {
        if (!name.equals("")) {
            Pelicula p = new Pelicula(name);
            peliculas.add(p);
            return p;
        } else {
            return null;
        }
    }
    
    public String fetchPelicula() {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(peliculas.size());
        return peliculas.get(index).toString();        
    }
}
