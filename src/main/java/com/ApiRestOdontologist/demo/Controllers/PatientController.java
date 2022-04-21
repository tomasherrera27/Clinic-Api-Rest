package com.ApiRestOdontologist.demo.Controllers;



import com.ApiRestOdontologist.demo.Dto.PatientDTO;
import com.ApiRestOdontologist.demo.Services.Impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping()
    public ResponseEntity<Set<PatientDTO>> findAll(){
        return  ResponseEntity.ok(patientService.findAll());
    }

    @PostMapping("/registrarPaciente")
    public ResponseEntity<?> registerPatient(@RequestBody PatientDTO patientDTO){
        PatientDTO newPatientDTO = patientService.Create(patientDTO);
        return new ResponseEntity<>(newPatientDTO, HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        PatientDTO patientDTO = patientService.findById(id);
        return new ResponseEntity<>(patientDTO, HttpStatus.OK);
    }
    @GetMapping("/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email){
        PatientDTO patientDTO = patientService.getPatientByEmail(email);
        return new ResponseEntity<>(patientDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable Integer id){
        ResponseEntity response = null;
        if(patientService.findById(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            patientService.deleteById(id);
            response = new ResponseEntity<>("Patient deleted id " + id, HttpStatus.OK);
        }
        return response;
    }
    @PutMapping("/editarPaciente")
    public ResponseEntity<?> modify(@RequestBody PatientDTO patientDTO){
        ResponseEntity<?> response = null;
        if(patientService.findById(patientDTO.getId())== null){
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            patientService.update(patientDTO);
            response = new ResponseEntity<>("update patient, id: " + patientDTO.getId(), HttpStatus.OK);
        }
        return response;
    }

}
