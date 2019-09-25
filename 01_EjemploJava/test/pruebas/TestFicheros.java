/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import org.junit.Test;
import static org.junit.Assert.*;
import stringAuxVarios.StringAux_v1;
import threads.HiloFichero;

/**
 *
 * @author alumno
 */
public class TestFicheros {
    
    public TestFicheros() {
    }

    /*  
    //@Test
    public void generacionFicheroAleatorio() {
        HiloFichero.crearFicheroEjem("C:\\Users\\alumno\\Desktop\\ESCUELA_JAVA\\escuela_java.git\\01_EjemploJava\\texto_esp.txt");
    }*/
    @Test
    public void leerFicheroAleatorio() {
        StringAux_v1 str1 = new StringAux_v1();
        String ruta = "C:\\Users\\alumno\\Desktop\\ESCUELA_JAVA\\escuela_java.git\\01_EjemploJava\\texto_esp.txt";
        HiloFichero test = new HiloFichero(ruta,str1);
        
        test.leerFicheroEjem(ruta);
    }

}
