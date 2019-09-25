/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

/**
 *
 * @author alumno
 */
public class TestGenericos {
    
    @Test
    public void metodosGenericos() {
        ArrayList<Integer> listaInt = new ArrayList<>();
        insertarDobleGenerico(listaInt, 10);
        insertarDobleGenerico(listaInt, 15);
        System.out.println("Enteros: " + listaInt.toString());
                
        ArrayList<String> listaStr = new ArrayList<>();
        insertarDobleGenerico(listaStr, "Texto 1");
        insertarDobleGenerico(listaStr, "Texto 2");
        // insertarDobleGenerico(listaStr, 666);
        System.out.println("Textos: " + listaStr.toString());
        mostrarGenerico(listaStr.toArray()) ;
        
        Float[] arrF = {1.1f, 2.2f, 3.3f};
        ArrayList<Float> listaF =  convertirEnList(arrF);
        mostrarGenerico(listaF.toArray());
    }
    public static <Tipo> void insertarDobleGenerico (ArrayList<Tipo> lista, Tipo valor) {
           lista.add(valor);
           lista.add(valor);
    }    
    public static <Tipo> void mostrarGenerico(Tipo[] array) {
        for (Tipo obj : array) {
            System.out.println(" - " + obj.toString());
        }
    }
    public static <Tipo> ArrayList<Tipo> convertirEnList(Tipo[] array) {
        ArrayList<Tipo> list = new ArrayList<>();
        for (Tipo obj : array)  list.add(obj);
        return list;
    }
    public static <Tipo> ArrayList<Tipo> convertirEnList2(Tipo[] array) {
        ArrayList<Tipo> list = new ArrayList<>();
        list.addAll(Arrays.asList(array));
        return list;
    }
    
    /*public static  void insertarDobleGenerico (ArrayList<Integer> lista, Integer valor) {
           lista.add(valor);
           lista.add(valor);
    } 
    public static  void insertarDobleGenerico (ArrayList<String> lista, String valor) {
           lista.add(valor);
           lista.add(valor);
    }*/
}
