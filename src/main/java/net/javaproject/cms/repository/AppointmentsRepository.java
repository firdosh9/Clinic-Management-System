package net.javaproject.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.javaproject.cms.entity.Appointments;

@Repository
public interface AppointmentsRepository  extends JpaRepository<Appointments, Long>{
	
	@Query(value="select pa.address,pa.email,pa.first_name,pa.last_name,"
			+ "pa.phone,ap.comments,ap.id as apId from appointments ap "
			+ "join patients pa on pa.id=ap.patient_id where patient_id = :patientId" ,
			nativeQuery = true)
	List<Object[]> findAppointmentForPatient(@Param("patientId")String patientId);
	
	@Query(value="select pa.address,pa.email,pa.first_name,pa.last_name,pa.phone,"
			+ "ap.comments,ap.id as apId, ap.appointment_date from appointments "
			+ "ap join patients pa on pa.id=ap.patient_id" , nativeQuery = true)
	List<Object[]> findAppointmentsForClinic();
}
