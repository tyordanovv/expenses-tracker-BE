package com.expenses.tracker.expensestracker.user.service;

import com.expenses.tracker.expensestracker.user.auth.RegistrationRequest;
import com.expenses.tracker.expensestracker.user.repository.UserDao;
import com.expenses.tracker.expensestracker.user.dto.UserDTO;
import com.expenses.tracker.expensestracker.user.dto.UserDTOSummary;
import com.expenses.tracker.expensestracker.user.entity.*;
import com.expenses.tracker.expensestracker.user.mapper.UserDTOMapper;
import com.expenses.tracker.expensestracker.user.repository.UserDetailsRepository;
import com.expenses.tracker.expensestracker.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserDataAccessService implements UserDao {
    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;
    private final PasswordEncoder encoder;
    private final UserDTOMapper userDTOMapper;

    public UserDataAccessService(
            UserRepository userRepository,
            UserDetailsRepository userDetailsRepository,
            PasswordEncoder encoder,
            UserDTOMapper userDTOMapper
            ) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.encoder = encoder;
        this.userDTOMapper = userDTOMapper;
    }

    @Override
    public List<User> selectAllUsers() {
        Page<User> page = userRepository.findAll(Pageable.ofSize(1000));
        return page.getContent();
    }

    @Override
    public Optional<User> selectUserById(Long customerId) {
        return userRepository.findById(customerId);
    }

    @Override
    public Optional<User> selectUserByEmail(String email) {
        return userRepository.findCustomerByEmail(email);
    }

    @Override
    public UserDTOSummary selectUserSummaryById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException(
                        "User with id " + id +" was not found!"
                ));
        UserDetails userDetails = userDetailsRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException(
                        "User Details with id " + id + " was not found!"
                ));
        return null;
    }

    @Override
    public UserDTO insertUser(RegistrationRequest request) {
        User user = new User(
                request.firstName(),
                request.lastName(),
                request.email(),
                encoder.encode(request.password()),
                Collections.singleton(UserRole.FREE),
                RegistrationType.DEFAULT
        );

        UserDetails userDetails = new UserDetails();
        userDetails.setGender(Gender.valueOf(request.gender().toUpperCase()));
        userDetails.setCountry(Country.valueOf(request.country().toUpperCase()));

        user.setUserDetails(userDetails);
        userDetails.setUser(user);

        userRepository.save(user);
        userDetailsRepository.save(userDetails);

        return userDTOMapper.apply(user);
    }

    @Override
    public boolean existsUserWithEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

    @Override
    public void deleteUserById(Long customerId) {
        userRepository.deleteById(customerId);
    }

    @Override
    public void updateUser(User updatedCustomer) {
        userRepository.save(updatedCustomer);
    }
}
