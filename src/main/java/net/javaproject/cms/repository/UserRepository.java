package net.javaproject.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaproject.cms.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	
	Users findByEmailAndPassword(String email, String password);

}
