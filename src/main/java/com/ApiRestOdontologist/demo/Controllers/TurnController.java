package com.ApiRestOdontologist.demo.Controllers;

import com.ApiRestOdontologist.demo.Dto.TurnDTO;
import com.ApiRestOdontologist.demo.Entities.Turn;
import com.ApiRestOdontologist.demo.Exceptions.ResourceNotFoundException;
import com.ApiRestOdontologist.demo.Services.Impl.TurnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnController {
    @Autowired
    TurnService turnService;


    @PostMapping("/agendarTurno")
    public ResponseEntity<?> saveTurn(@RequestBody TurnDTO turnDTO) throws ResourceNotFoundException {
        turnService.Create(turnDTO);
        return new ResponseEntity<>(turnDTO, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<?> showTurns(){
        Set<TurnDTO> turnsDTO = turnService.findAll();
        return new ResponseEntity<>(turnsDTO,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> showOneTurn(@PathVariable Integer id) throws ResourceNotFoundException{
        TurnDTO turnDTO = turnService.findById(id);
        return new ResponseEntity<>(turnDTO, HttpStatus.OK);
    }
    @PutMapping("/acutualizar")
    public ResponseEntity<?> update(@RequestBody TurnDTO turnDTO) throws ResourceNotFoundException{
        ResponseEntity response = null;
        if (turnService.findById(turnDTO.getId()) == null) {
            response = new ResponseEntity<>(turnDTO, HttpStatus.NOT_FOUND);
        } else {
            turnService.Create(turnDTO);
            response = new ResponseEntity<>("Turno modificado con id: " + turnDTO.getId() + " " + turnDTO.getOdontologist() + " " + turnDTO.getPatient(), HttpStatus.OK);

        }
        return response;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws ResourceNotFoundException {
            turnService.deleteById(id);
            return ResponseEntity.ok("eliminado");
    }

    }

