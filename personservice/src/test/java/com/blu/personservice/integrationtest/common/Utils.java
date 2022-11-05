package com.blu.personservice.integrationtest.common;//package com.blu.personservice.integrationtest.common;
//
//import com.blu.personservice.infrastructure.api.web.dto.response.GenericRestResponse;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import io.restassured.specification.ResponseSpecification;
//import org.junit.Assert;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//
//import static io.restassured.RestAssured.given;
//import static io.restassured.path.json.JsonPath.from;
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class Utils {
//    public static int port = 8062;
////
//    public static void initializeRESTAssured() {
////        RestAssured.baseURI = "http://localhost";
//        RestAssured.port = port;
////        RestAssured.keyStore("src/main/resources/keystore.jks", "openmf");
////        RestAssured.useRelaxedHTTPSValidation();
//    }
//
//    public static <T> T performServerPost(final RequestSpecification requestSpec, final ResponseSpecification responseSpec,
//                                          final String postURL, final String jsonBodyToSend, final String jsonAttributeToGetBack) {
//        final String json = given().spec(requestSpec).body(jsonBodyToSend).expect().spec(responseSpec).log().ifError().when().post(postURL)
//                .andReturn().asString();
//
//
//        if (jsonAttributeToGetBack == null) {
//            return (T) json;
//        }
//        return (T) from(json).get(jsonAttributeToGetBack);
//    }
//
//    public static <T> T performServerPost(final String postURL, final Object jsonBodyToSend, final String jsonAttributeToGetBack) {
//
//
//        // given:
//        RequestSpecification request = given()
//                .header("Content-Type", "application/json")
//                .body(jsonBodyToSend);
//        // when:
//        String response = given().spec(request)
//                .post(postURL)
//                .andReturn()
//                .asString();
//
//        if (jsonAttributeToGetBack == null) {
//            return (T) response;
//        }
//        return (T) from(response).get(jsonAttributeToGetBack);
//
//
////        if (jsonAttributeToGetBack == null) {
////            return (T) response;
////        }
////        return (T) from(response).get(jsonAttributeToGetBack);
//    }
//
//    public static String mapToJson(Object obj) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(obj);
//    }
//}
