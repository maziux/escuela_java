package stringAuxVarios;
/**@author Miguel Maseda
 */
public class StringAux_v2 implements IStringAux{

    
    private String string;

    public StringAux_v2(){
    }

    
    public StringAux_v2(String string){
        this.string = string;
    }
    
    public String getString() {
        return string;
    }
    
    public void setString(String string) {
        this.string = string;
    }    

    @Override
    public String quitarEspaciosSobrantes() {
        return quitarEspSobrantesV2(string);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
