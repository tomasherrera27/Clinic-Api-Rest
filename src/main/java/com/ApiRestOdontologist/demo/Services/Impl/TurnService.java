package com.ApiRestOdontologist.demo.Services.Impl;


import com.ApiRestOdontologist.demo.Dto.TurnDTO;
import com.ApiRestOdontologist.demo.Entities.Turn;
import com.ApiRestOdontologist.demo.Repositories.ITurnRepository;
import com.ApiRestOdontologist.demo.Services.ITurnService;
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

    @Override
    public TurnDTO findById(@NotNull Integer id) {
        Turn turn = turnRepository.getById(id);
        TurnDTO turnDTO = mapToDTO(turn);
        return turnDTO;
    }

    @Override
    public TurnDTO Create(@NotNull TurnDTO turnDTO) {
       Turn turn = mapToEntity(turnDTO);
       Turn newTurn = turnRepository.save(turn);
       return mapToDTO(newTurn);

    }

    @Override
    public void deleteById(@NotNull Integer id) {
        Turn turn = turnRepository.getById(id);
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
        List<Turn> list = turnRepository.findAll();
        Set<TurnDTO> DTOlist = new HashSet<>();
        for (Turn turn: list){
            DTOlist.add(mapToDTO(turn));
        }
        return DTOlist;
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