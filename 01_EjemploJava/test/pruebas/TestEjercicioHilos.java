/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import clasesjava.HiloObservado;
import clasesjava.ObservaHilo;
import java.util.ArrayList;
import java.util.Date;
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

    public ArrayList<Long> leerFicheroEjemSecuencial() {
        ArrayList<Long> myArr = new ArrayList<>();
        HiloFichero hf_1 = FactoriaHiloFich.HiloFichero1();
        HiloFichero hf_2 = FactoriaHiloFich.HiloFichero2();
        HiloFichero hf_3 = FactoriaHiloFich.HiloFichero3();
        HiloFichero hf_4 = FactoriaHiloFich.HiloFichero4();

        long start = new Date().getTime();
        hf_1.leerFicheroEjem(RUTA);
        long end = new Date().getTime() - start;
        myArr.add(end);

        start = new Date().getTime();
        hf_2.leerFicheroEjem(RUTA);
        end = new Date().getTime() - start;
        myArr.add(end);

        start = new Date().getTime();
        hf_3.leerFicheroEjem(RUTA);
        end = new Date().getTime() - start;
        myArr.add(end);

        start = new Date().getTime();
        hf_4.leerFicheroEjem(RUTA);
        end = new Date().getTime() - start;
        myArr.add(end);

        return myArr;
    }

    public void leerFicheroEjemHilos() {

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

        HiloObservado leerFicheroV1Observed = new HiloObservado(hiloLeerFicheroV1);
        HiloObservado leerFicheroV2Observed = new HiloObservado(hiloLeerFicheroV2);
        HiloObservado leerFicheroV3Observed = new HiloObservado(hiloLeerFicheroV3);
        HiloObservado leerFicheroV4Observed = new HiloObservado(hiloLeerFicheroV4);

        ObservaHilo observador1 = new ObservaHilo();
        ObservaHilo observador2 = new ObservaHilo();
        ObservaHilo observador3 = new ObservaHilo();
        ObservaHilo observador4 = new ObservaHilo();

        leerFicheroV1Observed.addObserver(observador1);
        leerFicheroV2Observed.addObserver(observador2);
        leerFicheroV3Observed.addObserver(observador3);
        leerFicheroV4Observed.addObserver(observador4);

        leerFicheroV1Observed.ejecutarHilo();
        leerFicheroV2Observed.ejecutarHilo();
        leerFicheroV3Observed.ejecutarHilo();
        leerFicheroV4Observed.ejecutarHilo();


        System.out.println(observador1.getTiempo());
        System.out.println(observador2.getTiempo());
        System.out.println(observador3.getTiempo());
        System.out.println(observador4.getTiempo());
    }

    @Test
    public void medirTiempos() {
        ArrayList<Long> metodoSecuencial = new ArrayList<>();
        long start1 = new Date().getTime();
        metodoSecuencial.addAll(leerFicheroEjemSecuencial());
        long end1 = new Date().getTime() - start1;
        
        long start2 = new Date().getTime();
        leerFicheroEjemHilos();
        long end2 = new Date().getTime() - start2;

        
        for (int i = 0; i < metodoSecuencial.size(); i++) {
            System.out.println("Metodo_"+i+" tarda: " + metodoSecuencial.get(i));
        }
        System.out.println("Con secuencial tardamos " + end1 + " milisegundos");
        System.out.println("Con hilos tardamos " + end2 + " milisegundos");


    }
}
