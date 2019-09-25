/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import clasesjava.StringAux;

/**
 *
 * @author alumno
 */
public class StringAuxV2 implements IStringAux {   
    
    @Override
    public String quitarEspacios(String str) {
        return StringAux.quitarEspSobrantesV2(str);
    }
    
}
