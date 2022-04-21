package com.ApiRestOdontologist.demo.Services.Impl;

import com.ApiRestOdontologist.demo.Dto.PatientDTO;
import com.ApiRestOdontologist.demo.Entities.Patient;
import com.ApiRestOdontologist.demo.Repositories.IPatientRepository;
import com.ApiRestOdontologist.demo.Services.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PatientService implements IPatientService {
    @Autowired
    IPatientRepository patientRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ObjectMapper mapper;

    @Override
    public PatientDTO findById(@NotNull  Integer id) {
        Patient patient = patientRepository.getById(id);
        PatientDTO savePatientDTO = mapToDTO(patient);
        return savePatientDTO;

    }

    @Override
    public PatientDTO Create( PatientDTO patientDTO) {
        Patient newPatientSaved = patientRepository.save(mapToEntity(patientDTO));
        PatientDTO newPatientDTO = mapToDTO(newPatientSaved);
        return newPatientDTO;
    }

    @Override
    public void deleteById(@NotNull Integer id) {
        Patient patient = patientRepository.getById(id);
        patientRepository.delete(patient);
    }

    @Override
    public PatientDTO update(PatientDTO patientDTO) {
        Patient patient = mapToEntity(patientDTO);
        Patient newPatientSaved = patientRepository.save(patient);
        return mapToDTO(newPatientSaved);
    }

    @Override
    public Set<PatientDTO> findAll() {
        List<Patient> pacientes = patientRepository.findAll();

        //recorremos la lista para agregar a pacientes dto
        Set<PatientDTO> pacientesDTO = new HashSet<>();

        for (Patient paciente : pacientes){
            pacientesDTO.add(mapper.convertValue(paciente,PatientDTO.class));

        }
        return pacientesDTO;
    }



    @Override
    public PatientDTO getPatientByEmail(String email){
        Patient patient = patientRepository.findPatientByEmail(email);
        return mapToDTO(patient);
    }
    @Override
    public PatientDTO getPatientByName(String name){
        Patient patient = patientRepository.findPatientByName(name);
        return mapToDTO(patient);
    }


    // MAPPERS
    private PatientDTO mapToDTO(Patient patient){
        PatientDTO patientDTO = modelMapper.map(patient, PatientDTO.class);

        return patientDTO;
    }

    private Patient mapToEntity(PatientDTO patientDTO){
        Patient patient = modelMapper.map(patientDTO, Patient.class);

        return patient;
    }
}
