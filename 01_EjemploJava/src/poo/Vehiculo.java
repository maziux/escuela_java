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
public abstract class Vehiculo {
    
    protected String matricula;
    private final String marca;
    private TipoColor color = TipoColor.ROJO;
  
   /* public Vehiculo() { 
        this.matricula = "SIN MATRICULAR";
    }*/
    public Vehiculo(String marca, String matricula) { 
        this.matricula = matricula;
        this.marca = marca;
        this.color = TipoColor.BLANCO;
    }
    public Vehiculo(String marca, String matricula, TipoColor color) { 
        this.matricula = matricula;
        this.marca = marca;
        this.color = color;
    }
    public Vehiculo(String marca, String matricula, String color) { 
        this.matricula = matricula;
        this.marca = marca;
        this.color = TipoColor.valueOf(color.toUpperCase());
    }    
    @Override
    public String toString() {
        return "Vehiculo "+ this.getClass().toString()
                + ": "+ getMatricula() + ", " + getMarca() 
                + " color " + this.getColor().toString() ;
    }
    public abstract void abrirPuerta();
    public abstract void acelerar();
    
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }   
    public String getMarca() {
        return marca;
    }    
    public TipoColor getColor() {
        return color;
    }
    public void setColor(TipoColor color) {
        this.color = color;
    }
}
// VEHICULO DECLARA (NO IMPLEMENTA) ALGUNOS METODOS DE COCHE