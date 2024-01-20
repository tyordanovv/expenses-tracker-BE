package com.expenses.tracker.expensestracker.user.controller;

import com.expenses.tracker.expensestracker.security.google.GoogleOAuth2Service;
import com.expenses.tracker.expensestracker.security.jwt.JWTUtil;
import com.expenses.tracker.expensestracker.user.dto.UserDTOSummary;
import com.expenses.tracker.expensestracker.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;
    private final JWTUtil jwtUtil;

    public UserController(UserService userService, JWTUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping()
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("ok");
    }
}
