package com.expenses.tracker.expensestracker.user.controller;

import com.expenses.tracker.expensestracker.security.google.GoogleOAuth2Service;
import com.expenses.tracker.expensestracker.security.google.GoogleOAuth2User;
import com.expenses.tracker.expensestracker.security.jwt.JWTUtil;
import com.expenses.tracker.expensestracker.user.entity.User;
import com.expenses.tracker.expensestracker.user.service.UserService;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final GoogleOAuth2Service googleOAuth2Service;
    private final JWTUtil jwtUtil;

//    @GetMapping("/oauth2/callback")
//    public ResponseEntity<String> oauth2Callback(@RequestParam(name = "code") String authorizationCode) throws IOException {
//        // Exchange authorization code for access token and refresh token
//        GoogleTokenResponse tokenResponse = googleOAuth2Service.exchangeAuthorizationCode(authorizationCode);
//
//        // Retrieve user information using access token
//        GoogleOAuth2User googleUser = googleOAuth2Service.getUserInfo(tokenResponse.getAccessToken());
//
//        // Check if user already exists in system
//        if (userService.userExists(googleUser.getEmail())) {
//            // User with email already exists, return error
//            return ResponseEntity.badRequest().body("User with email already exists");
//        }
//
//        // Create new user with Google information
//        User user = new User();
////        user.setEmail(googleUser.getEmail());
//        user.setFirstName(googleUser.getFirstName());
//        user.setLastName(googleUser.getLastName());
//        userService.saveUser(user);
//
//        // Generate JWT token
//        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), null);
//        String token = userService.generateToken(authentication);
//
//        return ResponseEntity.ok(token);
//    }

    @GetMapping()
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("ok");
    }
}
