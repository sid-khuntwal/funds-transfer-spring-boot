package com.fundstransfer.fundstransfer.controller;

import com.fundstransfer.fundstransfer.entity.Transaction;
import com.fundstransfer.fundstransfer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transfer")
    public void transferMoney(
            @RequestParam Integer senderUserId,
            @RequestParam Integer receiverUserId,
            @RequestParam int amount
    ) {
        transactionService.transferMoney(senderUserId, receiverUserId, amount);
    }

    @GetMapping("/all")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransaction();
    }

    @GetMapping("/user")
    public ResponseEntity<List<Transaction>> getTransactionsByUserId(@RequestParam(name = "userId") Integer userId) {
        List<Transaction> transactions = transactionService.getTransactionsByUserId(userId);
        return ResponseEntity.ok(transactions);
    }


}
