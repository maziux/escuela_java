/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

/**
 *
 * @author alumno
 */
public class Moto extends Vehiculo implements Rodable {

    public static final byte RUEDAS = 2;
    
    public Moto(String marca) {
        super(marca, "SIN MATRICULAR");
    }
    @Override
    public void abrirPuerta() {        
        // System.out.println(  "Loco, no hay puertas, no te tires");
    }

    @Override
    public void acelerar() {
        System.out.println("Moto " + getMatricula() + "acelerando ");
    }

    @Override
    public byte getNumRuedas() {
        return RUEDAS;
    }

    @Override
    public void moverse() {
        System.out.println("Moviendo motillo " + toString());
    }
}
