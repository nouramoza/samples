package com.blu.personservice.integrationtest.person;

import com.blu.personservice.cif.repository.PersonRepository;
import com.blu.personservice.cif.web.dto.PersonDto;
import com.blu.personservice.infrastructure.web.dto.response.GenericRestResponse;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.blu.personservice.infrastructure.util.ConstantsUtil.ResponseMessage.PERSON_ADDED_SUCCESSFULLY;
import static com.blu.personservice.infrastructure.util.ConstantsUtil.ResponseMessage.PERSON_FOUNDED;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonIntegrationTest {

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost";

    private static RestTemplate restTemplate;

    @Autowired
    private PersonRepository personRepository;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void beforeSetup() {
        baseUrl = baseUrl + ":" + port + "/api/v1/person/";
    }

    @AfterEach
    public void afterEach() {
        personRepository.deleteAll();
    }

    @Test
    void addPersonTest() {
        PersonDto personDto = PersonDto.builder()
        .firstName("firstName")
                .lastName("lastName")
                .phoneNumber("554545")
                .homeAddress("homeAddress")
                .nationalCode("9874563210")
                .build();

        GenericRestResponse genericRestResponse = restTemplate.postForObject(baseUrl.concat("/addPerson"), personDto, GenericRestResponse.class);
        Assertions.assertNotNull(genericRestResponse);
        Assertions.assertEquals(PERSON_ADDED_SUCCESSFULLY, genericRestResponse.getMessage());
    }

    @Test
    void getPersonTest() {
        GenericRestResponse genericRestResponse = restTemplate.getForObject(baseUrl.concat("/getPerson/101"), GenericRestResponse.class);
        Assertions.assertNotNull(genericRestResponse);
        Assertions.assertEquals(PERSON_FOUNDED, genericRestResponse.getMessage());
    }

    @Test
    void getAllPersonTest() {
        List<PersonDto> resultList = restTemplate.getForObject(baseUrl.concat("/getAllPerson"), List.class);
        Assertions.assertNotNull(resultList);
        Assertions.assertEquals(6, resultList.size());
    }

    @Test
    void deletePersonTest() {
         restTemplate.delete(baseUrl.concat("/deletePerson/101"));
        Assertions.assertEquals(5, personRepository.findAll().size());
    }

    @Test
    void updatePersonTest() {
        PersonDto personDto = PersonDto.builder()
                .id(101L)
                .firstName("firstName")
                .lastName("lastName")
                .phoneNumber("554545")
                .homeAddress("homeAddress")
                .nationalCode("9874563210")
                .build();
        restTemplate.put(baseUrl.concat("/updatePerson"), personDto);
        Assertions.assertEquals(6, personRepository.findAll().size());
        Assertions.assertEquals("firstName", personRepository.findById(101L).get().getFirstName());
    }
}
