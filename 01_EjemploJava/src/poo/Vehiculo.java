package poo;

/**@author Miguel Maseda
 */
public abstract class Vehiculo {

    private static final int CAPACIDAD_DEPOSITO = 60;
    private final String matricula;
    private final String marca;
    private double nivDeposito;
    private boolean arrancado;
    
    public Vehiculo(String matricula, String marca) {
        this.matricula = matricula;
        this.marca = marca;
    }
    
    public abstract void echarCarburante(double cantidad);
    
    public abstract void acelerar();
    
    public abstract void abrirPuerta(); 
    
    @Override
    public abstract String toString();
    
    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public static int getCAPACIDAD_DEPOSITO() {
        return CAPACIDAD_DEPOSITO;
    }

    public double getNivDeposito() {
        return nivDeposito;
    }
    
    public void modificarNivDeposito(double gastado){
        nivDeposito = getNivDeposito() + gastado;
        if (nivDeposito < 0)
            System.out.println("Te has quedado sin Gasolina!");
        if (nivDeposito > CAPACIDAD_DEPOSITO) {
            System.out.println("Deposito lleno!");
            nivDeposito = CAPACIDAD_DEPOSITO;
        }            
    }

    public boolean isArrancado() {
        return arrancado;
    }    

    public void setArrancado(boolean arrancado) {
        this.arrancado = arrancado;
    }    

    public void vaciarDeposito() {
        // float nivelDeposito = 2;
        this.nivDeposito = 3;
        System.out.println("Deposito vaciado de " + this.toString()
                /*+ "\n   Nivel: " + nivelDeposito*/ );
    }
}
