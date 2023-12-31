package com.fundstransfer.fundstransfer.service;

import com.fundstransfer.fundstransfer.entity.Transaction;

import java.util.List;

public interface TransactionService {
   public void transferMoney(Integer senderUserId, Integer recevierId, int ammount);

   public List<Transaction> getAllTransaction();

   public List<Transaction> getTransactionsByUserId(Integer userId);
}
