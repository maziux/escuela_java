<%-- 
    Document   : exito
    Created on : 26-sep-2019, 13:40:39
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exito - Registro guardado</title>
    </head>
    <body>
        <% String aux = session.getAttribute("tipoExito").toString(); %>
        <% if (aux != "borrado") { %>
            <h1>Exito - <%= aux %></h1>
            <label for="nombre">Nombre: </label>
            <input id="nombre" readonly value="<%= request.getParameter("nombre") %>"/><br />
            <label for="edad">Edad </label>
            <input id="edad" readonly value="<%= request.getParameter("edad") %>"/><br />
            <label for="edad">Mail </label>
            <input id="edad" readonly value="<%= request.getParameter("mail") %>"/><br />
            <label for="edad">Contraseña </label>
            <input id="edad" readonly value="<%= request.getParameter("password") %>"/><br />
        <% } else { %>
            <h1>Exito - <%= aux %></h1>
            <p> Usuario <%= request.getParameter("nombre") %> ha sido borrado </p>
        <% } %>
    </body>
</html>
