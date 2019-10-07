$(document).ready(function () {

    $.ajax({
        "url": "http://localhost:8084/CRUD_Vista_JSTL/api/users",
        /*"method": "GET",*/
        "success": function (respuestaArrayUsers) {

            respuestaArrayUsers.forEach(function (user) {
                $("#data_table").html(
                    $("#data_table").html() +
                    
                    `<tr><td><input class="id" name="id" 
                        readonly type="number" size="4" 
                        value="${user.id}"/></td>
                    <td><input class="email" name="email"
                        type="email" value="${user.email}"/></td>
                    <td><input class="password" name="password"
                        type="text" value="${user.password}"/></td>
                    <td><input class="name" name="name"
                        type="text" value="${user.name}"/></td>
                    <td><input class="age" name="age"
                        type="number" value="${user.age}"/></td>
                    <td><input name="method" type="button" value="Delete"/></td>
                    <td><input class="modify" name="method" type="button" value="Update"/></td></tr>`);
            });
        },
        "error": function () {
            alert("Error en peticion AJAX");
        }
    });
});