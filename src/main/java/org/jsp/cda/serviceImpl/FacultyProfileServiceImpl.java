package org.jsp.cda.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.jsp.cda.dao.FacultyProfileDao;
import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.FacultyProfile;
import org.jsp.cda.entity.StudentProfile;
import org.jsp.cda.entity.User;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.FacultyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FacultyProfileServiceImpl implements FacultyProfileService {
	
	private static final String FOLDER_PATH = "/Users/safdarazizz/Developer/workspace-spring-tool-suite-4-4.24.0.RELEASE/Images/Faculties/";

	
	@Autowired
	private FacultyProfileDao dao;
	
	@Autowired
	private UserDao user;

	@Override
	public ResponseEntity<?> saveFacultyProfile(long id, MultipartFile file) {
		
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
		
		FacultyProfile facultyProfile = FacultyProfile.builder().userId(id).photo(photo).user(user).build();
				
		dao.saveFacultyProfile(facultyProfile);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("FacultyProfile Saved Successfully").body(facultyProfile).build());
	}
}
