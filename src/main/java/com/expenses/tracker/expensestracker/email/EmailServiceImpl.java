package com.expenses.tracker.expensestracker.email;

import com.expenses.tracker.expensestracker.user.dto.UserDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{
    private final JavaMailSender javaMailSender;
    private final MimeMessageHelperFactory mimeMessageHelperFactory;

    EmailServiceImpl(
            JavaMailSender javaMailSender,
            MimeMessageHelperFactory mimeMessageHelperFactory
    ){
        this.javaMailSender = javaMailSender;
        this.mimeMessageHelperFactory = mimeMessageHelperFactory;
    }

    @Override
    public void sendWelcomeEmail(UserDTO user) {
        String email = "t.yordanovv@gmail.com";
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo(email);
            helper.setSubject("Welcome to YourApp!");
            helper.setText("Dear " + email + ",\n\nWelcome to YourApp! We are excited to have you on board.");

            javaMailSender.send(message);
        } catch (MessagingException e) {
            // Handle exception or log an error
        }
    }

    @Override
    public void sendPasswordResetEmail(UserDTO user, String resetToken) {

    }

    @Override
    public void sendSubscriptionConfirmationEmail(UserDTO user) {

    }

    @Override
    public void sendPaymentReceiptEmail(UserDTO user) {

    }

    @Override
    public void sendAnnouncementEmail(String subject, String content) {

    }
}
