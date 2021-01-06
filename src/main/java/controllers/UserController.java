package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dto.UserDTO;
import services.UserServiceImp;



@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImp userService;

	@RequestMapping(method = RequestMethod.GET, value = "/getAllusers")
	public List<UserDTO> getAllUser() {
		return userService.getAllUsers();
	}
	
	@PutMapping("/updateUser/{id}/{likedUser}")  // u need  loginUser ID = {id}  and liked User Name = {likedUser}
    public void updateUser(@PathVariable(name = "id") Long id,
    		@PathVariable(name = "likedUser") String likedUser) {
         userService.updateUser(id, likedUser);   
    }


}