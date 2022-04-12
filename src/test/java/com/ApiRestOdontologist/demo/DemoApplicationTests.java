package com.ApiRestOdontologist.demo;

import com.ApiRestOdontologist.demo.Dto.PatientDTO;
import com.ApiRestOdontologist.demo.Entities.Patient;
import com.ApiRestOdontologist.demo.Services.Impl.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {
/*
	@Autowired
	private PatientService patientService;
	 @Test
	public void createPatient(){
		PatientDTO patientDTO = new PatientDTO();
		 patientDTO.setName("tomas");
		 patientDTO.setLastname("herrera");
		 patientService.Create(patientDTO);

		 PatientDTO patientTomas = patientService.findById(1);
		 assertTrue(patientTomas != null);
	 }
	 @Test
	public void deletePatient(){
		 patientService.deleteById(1);
		 PatientDTO patientTomas = patientService.findById(1);
		 assertTrue(patientTomas == null);
	 }
*/
}
