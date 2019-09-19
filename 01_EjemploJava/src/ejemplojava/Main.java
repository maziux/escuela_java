/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojava;
import poo.TipoCarburante;
import poo.Coche;
import poo.CocheRally;
import clasesjava.ProbandoString;
import poo.Vehiculo;

/**
 *
 * @author Admin
 */
public class Main {

    public static void mainString(String[] args){
        ProbandoString.tratarCadenas();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Empezando POO");
        Coche miCoche;
        
        miCoche = new Coche("Kia",TipoCarburante.GASOLINA,"RoJO"); // La instanciacion se hace con new
        
        
        miCoche.echarCarburante(30); // Empezamos con medio deposito
        
        System.out.println("Todos los coches tienen: " + Vehiculo.getCAPACIDAD_DEPOSITO());
        System.out.println("Coche creado: " + miCoche.getMarca());
        System.out.println("Nivel deposito: " + miCoche.getNivDeposito() + " litros");
        
        
        Coche otroCoche = miCoche; // new Coche();
        // otroCoche.marca = "Seat"; YA NO SE PUEDE
        System.out.println("Coche creado: " + otroCoche.getMarca());
        // vaciarDeposito(miCoche);
        miCoche.vaciarDeposito();
        //System.out.println("Nivel deposito: " + otroCoche.getNivelDep() + " litros");
        
        miCoche.setArrancado(true);
        miCoche.echarCarburante(-2);
        for (int i = 0; i < 3; i++) 
            miCoche.acelerar();
        
        miCoche.mostrar();
        
        CocheRally miSupra = new CocheRally("TOYOTA",TipoCarburante.GASOLINA, "NEGRO", 2.1f);
        miSupra.echarCarburante(40);
        miSupra.mostrar();
        miSupra.setArrancado(true);
        miSupra.acelerar();
        miSupra.acelerar();
        miSupra.derrapar();
        miSupra.mostrar();
        
        Coche supraNormal = miSupra; // Conversion implicita.
        supraNormal.mostrar();
        //supraNormal.explosionCilindro();
        // supraNormal.derrapar(); -> ya no tiene este método
        // supraNormal - polimorfismo cambio clase a padre
        // pero método acelerar sigue llamando al del hijo
        supraNormal.acelerar();
        supraNormal.mostrar();
        
        CocheRally cr = (CocheRally) supraNormal; // Conversión explícita o casting
        System.out.println("Y el rozamiento?? " + cr.getRozamiento());
        cr.mostrar();
        
        /*
        cr = (CocheRally) miCoche;
        System.out.println("Y el rozamiento?? " + cr.getRozamiento());
        */
        
    }    
}