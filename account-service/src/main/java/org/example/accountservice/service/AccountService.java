package org.example.accountservice.service;

import org.example.accountservice.entity.Account;
import org.example.accountservice.dto.AccountDto;

import java.util.List;

public interface AccountService {
    public List<Account> getAllAccounts();

    public Account getAccountById(Long id);

    public AccountDto getAccountWithCardsAndLoans(Long id);

    public Account saveAccount(Account account);

    public void deleteAccount(Long id);
}