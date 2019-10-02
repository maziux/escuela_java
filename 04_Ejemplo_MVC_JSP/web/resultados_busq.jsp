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
        <%@include file="navegacion.jsp" %>
        
        <h2>Usuario</h2>
        <% Persona pers = (Persona) session.getAttribute("resultadoBusq"); %>
<<<<<<< HEAD
        <% if (pers != null) { %>
                <label for="nombre">Nombre: </label>
                <input id="nombre" readonly 
                       value="<%= pers.getNombre() %>"/>
                <label for="edad">Edad </label>
                <input id="edad" readonly value="<%= pers.getEdad() %>"/>
        <% } else { %>            
                <span style="color: red">
                    No se han encontrado personas
                </span>
        <% } %>
=======
        <% if (pers != null) {%>
        <form name='form1' method='post' action='./personas.do'>
            <input type="hidden" name="pantalla" id="pantalla" value="form_modificar"/> 
            <table border="1">

                <tr><td>Nombre: </td>
                    <td><input name="nombre" id="nombre" readonly value="<%= pers.getNombre()%>"/></td></tr>
                <tr><td><label for="edad">Edad </label></td>
                    <td><input type="number" name="edad" id="edad" value="<%= pers.getEdad()%>"/></td></tr>
                <tr><td>Email:</td>  
                    <td><input type='text' name='mail' id='mail' value="<%= pers.getMail()%>"/></td></tr>
                <tr><td>Password:</td>  
                    <td><input type='text' name='password' id='password' value="<%= pers.getPassword()%>"/></td></tr>
            </table>
            <input type='submit' name="boton" value='modificar'/>
            <input type='submit' name="boton" value='eliminar'/>
        </form>
        <% } else { %>            
        <span>No se han encontrado personas</span>
        <% }%>
>>>>>>> 94af767086859bea7808098e8ad27c5046918aee
    </body>
</html>
