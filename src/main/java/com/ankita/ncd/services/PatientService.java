package com.ankita.ncd.services;

import java.util.List;

import com.ankita.ncd.payloads.PatientDto;
import com.ankita.ncd.payloads.ScoreDto;

public interface PatientService 
{
	PatientDto createPatient(PatientDto patient);
	
	PatientDto updatePatient(ScoreDto scoreDto,String patientid);
	
	List<PatientDto> getPatientByPatientid(String patientid);
	
	List<PatientDto> getPatientByFirstname(String firstname);
	
	List<PatientDto> getPatientByLastname(String lastname);
	
	List<PatientDto> getAllPatients();
	
}
