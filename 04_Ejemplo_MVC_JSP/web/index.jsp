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
            <table border='1'>
                <tr><td>Nombre:</td>  
                    <td><input type='text' name='nombre' id='nombre'/></td></tr>
                <tr><td>Edad:</td>  
                    <td><input type='number' name='edad' id='edad'/></td></tr>
                <tr><td>Edad:</td>  
                    <td><input type='hidden' name='metodo' id='metodo' value="modificar"/></td></tr>
            </table>
            <input type='submit' value='Enviar'/>             
        </form>
        <h2>Buscar persona</h2>
        <form name='formBusq' method='get' action='./personas.do' onsubmit="mira()">            
            <table border='1'>
                <tr><td>Nombre:</td>  
                    <td><input type='text' name='nombre' id='nombre'/></td>
                    <td><input type='submit' name='metodo' value='Buscar'/>
                    <td><input type='submit' name='metodo' value='Modificar'/>  </td></tr>
            </table>                       
        </form>
        <script>
            // id y name para navegador
            // name para enviar parámetros
            function mira() {
                alert(document.formBusq.nombre.value);
                return true;
            }
        </script>
    </body>
</html>
