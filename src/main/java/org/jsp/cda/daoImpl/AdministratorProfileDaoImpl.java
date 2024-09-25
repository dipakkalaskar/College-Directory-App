package org.jsp.cda.daoImpl;

import java.util.List;

import org.jsp.cda.dao.AdministratorProfileDao;
import org.jsp.cda.entity.AdministratorProfile;
import org.jsp.cda.entity.FacultyProfile;
import org.jsp.cda.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdministratorProfileDaoImpl implements AdministratorProfileDao {
	
	@Autowired
	private AdministratorRepository repository;

	@Override
	public AdministratorProfile saveAdministratorProfile(AdministratorProfile administratorProfile) {
		return repository.save(administratorProfile);
	}
}
