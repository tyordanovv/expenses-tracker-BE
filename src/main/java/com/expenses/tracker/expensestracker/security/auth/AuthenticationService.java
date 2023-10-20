package com.expenses.tracker.expensestracker.security.auth;

import com.expenses.tracker.expensestracker.security.jwt.JWTUtil;
import com.expenses.tracker.expensestracker.user.dto.UserDTO;
import com.expenses.tracker.expensestracker.user.entity.User;
import com.expenses.tracker.expensestracker.user.service.UserDTOMapper;
import com.expenses.tracker.expensestracker.user.service.UserDataAccessService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserDTOMapper userDTOMapper;
    private final JWTUtil jwtUtil;
    private final UserDataAccessService userDataAccessService;

    public AuthenticationService(
            AuthenticationManager authenticationManager,
            UserDTOMapper userDTOMapper,
            JWTUtil jwtUtil,
            UserDataAccessService userDataAccessService
    ) {
        this.authenticationManager = authenticationManager;
        this.userDTOMapper = userDTOMapper;
        this.jwtUtil = jwtUtil;
        this.userDataAccessService = userDataAccessService;
    }

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

    public AuthenticationResponse register(RegistrationRequest request) {
        if (userDataAccessService.existsUserWithEmail(request.email())) {
            throw new RuntimeException("User with this email already exists.");
        }

        UserDTO userDTO = userDataAccessService.insertUser(request);

        if (userDTO != null) {
            String token = jwtUtil.issueToken(userDTO.email(), userDTO.roles());
            return new AuthenticationResponse(token, userDTO);
        }

        throw new RuntimeException("registration error");
    }
}
