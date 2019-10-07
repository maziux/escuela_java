$(document).ready(function () {
    $("#data_table").on("click",".modify",function(e) {
       
        
        let objUser = {
            "id": $(e.target).closest("input.id").attr("value"),
            "email": $(e.target).closest("input.email").attr("value"),
            "password": $(e.target).closest("input.password").attr("value"),
            "name": $(e.target).closest("input.name").attr("value"),
            "age": $(e.target).closest("input.age").attr("value")
        };
        
        //alert(aux);
        alert(JSON.stringify(objUser));
    });
});


      
        /*
         $.post({"url": "api/users", 
         "contentType": "JSON",
         "data": JSON.stringify(objUser),
         "success":
         function (respuestaUserObj) {
         $("#id").val(respuestaUserObj.id);
         }
         });
         */