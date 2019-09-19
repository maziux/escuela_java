package poo;
/**@author Miguel Maseda
 */
public class CocheRally extends Coche {
    
    private float rozamiento;
 
    public CocheRally(String marca) {
        super(marca);
        this.rozamiento = 3.1416f;
    }    

    public CocheRally(String marca, TipoCarburante carburante, TipoColor color, float roz) {
        super(marca,carburante,color);
        this.rozamiento = roz;
    }
    
    // Sobre carga de constructor
    public CocheRally(String marca, TipoCarburante carburante, String color, float roz) {
        super(marca,carburante,color);
        this.rozamiento = roz;
    }

    public void derrapar() {
        System.out.println("Derrapee!");
        super.explosionCilindro();
    }

    // Sobre carga de método
    public void derrapar(float cuanto) {
        System.out.println("Derrapee de " + cuanto + "newtons!");
        super.explosionCilindro();
    }

    // Sobre escritura de método
    @Override
    public void acelerar() {
        System.out.println("Acelerando a lo rally!");
        if (this.isArrancado()) {
            super.acelerar();
            modificarNivDeposito(-0.5);
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
