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
<<<<<<< HEAD
        String nombre = request.getParameter("nombre"); // name del INPUT
        // String edad = request.getParameter("edad"); 
        
        Persona p = ServicioPersona.getInstancia().getPersona(nombre);
        request.getSession().setAttribute("resultadoBusq", p);
        request.getRequestDispatcher("resultados_busq.jsp").forward(request, response);
=======

        String tipoBuscar = request.getParameter("tipoBuscar");

        switch (tipoBuscar) {
            case ("buscar1"):
                String nombre = request.getParameter("nombre"); // name del INPUT
                Persona p = ServicioPersona.getInstancia().getPersona(nombre);
                request.getSession().setAttribute("resultadoBusq", p);
                request.getRequestDispatcher("resultados_busq.jsp").forward(request, response);
                break;
            case ("buscar2"):
                ArrayList<Persona> personasTotal = new ArrayList<>();
                String nombres = request.getParameter("nombres");
                String mails = request.getParameter("mails");
                ArrayList<Persona> personasEncontradasNombre = ServicioPersona.getInstancia().buscarPersonasPorNombres(nombres);
                ArrayList<Persona> personasEncontradasMail = ServicioPersona.getInstancia().buscarPersonasPorMails(mails);
                if (!personasEncontradasNombre.isEmpty()) {
                    personasTotal.addAll(personasEncontradasNombre);
                }
                if (!personasEncontradasMail.isEmpty()) {
                    personasTotal.addAll(personasEncontradasMail);
                }
                if (!personasTotal.isEmpty()) {
                    request.getSession().setAttribute("resultadosBusqueda", personasTotal);
                    request.getRequestDispatcher("varios_resultados.jsp").forward(request, response);
                } else if (personasTotal.isEmpty()) {
                    request.getSession().setAttribute("resultadosBusqueda", personasTotal);
                    request.getRequestDispatcher("varios_resultados.jsp").forward(request, response);
                }
        }

>>>>>>> 94af767086859bea7808098e8ad27c5046918aee
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
<<<<<<< HEAD
        // request.getSession().setMaxInactiveInterval(60);
        String nombre = request.getParameter("nombre"); // name del INPUT
        String edad = request.getParameter("edad"); 
        try {
            Persona p = ServicioPersona.getInstancia().addPersonas(nombre, edad);
            request.setAttribute("personaAnadida", p);
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
=======
        String pantalla = request.getParameter("pantalla");

        // switch para elegir que formulario mostrar
        switch (pantalla) {

            // Pantalla de registro
            case ("form_registro"):
                try {
                    String nombre = request.getParameter("nombre"); // name del INPUT
                    String edad = request.getParameter("edad");
                    String email = request.getParameter("mail");
                    String password = request.getParameter("password");

                    Persona p = ServicioPersona.getInstancia().addPersona(nombre, edad, email, password);
                    if (p == null) {
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    } else {
                        request.getSession().setAttribute("tipoExito", "registrado");
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
                break;

            // Pantalla de modificacion
            case ("form_modificar"):
                String nombre = request.getParameter("nombre"); // name del INPUT
                String edad = request.getParameter("edad");
                String email = request.getParameter("mail");
                String password = request.getParameter("password");
                String accion = request.getParameter("boton");

                if (accion.equals("modificar")) {
                    try {
                        if (ServicioPersona.getInstancia().modificarPersona(nombre, edad, email, password)) {
                            request.getSession().setAttribute("tipoExito", "modificado");
                            //request.getRequestDispatcher("modificacionExito.jsp").forward(request, response);
                            request.getRequestDispatcher("exito.jsp").forward(request, response);
                        } else {
                            request.getRequestDispatcher("error.jsp").forward(request, response);
                        }
                    } catch (NumberFormatException ex) {
                        request.getSession().setAttribute("mensajeError", "Error en la modificacion numérico: " + ex.getMessage());
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    } catch (IllegalArgumentException ex) {
                        request.getSession().setAttribute("mensajeError", "Error en la modificacion en campos: " + ex.getMessage());
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    } catch (Exception ex) {
                        request.getSession().setAttribute("mensajeError", "Error en la modificacion genérico: " + ex.getMessage());
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                } else if (accion.equals("eliminar")) {
                    try {

                        if (ServicioPersona.getInstancia().eliminarPersona(nombre)) {
                            // arreglar esto                            
                            request.getSession().setAttribute("tipoExito", "borrado");
                            request.getRequestDispatcher("exito.jsp").forward(request, response);
                        }
                    } catch (Exception ex) {
                        request.getSession().setAttribute("mensajeError", "Error borrando gente: " + ex.getMessage());
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                }

                break;

>>>>>>> 94af767086859bea7808098e8ad27c5046918aee
        }
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
