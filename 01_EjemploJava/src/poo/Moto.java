package poo;
/**@author Miguel Maseda
 */
public class Moto extends Vehiculo implements Rodable{

    public static final byte RUEDAS = 2;
    
    public Moto(String matricula, String marca) {
        super(matricula, marca);
    }
    @Override
    public void abrirPuerta() {
        System.out.println("Loco, no hay puertas, no te tires.");
    }

    @Override
    public String toString() {
        return "Moto " + getMarca() + " Matricula: " + getMatricula();
    }

    @Override
    public void echarCarburante(double cantidad) {
        System.out.println("No tiene definido la cantidad de carburante!");
    }

    @Override
    public void acelerar() {
        if (isArrancado()) {
            modificarNivDeposito(-0.2);
            //explosionCilindro();
        }
    }

    @Override
    public byte getNumRuedas() {
        return RUEDAS;
    }

    @Override
    public void moverse() {
        System.out.println("Nos movemos! " + toString());
    }

}
