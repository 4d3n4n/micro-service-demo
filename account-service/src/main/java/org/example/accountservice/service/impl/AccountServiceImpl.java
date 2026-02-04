package org.example.accountservice.service.impl;

import org.example.accountservice.entity.Account;
import org.example.accountservice.dto.AccountDto;
import org.example.accountservice.dto.CardDto;
import org.example.accountservice.dto.LoanDto;
import org.example.accountservice.repository.AccountRepository;
import org.example.accountservice.service.AccountService;
import org.example.accountservice.client.CardClient;
import org.example.accountservice.client.LoanClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CardClient cardClient;

    @Autowired
    private LoanClient loanClient;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public AccountDto getAccountWithCardsAndLoans(Long id) {
        Account account = getAccountById(id);
        List<CardDto> cards = cardClient.getCardsByAccountId(id);
        List<LoanDto> loans = loanClient.getLoansByAccountId(id);
        
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setName(account.getName());
        accountDto.setEmail(account.getEmail());
        accountDto.setSolde(account.getSolde());
        accountDto.setCards(cards);
        accountDto.setLoans(loans);
        
        return accountDto;
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
