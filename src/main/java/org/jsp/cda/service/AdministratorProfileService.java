package org.jsp.cda.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface AdministratorProfileService {

	ResponseEntity<?> saveAdministratorProfile(long id, MultipartFile file);

	ResponseEntity<?> findAllFaculties();

	ResponseEntity<?> findAllStudents();

}
