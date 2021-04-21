package com.lattice.assignment.service;


import java.util.List;

import com.lattice.assignment.dto.PatientDto;
import com.lattice.assignment.entity.Patient;

public interface PatientService {

	Patient  addNewPatient(PatientDto patient);

	void deleteByUserId(long id);

	Patient updatePatient(long id, PatientDto patientDto);

	List<Patient> getAllPatient();



}
