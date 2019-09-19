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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alumno
 */
public class TestColecciones {
    
    @Test
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
}
