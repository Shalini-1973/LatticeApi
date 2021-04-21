package com.lattice.assignment.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lattice.assignment.dto.PatientDto;
import com.lattice.assignment.entity.Patient;
import com.lattice.assignment.repo.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientRepository repository;
	

	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@Override
	public Patient addNewPatient(PatientDto patient) {
		Patient newPatient = new Patient();
		newPatient.setName(patient.getName());
		newPatient.setAddress(patient.getAddress());
		newPatient.setEmail(patient.getEmail());
		newPatient.setPhone(patient.getPhone());
		newPatient.setPassword(passwordEncoder.encode(patient.getPassword()));
		Patient saved = repository.save(newPatient);
		return saved;
	}


	@Override
	public void deleteByUserId(long id) {
		repository.deleteById(id);
	}


	@Override
	public Patient updatePatient(long id, PatientDto patientDto) {
		
		Patient oldPatient = repository.findById(id).get();
		oldPatient.setName(patientDto.getName());
		oldPatient.setAddress(patientDto.getAddress());
		oldPatient.setEmail(patientDto.getEmail());
		oldPatient.setPhone(patientDto.getPhone());
		oldPatient.setPassword(patientDto.getPassword());
		return repository.save(oldPatient);
	}


	@Override
	public List<Patient> getAllPatient() {
		List<Patient> allPatient = repository.findAll();
		System.out.println("all patients : "+allPatient);
		return allPatient;
		
	}

}
