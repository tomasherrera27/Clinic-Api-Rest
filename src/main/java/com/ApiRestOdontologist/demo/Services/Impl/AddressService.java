package com.ApiRestOdontologist.demo.Services.Impl;

import com.ApiRestOdontologist.demo.Dto.AddressDTO;
import com.ApiRestOdontologist.demo.Entities.Address;
import com.ApiRestOdontologist.demo.Repositories.IAddressRepository;
import com.ApiRestOdontologist.demo.Services.IAddressService;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private IAddressRepository addressRepository;
    @Autowired
    private ModelMapper modelMapper;
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
    public List<AddressDTO> findAll() {
        List<Address> addressList = addressRepository.findAll();
        List<AddressDTO> addressDTOList = addressList.stream().map(address -> mapToDTO(address)).collect(Collectors.toList());
        return  addressDTOList;
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
