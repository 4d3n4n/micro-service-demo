package org.example.loansservice.service;

import org.example.loansservice.entity.Loan;

import java.util.List;

public interface LoanService {

    public List<Loan> getAllLoans();

    public Loan getLoanById(Long id);

    public List<Loan> getLoansByAccountId(Long accountId);
    public Loan saveLoan(Loan loan);

    public void deleteLoan(Long id);
}
