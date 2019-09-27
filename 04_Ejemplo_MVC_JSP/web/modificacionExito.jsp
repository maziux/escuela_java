<%-- 
    Document   : modificacionExito
    Created on : 27-sep-2019, 10:19:57
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exito - Registro modificado</title>
    </head>
    <body>
        <h1>Exito - Persona modificada</h1>
        <label for="nombre">Nombre: </label>
        <input id="nombre" readonly value="<%= request.getParameter("nombre") %>"/><br />
        <label for="edad">Edad </label>
        <input id="edad" readonly value="<%= request.getParameter("edad") %>"/><br />
        <label for="edad">Mail </label>
        <input id="edad" readonly value="<%= request.getParameter("mail") %>"/><br />
        <label for="edad">Contraseña </label>
        <input id="edad" readonly value="<%= request.getParameter("password") %>"/><br />
    </body>
</html>
