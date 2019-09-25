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
public class CocheRally extends Coche {
    private float rozamiento;
            
    public CocheRally(String marca) {
        super(marca);
        this.rozamiento = 3.1416f;
    }     
    public CocheRally(String marca, TipoCarburante carburante, TipoColor color, float roz) {
        super(marca, carburante, color);
        this.rozamiento = roz;
    }     
    // Sobre carga de constructor
    public CocheRally(String marca, TipoCarburante carburante, String color, float roz) {
        super(marca, carburante, color);
        this.rozamiento = roz;
    }
    public void derrapar() {
        System.out.println("Derrapeeeee!");
        super.explosionCilindro();
    }
    // Sobre carga de método
    public void derrapar(float cuanto) {
        System.out.println("Derrapeeeee de " + cuanto + " newtons!");
        super.explosionCilindro();
    }
    // SOBRE ESCRITURA DE MÉTODOS
    @Override
    public void acelerar() {
        System.out.println("Acelerando a lo rally ");
        if (this.isArrancado())  {
            super.acelerar();
            setNivDeposito(getNivDeposito() - .4);
            // nivDeposito -= 0.1;
            explosionCilindro();
        }
    }

    public float getRozamiento() {
        return rozamiento;
    }

    public void setRozamiento(float rozamiento) {
        this.rozamiento = rozamiento;
    }
    
}
