package poo;

public class Coche extends Vehiculo implements Rodable{ // hereda de Object

    
    //public static final int CAPACIDAD_DEPOSITO = 60; de vehiculo
    
    //private double nivDeposito; de vehiculo
    //private final String marca; de vehiculo
    private final TipoCarburante carburante;
    //private boolean arrancado; de vehiculo
    private TipoColor color = TipoColor.ROJO;    
    private final byte numRuedas;   // Valor constante por el final

    public Coche(String marca, String matricula) {
        super(matricula,marca);
        this.numRuedas = 4;
        //this.marca = marca;
        this.color = TipoColor.BLANCO;
        this.carburante = TipoCarburante.ELECTRICO;
    }

    public Coche(String marca) {
        super("matrícula prueba",marca);
        this.numRuedas = 4;
        //this.marca = marca;
        this.color = TipoColor.BLANCO;
        this.carburante = TipoCarburante.ELECTRICO;
    }
    
    public Coche(String marca, TipoCarburante carburante, TipoColor color) {
        super("matricula prueba", marca);
        this.numRuedas = 4;
        //this.marca = marca;
        this.color = color;
        this.carburante = carburante;
    }

    public Coche(String marca, TipoCarburante carburante, String color) {
        super("matricula prueba", marca);
        this.numRuedas = 4;
        //this.marca = marca;
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
    
    @Override
    public byte getNumRuedas() {
        return numRuedas;
    }
    
    @Override
    public void acelerar() {
        if (isArrancado()) {
            modificarNivDeposito(-0.1);
            explosionCilindro();
        }
    }

    @Override
    public void echarCarburante(double cantidad) {
        if (cantidad > 0)
            modificarNivDeposito(cantidad);
        }   
    
    @Override
    public String toString() {
        return "Coche " + getMarca() + " Matricula: " + getMatricula() + " color: " + this.color.toString() + " nivel " + getNivDeposito();
    }
    public void mostrar() {
        System.out.println(this.toString()); 
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

    @Override
    public void abrirPuerta() {
        System.out.println("Abriendo puertas del coche.");
    }

    @Override
    public void moverse() {
    
        System.out.println("AVANTI TUTO! " + toString());
    }
}