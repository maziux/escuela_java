<%-- 
    Document   : head
    Created on : 26-sep-2019, 11:37:47
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    String head(String titulo) {
        String nombreJSP = this.getClass().getSimpleName().replaceAll("_",".");
        return "<head>"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"
                + "<title>03_webServlets " + titulo + " (" + nombreJSP + ")</title>"
                + "<link rel='stylesheet' href='./estilos/estilos.jsp'/>"
                + "</head>";
    }
%>

