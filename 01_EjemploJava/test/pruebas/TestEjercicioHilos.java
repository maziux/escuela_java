/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import org.junit.Test;
import static org.junit.Assert.*;
import threads.FactoriaHiloFich;
import threads.HiloFichero;

/**
 *
 * @author alumno
 */
public class TestEjercicioHilos {
    

    public void strSecuencial(){
        String ruta = "C:\\Users\\alumno\\Desktop\\ESCUELA_JAVA\\escuela_java.git\\01_EjemploJava\\texto_esp.txt";
        HiloFichero hf_1 = FactoriaHiloFich.HiloFichero1();
        HiloFichero hf_2 = FactoriaHiloFich.HiloFichero2();
        HiloFichero hf_3 = FactoriaHiloFich.HiloFichero3();
        HiloFichero hf_4 = FactoriaHiloFich.HiloFichero4();
        hf_1.leerFicheroEjem(ruta);
        hf_2.leerFicheroEjem(ruta);
        hf_3.leerFicheroEjem(ruta);
        hf_4.leerFicheroEjem(ruta);
    }

    

    @Test
    public void testTiempo() {}
}
