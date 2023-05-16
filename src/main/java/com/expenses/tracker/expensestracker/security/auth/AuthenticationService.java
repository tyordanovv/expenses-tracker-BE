package com.expenses.tracker.expensestracker.security.auth;

import com.expenses.tracker.expensestracker.security.auth.AuthenticationRequest;
import com.expenses.tracker.expensestracker.security.auth.AuthenticationResponse;
import com.expenses.tracker.expensestracker.security.jwt.JWTUtil;
import com.expenses.tracker.expensestracker.user.dto.UserDTO;
import com.expenses.tracker.expensestracker.user.entity.User;
import com.expenses.tracker.expensestracker.user.service.UserDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserDTOMapper userDTOMapper;
    private final JWTUtil jwtUtil;

    public AuthenticationResponse login(AuthenticationRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        User principal = (User) authentication.getPrincipal();
        UserDTO customerDTO = userDTOMapper.apply(principal);
        String token = jwtUtil.issueToken(customerDTO.email(), customerDTO.roles());
        return new AuthenticationResponse(token, customerDTO);
    }
}
