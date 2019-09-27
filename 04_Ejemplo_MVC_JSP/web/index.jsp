<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC con JSP y Servlet</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Ejemplo MVC con JSP y Servlet</h1>
        <h2>Añadir persona</h2>
        <form name='form1' method='post' action='./personas.do'>  
            <input type="hidden" name="pantalla" id="pantalla" value="form_registro"/>                       
            <table border='1'>
                
                <tr><td>Nombre:</td>  
                    <td><input type='text' name='nombre' id='nombre'/></td></tr>
                <tr><td>Edad:</td>  
                    <td><input type='number' name='edad' id='edad'/></td></tr>
                <tr><td>Email:</td>  
                    <td><input type='text' name='mail' id='mail'/></td></tr>
                <tr><td>Password:</td>  
                    <td><input type='password' name='password' id='password'/></td></tr>
            </table>
            <input type='submit' value='Enviar'/>             
        </form>
        <h2>Buscar persona</h2>
        <form name='formBusq' method='get' action='./personas.do'>            
            <table border='1'>
                <tr><td>Nombre:</td>  
                    <td><input type='text' name='nombre' id='nombre'/></td>
                    <td><input type='submit' name="botonBuscar" value='buscar1'/>  </td></tr>
            </table>
        <h2>Buscar PERSONAS por nombre o mail</h2>
        <form name='formBusq' method='get' action='./personas.do'>            
            <table border='1'>
                <tr><td>Nombre:</td>  
                    <td><input type='text' name='nombres' id='nombre'/></td>
                <tr><td>Mail:</td>  
                    <td><input type='text' name='mails' id='mail'/></td>
                    <td><input type='submit' name="botonBuscar" value='buscar2'/>  </td></tr>
            </table>  
            
        </form>
    </body>
</html>
