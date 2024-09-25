package org.jsp.cda.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jsp.cda.dao.AdministratorProfileDao;
import org.jsp.cda.dao.FacultyProfileDao;
import org.jsp.cda.dao.StudentProfileDao;
import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.AdministratorProfile;
import org.jsp.cda.entity.FacultyProfile;
import org.jsp.cda.entity.StudentProfile;
import org.jsp.cda.entity.User;
import org.jsp.cda.exceptionclasses.UserNotFoundException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.AdministratorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AdministratorProfileServiceImpl implements AdministratorProfileService {
	
	private static final String FOLDER_PATH = "/Users/safdarazizz/Developer/workspace-spring-tool-suite-4-4.24.0.RELEASE/Images/Administrators/";

	
	@Autowired
	private AdministratorProfileDao dao;
	
	@Autowired
	private UserDao user;
	
	@Autowired
	private FacultyProfileDao facultyProfileDao;
	
	@Autowired
	private StudentProfileDao studentProfileDao;

	@Override
	public ResponseEntity<?> saveAdministratorProfile(long id, MultipartFile file) {
		
		Optional<User> optional = user.getUserById(id);
		
//		if(!optional.isPresent() && optional.get().getRole().toString().equalsIgnoreCase("STUDENT"))
//		{
//			
//		}
		
		User user = optional.get();
		
		String photo = FOLDER_PATH + UUID.randomUUID() + file.getOriginalFilename();
		
		try
		{
			file.transferTo(new File(photo));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		AdministratorProfile administratorProfile = AdministratorProfile.builder().userId(id).photo(photo).user(user).build();
				
		dao.saveAdministratorProfile(administratorProfile);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("AdministratorProfile Saved Successfully").body(administratorProfile).build());

		
	}

	@Override
	public ResponseEntity<?> findAllFaculties() {
		List<FacultyProfile> listOfFacultyProfiles = facultyProfileDao.findAllFaculties();
		
		if(listOfFacultyProfiles.isEmpty())
			throw UserNotFoundException.builder().message("No User present. Please insert a new User").build();
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Users found Successfully").body(listOfFacultyProfiles).build());
	}

	@Override
	public ResponseEntity<?> findAllStudents() {
		List<StudentProfile> listofStudentProfiles = studentProfileDao.findAllStudents();
		
		if(listofStudentProfiles.isEmpty())
			throw UserNotFoundException.builder().message("No User present. Please insert a new User").build();
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Users found Successfully").body(listofStudentProfiles).build());
	}
}
