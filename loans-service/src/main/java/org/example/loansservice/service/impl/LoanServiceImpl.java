package org.example.loansservice.service.impl;


import org.example.loansservice.entity.Loan;
import org.example.loansservice.repository.LoanRepository;
import org.example.loansservice.service.LoanService;
import org.example.loansservice.client.AccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private AccountClient accountClient;

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan getLoanById(Long id) {
        return loanRepository.findById(id).orElseThrow(() -> new RuntimeException("Loan not found"));
    }

    public List<Loan> getLoansByAccountId(Long accountId) {
        return loanRepository.findByAccountId(accountId);
    }

    public Loan saveLoan(Loan loan) {
        if (!accountClient.accountExists(loan.getAccountId())) {
            throw new RuntimeException("Account not found with id: " + loan.getAccountId());
        }
        return loanRepository.save(loan);
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}

