/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author alumno
 */
public class FactoriaHiloFich {
   
    public static HiloFichero HiloFichero1() {
        return new HiloFicheroStrAuxV1(new StringAuxV1());
    }
    public static HiloFichero HiloFichero2() {
        return new HiloFicheroStrAuxV2(new StringAuxV1());
    }
}
