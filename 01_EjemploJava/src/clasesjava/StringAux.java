package clasesjava;
/**@author Miguel Maseda
 */
public class StringAux{
    
    private String string;
    
    public StringAux(String string){
        this.string = string;
    }
    
    public String getString() {
        return string;
    }
    
    public void setString(String string) {
        this.string = string;
    }
    
    public String quitarEspSobrantes() {
        return quitarEspSobrantes(string);
    }
    
    public int contarPalabras(){
        return contarPalabras(string);
    }
    
    public static String quitarEspSobrantesV1(String texto) {
        // Recorrer carácter a carácter quitando los sobrantes
        String result = "";
        texto = texto.trim() + " ";
        for (int i = 0; i < texto.length() - 1; i++) {
            if (texto.charAt(i) != ' ') {
                result += texto.charAt(i);
            } else {
                if (texto.charAt(i+1) != ' ') {
                    result += ' ';
                }
            }
        }
        return result;
    }
    
    public static String quitarEspSobrantesV2(String texto) {
        texto = texto.trim();
        String[] palabras = texto.split(" ");
        String result = "";
        for (String palabra : palabras) {
            result += palabra.isEmpty() ? "" : palabra + " ";
        }
        return result.trim();
    }
    
    public static String quitarEspSobrantesV3(String texto) {
        texto = texto.trim();
        while(texto.contains("  "))
            texto = texto.replace("  ", " ");
        return texto;
    }
    
    public static String quitarEspSobrantes(String texto) {
        return texto.trim().replaceAll(" +", " ");
    }
    
    public static int contarPalabras(String texto) {
        texto = texto.trim();
        if (texto.isEmpty())
            return 0;
        else
            return quitarEspSobrantes(texto).split(" ").length;
    }
    
    /*
    public String quitarEspacios() {
        
        String[] textoAux = str.split(" ");
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
        return textoFinal;
    }
  
    public int contarPalabras() {
        String aux = this.quitarEspacios();
        return aux.split(" ").length;
    }
    */
}
