/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.modelo.logica;

import com.sinensia.modelo.Persona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/** Singleton porque sólo queremos un servicio por aplicación/servidor
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
        if (instancia == null) 
            instancia = new ServicioPersona();
        return instancia;
    }// </editor-fold>
    
    private ArrayList<Persona> personas;
    
    public Persona addPersona(String nombre, String edad, String email, String password)
        throws NumberFormatException, IOException, IllegalArgumentException {
        
        String emailRegexp = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
        
        if (! Pattern.matches(emailRegexp, email)) {
            throw new IllegalArgumentException("Mail no valido");
        } else if(password.contains(" ")) {
            throw new IllegalArgumentException("La contraseña no debe tener espacios");
        } else if (nombre.equals("")) {
            throw new IllegalArgumentException("El nombre es vacío");
        } else  if ( nombre.length() < 2) {
            throw new IllegalArgumentException("El nombre es demasiado corto");
        } else if ( edad.equals("") ) {
            throw new NumberFormatException("La edad está vacía");
        } else {
            int intEdad = Integer.parseInt(edad);
            if (intEdad <= 12 ) {
                 throw new IllegalArgumentException("La edad debe ser mayor que 12");
            } else {
                Persona p = new Persona(nombre, intEdad, email, password);
                personas.add(p);
                return p;
            }
        }
    }
    public Persona getPersona(String nombre) {
        for (Persona p : personas) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }
}
