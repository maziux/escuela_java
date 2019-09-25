/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojava;

import clasesjava.ProbandoString;
import poo.Coche;
import poo.CocheRally;
import ejemplojava.NewClass;
import poo.TipoCarburante;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        // ProbandoString.tratarCadenas();
        mainCoches(args);
    }
    /**
     * @param args the command line arguments
     */
    public static void mainCoches(String[] args) {
        
        NewClass nc = new NewClass();
           
        
        System.out.println("Empezando POO");
        Coche miCoche;
        
       // miCoche = new Coche("Kia", TipoCarcubrante.GASOLINA, TipoColor.BLANCO); // La instanciacion se hace con new
        miCoche = new Coche("Kia", TipoCarburante.GASOLINA, "BlANCO"); // La instanciacion se hace con new
        
        miCoche.echarCarburante(30); // Empezamos con medio deposito
        
        System.out.println("Todos los coches tienen: " + Coche.CAPACIDAD_DEPOSITO);
        System.out.println("Coche creado: " + miCoche.getMarca());
        System.out.println("Nivel deposito: " + miCoche.getNivDeposito() + " litros");
        
        
        Coche otroCoche = miCoche; // new Coche();
        // otroCoche.marca = "Seat"; YA NO SE PUEDE
        System.out.println("Coche creado: " + otroCoche.getMarca());
        // vaciarDeposito(miCoche);
        miCoche.vaciarDeposito();
        System.out.println("Nivel deposito: " + otroCoche.getNivDeposito()+ " litros");
        
        miCoche.setArrancado(true);
        miCoche.echarCarburante(-2);
        for (int i = 0; i < 3; i++) 
            miCoche.acelerar();
        
        miCoche.mostrar();
        
        CocheRally miSupra = new CocheRally("TOYOTA", TipoCarburante.GASOLINA, "NEGRO", 2.1f);
        miSupra.echarCarburante(40);
        miSupra.setArrancado(true);
        miSupra.acelerar();
        miSupra.acelerar();
        miSupra.derrapar();
        //miSupra.setNivDeposito(4); Solo dentro del paquete
        //miSupra.explosionCilindro();
        miSupra.mostrar();
        
        Coche supraNormal = miSupra;    // Conversión implícita
        //supraNormal.explosionCilindro();
        // supraNormal.derrapar();
        supraNormal.acelerar();
        supraNormal.mostrar();
        
        CocheRally cr = (CocheRally) supraNormal;   // Conversión explícita ó casting
        System.out.println("Y el rozamiento?? " + cr.getRozamiento());
        
        // Esto lanza excepcion:        
       /* cr = (CocheRally) miCoche;
        System.out.println("Y el rozamiento?? " + cr.getRozamiento());*/
    }    
}
