package com.ankita.ncd.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.ankita.ncd.models.Patient;
import com.ankita.ncd.payloads.PatientDto;
import com.ankita.ncd.payloads.ScoreDto;
import com.ankita.ncd.repository.PatientRepo;
import com.ankita.ncd.services.PatientService;
import com.ankita.ncd.exceptions.*;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepo patientRepo;
	
	
	
	public PatientServiceImpl(PatientRepo patientRepo) {
		super();
		this.patientRepo = patientRepo;
	}

	@Override
	public PatientDto createPatient(PatientDto patientDto) {
		
		Patient patient = this.dtoToPatient(patientDto);
		Patient savedPatient = this.patientRepo.save(patient);
		return this.patientToDto(savedPatient);
	}

	@Override
	public PatientDto updatePatient(ScoreDto scoreDto, String patientid) {
		
		Patient patient=this.patientRepo.findByPid(patientid);
				//.orElseThrow(()-> new ResourceNotFoundException("Patient"," patient_id ",patientid));
		int totalScore;
		
		totalScore =scoreDto.getAge() + scoreDto.getSmoke() + scoreDto.getAlcohol() + scoreDto.getWaist() + scoreDto.getPhy_act() + scoreDto.getFam_his();
		String screening = "";
		if (totalScore > 4)
		{
			screening ="Yes";
		}
		else
		{
			screening="No";
		}
		
		patient.setScore(totalScore);
		patient.setScreening(screening);
		
		Patient updatedPatient = this.patientRepo.save(patient);
		PatientDto patientDto1 = this.patientToDto(updatedPatient);
		
		return patientDto1;
	}

	@Override
	public List<PatientDto> getPatientByPatientid(String patientid) {
		
		
		List<Patient> patients=this.patientRepo.findByPatientid(patientid);
		
		int flag=0;
		
		for(Patient p : patients)
		{
			if(p!=null)
			{
				flag=1;
			}
			
			else
			{
				flag=0;
				
			}
		}
		
		if(flag==1)
		{
			List<PatientDto> patientDtos = patients.stream().map(patient->this.patientToDto(patient)).collect(Collectors.toList());
			
			return patientDtos;
		}
		
		else
		{
			throw new ResourceNotFoundException("Patient","patient Id",patientid);
		}
		 
		//patient.orElseThrow(()-> new ResourceNotFoundException("Patient"," patient_id ",patientid));
		//List<PatientDto> patientDtos = patients.stream().map(patient->this.patientToDto(patient)).collect(Collectors.toList());
		
		//return patientDtos;
		
	}

	@Override
	public List<PatientDto> getPatientByFirstname(String firstname) {

		List<Patient> patients = this.patientRepo.findByFirstname(firstname);
				//orElseThrow(()-> new NoSuchResourceFoundException("Patient"," first_name ",firstname));
		int flag=0;
		
		for(Patient p : patients)
		{
			if(p!=null)
			{
				flag=1;
			}
			
			else
			{
				flag=0;
				
			}
		}
		
		if(flag==1)
		{
			List<PatientDto> patientDtos = patients.stream().map(patient->this.patientToDto(patient)).collect(Collectors.toList());
			
			return patientDtos;
		}
		else
		{
			throw new ResourceNotFoundException("Patient","First Name",firstname);
		}
		
		//List<PatientDto> patientDtos = patients.stream().map(patient->this.patientToDto(patient)).collect(Collectors.toList());
		
		//return patientDtos;
	}

	@Override
	public List<PatientDto> getPatientByLastname(String lastname) {
		
		List<Patient> patients = this.patientRepo.findByLastname(lastname);
		//orElseThrow(()-> new NoSuchResourceFoundException("Patient"," first_name ",lastname));
		
		int flag=0;
		
		for(Patient p : patients)
		{
			if(p!=null)
			{
				flag=1;
			}
			
			else
			{
				flag=0;
				
			}
		}
		
		if(flag==1)
		{
			List<PatientDto> patientDtos = patients.stream().map(patient->this.patientToDto(patient)).collect(Collectors.toList());
			
			return patientDtos;
		}
		else
		{
			throw new ResourceNotFoundException("Patient","Last Name",lastname);
		}
		
		
		//List<PatientDto> patientDtos = patients.stream().map(patient->this.patientToDto(patient)).collect(Collectors.toList());
		
		//return patientDtos;
				
	}

	@Override
	public List<PatientDto> getAllPatients() {

		List<Patient> patients = this.patientRepo.findAll();	
		
		List<PatientDto> patientDtos = patients.stream().map(patient->this.patientToDto(patient)).collect(Collectors.toList());
		
		return patientDtos;
	}
	
	public Patient dtoToPatient(PatientDto patientDto)
	{
		Patient patient = new Patient();
		patient.setPatientid(patientDto.getPatientid());
		patient.setFirstname(patientDto.getFirstname());
		patient.setLastname(patientDto.getLastname());
		patient.setGender(patientDto.getGender());
		patient.setPhone(patientDto.getPhone());
		patient.setBirthday(patientDto.getBirthday());
		patient.setPincode(patientDto.getPincode());
		patient.setScore(patientDto.getScore());
		patient.setScreening(patientDto.getScreening());
		
		return patient;
	}
	
	public PatientDto patientToDto(Patient patient)
	{
		PatientDto patientDto = new PatientDto();
		patientDto.setPatientid(patient.getPatientid());
		patientDto.setFirstname(patient.getFirstname());
		patientDto.setLastname(patient.getLastname());
		patientDto.setGender(patient.getGender());
		patientDto.setPhone(patient.getPhone());
		patientDto.setBirthday(patient.getBirthday());
		patientDto.setPincode(patient.getPincode());
		patientDto.setScore(patient.getScore());
		patientDto.setScreening(patient.getScreening());
		
		return patientDto;
	}
	

}
