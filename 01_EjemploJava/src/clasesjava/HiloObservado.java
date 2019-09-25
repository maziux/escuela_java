package clasesjava;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Indra Mon
 */
public class HiloObservado extends Observable {

    private Thread hilo;
    private List<ObservaHilo> observers = new ArrayList();

    public HiloObservado(Thread hilo) {
        this.hilo = hilo;
    }

    public void addObserver(ObservaHilo observador) {
        this.observers.add(observador);
    }

    public void removeObserver(ObservaHilo observador) {
        this.observers.remove(observador);
    }

    public void ejecutarHilo() {
        long start = new Date().getTime();
        long finish;
        hilo.start();
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        while (hilo.isAlive()) {

        }
        finish = new Date().getTime() - start;
        
        if (!hilo.isAlive()) {
            observers.forEach((observer) -> {
                observer.update(true, finish);
            });
        }

    }

}
