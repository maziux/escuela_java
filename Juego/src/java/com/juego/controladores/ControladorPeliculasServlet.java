/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juego.controladores;

import com.juego.modelo.Pelicula;
import com.juego.modelo.logica.ServicioPelicula;
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
public class ControladorPeliculasServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String film = ServicioPelicula.getInstancia().fetchPelicula();
        request.getSession().setAttribute("gameFilm", film);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("film");
        Pelicula film = ServicioPelicula.getInstancia().addPelicula(name);
        if (film != null) {
            request.getSession().setAttribute("addedFilm", "Película añadida correctamente");
        } else {
            request.getSession().setAttribute("addedFilm", "");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
