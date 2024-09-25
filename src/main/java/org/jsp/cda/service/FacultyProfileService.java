package org.jsp.cda.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FacultyProfileService {

	ResponseEntity<?> saveFacultyProfile(long id, MultipartFile file);

}
