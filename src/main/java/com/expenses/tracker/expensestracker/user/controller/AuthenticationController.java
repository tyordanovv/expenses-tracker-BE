package com.expenses.tracker.expensestracker.user.controller;

import com.expenses.tracker.expensestracker.user.auth.AuthenticationRequest;
import com.expenses.tracker.expensestracker.user.auth.RegistrationRequest;
import com.expenses.tracker.expensestracker.user.response.AuthenticationResponse;
import com.expenses.tracker.expensestracker.user.service.AuthenticationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = authenticationService.login(request);
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, response.token())
                .body(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request){
        AuthenticationResponse response = authenticationService.register(request);
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, response.token())
                .body(response);
    }
}
