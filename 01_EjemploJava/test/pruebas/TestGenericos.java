/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alumno
 */
public class TestGenericos {
    

    @Test
    public void metodoGenerico() {
        ArrayList<Integer> listaInt = new ArrayList<>();
        insertarDobleGenerico(listaInt,10);
        insertarDobleGenerico(listaInt,15);
        System.out.println("Enteros: " + listaInt.toString());
        
        ArrayList<String> listaStr = new ArrayList<>();
        insertarDobleGenerico(listaStr, "Texto 1");
        insertarDobleGenerico(listaStr, "Texto 2");
        System.out.println("Textos: " + listaStr.toString());
        
        mostrarGenerico(listaStr.toArray());
        mostrarGenerico(listaInt.toArray());
        
        System.out.println(convArrayList(listaStr.toArray()));
        
        Float[] arrF = {1.1f, 2.2f, 3.3f};
        ArrayList<Float> listaF = convArrayList(arrF);
        mostrarGenerico(listaF.toArray());
        
        
    
    }
    
    public static <Tipo> void insertarDobleGenerico (ArrayList<Tipo> lista, Tipo valor) {
        lista.add(valor);
        lista.add(valor);
    }
    
    /* Mostrar una lista */
    public static <Tipo> void mostrarGenerico(Tipo[] lista) {
        for (Tipo obj : lista) {
            System.out.println(" - " + obj.toString());
        } 
    }
    
    /* método genérico para convertir Array en ArrayList */
    public static <Tipo> ArrayList<Tipo> convArrayList (Tipo[] array) {
        ArrayList<Tipo> myArray = new ArrayList<>();
        myArray.addAll(Arrays.asList(array));
        return myArray;
    }

}
