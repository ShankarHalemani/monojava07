package com.techlabs.app.repository;

import com.techlabs.app.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByTransactionTimestampBetween(LocalDateTime startDateTimestamp, LocalDateTime endDateTimestamp);

    List<Transaction> findBySenderAccountNumber_AccountNumberAndTransactionTimestampBetween(
            long accountNumber, LocalDateTime startDate, LocalDateTime endDate);

    List<Transaction> findByReceiverAccountNumber_AccountNumberAndTransactionTimestampBetween(
            long accountNumber, LocalDateTime startDate, LocalDateTime endDate);
}
