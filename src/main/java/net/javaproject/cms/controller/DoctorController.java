package net.javaproject.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaproject.cms.entity.Doctors;
import net.javaproject.cms.service.DoctorService;

@Controller
public class DoctorController {
	
	private DoctorService doctorService;

	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
	
	// handler method to handle list patients and return mode and view
	@GetMapping("/doctors")
	public String listDoctors(Model model) {
		model.addAttribute("doctors", doctorService.getAllDoctors());
		return "doctors";
	}
	
	@GetMapping("/doctors/new")
	public String createDoctorForm(Model model) {
		// create doctor object to hold doctor form data
		Doctors doctors = new Doctors();
		model.addAttribute("doctor", doctors);
		return "create_doctor";
		
	}
	
	@PostMapping("/doctors")
	public String saveDoctor(@ModelAttribute("doctors") Doctors doctor) {
		doctorService.saveDoctor(doctor);
		return "redirect:/doctors";
	}
	
	@GetMapping("/doctors/edit/{id}")
	public String editDoctorForm(@PathVariable Long id, Model model) {
		model.addAttribute("doctor", doctorService.getDoctorById(id));
		return "edit_doctor";
	}

	@PostMapping("/doctors/{id}")
	public String updateDoctor(@PathVariable Long id,
			@ModelAttribute("doctors") Doctors doctors,
			Model model) {
		
		// get patient from database by id
		Doctors existingDoctor = doctorService.getDoctorById(id);
		existingDoctor.setId(id);
		existingDoctor.setFirstName(doctors.getFirstName());
		existingDoctor.setLastName(doctors.getLastName());
		existingDoctor.setEmail(doctors.getEmail());
		existingDoctor.setPhone(doctors.getPhone());
		existingDoctor.setAddress(doctors.getAddress());
		existingDoctor.setExpertise (doctors.getExpertise ());
		existingDoctor.setTiming (doctors.getTiming());
		
		// save updated patient object
		doctorService.updateDoctor(existingDoctor);
		return "redirect:/doctors";		
	}
	
	// handler method to handle delete patient request
	
	@GetMapping("/doctors/{id}")
	public String deleteDoctor(@PathVariable Long id) {
		doctorService.deleteDoctorById(id);
		return "redirect:/doctors";
	}
	
}
