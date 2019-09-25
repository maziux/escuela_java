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
public class Pelota implements Rodable {

    @Override
    public byte getNumRuedas() {
        return 1;
    }
    @Override
    public void moverse() {
        
        System.out.println("Bota y rueda");
    }
}
