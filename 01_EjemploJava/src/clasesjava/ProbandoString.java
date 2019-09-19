package clasesjava;
/**@author Miguel Maseda
 */
public class ProbandoString {
    public static void tratarCadenas(){
        
        String texto = "En un lugar de la Mancha de cuyo nombre no quiero acordarme, vivía...";
        System.out.println(texto);
        System.out.println("Cuarta letra: " + texto.charAt(3));
        
        String texto2 = "En un lugar de Madrid...";
        System.out.println("Comparacion: " + texto.compareTo(texto2));
        
        texto2 = texto2.substring(0,10);
        System.out.println("texto2 ahora es: " + texto2);
        if(texto.contains(texto2))
            System.out.println("texto contiene texto2");
        else
            System.out.println("texto NO contiene texto2");
        
        System.out.println("\"Mancha\" está en la posición " + texto.indexOf("Mancha"));
        texto = texto.replace("lugar","bar");
        System.out.println(texto);
        String texto3 = "       en    un    LUGAR    ";
        //texto3 = texto3.toUpperCase().trim();
        System.out.println(texto3);
        
        /* con expresion regular
        String[] textoAux = texto3.split(" +");
        String texto4 = String.join(" ",textoAux);
        System.out.println(texto4);
        
        System.out.println("Total palabras: " + texto4.split(" ").length);
        */
        
        // sin expresiones regulares
        
        String[] textoAux = texto3.split(" ");
        int totalWords = 0;
        // contar palabras que no son espacio
        for(int i = 0; i < textoAux.length; i++) {
            //System.out.println("posAux:" + i + "contenido: " + textoAux[i]);
            if(textoAux[i].compareTo("") != 0)
                totalWords++;
        }
        
        // crear string con tamaño total totalWords y añadir palabras
        String[] textoAux2 = new String[totalWords];
        int auxN = 0;
        for(int i = 0; i < textoAux.length; i++) {
            if(textoAux[i].compareTo("") != 0) {
                textoAux2[auxN] = textoAux[i];
                auxN++;
            }
        }
        
        // mostrar resultado
        String textoFinal = String.join(" ",textoAux2);
        System.out.println(textoFinal + " Total palabras: " + textoAux2.length);

        
        /*
        // creando una subclase de String
        StringAux texto5 = new StringAux("    hola   adios   prueba  ");
        System.out.println(texto5.quitarEspacios());
        System.out.println(texto5.contarPalabras());
        */
        
        
    }

}
