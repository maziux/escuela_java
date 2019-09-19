package pruebas;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import poo.Coche;
import poo.CocheRally;
import poo.Moto;
import poo.Pelota;
import poo.Rodable;
import poo.TipoCarburante;
import poo.Vehiculo;

/**
 *
 * @author alumno
 */
public class TestAbstractInterfaces {
    
    //@Test
    public void abstractos() {
        Vehiculo miVehiculo;
        miVehiculo = new Vehiculo("Vehic.Matricula","Vehic.Marca") {
            @Override
            public void abrirPuerta() {
                System.out.println("Abriendo puertas...");
            }

            @Override
            public String toString() {
                return "Vehiculo " + getMarca() + " Matricula: " + getMatricula();
            }
            
            @Override
            public void acelerar() {
                System.out.println("Este no acelera.");
            }
            
            @Override
            public void echarCarburante(double cantidad) {
                System.out.println("No se le puede llenar el deposito.");
            }
        };

        Vehiculo miMoto = new Moto("MotoMatricula","MotoMarca");
        Vehiculo miCoche = new Coche("Ford");
        
        CocheRally miSupra = new CocheRally("TOYOTA",TipoCarburante.GASOLINA, "NEGRO", 2.1f);
        miSupra.echarCarburante(40);
        miSupra.mostrar();
        miSupra.setArrancado(true);
        miSupra.acelerar();
        miSupra.acelerar();
        miSupra.derrapar();
        miSupra.mostrar();
        
        
    }

    @Test
    public void interfaces() {
        Coche coche = new Coche("BMW", "555-HHH");
        coche.setArrancado(true);
        coche.echarCarburante(50);
        coche.moverse();
        coche.mostrar();
        
        Moto moto = new Moto("666-MMM","CBR 900");
        moto.moverse();
        moto.getNumRuedas();
        
        Pelota bola = new Pelota();
        bola.moverse();
        
        ArrayList<Rodable> cosasQueRueden = new ArrayList<>();
        cosasQueRueden.add(bola);
        cosasQueRueden.add(moto);
        cosasQueRueden.add(coche);
        
        for (Rodable rod: cosasQueRueden) {
            System.out.println(">> RODANDO -> " + rod.toString());
            System.out.println(" Ruedas: " + rod.getNumRuedas());
            rod.moverse();
        }
        
        
    }

}
