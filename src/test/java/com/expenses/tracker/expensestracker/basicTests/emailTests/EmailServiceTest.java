package com.expenses.tracker.expensestracker.basicTests.emailTests;

import com.expenses.tracker.expensestracker.email.EmailServiceImpl;
import com.expenses.tracker.expensestracker.user.dto.UserDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.util.Set;
import java.util.UUID;

public class EmailServiceTest {

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private EmailServiceImpl emailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendWelcomeEmail() throws MessagingException {
        // Prepare test data
        UserDTO user = new UserDTO(1, "testFN", "testLN", "test@gmail.com", Set.of("role"), Set.of(UUID.randomUUID()), "type");

        // Create a mock MimeMessage and MimeMessageHelper
        MimeMessage mimeMessage = mock(MimeMessage.class);

        // Stub the necessary method calls
        when(javaMailSender.createMimeMessage()).thenReturn(mimeMessage);

        // Call the method to be tested
        emailService.sendWelcomeEmail(user);

        // Verify the expected method calls
        verify(javaMailSender).send(mimeMessage);
    }
}
