package ejemplojava;

/**@author alumno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        System.out.println("Empezando POO");
        Coche miCoche;
        
        miCoche = new Coche("kia", 60, true); // La instancia se hace con new
        //miCoche.marca = "Kia";
        //miCoche.capacidadDeposito = 60;
        //miCoche.numRuedas = 4;
        //miCoche.esGasolina = true;
        miCoche.echarCarburante(30);
        
        System.out.println("Coche creado: " + miCoche.getMarca());
        System.out.println("Nivel deposito: " + miCoche.getNivelDep() + " litros");
        
        Coche otroCoche = miCoche; //new Coche();
        //otroCoche.marca = "Seat";
        
        System.out.println("Coche creado: " + otroCoche.getMarca());
        miCoche.vaciarDeposito();
        System.out.println("Nivel deposito: " + otroCoche.getNivelDep() + " litros");
        
        miCoche.arrancado = true;
        miCoche.echarCarburante(-2);
        for(int i = 0; i < 3; i++)
            miCoche.acelerar();
        
        miCoche.mostrar();
    }
}
