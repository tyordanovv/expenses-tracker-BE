package com.expenses.tracker.expensestracker.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

public interface MimeMessageHelperFactory {
    MimeMessageHelper createMimeMessageHelper(MimeMessage message) throws MessagingException;
}
