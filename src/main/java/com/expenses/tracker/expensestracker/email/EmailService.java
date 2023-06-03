package com.expenses.tracker.expensestracker.email;

import com.expenses.tracker.expensestracker.user.dto.UserDTO;

public interface EmailService {
    void sendWelcomeEmail(UserDTO user);
    void sendPasswordResetEmail(UserDTO user, String resetToken);
    void sendSubscriptionConfirmationEmail(UserDTO user);
    void sendPaymentReceiptEmail(UserDTO user);
    void sendAnnouncementEmail(String subject, String content);
}