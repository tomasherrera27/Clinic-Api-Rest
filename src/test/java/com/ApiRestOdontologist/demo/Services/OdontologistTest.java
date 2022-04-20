package com.ApiRestOdontologist.demo.Services;


import com.ApiRestOdontologist.demo.Dto.OdontologistDTO;
import com.ApiRestOdontologist.demo.Services.Impl.OdontologistService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class OdontologistTest {
    @Autowired
    private OdontologistService odontologistService;
    private OdontologistDTO odontologistDTO;

    @BeforeEach
    public void setUp() {
        odontologistDTO = new OdontologistDTO();
        odontologistDTO.setName("Dentista creado con test");
        odontologistDTO.setLastname("test");
        odontologistDTO.setLicence("123afgkj");
    }
    @Test
    public void saveOdontologist(){
        OdontologistDTO odontologist = odontologistService.Create(odontologistDTO);
        assertEquals(odontologist.getName(), odontologistDTO.getName());
    }
    @Test
    public void findById(){
        OdontologistDTO result = odontologistService.Create(odontologistDTO);
        assertNotNull(odontologistService.findById(result.getId()));
    }
    @Test
    public void listAll(){
        List<OdontologistDTO> odontologistList = odontologistService.findAll();
        Assert.assertTrue(!odontologistList.isEmpty());
        Assert.assertTrue(odontologistList.size() > 0);
    }
 /*
    @Test
    public void deleteOdontologist() {
        odontologistService.deleteById(27);
        assertEquals(null, odontologistService.findById(27));
    }
    @Test
    public void testUpdateDentist(){
        OdontologistDTO result = odontologistService.Create(odontologistDTO);
        OdontologistDTO getCreate = odontologistService.findById(result.getId());
        getCreate.setName("DentistUpdate");
       OdontologistDTO update = odontologistService.update(result);
        assertNotEquals(update, getCreate);

    }*/
    /*
    @Test
    public void testDeleteDentist()  {
        OdontologistDTO result = odontologistService.Create(odontologistDTO);
        assertNotNull(odontologistService.findById(result.getId()));
        odontologistService.deleteById(result.getId());
        assertThrows(Exception.class, () ->odontologistService.findById(result.getId()));
    }
    */


}
