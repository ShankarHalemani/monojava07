package com.techlabs.app.dto;

import com.techlabs.app.entity.Bank;
import com.techlabs.app.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponseDTO {

    private Long accountNumber;

    private double balance;

    private BankResponseDTO bankResponseDTO;

//    private List<TransactionResponseDTO> sentTransactions;
//
//    private List<TransactionResponseDTO> receivedTransactions;

    private boolean active;
}
