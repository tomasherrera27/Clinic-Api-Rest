package com.ApiRestOdontologist.demo.Services.Impl;


import com.ApiRestOdontologist.demo.Dto.OdontologistDTO;
import com.ApiRestOdontologist.demo.Entities.Odontologist;
import com.ApiRestOdontologist.demo.Exceptions.ResourceNotFoundException;
import com.ApiRestOdontologist.demo.Repositories.IOdontologistRepository;
import com.ApiRestOdontologist.demo.Services.IOdontologistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OdontologistService implements IOdontologistService {
    @Autowired
    private IOdontologistRepository odontologistRepository;
    //tuve que cambiar a object porque tuve algunos problemas con model mapper
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public OdontologistDTO findById(@NotNull Integer id) {
        Optional<Odontologist> odontologist =  odontologistRepository.findById(id);
        OdontologistDTO odontologistDTO = null;
        if(odontologist != null)
            odontologistDTO = objectMapper.convertValue(odontologist, OdontologistDTO.class);
            return odontologistDTO;

    }

    @Override
    public OdontologistDTO Create(@NotNull  OdontologistDTO odontologistDTO) {
        Odontologist odontologist = mapEntity(odontologistDTO);
        Odontologist saveOdontologist = odontologistRepository.save(odontologist);
        return mapDTO(saveOdontologist);
    }

    @Override
    public void deleteById(@NotNull Integer id) {
        Odontologist odontologist = odontologistRepository.getById(id);
        odontologistRepository.delete(odontologist);
    }

    @Override
    public OdontologistDTO update(OdontologistDTO odontologistDTO) {
        Odontologist odontologist = mapEntity(odontologistDTO);
        Odontologist saveOdontologist = odontologistRepository.save(odontologist);
        return mapDTO(saveOdontologist);
    }

    @Override
    public List<OdontologistDTO> findAll() {
        List<Odontologist> list = odontologistRepository.findAll();
        List<OdontologistDTO> DTOlist = list.stream().map(odontologist -> mapDTO(odontologist)).collect(Collectors.toList());
        return DTOlist;
    }

    @Override
    public Set<OdontologistDTO> listTurns() {
        return null;
    }

    // mapper
    private OdontologistDTO mapDTO(Odontologist odontologist){
        OdontologistDTO odontologistDTO = modelMapper.map(odontologist, OdontologistDTO.class);
        return odontologistDTO;
    }
    private Odontologist mapEntity(OdontologistDTO odontologistDTO){
        Odontologist odontologist = modelMapper.map(odontologistDTO, Odontologist.class);
        return odontologist;
    }
}
