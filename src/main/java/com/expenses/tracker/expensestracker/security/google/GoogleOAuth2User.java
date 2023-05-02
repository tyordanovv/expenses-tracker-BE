package com.expenses.tracker.expensestracker.security.google;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GoogleOAuth2User {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
}