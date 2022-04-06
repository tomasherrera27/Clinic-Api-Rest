package com.ApiRestOdontologist.demo.Controllers;

import com.ApiRestOdontologist.demo.Dto.OdontologistDTO;
import com.ApiRestOdontologist.demo.Entities.Odontologist;
import com.ApiRestOdontologist.demo.Services.Impl.OdontologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/odontologos")
public class OdontologistController {
    @Autowired
    private OdontologistService odontologistService;
    @GetMapping("/{id}")
    public ResponseEntity<OdontologistDTO> findById(@PathVariable("id") Integer id ){
        OdontologistDTO odontologistDTO = odontologistService.findById(id);
        return new ResponseEntity<>(odontologistDTO, HttpStatus.OK);
    }
    @PostMapping("/registrarOdontologo")
    public ResponseEntity<OdontologistDTO> crateOdontologist(@RequestBody OdontologistDTO odontologistDTO){
        OdontologistDTO newOdontologistDTO = odontologistService.Create(odontologistDTO);
        return new ResponseEntity<>(newOdontologistDTO, HttpStatus.OK);
    }
}
