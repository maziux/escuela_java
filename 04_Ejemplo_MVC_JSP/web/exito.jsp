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
        <h1>Exito - Registro guardado</h1>
        <label for="nombre">Nombre: </label>
        <input id="nombre" readonly value="<%= request.getParameter("nombre") %>"/>
        <label for="edad">Edad </label>
        <input id="edad" readonly value="<%= request.getParameter("edad") %>"/>
    </body>
</html>
