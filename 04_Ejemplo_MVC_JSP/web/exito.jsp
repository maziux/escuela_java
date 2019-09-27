<%-- 
    Document   : exito
    Created on : 26-sep-2019, 13:40:39
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

       
    <%!  void mostrarExitoRegistro() { %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exito - Registro guardado</title>
    </head>
    <body>
        <h1>Exito - Persona guardada</h1>
        <label for="nombre">Nombre: </label>
        <input id="nombre" readonly value="<%= request.getParameter("nombre") %>"/><br />
        <label for="edad">Edad </label>
        <input id="edad" readonly value="<%= request.getParameter("edad") %>"/><br />
        <label for="edad">Mail </label>
        <input id="mail" readonly value="<%= request.getParameter("mail") %>"/><br />
        <label for="edad">Contraseña </label>
        <input id="password" readonly value="<%= request.getParameter("password") %>"/><br />
    </body>        
   
    <% }; %>
     
    
    <% String tipoExito = request.getSession().getAttribute("tipoExito").toString();
        if(tipoExito.equals("registrado")) {
            mostrarExitoRegistro();
        }
        else if(tipoExito.equals("modificado")){
            mostrarExitoModificacion();
        }
        else if(tipoExito.equals("borrado")) {
            mostrarExitoBorrado();
        }
    %>
    
       <%--
    
            <%!  void mostrarExitoModificacion() { %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exito - Registro modificado</title>
    </head>
    <body>
        <h1>Exito - Persona modificada. Valores actuales</h1>
        <label for="nombre">Nombre: </label>
        <input id="nombre" readonly value="<%= request.getParameter("nombre") %>"/><br />
        <label for="edad">Edad </label>
        <input id="edad" readonly value="<%= request.getParameter("edad") %>"/><br />
        <label for="edad">Mail </label>
        <input id="edad" readonly value="<%= request.getParameter("mail") %>"/><br />
        <label for="edad">Contraseña </label>
        <input id="edad" readonly value="<%= request.getParameter("password") %>"/><br />
    </body>        
        
        
    <% }
        %>
        
    <%!  void mostrarExitoBorrado() { %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exito - Registro borrado</title>
    </head>
    <body>
        <h1>Exito en la eliminacion</h1>
        <p>La persona <% Request.getParameter("nombre") %> ha sido eliminada de la vida correctamente </p>
    </body>        
        
        
    <% }
        %>
        --%>
</html>
