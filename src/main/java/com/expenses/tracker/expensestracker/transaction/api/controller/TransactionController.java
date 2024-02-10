package com.expenses.tracker.expensestracker.transaction.api.controller;

import com.expenses.tracker.expensestracker.transaction.api.request.TransactionRequest;
import com.expenses.tracker.expensestracker.transaction.dto.TransactionDTO;
import com.expenses.tracker.expensestracker.transaction.service.TransactionServiceImpl;
import com.expenses.tracker.expensestracker.user.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/transactions")
@AllArgsConstructor
public class TransactionController {
    private TransactionServiceImpl transactionService;


    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Set<TransactionDTO>> getTransactions(
            @PathVariable Long userId,
            @AuthenticationPrincipal UserDetails userDetails
    ){
        if (userId.equals(getUserIdFromToken(userDetails))) {
            Set<TransactionDTO> transactions = transactionService.getAllTransactions(userId);
            return ResponseEntity.ok(transactions);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    @PostMapping("/{userId}")
    public ResponseEntity<Long> createCashTransaction(
            @PathVariable Long userId,
            @RequestBody TransactionRequest request,
            @AuthenticationPrincipal UserDetails userDetails
    ){
        if (userId.equals(getUserIdFromToken(userDetails))) {
            return ResponseEntity.ok(transactionService.createCashTransaction(userId, request));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    private Long getUserIdFromToken(UserDetails userDetails) {
        if (userDetails instanceof User) {
            return ((User) userDetails).getId();
        } else {
            return null;
        }
    }
}
