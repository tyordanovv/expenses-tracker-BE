package com.expenses.tracker.expensestracker.account.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/accounts/")
public class AccountController {
    @GetMapping("{user_id)")
    public ResponseEntity<String> getAccounts(@PathVariable Long user_id){
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/cash/details")
    public ResponseEntity<String> getCashAccountDetails(){
        return ResponseEntity.ok("ok");
    }
}
