package net.javaproject.cms.service;

import java.util.List;

import net.javaproject.cms.entity.Patients;

public interface PatientService {
	List<Patients> getAllPatients();
	
	Patients savePatient(Patients patients);
	
	Patients getPatientById(Long id);
	
	Patients updatePatient(Patients patients);
	
	void deletePatientById(Long id);
}
