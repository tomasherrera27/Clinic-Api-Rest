package com.ApiRestOdontologist.demo.Dto;

import lombok.Data;

@Data
public class AddressDTO {
    private Integer id;
    private String street;
    private Integer number;
    private String location;
    private String province;
}
