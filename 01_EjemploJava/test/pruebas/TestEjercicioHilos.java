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
    
    public TestEjercicioHilos() {
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
    
    
    public static void leerFicheroEjemHilos() {
        Thread hiloLeerFicheroV1 = new Thread() {
         //   HiloFichero hf1 = new HiloFichero();
        };
        
        Thread hiloLeerFicheroV2 = new Thread() {
            
        };
        
        Thread hiloLeerFicheroV3 = new Thread() {
            
        };
        
        Thread hiloLeerFicheroV4 = new Thread() {
            
        };
    }
}
