package net.javaproject.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaproject.cms.entity.Doctors;

public interface DoctorRepository extends JpaRepository<Doctors, Long>{

}
