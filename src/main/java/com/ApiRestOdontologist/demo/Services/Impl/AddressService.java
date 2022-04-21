package com.ApiRestOdontologist.demo.Services.Impl;

import com.ApiRestOdontologist.demo.Dto.AddressDTO;
import com.ApiRestOdontologist.demo.Entities.Address;
import com.ApiRestOdontologist.demo.Repositories.IAddressRepository;
import com.ApiRestOdontologist.demo.Services.IAddressService;
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
public class AddressService implements IAddressService {
    @Autowired
    private IAddressRepository addressRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    ObjectMapper mapper;

    @Override
    public AddressDTO findById(@NotNull Integer id) {
        Address address = addressRepository.getById(id);
        AddressDTO addressDTO = mapToDTO(address);
        return addressDTO;
    }

    @Override
    public AddressDTO Create(@NotNull AddressDTO addressDTO) {
            Address address = mapToEntity(addressDTO);
            Address newAddress = addressRepository.save(address);
            return mapToDTO(newAddress);
    }

    @Override
    public void deleteById(@NotNull Integer id) {
            Address address = addressRepository.getById(id);
            addressRepository.delete(address);
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {
        Address address = mapToEntity(addressDTO);
        Address newAddress = addressRepository.save(address);
        return mapToDTO(newAddress);
    }

    @Override
    public Set<AddressDTO> findAll() {
        List<Address> addressList = addressRepository.findAll();
        Set<AddressDTO> addressDTOS = new HashSet<>();
        for(Address address : addressList){
            addressDTOS.add(mapper.convertValue(address, AddressDTO.class));

        }
        return  addressDTOS;
    }




    //------ MAPPER -----
    private AddressDTO mapToDTO(Address address){
        AddressDTO adressDTO = modelMapper.map(address, AddressDTO.class);

        return adressDTO;
    }

    private Address mapToEntity(AddressDTO addressDTO){
            Address address = modelMapper.map(addressDTO, Address.class);

        return address;
    }
}
