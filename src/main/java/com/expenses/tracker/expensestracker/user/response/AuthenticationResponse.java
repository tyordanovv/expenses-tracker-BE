package com.expenses.tracker.expensestracker.user.response;

import com.expenses.tracker.expensestracker.user.dto.UserDTO;

public record AuthenticationResponse(
        String token,
        UserDTO userDto
) {
}
