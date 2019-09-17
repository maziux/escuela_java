package ejemplojava;

/**@author alumno
 */
public class Coche {
    
    private final byte numRuedas; // 'final' indica valor constante
    private String marca;
    private int capacidadDeposito;
    private boolean esGasolina;
    private double nivelDeposito;
    boolean arrancado;

    public Coche(String marca, int capacidadDeposito, boolean esGasolina){
        this.numRuedas = 4;
        this.marca = marca;
        this.capacidadDeposito = capacidadDeposito;
        this.esGasolina = esGasolina;
    }

    public int getCapacidadDeposito() {
        return capacidadDeposito;
    }

    public boolean isEsGasolina() {
        return esGasolina;
    }

    public double getNivelDeposito() {
        return nivelDeposito;
    }
   
    public boolean isArrancado() {
        return arrancado;
    }

    public void setArrancado(boolean arrancado) {
        this.arrancado = arrancado;
    }
    
    public byte getNumRuedas() {
        return numRuedas;
    }
        
    public double getNivelDep(){
        return nivelDeposito;
    }
    
    public void echarCarburante(double cantidad){
        if(cantidad > 0)
            this.nivelDeposito += cantidad;
        if (nivelDeposito > capacidadDeposito)
            nivelDeposito = capacidadDeposito;
    }
    
    public void acelerar(){
        if(arrancado) nivelDeposito -= 0.1;
    }
    
    public void vaciarDeposito() {
        this.nivelDeposito = 3;
        System.out.println("Deposito vaciado de " + this.toString()
            /*+ "\n   Nivel: " + this.nivelDeposito*/);
    }

    public String toString(){
        return "Coche " + marca + " nivel " + nivelDeposito;
    }
    
    public void mostrar(){
        System.out.println(this.toString());
    }

    public String getMarca() {
        return marca;
    }
}
