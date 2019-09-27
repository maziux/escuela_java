<%-- 
    Document   : resultados_busq
    Created on : 26-sep-2019, 15:55:55
    Author     : alumno
--%>

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
        <h2>Usuario</h2>
        <% Persona pers = (Persona) session.getAttribute("resultadoBusq"); %>
        <% if (pers != null) { %>
        <form name='form1' method='post' action='./personas.do'>
            <input type="hidden" name="pantalla" id="pantalla" value="form_modificar"/> 
            <table border="1">
                
                <tr><td>Nombre: </td>
                        <td><input id="nombre" name="nombre" readonly value="<%= pers.getNombre() %>"/></td></tr>
                <tr><td><label for="edad">Edad </label></td>
                    <td><input type="number" name="edad" id="edad" value="<%= pers.getEdad() %>"/></td></tr>
                <tr><td>Email:</td>  
                    <td><input type='text' name='mail' id='mail' value="<%= pers.getMail() %>"/></td></tr>
                <tr><td>Password:</td>  
                    <td><input type='text' name='password' id='password' value="<%= pers.getPassword() %>"/></td></tr>
            </table>
            <input type='submit' name="modificar" value='modificar'/>
            <input type='submit' name="modificar" value='eliminar'/>
            
        </form>
        <% } else { %>            
            <span>No se han encontrado personas</span>
        <% } %>
    </body>
</html>
