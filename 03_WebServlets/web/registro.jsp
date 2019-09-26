<%-- 
    Document   : registro
    Created on : 26-sep-2019, 10:37:15
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="./estilos/estilos.jsp">
    </head>
</head>
<body>        

    <%@include file="header.jsp" %>
    <h1>Introduzca sus datos</h1>

    <form name='form1' method='post' action='./param.jsp'>
        <table border='1'>
            <tr><td>Nombre:</td>
                <td><input type='text' name='nombre' id='nombre'/></td></tr>
            <tr><td>Edad:</td>
                <td><input type='number' name='edad' id='edad'/></td></tr>
            <!--
            <tr><td>E-mail:</td>
                <td><input type="email" name="mail" id="mail"></td></tr>
            <tr><td>Password:</td>
                <td><input type="password" name="pass" id="pass"></td></tr>
            -->
        </table>
        <input type='submit' value='Enviar'/>
    </form>
</body>
</html>
