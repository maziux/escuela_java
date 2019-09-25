package poo;

public  class Coche extends Vehiculo implements Rodable { // hereda de Object
    
    public static final int CAPACIDAD_DEPOSITO = 60;
    
    private final byte numRuedas;   // Valor constante por el final
    private double nivDeposito;
    private boolean arrancado;
    private final TipoCarburante carburante;

    
    public Coche(String marca) {
        super(marca, "SIN MATRICULAR");
        this.numRuedas = 4;
        this.carburante = TipoCarburante.ELECTRICO;
    }
    public Coche(String marca, String matricula) {
        super(marca, matricula);
        this.numRuedas = 4;
        this.carburante = TipoCarburante.ELECTRICO;
    }
    public Coche(String marca, TipoCarburante carburante, TipoColor color) {
        super(marca, "SIN MATRICULAR", color);
        this.numRuedas = 4;
        this.carburante = carburante;
    }
    public Coche(String marca, TipoCarburante carburante, String color) {
        super(marca,"SIN MATRICULAR", color);
        this.numRuedas = 4;
        
       //  this.color = Enum.valueOf(TipoColor.class, color);
        
       /* switch (color) {
            case "ROJO": this.color = TipoColor.ROJO; break;
        }*/
        this.carburante = carburante;
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
    @Override
    public void acelerar() {
        if (arrancado)  {
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
    @Override
    public String toString() {
        return "Coche " + getMarca() + " color " + this.getColor().toString() + " nivel " + nivDeposito ;
    }
    public void mostrar() {
        System.out.println(this.toString()); 
    }


    public TipoCarburante getCarburante() {
        return carburante;
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

    
    protected void explosionCilindro() {
        System.out.println("Motor funcionando");
    }
    protected void setNivDeposito(double nuevoNiv) {
        this.nivDeposito = nuevoNiv;
    }

    @Override
    public void abrirPuerta() {
        if (arrancado)
            System.out.println("Abriendo puerta, cuidado coche encendido");
        else
            System.out.println("Abriendo puerta, cuidado coche encendido");
    }

    @Override
    public void moverse() {        
           System.out.println("AVANTI TUTO! "  + toString());
    }
}
