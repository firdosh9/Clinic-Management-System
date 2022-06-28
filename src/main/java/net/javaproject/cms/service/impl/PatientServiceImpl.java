package net.javaproject.cms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaproject.cms.entity.Patients;
import net.javaproject.cms.repository.PatientRepository;
import net.javaproject.cms.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	private PatientRepository patientRepository;
	
	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public List<Patients> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patients savePatient(Patients patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Patients getPatientById(Long id) {
		return patientRepository.findById(id).get();
	}

	@Override
	public Patients updatePatient(Patients patient) {
		return patientRepository.save(patient);
	}

	@Override
	public void deletePatientById(Long id) {
		patientRepository.deleteById(id);	
	}

}
