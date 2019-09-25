/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import threads.FactoriaHiloFich;
import threads.HiloFichero;

/**
 *
 * @author alumno
 */
public class TestEjercicioHilos {

    final static String RUTA = "./texto_esp.txt";

    public void leerFicheroEjemSecuencial() {
        HiloFichero hf_1 = FactoriaHiloFich.HiloFichero1();
        HiloFichero hf_2 = FactoriaHiloFich.HiloFichero2();
        HiloFichero hf_3 = FactoriaHiloFich.HiloFichero3();
        HiloFichero hf_4 = FactoriaHiloFich.HiloFichero4();
        hf_1.leerFicheroEjem(RUTA);
        hf_2.leerFicheroEjem(RUTA);
        hf_3.leerFicheroEjem(RUTA);
        hf_4.leerFicheroEjem(RUTA);

    }

    public ArrayList<Long> leerFicheroEjemHilos() {

        Thread hiloLeerFicheroV1 = new Thread() {
            @Override
            public void run() {
                HiloFichero hf_1 = FactoriaHiloFich.HiloFichero1();
                hf_1.leerFicheroEjem(RUTA);
            }
        };

        Thread hiloLeerFicheroV2 = new Thread() {
            @Override
            public void run() {
                HiloFichero hf_2 = FactoriaHiloFich.HiloFichero2();
                hf_2.leerFicheroEjem(RUTA);
            }
        };

        Thread hiloLeerFicheroV3 = new Thread() {
            @Override
            public void run() {
                HiloFichero hf_3 = FactoriaHiloFich.HiloFichero3();
                hf_3.leerFicheroEjem(RUTA);
            }
        };

        Thread hiloLeerFicheroV4 = new Thread() {
            @Override
            public void run() {
                HiloFichero hf_4 = FactoriaHiloFich.HiloFichero4();
                hf_4.leerFicheroEjem(RUTA);
            }
        };

        long start1, start2, start3, start4, end1, end2, end3, end4;

        hiloLeerFicheroV1.start();
        hiloLeerFicheroV2.start();
        hiloLeerFicheroV3.start();
        hiloLeerFicheroV4.start();
        try {
            hiloLeerFicheroV1.join();
            
            hiloLeerFicheroV2.join();
            hiloLeerFicheroV3.join();
            hiloLeerFicheroV4.join();
        } catch (InterruptedException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return new ArrayList<Long>();
    }

    @Test
    public void medirTiempos() {
        long start1 = new Date().getTime();
        leerFicheroEjemSecuencial();
        long end1 = new Date().getTime() - start1;

        long start2 = new Date().getTime();
        leerFicheroEjemHilos();
        long end2 = new Date().getTime() - start2;

        System.out.println("Con secuencial tardamos " + end1 + " milisegundos");
        System.out.println("Con hilos tardamos " + end2 + " milisegundos");

    }
}
