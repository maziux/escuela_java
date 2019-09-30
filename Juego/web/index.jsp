<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>AHORCADO</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Introducir películas</h1>
        <form name="addFilm" method="post" action="./films.do">
            <intput type="hidden" value="addFilm"/>
            <label for="film">Título: </label>
            <input id="film" type="text" name="film">
            <input type='submit' name="buttonAddFilm" value='Add'/>
        </form>
        <% String aux = (String) session.getAttribute("addedFilm"); %>
        <% if (aux != null) { %>
            <p><%= aux %></p>
        <% } %>
        
        <!-- empezar si hay peliculas -->
        <form name="startGame" method="get" action="./films.do">
            <intput type="hidden" value="start"/>
            <input type="submit" name="start" value="Start_Game">
        </form>
    </body>
</html>