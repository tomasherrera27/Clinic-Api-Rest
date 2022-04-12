package com.ApiRestOdontologist.demo.Services;

import com.ApiRestOdontologist.demo.Dto.PatientDTO;

public interface IPatientService extends ICrudService<PatientDTO>{
    PatientDTO getPatientByEmail(String email);
    PatientDTO getPatientByName(String name);
}
