//package com.blu.personservice.integrationtest.person;//package com.blu.personservice.integrationtest.person;
//
//import com.blu.personservice.cif.web.dto.PersonDto;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class PersonTests {
//
//    private static final String ADD_PERSON_URI = "/api/v1/person/addPerson";
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    private RequestSpecification requestSpec;
//    private ResponseSpecification responseSpec;
//
//    @BeforeEach
//    public void setup() {
//        Utils.initializeRESTAssured();
//        this.requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
////        this.requestSpec.header("Authorization", "");
////        this.requestSpec.header("Fineract-Platform-TenantId", "default");
//
////        this.requestSpec.header("Authorization", Utils.loginIntoServerAndGetBase64EncodedAuthenticationKey());
//        this.responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
////        this.responseSpecWithAuthorizationError = new ResponseSpecBuilder().expectStatusCode(403).build();
////        this.loanTransactionHelper = new LoanTransactionHelper(this.requestSpec, this.responseSpec);
////        this.accountHelper = new AccountHelper(this.requestSpec, this.responseSpec);
////        this.journalEntryHelper = new JournalEntryHelper(this.requestSpec, this.responseSpec);
//    }
//
//    @Test
//    void createPersonTest() throws JsonProcessingException {
////        Utils.initializeRESTAssured();
////        this.requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
////        this.responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
//        PersonDto personDto = new PersonDto();
//        personDto.setFirstName("ddd");
//        personDto.setLastName("ddd");
//        personDto.setPhoneNumber("ddd");
//        personDto.setHomeAddress("ddd");
//        personDto.setNationalCode("ddd");
//
////        Response response = Utils.performServerPost(requestSpec, responseSpec, ADD_PERSON_URI, personDto,
////                "id");
//        // then:
////        assertThat(response.statusCode()).isEqualTo(201);
//
//        GenericRestResponse response = Utils.performServerPost( ADD_PERSON_URI, personDto, null);
//
////        GenericRestResponse genericRestResponse = objectMapper.readValue(response, Response.class);
//        Assertions.assertEquals(1L, 1);
//
//    }
//
//    @Autowired
//    MockMvc mockMvc;
//    @Test
//    void createPersonTest_2() throws Exception {
////        Utils.initializeRESTAssured();
////        this.requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
////        this.responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
//        PersonDto personDto = PersonDto.builder()
//        .firstName("firstName")
//                .lastName("lastName")
//                .phoneNumber("phoneNumber")
//                .homeAddress("homeAddress")
//                .nationalCode("123135214354")
//                .build();
//
//
//        RequestBuilder req = post(ADD_PERSON_URI)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(personDto));
//
//        MvcResult mvcResult = this.mockMvc.perform(req)
////                .andExpect(content().string(containsString(ErrorConstants.MoveExceptionMessages.WRONG_AREA_SELECTED_MSG)))
//                .andExpect(status().isConflict())
//                .andDo(print())
//                .andReturn();
//        MockHttpServletResponse response = mvcResult.getResponse();
//        Assert.assertEquals(HttpStatus.CONFLICT.value(), response.getStatus());
//
//
//
//        Assertions.assertEquals(1L, 1);
//
//    }
//
//}
