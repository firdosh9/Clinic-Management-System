package net.javaproject.cms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaproject.cms.entity.Doctors;
import net.javaproject.cms.repository.DoctorRepository;
import net.javaproject.cms.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

	private DoctorRepository doctorRepository;
	
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	@Override
	public List<Doctors> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctors saveDoctor(Doctors doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctors getDoctorById(Long id) {
		return doctorRepository.findById(id).get();
	}

	@Override
	public Doctors updateDoctor(Doctors doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public void deleteDoctorById(Long id) {
		doctorRepository.deleteById(id);	
	}

}
