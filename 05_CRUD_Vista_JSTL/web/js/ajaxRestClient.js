window.addEventListener("load",() => {
    let data_table = document.getElementById("data_table");
    
    let ajaxObj = new XMLHttpRequest();
    
    // evento de cambio de estado de la llamada HTTP
    ajaxObj.onreadystatechange = function() {
        /* alert("Cambio de estado: " + this.readyState
                + ", status: " + this.status); */
        if (this.readyState == 4 && this.status == 200) {
            let jsonResp = this.responseText;
            // jsonResp es una cadena de texto
            // que debemos convertir en un objeto JS
            let objRespListusers = JSON.parse(jsonResp);
            data_table.innerHTML = "";
            for (let user of objRespListusers) {
                data_table.innerHTML +=
                        `<tr>
                            <td>${user.email}</td>
                            <td>${user.name}</td>
                        </tr>`;
            }
        }
    };
    
    ajaxObj.open("GET", "api/users");
    ajaxObj.send();
});


