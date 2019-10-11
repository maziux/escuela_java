/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinensia.springrestusers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Rest controller con Spring almacenado
 * en bbdd embedida.
 *
 * @author alumno
 */
@RestController
@RequestMapping("/users")
public class UserRestController {
	
	@Autowired
	UsersRepository miRepo;


    @RequestMapping(method = RequestMethod.POST)
    public User addUser(@RequestBody User user)
            throws NumberFormatException, IOException, IllegalArgumentException {
       
	    if (user.getAge() <= 12) {
	        throw new IllegalArgumentException("La edad debe ser mayor que 12");
	    } else {
	    	user = miRepo.save(user);
	        return user;
	    }
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
    	return miRepo.findAll();
    }
    
}
