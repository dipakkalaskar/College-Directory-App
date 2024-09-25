package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Profile;
import org.jsp.cda.entity.User;

public interface UserDao {

	Optional<User> findByUsernameAndPassword(String username, String password);

	User saveUser(User user);

	Optional<User> getUserById(long id);

	Optional<User> getUserByUsername(String username);

	void deleteUserById(long id);

	List<User> findAllUsers();
}
