/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sinensia.controladores;

import com.sinensia.modelo.Persona;
import com.sinensia.modelo.logica.ServicioPersona;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
public class ControladorPersonasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre"); // name del INPUT
        // String edad = request.getParameter("edad"); 
        
        Persona p = ServicioPersona.getInstancia().getPersona(nombre);
        request.getSession().setAttribute("resultadoBusq", p);
        request.getRequestDispatcher("resultados_busq.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // request.getSession().setMaxInactiveInterval(60);
        String nombre = request.getParameter("nombre"); // name del INPUT
        String edad = request.getParameter("edad"); 
        String email = request.getParameter("mail");
        String password = request.getParameter("password");
        
        try {
            Persona p = ServicioPersona.getInstancia().addPersona(nombre, edad, email, password);
            if (p == null) {
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                 request.getRequestDispatcher("exito.jsp").forward(request, response);          
            }
        } catch (NumberFormatException ex) {
            request.getSession().setAttribute("mensajeError", "Error numérico: " + ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (IllegalArgumentException ex) {
            request.getSession().setAttribute("mensajeError", "Error en campos: " + ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);            
        } catch (Exception ex) {
            request.getSession().setAttribute("mensajeError", "Error genérico: " + ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);            
        }
        // TODO Ampliar los catch para capturar los distintos tipos de errores con password y mail
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
