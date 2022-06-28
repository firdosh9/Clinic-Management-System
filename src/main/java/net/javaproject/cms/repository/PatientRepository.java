package net.javaproject.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaproject.cms.entity.Patients;

public interface PatientRepository extends JpaRepository<Patients, Long>{

}
