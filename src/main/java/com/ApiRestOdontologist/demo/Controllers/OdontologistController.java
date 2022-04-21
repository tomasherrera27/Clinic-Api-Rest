package com.ApiRestOdontologist.demo.Controllers;

import com.ApiRestOdontologist.demo.Dto.OdontologistDTO;
import com.ApiRestOdontologist.demo.Entities.Odontologist;
import com.ApiRestOdontologist.demo.Exceptions.ResourceNotFoundException;
import com.ApiRestOdontologist.demo.Services.Impl.OdontologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/odontologos")
@CrossOrigin(origins="*")
public class OdontologistController {
    @Autowired
    private OdontologistService odontologistService;
    @GetMapping("/{id}")
    public ResponseEntity<OdontologistDTO> findById(@PathVariable("id") Integer id ){
        OdontologistDTO odontologistDTO = odontologistService.findById(id);
        return new ResponseEntity<>(odontologistDTO, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Set<OdontologistDTO>> findAll(){
        return  ResponseEntity.ok(odontologistService.findAll());
    }
    @PostMapping("/registrarOdontologo")
    public ResponseEntity<OdontologistDTO> crateOdontologist(@RequestBody OdontologistDTO odontologistDTO){
        OdontologistDTO newOdontologistDTO = odontologistService.Create(odontologistDTO);
        return new ResponseEntity<>(newOdontologistDTO, HttpStatus.OK);
    }

    @PutMapping("/editarOdontologo")
    public ResponseEntity<OdontologistDTO> editOdontologist(@RequestBody OdontologistDTO odontologistDTO){
        OdontologistDTO editedOdontologist = odontologistService.update(odontologistDTO);
        return new ResponseEntity<>(editedOdontologist, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        ResponseEntity<String> response = null;
        if (odontologistService.findById(id) != null){
            odontologistService.deleteById(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");

        }else{
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("no se pudo eliminar");
        }
        return response;

    }
}
