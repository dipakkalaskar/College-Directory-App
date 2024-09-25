package org.jsp.cda.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface StudentProfileService {

	ResponseEntity<?> saveStudentProfile(long id, MultipartFile file);

}
