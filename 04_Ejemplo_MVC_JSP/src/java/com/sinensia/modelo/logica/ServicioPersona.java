/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.modelo.logica;

import com.sinensia.modelo.Persona;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Singleton porque sólo queremos un servicio por aplicación/servidor
 *
 * @author alumno
 */
public class ServicioPersona {

// <editor-fold defaultstate="collapsed" desc="Código patrón de diseño Singleton.">
    private static ServicioPersona instancia;

    private ServicioPersona() {
        personas = new ArrayList<>();
    }

    public static ServicioPersona getInstancia() {
        if (instancia == null) {
            instancia = new ServicioPersona();
        }
        return instancia;
    }// </editor-fold>

    private ArrayList<Persona> personas;

    public Persona addPersonas(String nombre, String edad)
            throws NumberFormatException, IOException, IllegalArgumentException {

        if (nombre.equals("")) {
            throw new IllegalArgumentException("El nombre es vacío");
        } else if (nombre.length() < 2) {
            throw new IllegalArgumentException("El nombre es demasiado corto");
        } else if (edad.equals("")) {
            throw new NumberFormatException("La edad está vacía");
        } else {
            int intEdad = Integer.parseInt(edad);
            if (intEdad <= 12) {
                throw new IllegalArgumentException("La edad debe ser mayor que 12");
            } else {
                Persona p = new Persona(nombre, intEdad);
                personas.add(p);
                return p;
            }
        }
    }

<<<<<<< HEAD
    public Persona getPersona(String nombre) {
        for (Persona p : personas) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
=======
    public ArrayList<Persona> buscarPersonasPorNombres(String listaNombres) {
        ArrayList<Persona> personasEncontradas = new ArrayList<>();
        if (listaNombres == null) {
            return personasEncontradas;
        }
        String[] nombres = listaNombres.split(",");
        for (String nombre : nombres) {
            for(Persona p: personas) {
                if(p.getNombre().equalsIgnoreCase(nombre.trim())){
                    personasEncontradas.add(p);
                }
            }
        }
        return personasEncontradas;
    }

    public ArrayList<Persona> buscarPersonasPorMails(String listaMails) {
        ArrayList<Persona> personasEncontradas = new ArrayList<>();
        if (listaMails == null) {
            return personasEncontradas;
        }
        String[] mails = listaMails.split(",");
        for(String mail : mails){
            personas.stream().filter((p) ->(p.getMail().equals(mail.trim()))).forEachOrdered((p) ->{
                personasEncontradas.add(p);
            });
        }
        return personasEncontradas;
>>>>>>> 94af767086859bea7808098e8ad27c5046918aee
    }

    public boolean removePersona(String nombre) {
        Persona perElim = null;
        for (Persona p : personas) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                perElim = p;
            }
        }
        if (perElim == null) {
            return false;
        } else {
            personas.remove(perElim);
            return true;
        }
    }
}
