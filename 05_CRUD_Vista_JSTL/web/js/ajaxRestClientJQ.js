$(document).ready( function() {
    
    $.ajax( {
        "url": "http://localhost:8084/CRUD_Vista_JSTL/api/users",
        /*"method": "GET",*/
        "success": function(respuestaArrayUsers) {
            
            respuestaArrayUsers.forEach(function(user) {
                $("#data_table").html(
                    $("#data_table").html() + 
                    `<tr><td>${user.email}</td>
                        <td>${user.name}</td>
                    </tr>`);
            });
        },
        "error": function() {
            alert("Error en peticion AJAX");
        }
    })
});
