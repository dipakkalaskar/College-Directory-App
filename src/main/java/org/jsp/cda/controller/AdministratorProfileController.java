package org.jsp.cda.controller;

import org.jsp.cda.service.AdministratorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/administratorprofiles")
public class AdministratorProfileController {
	
	@Autowired
	private AdministratorProfileService service;
	
	@Operation(summary = "To create a AdministratorProfiles", description = "This API will accept the RequestBody of AdministratorProfile entity and persist to the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "AdministratorProfile Saved Successfully"), @ApiResponse(responseCode = "400", description = "Unable to save AdministratorProfile")})
	@PostMapping
	public ResponseEntity<?> saveAdministratorProfile(@RequestParam long id, @RequestParam MultipartFile file)
	{
		return service.saveAdministratorProfile(id, file);
	}
	
	@Operation(summary = "To fetch all the Faculties", description = "This API will fetch all the Faculties available in the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Fetched all the Faculties successfully"), @ApiResponse(responseCode = "400", description = "Could not fetch all the Faculties, No Faculties found")})
	@GetMapping("/faculty")
	public ResponseEntity<?> findAllFaculties()
	{
		return service.findAllFaculties();
	}
	
	@Operation(summary = "To fetch all the Students", description = "This API will fetch all the Students available in the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "Fetched all the Students successfully"), @ApiResponse(responseCode = "400", description = "Could not fetch all the Students, No Students found")})
	@GetMapping("/student")
	public ResponseEntity<?> findAllStudents()
	{
		return service.findAllStudents();
	}
}
