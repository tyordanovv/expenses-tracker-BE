package com.expenses.tracker.expensestracker.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class DefaultMimeMessageHelperFactory {
    public MimeMessageHelper createMimeMessageHelper(MimeMessage message) throws MessagingException {
        return new MimeMessageHelper(message);
    }
}
