package com.ApiRestOdontologist.demo.Services.Impl;


import com.ApiRestOdontologist.demo.Dto.TurnDTO;
import com.ApiRestOdontologist.demo.Entities.Turn;
import com.ApiRestOdontologist.demo.Exceptions.ResourceNotFoundException;
import com.ApiRestOdontologist.demo.Repositories.ITurnRepository;
import com.ApiRestOdontologist.demo.Services.ITurnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TurnService implements ITurnService {
    @Autowired
    ITurnRepository turnRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ObjectMapper mapper;

    @Override
    public TurnDTO findById(@NotNull Integer id) throws ResourceNotFoundException {
        Turn turn = turnRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("turno no encontrado"));
        return mapToDTO(turn);
    }

    @Override
    public TurnDTO Create(TurnDTO turnDTO) {
       Turn turn = mapToEntity(turnDTO);
       Turn newTurn = turnRepository.save(turn);
       return mapToDTO(newTurn);

    }

    @Override
    public void deleteById(@NotNull Integer id) throws ResourceNotFoundException {
        Turn turn = turnRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("no se pudo encontrar el id"));
        turnRepository.delete(turn);
    }

    @Override
    public TurnDTO update(TurnDTO turnDTO) {
        Turn turn = mapToEntity(turnDTO);
        Turn newTurn = turnRepository.save(turn);
        return mapToDTO(newTurn);
    }

    @Override
    public List<TurnDTO> findAll() {
        return null;
    }

    @Override
    public Set<TurnDTO> listTurns() {
        List<Turn> turnos = turnRepository.findAll();
        Set<TurnDTO> turnosDto = new HashSet<>();

        for( Turn turno : turnos){
            turnosDto.add(mapper.convertValue(turno,TurnDTO.class));
        }
        return turnosDto;
    }


        // MAPPERS
    private TurnDTO mapToDTO(Turn turn){
        TurnDTO turnDTO = modelMapper.map(turn, TurnDTO.class);

        return turnDTO;
    }

    private Turn mapToEntity(TurnDTO turnDTO){
       Turn turn  = modelMapper.map(turnDTO, Turn.class);

        return turn;
    }


}
