package org.jsp.cda.controller;

import org.jsp.cda.entity.User;
import org.jsp.cda.service.UserService;
import org.jsp.cda.util.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserService service;               

	@Operation(summary = "To login into the account", description = "This API will accept the RequestBody of User entity and does the validation from the database to access the account")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "User login Successfully"), @ApiResponse(responseCode = "400", description = "Unable to login")})
	@PostMapping(value = "/login")
	public ResponseEntity<?> findByUsernameAndPassword(@RequestBody AuthUser authUser) {
		return service.findByUsernameAndPassword(authUser);
	}

	@Operation(summary = "To create a User", description = "This API will accept the RequestBody of User entity and persist to the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "User Saved Successfully"), @ApiResponse(responseCode = "400", description = "Unable to save User")})
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user, MultipartFile file) {
		return service.saveUser(user);
	}
	
	@Operation(summary = "To fetch the User based on ID", description = "This API will fetch the Users available in the database table based on the ID")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Fetched the User successfully"), @ApiResponse(responseCode = "400", description = "Could not fetch the User")})
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getUserById(@PathVariable long id) {
		return service.getUserById(id);
	}
	
	@Operation(summary = "To fetch the User based on Username", description = "This API will fetch the Users available in the database table based on the Username")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Fetched the User successfully"), @ApiResponse(responseCode = "400", description = "Could not fetch the User")})
	@GetMapping("/name/{name}")
	public ResponseEntity<?> getUserByUsername(@PathVariable String username)
	{
		return service.getUserByUsername(username);
	}
	
	@Operation(summary = "To Delete the User based on ID", description = "This API will delete the Users available in the database table based on the ID")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Deleted the User successfully"), @ApiResponse(responseCode = "400", description = "Could not delete the User")})
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long id)
	{
		return service.deleteUserById(id);
	}
	
	@Operation(summary = "To fetch all the Users", description = "This API will fetch all the Users available in the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Fetched all the Users successfully"), @ApiResponse(responseCode = "400", description = "Could not fetch all the Users, No User found")})
	@GetMapping("/all")
	public ResponseEntity<?> findAllUsers()
	{
		return service.findAllUsers();
	}
	
	@Operation(summary = "To Update the Users", description = "This API will update the Users available in the database table by providing the respective data and ID")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "User updated successfully"), @ApiResponse(responseCode = "400", description = "Could not update the User")})
	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody User user)
	{
		return service.updateUser(user);
	}
}
