
package net.javaproject.cms.service;

import java.util.List;

import net.javaproject.cms.entity.Doctors;

public interface DoctorService {
	List<Doctors> getAllDoctors();
	
	Doctors saveDoctor(Doctors doctors);
	
	Doctors getDoctorById(Long id);
	
	Doctors updateDoctor(Doctors doctors);
	
	void deleteDoctorById(Long id);
}
