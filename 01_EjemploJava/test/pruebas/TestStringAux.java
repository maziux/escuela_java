/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import clasesjava.StringAux;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alumno
 */
public class TestStringAux {

    @Test
    public void probandoQuitarEspacios() {
        
        String texto = "En un lugar de la Mancha de cuyo nombre no quiero acordarme, vivía...";
        String texto2 = "En un lugar de Madrid...";
        String texto3 = "       en    un    LUGAR";
        
        String resultadoOk = "en un LUGAR";
        StringAux texto3Aux = new StringAux(texto3);
        String resultadoAux = texto3Aux.quitarEspSobrantes(); // futura llamada
        assertEquals(resultadoOk, resultadoAux);
        assertEquals("En un lugar de Madrid...", StringAux.quitarEspSobrantes("      En un lugar de Madrid..."));
    }
    
    @Test
    public void probandoContarPalabras() {
        assertEquals(5,StringAux.contarPalabras("      En un lugar de Madrid..."));
        assertEquals(3,StringAux.contarPalabras("       en    un    LUGAR"));
        assertEquals(0,StringAux.contarPalabras("     "));
        assertEquals(1,StringAux.contarPalabras("LUGAR"));
    }
}
