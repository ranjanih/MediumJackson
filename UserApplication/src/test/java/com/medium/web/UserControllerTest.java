package com.medium.web;

import com.medium.page.RestPageImpl;
import com.medium.userdetails.UserApplication;
import com.medium.userdetails.model.UserData;
import com.medium.userdetails.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = UserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    void givenGetData_whenRestTemplateExchange_thenReturnsPageOfUser() {

        ResponseEntity<RestPageImpl<UserData>> responseEntity = restTemplate.exchange(
                "http://localhost:" + port + "/data/userdetails/page", HttpMethod.GET, null,
                new ParameterizedTypeReference<RestPageImpl<UserData>>() {
                });

        assertEquals(200, responseEntity.getStatusCodeValue());
        RestPageImpl<UserData> restPage = responseEntity.getBody();
        assertNotNull(restPage);

        assertEquals(45, restPage.getTotalElements());
        assertEquals(20, restPage.getSize());
    }
}
