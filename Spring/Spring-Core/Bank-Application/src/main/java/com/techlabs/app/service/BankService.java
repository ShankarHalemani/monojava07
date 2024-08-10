package com.techlabs.app.service;

import com.techlabs.app.dto.BankRequestDTO;
import com.techlabs.app.dto.BankResponseDTO;

import java.util.List;

public interface BankService {
    List<BankResponseDTO> getAllBanks();

    BankResponseDTO getBankById(long bankId);

    BankResponseDTO addNewBank(BankRequestDTO bankRequestDTO);

    BankResponseDTO updateBank(BankRequestDTO bankRequestDTO);

    void deleteBankById(long bankId);

    BankResponseDTO activateBank(long bankId);
}
