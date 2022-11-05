package com.blu.personservice.functionaltest.cif.controller;


import com.blu.personservice.cif.entity.PersonEntity;
import com.blu.personservice.cif.service.PersonService;
import com.blu.personservice.cif.web.dto.PersonDto;
import com.blu.personservice.infrastructure.web.dto.response.GenericRestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.blu.personservice.infrastructure.util.ConstantsUtil.ResponseMessage.PERSON_ADDED_SUCCESSFULLY;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class PersonControllerTest {
    private static final String PERSON_URI = "/person";

    @MockBean
    private PersonService personService;

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private PersonEntity personEntity;
    private GenericRestResponse genericRestResponse;

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

        genericRestResponse = new GenericRestResponse(GenericRestResponse.STATUS.SUCCESS,
                PERSON_ADDED_SUCCESSFULLY,
                personEntity);
    }

    @Test
    void addPerson() throws Exception {

        Mockito.when(personService.addPerson(Mockito.any(PersonDto.class))).thenReturn(genericRestResponse);
        PersonDto personDto = PersonDto.builder()
                .firstName("firstName")
                .lastName("lastName")
                .homeAddress("address")
                .nationalCode("5324524235")
                .phoneNumber("326598745")
                .build();
//
        RequestBuilder req = post(PERSON_URI + "/addPerson")
                .contentType(MediaType.APPLICATION_JSON) // for DTO
                .content(objectMapper.writeValueAsString(personDto));

        MvcResult mvcResult = this.mockMvc.perform(req)
//                .andExpect(content().string(containsString(outputExpectedMockBoard)))
//                .andExpect(status().isOk())
//                .andExpect(status().isCreated())
                .andDo(print())
                .andReturn();
        GenericRestResponse resultResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), GenericRestResponse.class);

        Assertions.assertEquals(GenericRestResponse.STATUS.SUCCESS,resultResponse.getStatus());
        Assertions.assertEquals(PERSON_ADDED_SUCCESSFULLY,resultResponse.getMessage());

    }

}
