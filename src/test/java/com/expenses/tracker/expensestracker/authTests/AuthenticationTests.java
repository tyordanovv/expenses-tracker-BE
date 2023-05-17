package com.expenses.tracker.expensestracker.authTests;

import com.expenses.tracker.expensestracker.security.auth.AuthenticationRequest;
import com.expenses.tracker.expensestracker.security.auth.AuthenticationResponse;
import com.expenses.tracker.expensestracker.security.auth.RegistrationRequest;
import com.expenses.tracker.expensestracker.security.jwt.JWTUtil;
import com.expenses.tracker.expensestracker.user.dto.UserDTO;
import com.expenses.tracker.expensestracker.user.entity.Gender;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class AuthenticationTests {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private JWTUtil jwtUtil;

    private static final Random RANDOM = new Random();
    private static final String AUTHENTICATION_PATH = "/api/v1/auth";
    private static final String USER_PATH = "/api/v1/user";

    @Test
    void canLogin() {
        // Given
        // create registration customerRegistrationRequest
        String firstName = "Tihomir";
        String lastName = "Yordanov";
        String email = lastName + "-" + firstName + "@gmail.com";
        String password = "password";

        RegistrationRequest customerRegistrationRequest = new RegistrationRequest(
                firstName, lastName, email, password
        );

        AuthenticationRequest authenticationRequest = new AuthenticationRequest(
                email,
                password
        );

        webTestClient.post()
                .uri(AUTHENTICATION_PATH + "/login")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(authenticationRequest), AuthenticationRequest.class)
                .exchange()
                .expectStatus()
                .isUnauthorized();

        // send a post customerRegistrationRequest
        webTestClient.post()
                .uri(USER_PATH)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                        Mono.just(customerRegistrationRequest),
                        RegistrationRequest.class
                )
                .exchange()
                .expectStatus()
                .isOk();

        EntityExchangeResult<AuthenticationResponse> result = webTestClient.post()
                .uri(AUTHENTICATION_PATH + "/login")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(authenticationRequest), AuthenticationRequest.class)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(new ParameterizedTypeReference<AuthenticationResponse>() {
                })
                .returnResult();

        String jwtToken = result.getResponseHeaders()
                .get(HttpHeaders.AUTHORIZATION)
                .get(0);

        AuthenticationResponse authenticationResponse = result.getResponseBody();

        UserDTO customerDTO = authenticationResponse.userDto();

        assertThat(jwtUtil.isTokenValid(
                jwtToken,
                customerDTO.email())).isTrue();

        assertThat(customerDTO.email()).isEqualTo(email);
        assertThat(customerDTO.firstName()).isEqualTo(firstName);
        assertThat(customerDTO.lastName()).isEqualTo(lastName);
        assertThat(customerDTO.roles()).isEqualTo(List.of("ROLE_USER"));

    }
}
