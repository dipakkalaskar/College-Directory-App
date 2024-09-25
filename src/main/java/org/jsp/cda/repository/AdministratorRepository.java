package org.jsp.cda.repository;

import org.jsp.cda.entity.AdministratorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<AdministratorProfile, Long> {

}
