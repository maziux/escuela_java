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
public class HiloFicheroStrAuxV3 extends HiloFichero {

    public HiloFicheroStrAuxV3(IStringAux strAux) {
        super(strAux);
    }

    @Override
    protected String quitarEspacios(String s) {
        return StringAux.quitarEspSobrantesV3(s);
    }
    
}