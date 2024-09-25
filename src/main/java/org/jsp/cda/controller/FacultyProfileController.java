package org.jsp.cda.controller;

import org.jsp.cda.entity.FacultyProfile;
import org.jsp.cda.entity.StudentProfile;
import org.jsp.cda.service.FacultyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/facultyprofiles")
public class FacultyProfileController {
	
	@Autowired
	private FacultyProfileService service;
	
	@Operation(summary = "To create a FacultyProfile", description = "This API will accept the RequestBody of FacultyProfile entity and persist to the database table")
	@ApiResponses({@ApiResponse(responseCode = "200", description = "FacultyProfile Saved Successfully"), @ApiResponse(responseCode = "400", description = "Unable to save FacultyProfile")})
	@PostMapping
	public ResponseEntity<?> saveFacultyProfile(@RequestParam long id, @RequestParam MultipartFile file)
	{
		return service.saveFacultyProfile(id, file);
	}
}
