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
        return new HiloFicheroStrAuxV2(new StringAuxV2());
    }

    public static HiloFichero HiloFichero3() {
        return new HiloFicheroStrAuxV3(new StringAuxV3());
    }

    public static HiloFichero HiloFichero4() {
        return new HiloFicheroStrAuxV2(new StringAuxV4());
    }
}
