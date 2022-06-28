package net.javaproject.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaproject.cms.entity.Appointments;
import net.javaproject.cms.service.AppointmentService;
import net.javaproject.cms.service.PatientService;

@Controller
public class AppointmentController {

	private AppointmentService appointmentService;
	private PatientService patientService;

	public AppointmentController(AppointmentService appointmentService, 
			PatientService patientService) {
		super();
		this.appointmentService = appointmentService;
		this.patientService = patientService;
	}
	
	// handler method to handle list patients and return mode and view
	@GetMapping("/appointments")
	public String listAppointments(Model model) {
		model.addAttribute("appointments", appointmentService.getAllAppointmentsForClinic());
		return "appointments";
	}
	
	@GetMapping("/appointments/new")
	public String createAppointmentForm(Model model) {
		// create patient object to hold patient form data
		Appointments appointments = new Appointments();
		model.addAttribute("appointment", appointments);
		model.addAttribute("patients", patientService.getAllPatients());
		return "create_appointment";
	}
	
	@GetMapping("/appointment-create/new/{id}")
	public String createAppointmentForPatForm(@PathVariable Long id, Model model) {
		System.out.println(id);
		// create patient object to hold patient form data
		Appointments appointments = new Appointments();
		model.addAttribute("appointment", appointments);
		return "create_appointment";
	}
	
	@PostMapping("/appointments")
	public String saveAppointment(@ModelAttribute("appointments") Appointments appointment) {
		appointmentService.saveAppointment(appointment);
		return "redirect:/appointments";
	}
	
	@GetMapping("/appointments/edit/{id}")
	public String editAppointmentForm(@PathVariable Long id, Model model) {
		model.addAttribute("appointment", appointmentService.getAppointmentById(id));
		return "edit_appointment";
	}

	@PostMapping("/appointments/{id}")
	public String updateAppointment(@PathVariable Long id,
			@ModelAttribute("appointments") Appointments appointments,
			Model model) {
		
		// get patient from database by id
		Appointments existingAppointment = appointmentService.getAppointmentById(id);
		existingAppointment.setId(id);
		existingAppointment.setPatientId(appointments.getPatientId());
		existingAppointment.setAppointmentDate(appointments.getAppointmentDate());
		existingAppointment.setStatus(appointments.getStatus());
		existingAppointment.setComments(appointments.getComments());
		
		
		// save updated patient object
		appointmentService.updateAppointments(existingAppointment);
		return "redirect:/appointments";		
	}
	
	// handler method to handle delete patient request
	
	@GetMapping("/appointments/{id}")
	public String deleteAppointment(@PathVariable Long id) {
		appointmentService.deleteAppointmentById(id);
		return "redirect:/appointments";
	}
	
	@GetMapping("/patient/appointment/{patientId}")
	public String getAllPatientAppointmentDetails(@PathVariable Long patientId) {
		appointmentService.getAllPatientAppointment(patientId);
		return "redirect:/appointments";
	}
	
}


