<%-- 
    Document   : nuevo_juego
    Created on : 27-sep-2019, 17:28:24
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Game</titlew>
    </head>
    <body>
        <h1>New Game</h1>
        <% String aux = (String) session.getAttribute("gameFilm"); %>
        <p><%= aux %></p>
</body>
</html>
