package com.ApiRestOdontologist.demo.Controllers;

import com.ApiRestOdontologist.demo.Dto.TurnDTO;
import com.ApiRestOdontologist.demo.Services.Impl.TurnService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnController {
    @Autowired
    TurnService turnService;
    @PostMapping("/agendarTurno")
    public ResponseEntity<?> saveTurn(@RequestBody TurnDTO turnDTO){
        turnService.Create(turnDTO);
        return new ResponseEntity<>(turnDTO, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<?> showTurns(){
        Set<TurnDTO> turnDTOS = turnService.listTurns();
        return new ResponseEntity<>(turnDTOS, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> showOneTurn(@PathVariable Integer id){
        TurnDTO turnDTO = turnService.findById(id);
        return new ResponseEntity<>(turnDTO, HttpStatus.OK);
    }
    @PutMapping("/acutualizar")
    public ResponseEntity<?> update(@RequestBody TurnDTO turnDTO){
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
    public ResponseEntity<?> delete(@PathVariable Integer id){
        ResponseEntity response = null;
        if (turnService.findById(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            turnService.deleteById(id);
            response = new ResponseEntity<>("Turno  eliminado", HttpStatus.OK);
        }
        return  response;
    }
    }

