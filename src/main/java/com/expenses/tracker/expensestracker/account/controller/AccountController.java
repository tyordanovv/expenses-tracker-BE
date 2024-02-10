package com.expenses.tracker.expensestracker.account.controller;

import com.expenses.tracker.expensestracker.account.entity.AccountDTO;
import com.expenses.tracker.expensestracker.account.service.AccountService;
import com.expenses.tracker.expensestracker.transaction.dto.TransactionDTO;
import com.expenses.tracker.expensestracker.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/v1/accounts")
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;

    @GetMapping("/{userId}")
    public ResponseEntity<Set<AccountDTO>> getAccounts(
            @PathVariable Long userId,
            @AuthenticationPrincipal UserDetails userDetails
    ){
        Set<AccountDTO> accounts = accountService.getAllUserAccounts(getUserIdFromToken(userDetails));
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/cash/details")
    public ResponseEntity<String> getCashAccountDetails(){
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/cash")
    public ResponseEntity<String> addCashAccount(){
        return ResponseEntity.ok("ok");
    }

    private Long getUserIdFromToken(UserDetails userDetails) {
        if (userDetails instanceof User) {
            return ((User) userDetails).getId();
        } else {
            return null;
        }
    }
}
