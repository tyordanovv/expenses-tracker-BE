package com.expenses.tracker.expensestracker.account.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {
    @GetMapping()
    public ResponseEntity<String> getAccountsDetails(){
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/cash/details")
    public ResponseEntity<String> getCashAccountDetails(){
        return ResponseEntity.ok("ok");
    }
}
