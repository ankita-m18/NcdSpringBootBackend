package com.ankita.ncd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankita.ncd.payloads.PatientDto;
import com.ankita.ncd.payloads.ScoreDto;
import com.ankita.ncd.services.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
	@Autowired
    private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
    
	
	//POST - create patient
	@PostMapping("/")
	public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto)
	{
		PatientDto createdPatientDto = this.patientService.createPatient(patientDto);
		return new ResponseEntity<>(createdPatientDto,HttpStatus.CREATED);
	}
	
	//PUT - update patient
	@PutMapping("/{patientid}")
	public ResponseEntity<PatientDto> updatePatient(@RequestBody ScoreDto scoreDto,@PathVariable("patientid") String patientid)
	{
		PatientDto updatedPatientDto = this.patientService.updatePatient(scoreDto, patientid);
		return ResponseEntity.ok(updatedPatientDto);
	}
	
	//GET - select  all patient
	@GetMapping("/")
	public ResponseEntity<List<PatientDto>> getAllPatients()
	{
		return ResponseEntity.ok(this.patientService.getAllPatients());
	}
	
	//GET - select patient by patient_id
	@GetMapping("/id/{patientid}")
	public ResponseEntity<List<PatientDto>> getPatientById(@PathVariable("patientid") String patientid)
	{
		return ResponseEntity.ok(this.patientService.getPatientByPatientid(patientid));
	}
	
	//GET - select patient by patient_id
	@GetMapping("/firstname/{firstname}")
	public ResponseEntity<List<PatientDto>> getPatientByFirstname(@PathVariable("firstname") String firstname)
	{
		return ResponseEntity.ok(this.patientService.getPatientByFirstname(firstname));
	}
	
	//GET - select patient by patient_id
	@GetMapping("/lastname/{lastname}")
	public ResponseEntity<List<PatientDto>> getPatientByLastname(@PathVariable("lastname") String lastname)
	{
		return ResponseEntity.ok(this.patientService.getPatientByLastname(lastname));
	}

}
