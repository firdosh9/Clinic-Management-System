package net.javaproject.cms.dto;

public class PatientAppointmentDTO {
	
	@Override
	public String toString() {
		return "PatientAppointmentDTO [patientId=" + patientId + ","
				+ " appointmentId=" + appointmentId 
				+ ", appointmentDate=" + appointmentDate 
				+ ", firstName=" + firstName + ", address=" + address
				+ ", LastName=" + LastName + ", phoneNo=" + phoneNo 
				+ ", email=" + email + ", status=" + status + ", comments="
				+ comments + "]";
	}
	private String patientId;
	private String appointmentId;
	private String appointmentDate;
	private String firstName;
	private String LastName;
	private String phoneNo;
	private String email;
	private String address;
	private String status;
	private String comments;
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
