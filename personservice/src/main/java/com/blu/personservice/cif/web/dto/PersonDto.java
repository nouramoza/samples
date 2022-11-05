package com.blu.personservice.cif.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class PersonDto implements Serializable {

    private Long id;

    private String firstName;
    private String lastName;
    private String nationalCode;
    private String homeAddress;
    private String phoneNumber;
}
