package com.ApiRestOdontologist.demo.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {
    private Integer id;
    private String street;
    private Integer number;
    private String location;
    private String province;

    public AddressDTO(String street, Integer number, String location, String province) {
        this.street = street;
        this.number = number;
        this.location = location;
        this.province = province;
    }

}
