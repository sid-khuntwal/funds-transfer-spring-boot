package com.fundstransfer.fundstransfer.repository;

import com.fundstransfer.fundstransfer.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    public List<Transaction> findBySenderUserIdOrReceiverUserId(Integer senderUserId, Integer receiverUserId);
}
