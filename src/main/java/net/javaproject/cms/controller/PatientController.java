package net.javaproject.cms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaproject.cms.entity.Patients;
import net.javaproject.cms.service.PatientService;

@Controller
public class PatientController {
	
	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	
	// handler method to handle list patients and return mode and view
	@GetMapping("/patients")
	public String listPatients(Model model) {
		model.addAttribute("patients", patientService.getAllPatients());
		return "patients";
	}
	
	@GetMapping("/all-patients")
	public List<Patients> listAllPatients() {
		return patientService.getAllPatients();
	}
	
	@GetMapping("/patients/new")
	public String createPatientForm(Model model) {
		// create patient object to hold patient form data
		Patients patients = new Patients();
		model.addAttribute("patient", patients);
		return "create_patient";
		
	}
	
	@PostMapping("/patients")
	public String savePatient(@ModelAttribute("patients") Patients patient) {
		patientService.savePatient(patient);
		return "redirect:/patients";
	}
	
	@GetMapping("/patients/edit/{id}")
	public String editPatientForm(@PathVariable Long id, Model model) {
		model.addAttribute("patient", patientService.getPatientById(id));
		return "edit_patient";
	}

	@PostMapping("/patients/{id}")
	public String updatePatient(@PathVariable Long id,
			@ModelAttribute("patients") Patients patients,
			Model model) {
		
		// get patient from database by id
		Patients existingPatient = patientService.getPatientById(id);
		existingPatient.setId(id);
		existingPatient.setFirstName(patients.getFirstName());
		existingPatient.setLastName(patients.getLastName());
		existingPatient.setEmail(patients.getEmail());
		existingPatient.setPhone(patients.getPhone());
		existingPatient.setAddress(patients.getAddress());
		existingPatient.setWeight(patients.getWeight());
		existingPatient.setHeight(patients.getHeight());
		existingPatient.setMedicalHistory(patients.getMedicalHistory());
		
		// save updated patient object
		patientService.updatePatient(existingPatient);
		return "redirect:/patients";		
	}
	
	// handler method to handle delete patient request
	
	@GetMapping("/patients/{id}")
	public String deletePatient(@PathVariable Long id) {
		patientService.deletePatientById(id);
		return "redirect:/patients";
	}
	
}
