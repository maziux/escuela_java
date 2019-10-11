package viewnext.sringrestclient;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringrestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrestClientApplication.class, args);
		System.out.println("\n>> Recogiendo usuarios\n");
		RestClient clienteRest = new RestClient();
		String jsonUser = clienteRest.get("/users");
		System.out.println("\n>> Usuarios recogidos:\n" + jsonUser);
		String usuarioAEnviar = "{\n" + 
				"    \"email\": \"DDD@DDD.com\",\n" + 
				"    \"name\": \"DDD\",\n" + 
				"    \"age\": 60\n" + 
				"}";
		String jsonUserCreado = clienteRest.post("/users", usuarioAEnviar);
		System.out.println("\n>> Usuarios recogidos:\n" + jsonUserCreado);
	}
	
	/*
	public List<User> getTodosUsuarios() {
				
	}*/

}
