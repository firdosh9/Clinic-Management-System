package net.javaproject.cms.service;

import java.util.List;

import net.javaproject.cms.dto.PatientAppointmentDTO;
import net.javaproject.cms.entity.Appointments;

public interface AppointmentService {
	
	List<Appointments> getAllAppointments();
	
	Appointments saveAppointment(Appointments Appointments);
	
	Appointments getAppointmentById(Long id);
	
	Appointments updateAppointments(Appointments Appointments);
	
	void deleteAppointmentById(Long id);

	List<PatientAppointmentDTO> getAllPatientAppointment(Long patinetId);

	List<PatientAppointmentDTO> getAllAppointmentsForClinic();
}

