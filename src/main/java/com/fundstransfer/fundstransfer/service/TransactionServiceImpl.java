package com.fundstransfer.fundstransfer.service;

import com.fundstransfer.fundstransfer.repository.TransactionRepository;
import com.fundstransfer.fundstransfer.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fundstransfer.fundstransfer.entity.User;
import com.fundstransfer.fundstransfer.entity.Transaction;

import java.util.*;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }


    @Override
    @Transactional
    public void transferMoney(Integer senderUserId, Integer receiverId, int amount) {
        try {
            User sender = userRepository.findById(senderUserId)
                    .orElseThrow(() -> new EntityNotFoundException("Sender not found: " + senderUserId));
            User receiver = userRepository.findById(receiverId)
                    .orElseThrow(() -> new EntityNotFoundException("Receiver not found: " + receiverId));

            if (sender.getAccBalance() >= amount) {
                sender.setAccBalance(sender.getAccBalance() - amount);
                receiver.setAccBalance(receiver.getAccBalance() + amount);

                userRepository.save(sender);
                userRepository.save(receiver);

                Transaction transaction = new Transaction();
                transaction.setSender(sender);
                transaction.setReceiver(receiver);
                transaction.setAmmount(amount);

                transactionRepository.save(transaction);
            } else {
                throw new IllegalArgumentException("Insufficient funds for the transfer.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error during money transfer", e);
        }

    }

    @Override
    public List<Transaction> getAllTransaction() {
        try {
            return transactionRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error while getting all transactions", e);
        }
    }

    @Override
    public List<Transaction> getTransactionsByUserId(Integer userId) {
        try {
            return transactionRepository.findBySenderUserIdOrReceiverUserId(userId, userId);
        } catch (Exception e) {
            throw new RuntimeException("Error while getting transactions for user ID: " + userId, e);
        }
    }


}
