package threads;

import clasesjava.StringAux;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import stringAuxVarios.StringAux_v1;
import stringAuxVarios.StringAux_v2;

/**@author Miguel Maseda
 */
public class HiloFichero {
    
    private String rutaFich;
    private StringAux_v1 strAux1;
    private StringAux_v2 strAux2;
    
    public HiloFichero(String ruta, StringAux_v1 strAux_v){
        this.rutaFich = ruta;
        this.strAux1 = strAux_v;
        this.strAux2 = null;        
    }
    public HiloFichero(String ruta, StringAux_v2 strAux_v){
        this.rutaFich = ruta;
        this.strAux1 = null;
        this.strAux2 = strAux_v;        
    }

    public void crearFicheroEjem(String rutaFich) /*
    throws IOException */{
        String[] palabras = new String['Z' - 'A' + 1];
        Random r = new Random(new Date().getTime());
        
        for (char c = 'A'; c < 'Z'+1; c++) {
            int repe = 2 + Math.abs(r.nextInt() % 8); // Número aleatorio entre 2 y 9
            palabras[c - 'A'] = "";
            for (int i = 0; i < repe; i++)
                palabras[c - 'A'] += "" + c;
        }
        System.out.println("" + Arrays.toString(palabras));
        
        // Crear fichero
        FileWriter fich = null;
        try {
            fich = new FileWriter(rutaFich, false);
            for (int i = 0; i < 200000; i++) {
                // r.nextInt(n) -> devuelve número aleatorio entre 0 y n-1
                if (r.nextInt(2) == 0)
                    fich.write(palabras[r.nextInt(palabras.length)]);
                if (r.nextInt(2) == 0)
                    for (int j = 0; j < 5; j++)
                        fich.write(" ");
                if (r.nextInt(12) == 0)
                    fich.write("\n\r");
            }
        } catch(IOException ex) {
            System.err.println("Error en escritura: " + ex.getMessage());
        } catch(Exception ex) {
            System.err.println("Otro error: " + ex.getMessage());
        } finally {
            try {
                if (fich != null) {
                    fich.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(HiloFichero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }

    public void leerFicheroEjem(String rutaFich) {
        File fich = new File(rutaFich);
        Scanner escaner = null;
        try {
            escaner = new Scanner(fich);
            while(escaner.hasNextLine()) {
                String linea = escaner.nextLine();
                // V1
                if (strAux1 != null) {
                    strAux1.setString(linea);
                    System.out.println(strAux1.quitarEspaciosSobrantes());
                }
                // V2
                if (strAux2 != null) {
                    strAux2.setString(linea);
                    System.out.println(strAux2.quitarEspaciosSobrantes());
                }
                //System.out.println(linea);
                
                // V0
                //StringAux strAux = new StringAux(linea);
                //System.out.println(strAux.quitarEspSobrantes());
                
                // V1
                //StringAux_v1 strAux = new StringAux_v1(linea);

                // v2
                //StringAux_v2 strAux = new StringAux_v2(linea);
                //System.out.println(strAux.quitarEspaciosSobrantes());
            }
        } catch(Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (escaner != null) {
                    escaner.close();
                }
            } catch (Exception ex) {
                Logger.getLogger(HiloFichero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
