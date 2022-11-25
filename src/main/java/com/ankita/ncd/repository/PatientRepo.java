package com.ankita.ncd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ankita.ncd.models.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long>{
	
//	@Query(value = "SELECT * FROM patient_info p WHERE p.patient_id=?1", nativeQuery = true)
//	Patient findByPatientId(long patientid);
	
	@Query(value = "SELECT * FROM patient_info p WHERE p.patient_id = ?1", nativeQuery = true)
	Patient findByPid(String patientid);
	
	@Query(value = "SELECT * FROM patient_info p WHERE p.patient_id = ?1", nativeQuery = true)
	List<Patient> findByPatientid(String patientid);
	
	@Query(value = "SELECT * FROM patient_info p WHERE p.first_name = ?1", nativeQuery = true)
	List<Patient> findByFirstname(String firstname);
	
	@Query(value = "SELECT * FROM patient_info p WHERE p.last_name = ?1", nativeQuery = true)
	List<Patient> findByLastname(String lastname);
	
}
