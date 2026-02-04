package org.example.loansservice.repository;

import org.example.loansservice.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByAccountId(Long customerId);

}
