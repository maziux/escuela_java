<%-- 
    Document   : varios_resultados
    Created on : 27-sep-2019, 12:55:58
    Author     : alumno
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.sinensia.modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo MVC con JSP y Servlet</title>
    </head>
    <body>
        <h1>Ejemplo MVC con JSP y Servlet</h1>
        <h2>Usuarios ENCONTRADOS</h2>
        <% ArrayList<Persona> pers = (ArrayList) session.getAttribute("resultadosBusqueda"); %>
        <% if (!pers.isEmpty()) { %>
            <% for (Persona p : pers) { %>                
                <span>Nombre: <%= p.getNombre() %></span>
                <span>Edad: <%= p.getEdad() %></span>
                <span>Email: <%= p.getMail() %></span>
                <span>Password: <%= p.getPassword() %></span>
                <br />
            <% } %>
        <% } else { %>
            <p>No se han encontrado resultados</p>
        <% } %>
        
    </body>
</html>

