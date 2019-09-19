package ejemplojava;

public class Coche { // hereda de Object
    

   
    public static final int CAPACIDAD_DEPOSITO = 60;
    
    private final byte numRuedas;   // Valor constante por el final
    private final String marca;
    private final TipoCarburante carburante;
    private double nivDeposito;
    private boolean arrancado;
    private TipoColor color = TipoColor.ROJO;

    public Coche(String marca, TipoCarburante carburante, TipoColor color) {
        this.numRuedas = 4;
        this.marca = marca;
        this.color = color;
        this.carburante = carburante;
    }

    public Coche(String marca, TipoCarburante carburante, String color) {
        this.numRuedas = 4;
        this.marca = marca;
        //this.color = getStringColor(color.toUpperCase());
        //this.color = Enum.valueOf(Enums, color.toUpperCase());
        this.color = TipoColor.valueOf(color.toUpperCase());
        this.carburante = carburante;
    }

    /*
    private TipoColor getStringColor(String c){
        TipoColor resultado;
        switch(c.toUpperCase()) {
            case "BLANCO":
                resultado = TipoColor.BLANCO;
                break;
            case "NEGRO":
                resultado = TipoColor.NEGRO;
                break;
            case "ROJO":
                resultado = TipoColor.ROJO;
                break;
            case "VERDE":
                resultado = TipoColor.VERDE;
                break;
            case "AZUL":
                resultado = TipoColor.AZUL;
                break;
            case "PLATEADO":
                resultado = TipoColor.PLATEADO;
                break;
            default:
                resultado = TipoColor.BLANCO;
                break;
        }
        return resultado;
    }*/
    
    public double getNivelDep() {
        return nivDeposito;
    }

    public byte getNumRuedas() {
        return numRuedas;
    }
    
    public void echarCarburante(double cantidad) {
        if (cantidad > 0)
            this.nivDeposito += cantidad;
        
        if (nivDeposito > CAPACIDAD_DEPOSITO)
            nivDeposito = CAPACIDAD_DEPOSITO;
    }
    
    public void acelerar() {
        if (arrancado) {
            nivDeposito -= 0.1;
            explosionCilindro();
        }
    }
    
    public void vaciarDeposito() {
        // float nivelDeposito = 2;
        this.nivDeposito = 3;
        System.out.println("Deposito vaciado de " + this.toString()
                /*+ "\n   Nivel: " + nivelDeposito*/ );  
    }
    public String toString() {
        return "Coche " + marca + " color: " + this.color.toString() + " nivel " + nivDeposito;
    }
    public void mostrar() {
        System.out.println(this.toString()); 
    }

    public String getMarca() {
        return marca;
    }

    public boolean isArrancado() {
        return arrancado;
    }

    public double getNivDeposito() {
        return nivDeposito;
    }

    public void setArrancado(boolean arrancado) {
        this.arrancado = arrancado;
    }

    public void setColor(TipoColor color) {
        this.color = color;
    }

    public TipoColor getColor() {
        return color;
    }

    public TipoCarburante getCarburante() {
        return carburante;
    }
    
    protected void explosionCilindro() {
        System.out.println("Motor funcionando.");
    }
    
    protected void setNivelDeposito(double nuevoNiv){
        this.nivDeposito = nuevoNiv;
    }
}