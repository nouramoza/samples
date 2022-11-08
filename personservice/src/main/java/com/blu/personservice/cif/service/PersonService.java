package com.blu.personservice.cif.service;


import com.blu.personservice.cif.entity.PersonEntity;
import com.blu.personservice.cif.web.dto.PersonDto;
import com.blu.personservice.infrastructure.web.dto.response.GenericRestResponse;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    GenericRestResponse addPerson(PersonDto personDto);

    GenericRestResponse getPerson(Long id);

    List<PersonDto> getAllPerson();

    GenericRestResponse updatePerson(Long id, PersonDto personDto);

    GenericRestResponse deletePerson(Long id);

    Optional<PersonEntity> getPersonById(Long id);

}
