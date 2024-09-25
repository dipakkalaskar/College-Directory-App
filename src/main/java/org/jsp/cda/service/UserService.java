package org.jsp.cda.service;

import org.jsp.cda.entity.User;
import org.jsp.cda.util.AuthUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

	ResponseEntity<?> findByUsernameAndPassword(AuthUser authUser);
	
	ResponseEntity<?> saveUser(User user);

	ResponseEntity<?> getUserById(long id);

	ResponseEntity<?> getUserByUsername(String username);

	ResponseEntity<?> deleteUserById(long id);

	ResponseEntity<?> findAllUsers();

	ResponseEntity<?> updateUser(User user);
}
