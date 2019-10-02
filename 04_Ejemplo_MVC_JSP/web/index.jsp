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
<<<<<<< HEAD
=======

>>>>>>> 94af767086859bea7808098e8ad27c5046918aee
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
<<<<<<< HEAD
        <form name='formBusq' method='get' action='./personas.do' onsubmit="mira()">            
            <table border='1'>
                <tr><td>Nombre:</td>  
                    <td><input type='text' name='nombre' id='nombre'/></td>
                    <td><input type='submit' name='metodo' value='Buscar'/>
                    <td><input type='submit' name='metodo' value='Modificar'/>  </td></tr>
            </table>                       
=======
        <form name='formBusq' method='get' action='./personas.do'>   
            <input type="hidden" name="tipoBuscar" id="buscarUno" value="buscar1"/>                       
            <table border='1'>
                <tr><td>Nombre:</td>  
                    <td><input type='text' name='nombre' id='nombre'/></td>
                    <td><input type='submit' name="botonBuscar" value='Buscar'/>  </td></tr>
            </table>
        </form>
        <h2>Buscar PERSONAS por nombre o mail</h2>
        <form name='formBuscarVarios' method='get' action='./personas.do'>   
            <input type="hidden" name="tipoBuscar" id="buscarVarios" value="buscar2"/>                       
            <table border='1'>
                <tr><td>Nombre:</td>  
                    <td><input type='text' name='nombres' id='nombre'/></td>
                <tr><td>Mail:</td>  
                    <td><input type='text' name='mails' id='mail'/></td>
                    <td><input type='submit' name="botonBuscar" value='Buscar'/>  </td></tr>
            </table>  

>>>>>>> 94af767086859bea7808098e8ad27c5046918aee
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
