package com.blu.personservice.functionaltest.cif.service;

import com.blu.personservice.cif.entity.PersonEntity;
import com.blu.personservice.cif.repository.PersonRepository;
import com.blu.personservice.cif.service.serviceImpl.PersonServiceImpl;
import com.blu.personservice.cif.web.dto.PersonDto;
import com.blu.personservice.infrastructure.web.dto.response.GenericRestResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonServiceImpl personService;

    @Mock
    private PersonRepository personRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private PersonEntity personEntity;

    @BeforeEach
    void init() {
        personEntity = PersonEntity.builder()
                .id(1L)
                .firstName("firstName")
                .lastName("lastName")
                .homeAddress("address")
                .nationalCode("5324524235")
                .phoneNumber("326598745")
                .build();
    }


    @Test
    void addPersonTest() throws JsonProcessingException {


        when(personRepository.saveAndFlush(Mockito.any(PersonEntity.class))).thenReturn(personEntity);
        PersonDto personDto = PersonDto.builder()
                .firstName("firstName")
                .lastName("lastName")
                .homeAddress("address")
                .nationalCode("5324524235")
                .phoneNumber("326598745")
                .build();
        GenericRestResponse response = personService.addPerson(personDto);
        PersonEntity resultPerson = objectMapper.readValue(response.getData().toString(), PersonEntity.class);
        Assertions.assertNotNull(resultPerson);
        Assertions.assertEquals(1l, resultPerson.getId());

    }

    @Test
    void getPersonTest_exp() {

        when(personRepository.findById(1L)).thenReturn(Optional.ofNullable(personEntity));

        Assertions.assertThrows(RuntimeException.class, () -> {
            personService.getPersonById(2L);
        });
    }

    @Test
    void deletePersonTest() {

        when(personRepository.findById(1L)).thenReturn(Optional.ofNullable(personEntity));

//        Mockito.doNothing(Mockito.when(personRepository.delete(Mockito.any(PersonEntity.class))));
//        Mockito.doNothing().when(personRepository.delete(Mockito.any(PersonEntity.class))));
        personService.deletePerson(1L);


        Mockito.verify(personRepository, Mockito.times(1)).delete(personEntity);


    }
}
