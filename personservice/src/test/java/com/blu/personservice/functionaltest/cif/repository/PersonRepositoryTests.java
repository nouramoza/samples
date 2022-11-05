package com.blu.personservice.functionaltest.cif.repository;

import com.blu.personservice.cif.entity.PersonEntity;
import com.blu.personservice.cif.repository.PersonRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class PersonRepositoryTests {

    @Autowired
    private PersonRepository personRepository;

    private PersonEntity personEntity;

    @BeforeEach
    void init() {
        personEntity = PersonEntity.builder()
                .firstName("firstName")
                .lastName("lastName")
                .homeAddress("address")
                .nationalCode("5324524235")
                .phoneNumber("326598745")
                .build();
    }

    @Test
    @Order(1)
    @DisplayName("add person")
    void addPersonTest() {
        //Arrange: setting up data


        //act: calling method
        PersonEntity newPerson = personRepository.save(personEntity);

        //assert: verifying data
        Assertions.assertNotNull(newPerson);
        Assertions.assertEquals(1L, newPerson.getId());

    }

    @Test
    @Order(2)
    @DisplayName("find person")
    void retrievePersonTest() {

        //act: calling method
        Optional<PersonEntity> newPerson = personRepository.findById(101L);

        //assert: verifying data
        Assertions.assertNotNull(newPerson);
        Assertions.assertEquals(101L, newPerson.get().getId());
        Assertions.assertEquals("Noura", newPerson.get().getFirstName());

    }

    @Test
    @Order(3)
    @DisplayName("find All person")
    void retrieveAllPersonTest() {
        //act: calling method
        List<PersonEntity> personList = personRepository.findAll();

        //assert: verifying data
        Assertions.assertNotNull(personList);
        Assertions.assertEquals(6, personList.size());

    }
}
