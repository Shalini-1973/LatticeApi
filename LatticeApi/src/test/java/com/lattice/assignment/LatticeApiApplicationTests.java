package com.lattice.assignment;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.lattice.assignment.dto.PatientDto;
import com.lattice.assignment.entity.Patient;
import com.lattice.assignment.repo.PatientRepository;
import com.lattice.assignment.service.PatientService;

@SpringBootTest
class LatticeApiApplicationTests {

	@Autowired
	private PatientService service;
	
	@MockBean
	private PatientRepository repo;
	
	@Test
	public void getAllPatientTest() {
		when(repo.findAll()).thenReturn(Stream
				.of(new Patient("amit","delhi","abc@gmail.com","55556666","abcd1234")).collect(Collectors.toList()));
		
		assertEquals(2,service.getAllPatient().size());
	}
	
	@Test
	public void savePatientTest() {
		Patient patient = new Patient();
		patient.setName("Shalini");
		patient.setAddress("katihar");
		patient.setEmail("shalini@gmail.com");
		patient.setPassword("shalini123");
		patient.setPhone("6204789652");
		
		PatientDto pd = new PatientDto();
		pd.setAddress(patient.getAddress());
		pd.setName(patient.getName());
		pd.setEmail(patient.getEmail());
		pd.setPassword(patient.getPassword());
		pd.setPhone(patient.getPhone());
		when(repo.save(patient)).thenReturn(patient);
		assertEquals(patient,service.addNewPatient(pd));
	}
	
	@Test
	public void deleteUserById() {
		long id=1;
		service.deleteByUserId(id);
		verify(repo,times(1)).deleteById(id);
	}
	
}
