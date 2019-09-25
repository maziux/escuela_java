/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesjava;

/**
 *
 * @author alumno
 */
public  class ProbandoString 
{
    public static void tratarCadenas() 
    {
        String texto = "En un lugar de la Mancha de cuyo nombre no quiero acordarme, vivía...";
        System.out.println(texto);
        System.out.println("Cuarta letra " + texto.charAt(3));
        // Comparaciones
        String texto2 = "En un lugar de Madrid...";
        System.out.println("Comparacion: " + texto.compareTo(texto2));
        
        texto2 = texto2.substring(0, 10);
        System.out.println("texto2 ahora es " + texto2);
        
        if (texto.contains(texto2))
            System.out.println("texto contiene texto 2");
        else
            System.out.println("texto NO contiene texto 2");
        
        System.out.println("\"Mancha\" está en la posicion " + texto.indexOf("Mancha") );
        texto = texto.replace("lugar", "bar");
        System.out.println(texto);
        String texto3 = "        en   un     LUGAR    ";
        texto3 = texto3.toUpperCase().trim();
        System.out.println(texto3);
    }
}
