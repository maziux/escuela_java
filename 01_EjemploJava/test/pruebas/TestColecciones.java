/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import poo.Coche;
import poo.CocheRally;
import poo.TipoCarburante;
import poo.TipoColor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;
import static org.junit.Assert.*;
import poo.Pelota;

/**
 *
 * @author alumno
 */
public class TestColecciones {
    
    //@Test
    public void arrays() {
        Coche[] coches = new Coche[3]; // Coche coches[];
        coches[0] = new Coche("Fiat",TipoCarburante.DIESEL, TipoColor.AZUL);
        coches[1] = new Coche("Audi",TipoCarburante.GASOLINA, TipoColor.ROJO);
        coches[2] = new Coche("Kia",TipoCarburante.ELECTRICO, TipoColor.VERDE);
        
        Coche[] cochesBis = {coches[0],coches[1],coches[2]};
        
        Coche elMio = new Coche("Kia",TipoCarburante.ELECTRICO, TipoColor.VERDE);
        elMio = coches[2];
        
        /* NO USAR ArrayList NO genérico NUNCA!! */
        ArrayList arrayListObj = new ArrayList(); // ArrayList NO genérico
        arrayListObj.add(42);                     // Todos los elementos son objetos
        arrayListObj.add("Aaaaaa");
        arrayListObj.add(elMio);
        arrayListObj.add(false);

        for (Object obj : arrayListObj) {
            System.out.println(" OBJ: " + obj);
        }
        
        // ArrayList genérico
        // Solo se puede añadir las clases indicadas
        ArrayList<Integer> ventasAnuales = new ArrayList<Integer>();
        Integer objEntero = new Integer(200);
        objEntero.longValue();
        ventasAnuales.add(objEntero);
        ventasAnuales.add(30000);
        
        ArrayList<Coche> cochesParaVender = new ArrayList<>();
        cochesParaVender.add(new Coche("Sinca",TipoCarburante.GASOLINA,TipoColor.AZUL));
        cochesParaVender.add(coches[0]);
        cochesParaVender.add(coches[1]);
        cochesParaVender.add(coches[2]);
        
        cochesParaVender.add(new CocheRally("Subaru Imprezza"));
        if (cochesParaVender.contains(coches[0])) {
            System.out.println("El coche existe!");
        }
        
        cochesParaVender.forEach( (coche) -> {
            System.out.println(" -> " + coche.toString());
        });
    }
    
    //@Test
    public void sets() {
        HashSet<Pelota> pelotas = new HashSet<>();
        Pelota p1 = new Pelota();
        Pelota p2 = new Pelota();
        Pelota p3 = new Pelota();
        
        pelotas.add(p1);
        pelotas.add(p2);
        pelotas.add(p3);
        
        pelotas.add(p1);
        pelotas.add(p2);
        
        System.out.println("Set pelotas: " + pelotas);
        assertEquals(pelotas.size(), 3);
        
        pelotas.forEach((p) -> {
            System.out.println(p.toString());
        });        
    }
    
    //@Test
    public void maps(){
        //HashMap<String, Boolean> coloresCalidos = new HashMap<>();
        TreeMap<String, Boolean> coloresCalidos = new TreeMap<>();
        coloresCalidos.put("BLANCO", false);
        coloresCalidos.put("ROJO", true);
        coloresCalidos.put("AZUL", false);
        coloresCalidos.put("VERDE", false);
        coloresCalidos.put("NARANJA", true);
 
        if (coloresCalidos.get("ROJO")){
            System.out.println("ROJO es cálido");
        }
        if (coloresCalidos.get("AZUL")){
            System.out.println("AZUL es cálido");
        }
        System.out.println("VERDE es " + coloresCalidos.get("VERDE"));
        
        for (Map.Entry<String, Boolean> par : coloresCalidos.entrySet()) {
            System.out.println("Clave:  " + par.getKey());
            System.out.println(" Valor: " + par.getValue());
        }
        
        assertEquals(coloresCalidos.get("AZUL"), false);
        assertEquals(coloresCalidos.size(), 5);

    }

    @Test
    public void mapsCoches() {
        Coche c1 = new Coche("c1 Fiat", "c1 matricula");
        Coche c2 = new Coche("c2 Ford", "c2 matricula");
        Coche c3 = new Coche("c3 BMW", "c3 matricula");
        Coche c4 = new Coche("c4 Kia", "c4 matricula");
        
        TreeMap<String, Coche> treeCoches = new TreeMap<>();
        treeCoches.put(c1.getMatricula(), c1);
        treeCoches.put(c2.getMatricula(), c2);
        treeCoches.put(c3.getMatricula(), c3);
        treeCoches.put(c4.getMatricula(), c4);
        
        treeCoches.forEach((k,v) -> {
            System.out.println("COCHE:     " + v.toString());
            System.out.println("MATRICULA: " + k + "\n");
        });
    }
}
