/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alumno
 */
public class TestEjemploHilos {
    
    public class ProcesoA extends Thread {

        @Override
        public void run() {
            // super.run(); //To change body of generated methods, choose Tools | Templates.
            mostrarLista();
        }        
        public void mostrarLista(){
            for (int i = 0; i < 200; i++) {
                System.out.println("> Proceso A: " + i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TestEjemploHilos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    

 
    @Test
    public void probandoClasesConNombre() throws InterruptedException {
        ProcesoA procA = new ProcesoA();
        Thread procB = new Thread() {
            @Override
            public void run(){
                for (int i = 0; i < 200; i++) {
                    try {
                        System.out.println("Proceso B:   " + i);
                        Thread.sleep(3);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TestEjemploHilos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        
        procA.start(); // se llama al método start no al run. Si llamamos al
                       // run, se ejecuta en el hilo principal.
        procB.start();
        procA.suspend();
        Thread.sleep(20);
        procA.resume();
        try {
            procA.join();
            procB.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestEjemploHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
