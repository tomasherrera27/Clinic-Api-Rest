package com.ApiRestOdontologist.demo.Test;


import com.ApiRestOdontologist.demo.Dto.OdontologistDTO;
import com.ApiRestOdontologist.demo.Exceptions.ResourceNotFoundException;
import com.ApiRestOdontologist.demo.Services.IOdontologistService;
import com.ApiRestOdontologist.demo.Services.Impl.OdontologistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

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
        OdontologistDTO save = odontologistService.Create(odontologistDTO);
        assertEquals(save.getName(), odontologistDTO.getName());
    }

    @Test
    public void deleteOdontologist() {

    }

}
