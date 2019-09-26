package clasesjava;

import ejercicioHilos.Observer;

/** @author Indra Mon
 */
public class ObservaHilo implements Observer{
    boolean terminado = false;
    long tiempo;

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }
    
    @Override
    public void update(Object o, boolean terminado, long tiempo) {
        this.terminado = terminado;
        this.tiempo = tiempo;
    }
}
