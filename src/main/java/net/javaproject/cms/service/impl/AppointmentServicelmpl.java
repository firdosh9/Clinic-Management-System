package net.javaproject.cms.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaproject.cms.dto.PatientAppointmentDTO;
import net.javaproject.cms.entity.Appointments;
import net.javaproject.cms.repository.AppointmentsRepository;
import net.javaproject.cms.service.AppointmentService;

@Service
public class AppointmentServicelmpl implements AppointmentService {

	@Autowired
	private AppointmentsRepository appointmentsRepository;

	public AppointmentServicelmpl(AppointmentsRepository appointmentsRepository) {
		super();
		this.appointmentsRepository = appointmentsRepository;
	}

	@Override
	public List<Appointments> getAllAppointments() {
		return appointmentsRepository.findAll();
	}

	@Override
	public Appointments saveAppointment(Appointments appointments) {
		return appointmentsRepository.save(appointments);
	}

	@Override
	public Appointments getAppointmentById(Long id) {
		return appointmentsRepository.findById(id).get();
	}

	@Override
	public Appointments updateAppointments(Appointments appointments) {
		return appointmentsRepository.save(appointments);
	}

	@Override
	public void deleteAppointmentById(Long id) {
		appointmentsRepository.deleteById(id);
	}

	@Override
	public List<PatientAppointmentDTO> getAllPatientAppointment(Long patinetId) {
		List<PatientAppointmentDTO> appointmentDTOs = new ArrayList<>();

		try {
			List<Object[]> list = appointmentsRepository.findAppointmentForPatient
					(String.valueOf(patinetId));
			for (Object[] obj : list) {
				PatientAppointmentDTO appointmentDTO = new PatientAppointmentDTO();
				BigInteger bigInteger = (BigInteger) (obj[6]);
				appointmentDTO.setAppointmentId(bigInteger.toString());
				appointmentDTO.setFirstName((String) obj[2]);

				appointmentDTOs.add(appointmentDTO);
			}
			//Object[] obj = list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appointmentDTOs;
	}
	@Override
	public List<PatientAppointmentDTO> getAllAppointmentsForClinic() {
		List<PatientAppointmentDTO> appointmentDTOs = new ArrayList<>();

		try {
			List<Object[]> list = appointmentsRepository.findAppointmentsForClinic();
			for (Object[] obj : list) {
				PatientAppointmentDTO appointmentDTO = new PatientAppointmentDTO();
				BigInteger bigInteger = (BigInteger) (obj[6]);
				appointmentDTO.setAppointmentId(bigInteger.toString());
				appointmentDTO.setAddress((String) obj[0]);
				appointmentDTO.setEmail((String) obj[1]);
				appointmentDTO.setFirstName((String) obj[2]);
				appointmentDTO.setLastName((String) obj[3]);
				appointmentDTO.setPhoneNo((String) obj[4]);
				appointmentDTO.setComments((String) obj[5]);
				appointmentDTO.setStatus((String) obj[5]);
				appointmentDTO.setAppointmentDate((String) obj[7]);
                appointmentDTOs.add(appointmentDTO);
			}
			// Object[] obj=list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appointmentDTOs;
	}
}
