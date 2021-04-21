package com.lattice.assignment.controller;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.lattice.assignment.dto.PatientDto;
import com.lattice.assignment.entity.Patient;
import com.lattice.assignment.service.PatientService;


@Controller
public class PatientController {
	
	Logger logger = LogManager.getLogger();
	
	@Autowired
	private PatientService service;
		
	@PostMapping("/addPatient")
	public ResponseEntity addPatient(@Valid @RequestBody PatientDto patientDto) {
		
	/*	List<String> checkValidity = PatientValidity.checkValidity(patientDto);
		
		if(checkValidity.size()>0) {
			logger.error("Bad Credentials");
			return ResponseEntity.ok(checkValidity);
		}
		*/
		
		try {
			
			Pattern phonePattern = Pattern.compile("(0|91)[6-9][0-9]{9}");
			Matcher match =phonePattern.matcher(patientDto.getPhone());
			Boolean bool= match.find() && match.group().equals(patientDto.getPhone());
			if(!bool) {
				return ResponseEntity.ok("Invalid Phone Number");
			}	
			
			Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,15}$");
			Matcher passwordMatch =passwordPattern.matcher(patientDto.getPassword());
			Boolean pass= passwordMatch.find() && passwordMatch.group().equals(patientDto.getPassword());
			if(!pass) {
				return ResponseEntity.ok("must contain one upper character, one lower character and a number. Max length 15 and min length 8");
			}
			
		Patient addNewPatient = service.addNewPatient(patientDto);
		return ResponseEntity.ok(addNewPatient);
		}catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	
	@PostMapping("/deletePatient")
	public ResponseEntity<String> deletePatient(@RequestParam("userId") long id) {
		
		service.deleteByUserId(id);
		logger.info("Patient deleted");
		return ResponseEntity.ok("Patient Deleted");
	}
	
	@PatchMapping("/update")
	public ResponseEntity updatePatient(@RequestParam("userId") long id, @RequestBody PatientDto patientDto){
		
		try {
		Patient updatedPatient = service.updatePatient(id,patientDto);
		return ResponseEntity.ok(updatedPatient);
		}catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
	}
	
	@GetMapping("/getAllPatient")
	public ResponseEntity<List<Patient>> getAllPatient() {
		logger.info("Request For updation");
		
		List<Patient> allPatients = service.getAllPatient();
		
		return ResponseEntity.ok(allPatients);
	}

}
